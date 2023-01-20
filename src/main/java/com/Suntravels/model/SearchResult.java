package com.Suntravels.model;

import java.util.List;
import java.util.Optional;

public class SearchResult
{
    private Hotel hotel;
    private List<RoomDetail> roomDetails;
    private boolean isAvailable;

    public SearchResult()
    {
    }

    public SearchResult( Hotel hotel, List<RoomDetail> roomDetails, boolean isAvailable )
    {
        this.hotel = hotel;
        this.roomDetails = roomDetails;
        this.isAvailable = isAvailable;
    }

    public Hotel getHotel()
    {
        return hotel;
    }

    public void setHotel( Hotel hotel )
    {
        this.hotel = hotel;
    }

    public List<RoomDetail> getRoomDetails()
    {
        return roomDetails;
    }

    public void setRoomDetails( List<RoomDetail> roomDetails )
    {
        this.roomDetails = roomDetails;
    }

    public boolean isAvailable()
    {
        return isAvailable;
    }

    public void setAvailable( boolean available )
    {
        isAvailable = available;
    }

    @Override
    public String toString()
    {
        return "SearchResult{" +
                       "hotel=" + hotel +
                       ", roomDetails=" + roomDetails +
                       ", isAvailable=" + isAvailable +
                       '}';
    }
}
