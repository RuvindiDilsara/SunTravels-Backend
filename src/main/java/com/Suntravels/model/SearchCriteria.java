package com.Suntravels.model;

import java.time.LocalDate;
import java.util.List;

public class SearchCriteria
{
    private LocalDate checkInDate;
    private Integer noOfNights;
    private List<Room> rooms;

    public SearchCriteria()
    {
    }

    public SearchCriteria( LocalDate checkInDate, Integer noOfNights, List<Room> rooms )
    {
        this.checkInDate = checkInDate;
        this.noOfNights = noOfNights;
        this.rooms = rooms;
    }

    public LocalDate getCheckInDate()
    {
        return checkInDate;
    }

    public void setCheckInDate( LocalDate checkInDate )
    {
        this.checkInDate = checkInDate;
    }


    public List<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms( List<Room> rooms )
    {
        this.rooms = rooms;
    }

    public Integer getNoOfNights()
    {
        return noOfNights;
    }

    public void setNoOfNights( Integer noOfNights )
    {
        this.noOfNights = noOfNights;
    }

    @Override
    public String toString()
    {
        return "SearchCriteria{" +
                       "checkInDate=" + checkInDate +
                       ", noOfNights=" + noOfNights +
                       ", rooms=" + rooms +
                       '}';
    }
}
