package com.Suntravels.controller;

import com.Suntravels.model.Room;
import com.Suntravels.model.RoomType;
import com.Suntravels.model.SearchCriteria;
import com.Suntravels.model.SearchResult;
import com.Suntravels.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController
{
    private final SearchService service;

    public SearchController( SearchService service )
    {
        this.service = service;
    }

//    @GetMapping()
//    public String hello(){
//        return "Hello";
//    }

//    @PostMapping()
//    public ResponseEntity<SearchCriteria> searchAvailability(@RequestBody SearchCriteria searchCriteria   ){
//        return new ResponseEntity<>(searchCriteria, HttpStatus.OK );
//    }

    @PostMapping()
    public ResponseEntity<List<SearchResult>> searchAvailability(@RequestBody SearchCriteria searchCriteria   ){
        List<SearchResult> searchResults = service.searchAvailability(

                searchCriteria.getCheckInDate(),
                searchCriteria.getNoOfNights(),
                searchCriteria.getRooms());

        return new ResponseEntity<>(searchResults, HttpStatus.OK );
    }

    @PostMapping("/test")
    public String test(@RequestBody LocalDate checkInDate){
        LocalDate receivedDate = checkInDate;
        return receivedDate.toString();
    }
}
