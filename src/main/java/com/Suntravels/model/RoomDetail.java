package com.Suntravels.model;

public class RoomDetail
{
    private String roomTypeName;
    private boolean availability;
    private Integer pricePerOnePerson;

    public RoomDetail()
    {
    }

    public RoomDetail( String roomTypeName, boolean availability, Integer pricePerOnePerson )
    {
        this.roomTypeName = roomTypeName;
        this.availability = availability;
        this.pricePerOnePerson = pricePerOnePerson;
    }

    public String getRoomTypeName()
    {
        return roomTypeName;
    }

    public void setRoomTypeName( String roomTypeName )
    {
        this.roomTypeName = roomTypeName;
    }

    public boolean getAvailability()
    {
        return availability;
    }

    public void setAvailability( boolean availability )
    {
        this.availability = availability;
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
        return "RoomDetail{" +
                       "roomTypeName='" + roomTypeName + '\'' +
                       ", availability=" + availability +
                       ", pricePerOnePerson=" + pricePerOnePerson +
                       '}';
    }


}
