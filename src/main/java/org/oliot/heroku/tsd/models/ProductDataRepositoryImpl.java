/*
 * Copyright 2017 Open Language for Internet of Things (Oliot)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.oliot.heroku.tsd.models;

import org.apache.commons.lang3.StringUtils;
import org.oliot.heroku.tsd.models.schema.TSDProductDataType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.xml.bind.JAXBElement;
import java.util.List;

class ProductDataRepositoryImpl implements ProductDataRepositoryCustom {

    private final MongoTemplate mongoTemplate;
    private static final Logger logger = LoggerFactory
            .getLogger(ProductDataRepositoryImpl.class);

    @Autowired
    public ProductDataRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<JAXBElement> getModuleInformation(Class moduleClass, String serializedGLN) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("serializedGLN").is(serializedGLN)),
                Aggregation.unwind("$productDataRecord"),
                Aggregation.unwind("$productDataRecord.module"),
                Aggregation.unwind("$productDataRecord.module.any"),
                Aggregation.match(Criteria.where("productDataRecord.module.any.declaredType").is(moduleClass.getName())),
                Aggregation.replaceRoot("productDataRecord.module.any")
        );

        logger.info(aggregation.toString());

        AggregationResults<JAXBElement> aggregationResults =
                mongoTemplate.aggregate(aggregation, TSDProductDataType.class, JAXBElement.class);
        try {
            return aggregationResults.getMappedResults();
        } catch (IndexOutOfBoundsException e) {
            logger.info("NO DATA");
            return null;
        }
    }



    /*Following is Liam's code , I want to make a method that gets module information using latitude and longitude */
    @Override
    public List<JAXBElement> getModuleInformationCoord(Class moduleClass, Double longitude, Double latitude) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("longitude").is(longitude)),
                Aggregation.match(Criteria.where("latitude").is(latitude)),
                Aggregation.unwind("$productDataRecord"),
                Aggregation.unwind("$productDataRecord.module"),
                Aggregation.unwind("$productDataRecord.module.any"),
                Aggregation.match(Criteria.where("productDataRecord.module.any.declaredType").is(moduleClass.getName())),
                Aggregation.replaceRoot("productDataRecord.module.any") //What does Replace Root mean??
        );

        logger.info(aggregation.toString());

        AggregationResults<JAXBElement> aggregationResults =
                mongoTemplate.aggregate(aggregation, TSDProductDataType.class, JAXBElement.class);
        try {
            return aggregationResults.getMappedResults();
        } catch (IndexOutOfBoundsException e) {
            logger.info("NO DATA");
            return null;
        }
    }

    @Override
    public TSDProductDataType getProductHeader(String serializedGLN) {
        Query query = new Query();
        query.addCriteria(Criteria.where("serializedGLN").is(serializedGLN));
        query.fields().exclude("productDataRecord");

        return mongoTemplate.findOne(query, TSDProductDataType.class);
    }

    @Override
    public TSDProductDataType getFull(String serializedGLN) {
        Query query = new Query();
        query.addCriteria(Criteria.where("serializedGLN").is(serializedGLN));

        return mongoTemplate.findOne(query, TSDProductDataType.class);
    }


    @Override
    public TSDProductDataType getProductHeaderDouble(Double longitude, Double latitude) {
        Query query = new Query();
        query.addCriteria(Criteria.where("longitude").is(longitude));
        query.addCriteria(Criteria.where("latitude").is(latitude));
        query.fields().exclude("productDataRecord");

        return mongoTemplate.findOne(query, TSDProductDataType.class);
    }

    @Override
    public void insertOrReplace(TSDProductDataType tsdProductDataType) {
        String serializedGLN = tsdProductDataType.getSerializedGLN();

        /* remove if already exists */
        Query query = new Query();
        query.addCriteria(Criteria.where("serializedGLN").is(serializedGLN));

        if (mongoTemplate.findAndRemove(query, TSDProductDataType.class) != null) {
            logger.info("Replacing resource: " + serializedGLN);
        } else {
            logger.info("Adding resource: " + serializedGLN);
        }

        /* insert */
        mongoTemplate.save(tsdProductDataType);
    }
}
