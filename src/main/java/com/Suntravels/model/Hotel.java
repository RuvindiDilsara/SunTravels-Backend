package com.Suntravels.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table
public class Hotel implements Serializable
{
    @Id
    @SequenceGenerator(
            name = "hotel_sequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
                           generator = "hotel_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long hotelId;
    private String hotelName;
    private String address;
    private Integer contactNo;

    public Hotel()
    {
    }

    public Hotel( Long hotelId, String hotelName, String address, Integer contactNo )
    {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.address = address;
        this.contactNo = contactNo;
    }

    public Hotel( String hotelName, String address, Integer contactNo )
    {
        this.hotelName = hotelName;
        this.address = address;
        this.contactNo = contactNo;
    }

    public Long getHotelId()
    {
        return hotelId;
    }

    public void setHotelId( Long hotelId )
    {
        this.hotelId = hotelId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelName( String hotelName )
    {
        this.hotelName = hotelName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public Integer getContactNo()
    {
        return contactNo;
    }

    public void setContactNo( Integer contactNo )
    {
        this.contactNo = contactNo;
    }

    @Override
    public String toString()
    {
        return "Hotel{" +
                       "hotelId=" + hotelId +
                       ", hotelName='" + hotelName + '\'' +
                       ", address='" + address + '\'' +
                       ", contactNo=" + contactNo +
                       '}';
    }
}
