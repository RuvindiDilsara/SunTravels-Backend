package com.Suntravels.model;

public class Room
{
    private Integer noOfRooms;
    private Integer noOfAdults;

    public Room( Integer noOfRooms, Integer noOfAdults )
    {
        this.noOfRooms = noOfRooms;
        this.noOfAdults = noOfAdults;
    }

    public Room()
    {
    }

    public Integer getNoOfRooms()
    {
        return noOfRooms;
    }

    public void setNoOfRooms( Integer noOfRooms )
    {
        this.noOfRooms = noOfRooms;
    }

    public Integer getNoOfAdults()
    {
        return noOfAdults;
    }

    public void setNoOfAdults( Integer noOfAdults )
    {
        this.noOfAdults = noOfAdults;
    }

    @Override
    public String toString()
    {
        return "Room{" +
                       "noOfRooms=" + noOfRooms +
                       ", noOfAdults=" + noOfAdults +
                       '}';
    }
}
