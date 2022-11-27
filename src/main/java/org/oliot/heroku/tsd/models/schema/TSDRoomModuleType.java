package org.oliot.heroku.tsd.models.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TSD_RoomModuleType", namespace = "urn:gs1:tsd:room_module:xsd:1", propOrder = {
    "roomNumber",
    "roomFloor",
    "contactNumber",
    "roomName",
    "roomPurpose",
    "roomLocation",
    "capacity",
    "isReserved"
})
public class TSDRoomModuleType {

    @XmlElement(required = true)
    protected Integer roomNumber;
    @XmlElement(required = true)
    protected Integer roomFloor;
    @XmlElement(required = true)
    protected Long contactNumber;
    @XmlElement(required = true)
    protected Description70Type roomName;
    @XmlElement(required = true)
    protected Description500Type roomPurpose;
    @XmlElement(required = true)
    protected TSDRoomLocationType roomLocation;
    @XmlElement(required = true)
    protected Integer capacity;
    @XmlElement(required = true)
    protected boolean isReserved;

    

    /**
     * Gets the value of the refBusStops property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the value of the refBusStops property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setRoomNumber(Integer value) {
        this.roomNumber = value;
    }

    /**
     * Gets the value of the localID property.
     *
     * @return
     *     possible object is
     *     {@link TSDSingleValueMetaType }
     *
     */
    public Integer getRoomFloor() {
        return roomFloor;
    }

    /**
     * Sets the value of the localID property.
     *
     * @param value
     *     allowed object is
     *     {@link TSDSingleValueMetaType }
     *
     */
    public void setRoomFloor(Integer value) {
        this.roomFloor = value;
    }

    /**
     * Gets the value of the shortID property.
     *
     * @return
     *     possible object is
     *     {@link TSDSingleValueMetaType }
     *
     */
    public Long getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the value of the shortID property.
     *
     * @param value
     *     allowed object is
     *     {@link TSDSingleValueMetaType }
     *
     */
    public void setContactNumber(Long value) {
        this.contactNumber = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link TSDSingleValueMetaType }
     *
     */
    public Description70Type getRoomName() {
        return roomName;
    }

    public void setRoomName(Description70Type value)
    {
        this.roomName=value;
    }

    
    public Description500Type getRoomPurpose() {
        return roomPurpose;
    }

    public void setRoomPurpose(Description500Type value)
    {
        this.roomPurpose=value;
    }

    public TSDRoomLocationType getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(TSDRoomLocationType value)
    {
        this.roomLocation=value;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer value)
    {
        this.capacity=value;
    }

    public boolean getIsReversed() {
        return isReserved;
    }

    public void setIsReserved(boolean value)
    {
        this.isReserved=value;
    }

}
