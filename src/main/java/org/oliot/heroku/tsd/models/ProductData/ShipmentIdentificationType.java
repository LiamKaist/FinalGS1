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

package org.oliot.heroku.tsd.models.ProductData;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ShipmentIdentificationType complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="ShipmentIdentificationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="gsin" type="{urn:gs1:shared:shared_common:xsd:3}GSINType"/>
 *         &lt;element name="additionalShipmentIdentification" type="{urn:gs1:shared:shared_common:xsd:3}AdditionalShipmentIdentificationType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentIdentificationType", propOrder = {
        "gsin",
        "additionalShipmentIdentification"
})
public class ShipmentIdentificationType {

    @XmlElement(required = true)
    protected String gsin;
    protected List<AdditionalShipmentIdentificationType> additionalShipmentIdentification;

    /**
     * Gets the value of the gsin property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGsin() {
        return gsin;
    }

    /**
     * Sets the value of the gsin property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGsin(String value) {
        this.gsin = value;
    }

    /**
     * Gets the value of the additionalShipmentIdentification property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalShipmentIdentification property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalShipmentIdentification().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalShipmentIdentificationType }
     */
    public List<AdditionalShipmentIdentificationType> getAdditionalShipmentIdentification() {
        if (additionalShipmentIdentification == null) {
            additionalShipmentIdentification = new ArrayList<AdditionalShipmentIdentificationType>();
        }
        return this.additionalShipmentIdentification;
    }

}
