
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

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSD_BuildingRecordType", namespace = "urn:gs1:tsd:product_data:xsd:1", propOrder = {
    "buildingDescription",
    "contactNumber",
    "module",
    "avpList"
})
public class TSDBuildingRecordType {

    protected Description1000Type buildingDescription;
    protected Integer contactNumber;
    @XmlElement(required = true)
    protected List<ExtensionType> module;
    protected TSDAttributeValuePairListType avpList;

    /**
     * Gets the value of the buildingDescription property.
     * 
     * @return
     *     possible object is
     *     {@link Description1000Type }
     *     
     */
    public Description1000Type getbuildingDescription() {
        return buildingDescription;
    }

    /**
     * Sets the value of the buildingDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link Description1000Type }
     *     
     */
    public void setbuildingDescription(Description1000Type value) {
        this.buildingDescription = value;
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
