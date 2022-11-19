
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

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TSD_ProductDataType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TSD_ProductDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="epcURI" type="{urn:gs1:shared:shared_common:xsd:3}EPCURIType"/>
 *         &lt;element name="targetMarket" type="{urn:gs1:shared:shared_common:xsd:3}CountryCodeType"/>
 *         &lt;element name="informationProviderGLN" type="{urn:gs1:shared:shared_common:xsd:3}GLNType"/>
 *         &lt;element name="informationProviderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="timeToLive" type="{http://www.w3.org/2001/XMLSchema}duration" minOccurs="0"/>
 *         &lt;element name="productDataRecord" type="{urn:gs1:tsd:product_data:xsd:1}TSD_ProductDataRecordType" maxOccurs="unbounded"/>
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
@XmlType(name = "TSD_ProductDataType", namespace = "urn:gs1:tsd:product_data:xsd:1", propOrder = {
    "serializedGLN",
    "buildingName",
    "buildingCode",
    "longitude",
    "latitude",
    "productDataRecord",
    "avpList"
})

public class TSDProductDataType {
    @Id
    @XmlTransient
    private final String id = null;

    @XmlElement(required = true)
    protected String serializedGLN;
    @XmlElement(required = true)
    protected String buildingName;
    @XmlElement(required = true)
    protected String buildingCode;
    @XmlElement(required = true)
    protected Double longitude;
    @XmlElement(required = true)
    protected Double latitude;
    @XmlElement(required = true)
    protected List<TSDProductDataRecordType> productDataRecord;
    protected TSDAttributeValuePairListType avpList;

    /**
     * Gets the value of the epcURI property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSerializedGLN() {
        return serializedGLN;
    }

    /**
     * Sets the value of the epcURI property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSerializedGLN(String value) {
        this.serializedGLN = value;
    }

    /**
     * Gets the value of the targetMarket property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * Sets the value of the targetMarket property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBuildingName(String value) {
        this.buildingName = value;
    }

    /**
     * Gets the value of the informationProviderGLN property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getBuildingCode() {
        return buildingCode;
    }

    /**
     * Sets the value of the informationProviderGLN property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setBuildingCode(String value) {
        this.buildingCode = value;
    }

    /**
     * Gets the value of the informationProviderName property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the informationProviderName property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    
     /**
     * Gets the value of the informationProviderName property.
     *
     * @return
     *     possible object is
     *     {@link Double }
     *
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the informationProviderName property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     *
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

    /**
     * Gets the value of the productDataRecord property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productDataRecord property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductDataRecord().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSDProductDataRecordType }
     *
     *
     */
    public List<TSDProductDataRecordType> getProductDataRecord() {
        if (productDataRecord == null) {
            productDataRecord = new ArrayList<TSDProductDataRecordType>();
        }
        return this.productDataRecord;
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
