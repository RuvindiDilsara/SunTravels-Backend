package com.Suntravels.controller;

import com.Suntravels.model.Hotel;
import com.Suntravels.repo.HotelRepo;
import com.Suntravels.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController
{
    private final HotelService hotelService;
    private final HotelRepo hotelRepo;

    @Autowired
    public HotelController( HotelService hotelService,
                            HotelRepo hotelRepo )
    {
        this.hotelService = hotelService;
        this.hotelRepo = hotelRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotels = hotelService.findAllHotels();
        return new ResponseEntity<>( hotels, HttpStatus.OK );
    }

    @GetMapping("/find/{hotelId}")
    public ResponseEntity<Hotel> getHotelById( @PathVariable("hotelId") Long hotelId ){
        Hotel hotel = hotelService.findHotelById(hotelId);
        return new ResponseEntity<>( hotel, HttpStatus.OK );
    }

    @PostMapping("/add")
    public ResponseEntity<Hotel> addHotel( @RequestBody Hotel hotel ){
        Hotel newHotel = hotelService.addHotel( hotel );
        return new ResponseEntity<>( newHotel, HttpStatus.CREATED );
    }

    @PutMapping("/update")
    public ResponseEntity<Hotel> updateHotel( @RequestBody Hotel hotel ){
        Hotel updateHotel = hotelService.updateHotel( hotel );
        return new ResponseEntity<>( updateHotel, HttpStatus.OK );
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<?> deleteHotel( @PathVariable("hotelId") Long hotelId ){
        hotelService.deleteHotel( hotelId );
        return new ResponseEntity<>( HttpStatus.OK );
    }
}
