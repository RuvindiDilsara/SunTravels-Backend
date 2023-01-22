package com.Suntravels.repo;

import com.Suntravels.model.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.mockito.Mockito.*;
@DataJpaTest
class HotelRepoTest
{
    @Autowired
    private HotelRepo underTest;

    @Test
    void itShouldSelectHotelByHotelName()
    {
        //given
        String hotelName = "Galadari";
        Hotel hotel = new Hotel(
                hotelName,
                "Galle Road, Colombo 01.",
                112345678
        );
        underTest.save( hotel );
        //when
        Hotel recievedHotel = underTest.findByHotelName( hotelName);

        //then
        assertThat( recievedHotel ).isEqualTo( hotel );
    }
}