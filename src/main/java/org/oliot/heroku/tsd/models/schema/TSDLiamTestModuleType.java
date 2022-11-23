
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
            <xsd:element name="RoomName" type="shared_common:Description70Type" minOccurs="1" maxOccurs="2"/>      
            <xsd:element name="RoomPurpose" type="shared_common:Description70Type" minOccurs="1" maxOccurs="2">
        </sequence>
    </xsd:complexType>

package org.oliot.heroku.tsd.models.schema;


*/

@XmlAccessorType(XmlAccessType.FIELD)


@XmlType(name = "TSD_LiamTestModuleType", namespace = "urn:gs1:tsd:liam_test_module:xsd:1", propOrder = {
    "roomName",
    "roomPurpose",
    "access"
})


public class TSDLiamTestModuleType {

    @Id
    @XmlTransient
    private final String id = null;

    @XmlElement(required = true)
    protected List<Description70Type> roomName;
    @XmlElement(required = true)
    protected List<Description70Type> roomPurpose;
    @XmlElement(required = true)
    protected List<Description70Type> access;



    /**
     * Gets the value of the RoomName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the RoomName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description70Type }
     * 
     * 
     */
    public List<Description70Type> getRoomName() {
        if (roomName == null) {
            roomName = new ArrayList<Description70Type>();
        }
        return this.roomName;
    }

    
     
    /**
     * Gets the value of the RoomName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the RoomName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoomName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Description70Type }
     * 
     * 
     */
     
   
    public List<Description70Type> getRoomPurpose() {
       if (roomPurpose == null) {
           roomPurpose = new ArrayList<Description70Type>();
       }
       return this.roomPurpose;
    }


    /**
     * Gets the value of the sgln property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<Description70Type> getAccess() {
        if (access == null) {
            access = new ArrayList<Description70Type>();
        }
        return this.access;
    }
   
}

