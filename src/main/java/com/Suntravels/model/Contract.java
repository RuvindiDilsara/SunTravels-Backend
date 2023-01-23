package com.Suntravels.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Contract
{
    @Id
    @SequenceGenerator( name = "contract_sequence",
    sequenceName = "contract_sequence",
    allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
                           generator = "contract_sequence"
    )
    @Column(nullable = false, updatable = false)
    private Long contractId;
    private String hotelName;
    private LocalDate startingDate;
    private LocalDate endingDate;

    private Double markupValue;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name= "contract_id")
    private List<RoomType> roomTypes;

    public Contract()
    {
    }

    public Contract( String hotelName, LocalDate startingDate, LocalDate endingDate, List<RoomType> roomTypes,
                     Double markupValue)
    {
        this.hotelName = hotelName;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.roomTypes = roomTypes;
        this.markupValue = markupValue;
    }

    public Contract( String hotelName, Double markupValue )
    {
        this.hotelName = hotelName;
        this.markupValue = markupValue;
    }

    public Contract( Long contractId, String hotelName )
    {
        this.contractId = contractId;
        this.hotelName = hotelName;
    }

    public Contract( Long contractId, String hotelName, LocalDate startingDate, LocalDate endingDate, List<RoomType> roomTypes )
    {
        this.contractId = contractId;
        this.hotelName = hotelName;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.roomTypes = roomTypes;
    }

    public Long getContractId()
    {
        return contractId;
    }

    public void setContractId( Long contractId )
    {
        this.contractId = contractId;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public void setHotelId( String hotelName )
    {
        this.hotelName = hotelName;
    }

    public LocalDate getStartingDate()
    {
        return startingDate;
    }

    public void setStartingDate( LocalDate startingDate )
    {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate()
    {
        return endingDate;
    }

    public void setEndingDate( LocalDate endingDate )
    {
        this.endingDate = endingDate;
    }

    public List<RoomType> getRoomTypes()
    {
        return roomTypes;
    }

    public void setRoomTypes( List<RoomType> roomTypes )
    {
        this.roomTypes = roomTypes;
    }

    public void setHotelName( String hotelName )
    {
        this.hotelName = hotelName;
    }

    public Double getMarkupValue()
    {
        return markupValue;
    }

    public void setMarkupValue( Double markupValue )
    {
        this.markupValue = markupValue;
    }

    @Override
    public String toString()
    {
        return "Contract{" +
                       "contractId=" + contractId +
                       ", hotelName='" + hotelName + '\'' +
                       ", startingDate=" + startingDate +
                       ", endingDate=" + endingDate +
                       ", markupValue=" + markupValue +
                       ", roomTypes=" + roomTypes +
                       '}';
    }
}
