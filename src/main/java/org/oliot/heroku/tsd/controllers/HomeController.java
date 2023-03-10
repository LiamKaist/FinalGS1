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

import org.oliot.heroku.tsd.exceptions.ResourceConflictException;
import org.oliot.heroku.tsd.exceptions.ResourceGeneralException;
import org.oliot.heroku.tsd.models.ProductDataRepository;
import org.oliot.heroku.tsd.models.schema.ObjectFactory;
import org.oliot.heroku.tsd.models.schema.*;
import org.oliot.heroku.tsd.services.ProductDataValidationEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.StringReader;


@Controller
public class HomeController {

    private ProductDataRepository repository;

    @Autowired
    public HomeController(ProductDataRepository repository) {
        this.repository = repository;
    }

    @ExceptionHandler(ResourceConflictException.class)
    public String handleResourceConflictException(Model model) {
        model.addAttribute("errorMessage", "Product already exists in database!");
        return "404";
    }

    @ExceptionHandler(ResourceGeneralException.class)
    public String handleResourceGeneralException(Model model) {
        model.addAttribute("errorMessage", "Unknown Error! Please try again...");
        return "404";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /* @PostMapping("/insert")
    public String insert() {
        String datatodisplay ="Liam";
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaFile = new File("src/main/java/org/oliot/heroku/tsd/models/schema/tsd/ProductData.xsd");
            Schema schema = schemaFactory.newSchema(schemaFile);

            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new ProductDataValidationEventHandler());

            StringReader reader = new StringReader(xmldata);

            JAXBElement<TSDProductDataType> jaxbElement
                    = (JAXBElement<TSDProductDataType>) unmarshaller.unmarshal(reader);
            TSDProductDataType tsdProductDataType = jaxbElement.getValue();
            repository.save(tsdProductDataType);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new ResourceConflictException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceGeneralException();
        }

        return datatodisplay;
    } */
    

    @PostMapping("/insert")
    public String insert(@RequestParam("editor") String xmldata) { /*My understanding is that editor is the key for the xml being sent and here we are requesting the xml being sent's xml */
        try {

            // to check receiving end
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaFile = new File("src/main/java/org/oliot/heroku/tsd/models/schema/tsd/ProductData.xsd");
            Schema schema = schemaFactory.newSchema(schemaFile);
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new ProductDataValidationEventHandler());

            //Creating a marshaller for RoomModule.xsd to check the validity of the incoming xml
            File roomSchemaFile = new File("src/main/java/org/oliot/heroku/tsd/models/schema/tsd/RoomModule.xsd");
            Schema roomSchema = schemaFactory.newSchema(roomSchemaFile);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setSchema(roomSchema);
            marshaller.setEventHandler(new ProductDataValidationEventHandler());

            //Creating a marshaller for BuildingServicesModule.xsd to check the validity of the incoming xml
            File BServiceSchemaFile = new File("src/main/java/org/oliot/heroku/tsd/models/schema/tsd/BuildingServicesModule.xsd");
            Schema bServiceSchema = schemaFactory.newSchema(BServiceSchemaFile);
            Marshaller bServicemarshaller = jaxbContext.createMarshaller();
            marshaller.setSchema(roomSchema);
            marshaller.setEventHandler(new ProductDataValidationEventHandler());
            

            StringReader reader = new StringReader(xmldata);

            JAXBElement<TSDProductDataType> jaxbElement
                    = (JAXBElement<TSDProductDataType>) unmarshaller.unmarshal(reader);
            TSDProductDataType tsdProductDataType = jaxbElement.getValue();
            
            //This following part is to test whether or not the types of the xsd are satisfied
            ExtensionType obj = tsdProductDataType.getBuildingRecord().get(0).getModule().get(0);
            for (Object o: obj.getAny()) {
            JAXBElement elem = (JAXBElement)o;
            switch (elem.getName().getLocalPart()) {
                case "roomModule":
                    marshaller.marshal(elem, System.out); 
                    TSDRoomModuleType roomModuleType =
                            (TSDRoomModuleType) elem.getValue();
                    System.out.println(roomModuleType.getRoomName());
                    break;
                case "buildingServicesModule":
                    bServicemarshaller.marshal(elem, System.out); //Testing one of the module xml

                    TSDBuildingServicesModuleType buildingServicesModuleType =
                            (TSDBuildingServicesModuleType) elem.getValue();
                    System.out.println(buildingServicesModuleType.getCampusServiceType());
                }
            }
            
            repository.insertOrReplace(tsdProductDataType);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new ResourceConflictException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceGeneralException();
        }

        return "redirect:/";
    } /*this is the original post mapping */
    
    /*@PostMapping("/insert")
    public String insert(@RequestParam("editor") String xmldata) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaFile = new File("src/main/java/org/oliot/heroku/tsd/models/schema/tsd/LiamTestModule.xsd");
            Schema schema = schemaFactory.newSchema(schemaFile);

            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            unmarshaller.setSchema(schema);
            unmarshaller.setEventHandler(new ProductDataValidationEventHandler());

            StringReader reader = new StringReader(xmldata);

            JAXBElement<TSDLiamTestModuleType> jaxbElement
                    = (JAXBElement<TSDLiamTestModuleType>) unmarshaller.unmarshal(reader);
            TSDLiamTestModuleType tsdLiamModuleType = jaxbElement.getValue();
            repository.save(tsdLiamModuleType);
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            throw new ResourceConflictException();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResourceGeneralException();
        }

        return "redirect:/";
    }*/
    

    @PostMapping("/reset")
    public String reset() {
        //repository.deleteAll(); //Removed the possibility to delete the repo
        return "redirect:/";
    }
}