package com.Suntravels.model;

import java.time.LocalDate;
import java.util.List;

public class SearchCriteria
{
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private List<Room> rooms;

    public SearchCriteria()
    {
    }

    public SearchCriteria( LocalDate checkInDate, LocalDate chekcOutDate, List<Room> rooms )
    {
        this.checkInDate = checkInDate;
        this.checkOutDate = chekcOutDate;
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

    public LocalDate getCheckOutDate()
    {
        return checkOutDate;
    }

    public void setChekcOutDate( LocalDate chekcOutDate )
    {
        this.checkOutDate = chekcOutDate;
    }

    public List<Room> getRooms()
    {
        return rooms;
    }

    public void setRooms( List<Room> rooms )
    {
        this.rooms = rooms;
    }

    @Override
    public String toString()
    {
        return "SearchCriteria{" +
                       "checkInDate=" + checkInDate +
                       ", chekcOutDate=" + checkOutDate +
                       ", rooms=" + rooms +
                       '}';
    }
}
