
package org.oliot.heroku.tsd.models.schema;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.Duration;
import java.util.ArrayList;
import java.util.List;
/* 
<xsd:import namespace="urn:gs1:shared:shared_common:xsd:3" schemaLocation="../shared/SharedCommon.xsd"/>
    <xsd:import namespace="urn:gs1:tsd:tsd_common:xsd:1" schemaLocation="TSDCommon.xsd"/>
    
    <xsd:element name="liamTestModule" type="liam_test_module:TSD_LiamTestModuleType"/>

    <xsd:complexType name="TSD_LiamTestModuleType">
        <sequence>
            <xsd:element name="productName" type="shared_common:Description70Type" minOccurs="1" maxOccurs="2"/>      
            <xsd:element name="extraName" type="shared_common:Description70Type" minOccurs="1" maxOccurs="2">
        </sequence>
    </xsd:complexType>

package org.oliot.heroku.tsd.models.schema;


*/

@XmlAccessorType(XmlAccessType.FIELD)


@XmlType(name = "TSD_LiamTestModuleType", namespace = "urn:gs1:tsd:liam_test_module:xsd:1", propOrder = {
    "productName",
    "extraName",
    "sgln"
})


public class TSDLiamTestModuleType {

    @Id
    @XmlTransient
    private final String id = null;

    @XmlElement(required = true)
    protected List<Description70Type> productName;
    @XmlElement(required = true)
    protected List<Description70Type> extraName;
    @XmlElement(required = true)
    protected String sgln;



    /**
     * Gets the value of the productName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description70Type }
     * 
     * 
     */
    public List<Description70Type> getProductName() {
        if (productName == null) {
            productName = new ArrayList<Description70Type>();
        }
        return this.productName;
    }

    
     
    /**
     * Gets the value of the productName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the productName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProductName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description70Type }
     * 
     * 
     */
     
   
    public List<Description70Type> getExtraName() {
       if (extraName == null) {
           extraName = new ArrayList<Description70Type>();
       }
       return this.extraName;
    }


    /**
     * Gets the value of the sgln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSgln() {
        return sgln;
    }
   
}

