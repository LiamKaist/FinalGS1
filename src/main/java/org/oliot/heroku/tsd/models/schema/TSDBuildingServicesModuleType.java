
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

package org.oliot.heroku.tsd.models.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TSD_BasicProductInformationModuleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TSD_BasicProductInformationModuleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numberOfServiceTypes" type="{urn:gs1:shared:shared_common:xsd:3}Description80Type" maxOccurs="unbounded"/>
 *         &lt;element name="consumerMarketingDescription" type="{urn:gs1:shared:shared_common:xsd:3}Description2500Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="gpcCategoryCode" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="\d{8}"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="regulatednumberOfServiceTypes" type="{urn:gs1:shared:shared_common:xsd:3}Description500Type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="brandNameInformation" type="{urn:gs1:tsd:basic_product_information_module:xsd:1}TSD_BrandNameInformationType"/>
 *         &lt;element name="productInformationLink" type="{urn:gs1:tsd:tsd_common:xsd:1}TSD_ProductInformationLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="imageLink" type="{urn:gs1:tsd:tsd_common:xsd:1}TSD_ImageLinkType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="packagingSignatureLine" type="{urn:gs1:tsd:basic_product_information_module:xsd:1}TSD_PackagingSignatureLineType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="avpList" type="{urn:gs1:tsd:tsd_common:xsd:1}TSD_AttributeValuePairListType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSD_BuildingServicesModuleType", namespace = "urn:gs1:tsd:building_services_module:xsd:1", propOrder = {
    "numberOfServiceTypes",
    "campusServiceType",
    "module",
    "avpList"
})
public class TSDBuildingServicesModuleType {

    @XmlElement(required = true)
    protected Integer numberOfServiceTypes;
    @XmlElement(required = true)
    protected String campusServiceType;
    protected List<ExtensionType> module;
    protected TSDAttributeValuePairListType avpList;

    /**
     * Gets the value of the numberOfServiceTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numberOfServiceTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getnumberOfServiceTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description80Type }
     * 
     * 
     */
    public Integer getnumberOfServiceTypes() {
        return numberOfServiceTypes;
    }


    /**
     * Gets the value of the numberOfServiceTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the numberOfServiceTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getnumberOfServiceTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description80Type }
     * 
     * 
     */
    public String getCampusServiceType() {
       
        return campusServiceType;
    }

    

    /**
     * Gets the value of the module property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the module property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getModule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExtensionType }
     * 
     * 
     */
    public List<ExtensionType> getModule() {
        if (module == null) {
            module = new ArrayList<ExtensionType>();
        }
        return this.module;
    }
    
    
    /**
     * Gets the value of the avpList property.
     * 
     * @return
     *     possible object is
     *     {@link TSDAttributeValuePairListType }
     *     
     */
    public TSDAttributeValuePairListType getAvpList() {
        return avpList;
    }

    /**
     * Sets the value of the avpList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TSDAttributeValuePairListType }
     *     
     */
    public void setAvpList(TSDAttributeValuePairListType value) {
        this.avpList = value;
    }

}
