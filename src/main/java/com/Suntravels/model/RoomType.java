package com.Suntravels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class RoomType
{
    @Id
    @SequenceGenerator( name = "room_type_sequence",
    sequenceName = "room_type_sequence",
    allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
                           generator = "room_type_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long roomTypeId;
    private String roomTypeName;
    private Integer noOfRooms;
    private Integer maxNoOfAdults;
    private Integer pricePerOnePerson;

    public RoomType()
    {
    }

    public RoomType( String roomTypeName, Integer noOfRooms, Integer maxNoOfAdults, Integer pricePerOnePerson )
    {
        this.roomTypeName = roomTypeName;
        this.noOfRooms = noOfRooms;
        this.maxNoOfAdults = maxNoOfAdults;
        this.pricePerOnePerson = pricePerOnePerson;
    }

    public Long getRoomTypeId()
    {
        return roomTypeId;
    }

    public void setRoomTypeId( Long roomTypeId )
    {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomTypeName()
    {
        return roomTypeName;
    }

    public void setRoomTypeName( String roomTypeName )
    {
        this.roomTypeName = roomTypeName;
    }

    public Integer getNoOfRooms()
    {
        return noOfRooms;
    }

    public void setNoOfRooms( Integer noOfRooms )
    {
        this.noOfRooms = noOfRooms;
    }

    public Integer getMaxNoOfAdults()
    {
        return maxNoOfAdults;
    }

    public void setMaxNoOfAdults( Integer maxNoOfAdults )
    {
        this.maxNoOfAdults = maxNoOfAdults;
    }

    public Integer getPricePerOnePerson()
    {
        return pricePerOnePerson;
    }

    public void setPricePerOnePerson( Integer pricePerOnePerson )
    {
        this.pricePerOnePerson = pricePerOnePerson;
    }

    @Override
    public String toString()
    {
        return "RoomType{" +
                       "roomTypeId=" + roomTypeId +
                       ", roomType='" + roomTypeName + '\'' +
                       ", noOfRooms=" + noOfRooms +
                       ", maxNoOfAdults=" + maxNoOfAdults +
                       ", pricePerOnePerson=" + pricePerOnePerson +
                       '}';
    }
}
