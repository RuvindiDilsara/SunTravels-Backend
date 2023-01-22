package com.Suntravels.repo;

import com.Suntravels.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HotelRepo extends JpaRepository<Hotel, Long>
{
    Hotel findByHotelName(String hotelName);
}
