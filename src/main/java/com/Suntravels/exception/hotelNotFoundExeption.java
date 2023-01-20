package com.Suntravels.exception;

public class hotelNotFoundExeption extends RuntimeException
{
    public hotelNotFoundExeption( String message)
    {
        super(message);
    }
}
