package com.Suntravels.service;

import com.Suntravels.model.Contract;
import com.Suntravels.model.Hotel;
import com.Suntravels.model.Room;
import com.Suntravels.model.RoomDetail;
import com.Suntravels.model.RoomType;
import com.Suntravels.model.SearchResult;
import com.Suntravels.repo.ContractRepo;
import com.Suntravels.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService
{
    private final HotelRepo hotelRepo;
    private final ContractRepo contractRepo;

    @Autowired
    public SearchService( HotelRepo hotelRepo, ContractRepo contractRepo )
    {
        this.hotelRepo = hotelRepo;
        this.contractRepo = contractRepo;
    }

    public List<SearchResult> searchAvailability( LocalDate checkInDate, Integer noOfNights, List<Room> rooms )
    {
        LocalDate checkOutDate = checkInDate.plusDays( noOfNights );
        List<SearchResult> searchResults = new ArrayList<>();
        boolean isAvailable = false;
        List<Hotel> hotels = hotelRepo.findAll();
        SearchResult searchResult = null;
        for( Hotel hotel : hotels )
        {
            List<RoomDetail> roomDetails = new ArrayList<>();
            List<Contract> contracts = contractRepo.findByHotelName( hotel.getHotelName() );
            searchResult = new SearchResult();
            searchResult.setHotel( hotel );
            isAvailable = false;
            for( Contract contract : contracts )
            {
                if( ( contract.getStartingDate().isBefore( checkInDate ) ) &
                            ( contract.getEndingDate().isAfter( checkOutDate ) ) )
                {
                    List<RoomType> roomTypes = contract.getRoomTypes();
                    Double markupValue = 100 + contract.getMarkupValue();
                    for( RoomType roomType : roomTypes )
                    {
                        RoomDetail roomDetail = new RoomDetail();
                        roomDetail.setRoomTypeName( roomType.getRoomTypeName() );
                        roomDetail.setAvailability( true );
                        for( Room room : rooms )
                        {
                            if( room.getNoOfRooms() > roomType.getNoOfRooms() |
                                        room.getNoOfAdults() > roomType.getMaxNoOfAdults() )
                            {
                                roomDetail.setAvailability( false );
                                break;
                            }
                        }

                        if( roomDetail.getAvailability() )
                        {
                            isAvailable = true;
                            roomDetail.setPricePerOnePerson( roomType.getPricePerOnePerson() * markupValue / 100 * noOfNights);
                        }
                        roomDetails.add( roomDetail );
                    }
                    searchResult.setRoomDetails( roomDetails );
                }
            }
            searchResult.setAvailable( isAvailable );
            searchResults.add( searchResult );
        }
        return searchResults;

    }

}
