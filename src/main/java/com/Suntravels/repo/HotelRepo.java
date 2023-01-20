package com.Suntravels.repo;

import com.Suntravels.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long>
{
//
//@Query("SELECT s FROM Hotel s WHERE s.hotelName = ?Galadari")
//    Optional<Hotel> findHotelByHotelName( String hotelName );
    Hotel findByHotelName(String hotelName);
}
