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

package org.oliot.heroku.tsd.controllers;

//Liam ADDED this
import main.java.org.oliot.heroku.tsd.services.calculator.Havershine;

import org.oliot.heroku.tsd.models.ProductDataRepository;
import org.oliot.heroku.tsd.models.schema.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.JAXBElement;
import java.util.List;
//Added by Liam
import java.util.ArrayList;

@RestController
public class ProductDataRestController {
    private ProductDataRepository repository;

    @Autowired
    public ProductDataRestController(ProductDataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/resource/{serializedGLN}/MetaInformation")
    public TSDProductDataType getMetaInformation(@PathVariable String serializedGLN) {
        TSDProductDataType header;
        header = repository.getProductHeader(serializedGLN);
        return header;
    }

    @GetMapping("/resource/{latitude}/{longitude}/MetaInformation2")
    public Double getMetaInformation2(@PathVariable Double latitude,@PathVariable Double longitude) {
        //TSDProductDataType header;
        Double doble=Havershine.havershineMethod(longitude,latitude,35.25488,123.254569);
        //header = repository.getProductHeaderDouble(longitude,latitude); //Problem is that getProductHeader only accepts strings, I would need it to accept Double I think to be able to find the longitude double in xml
        return doble;
    }
    
    @GetMapping("/resource/{latitude}/{longitude}/{radius}/Nearby")
    public List<TSDProductDataType> getNearby(@PathVariable Double latitude,@PathVariable Double longitude,@PathVariable Double radius) { //radius in metres
        List<TSDProductDataType> header;
        //Creating the list that contains the buildingData (ProductData here cause I am not going to change all the names)
        List<TSDProductDataType> buildinglist = new ArrayList<TSDProductDataType>();
        
        header = repository.findAll(); //Problem is that getProductHeader only accepts strings, I would need it to accept Double I think to be able to find the longitude double in xml
        for(int i=header.size()-1;i>=0;i--){// loop to explore all the product data, for each I will extract the longitude and latitude and apply Havershine
            TSDProductDataType building= (TSDProductDataType) header.get(i);
            Double buildinglon= building.getLongitude();
            Double buildinglat= building.getLatitude();
            Double distance=Havershine.havershineMethod(buildinglon,buildinglat,longitude,latitude); //Comparing both coordinates using Havershine's method
            
            if(distance<=radius) { // If the building is less than a 100 metres away from the drone's coordinates
                buildinglist.add((TSDProductDataType) building);
            }
            
        }
        
        
        return buildinglist;
    }


    @GetMapping("/building/{sgln}")
    public TSDProductDataType getBuilding(@PathVariable String sgln) { 
        TSDProductDataType fullData;
        fullData = repository.getFull(sgln); 
        return fullData;
    }







    
    @GetMapping("/resource/{epcURI}/BasicProductInformation")
    public TSDBasicProductInformationModuleType getBasicProductInformation(@PathVariable String epcURI) {
        List<JAXBElement> iterator;
        iterator = repository.getModuleInformation(TSDBasicProductInformationModuleType.class, epcURI);
        return iterator.isEmpty() ? null : (TSDBasicProductInformationModuleType) iterator.get(0).getValue();
    }

    @GetMapping("/resource/{epcURI}/BusLineInformation")
    public TSDBusLineInformationModuleType getBusLineInformation(@PathVariable String epcURI) {
        List<JAXBElement> iterator;
        iterator = repository.getModuleInformation(TSDBusLineInformationModuleType.class, epcURI);
        return iterator.isEmpty() ? null : (TSDBusLineInformationModuleType) iterator.get(0).getValue(); //It is important to cast apparently, I should check why

    }

    @GetMapping("/resource/{longitude}/{latitude}/BusStopInformation")
    public List<TSDBusStopInformationModuleType> getBusStopInformation(@PathVariable Double longitude,@PathVariable Double latitude) {
        List<JAXBElement> iterator;
        iterator = repository.getModuleInformationCoord(TSDBusStopInformationModuleType.class, longitude,latitude);
        List<TSDBusStopInformationModuleType> modulelist = new ArrayList<TSDBusStopInformationModuleType>();
        
        for(int i=iterator.size()-1;i>=0;i--){
            //System.out.println("Wow" + (TSDBusStopInformationModuleType) iterator.get(i).getValue());
            modulelist.add((TSDBusStopInformationModuleType) iterator.get(i).getValue()); //I add the value contained in the JAXBElement to the list which should contain TSDBusStopInformationModuleType
        }
        //System.out.println("iteratorsize:" + iterator.size());
        //System.out.println("modulelistsize:" + modulelist.size());
        return iterator.isEmpty() ? null : modulelist; // Question mark is the ternary condition , should remember it
    }

    


    /*Code Liam wrote Below */
    @GetMapping("/resource/{epcURI}/LiamTestModule")
    public TSDLiamTestModuleType getLiamTest(@PathVariable String epcURI) {
        List<JAXBElement> iterator;
        iterator = repository.getModuleInformation(TSDLiamTestModuleType.class, epcURI);
        return iterator.isEmpty() ? null : (TSDLiamTestModuleType) iterator.get(0).getValue();
    }

}
