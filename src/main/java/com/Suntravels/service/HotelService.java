package com.Suntravels.service;

import com.Suntravels.exception.hotelNotFoundExeption;
import com.Suntravels.model.Hotel;
import com.Suntravels.repo.HotelRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService
{
    private final HotelRepo hotelRepo;

    @Autowired
    public HotelService( HotelRepo hotelRepo )
    {
        this.hotelRepo = hotelRepo;
    }

    public Hotel addHotel( Hotel hotel){
        return hotelRepo.save(hotel);
    }

    public List<Hotel> findAllHotels(){
        return hotelRepo.findAll();
    }

    @Transactional
    public Hotel updateHotel(Hotel hotel){
        return hotelRepo.save( hotel );
    }

    public Hotel findHotelById(Long hotelId){
        return hotelRepo.findById(hotelId)
                        .orElseThrow(()-> new hotelNotFoundExeption("hotel id "+hotelId+" was not found"));
    }

    public void deleteHotel(Long hotelId){
        boolean exists = hotelRepo.existsById( hotelId );
        if(!exists){
            throw new hotelNotFoundExeption("hotel id "+hotelId+" was not found");
        }
        hotelRepo.deleteById( hotelId );
    }

}
