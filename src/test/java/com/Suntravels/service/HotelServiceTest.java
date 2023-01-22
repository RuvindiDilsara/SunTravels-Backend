package com.Suntravels.service;

import com.Suntravels.model.Hotel;
import com.Suntravels.repo.HotelRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith( MockitoExtension.class )
class HotelServiceTest
{
    @Mock private HotelRepo hotelRepo;
    private HotelService underTest;

    @BeforeEach
    void setUp()
    {
        underTest = new HotelService( hotelRepo );
    }

    @Test
    void canAddHotel()
    {
        //given
        Hotel hotel = new Hotel(
                "Galadari",
                "Galle Road, Colombo 01.",
                112345678
        );
        //when
        underTest.addHotel( hotel );

        //then
        ArgumentCaptor<Hotel> hotelArgumentCaptor =
                ArgumentCaptor.forClass( Hotel.class );
        verify( hotelRepo ).save( hotelArgumentCaptor.capture() );

        Hotel capturedHotel = hotelArgumentCaptor.getValue();

        assertThat(capturedHotel).isEqualTo( hotel );
    }

    @Test
    void willThrowWhenAHotelIsAlreadyExists()
    {
        //given
        Hotel hotel = new Hotel(
                "Galadari",
                "Galle Road, Colombo 01.",
                112345678
        );
        given(hotelRepo.findByHotelName( "Galadari" ))
                .willReturn( hotel );
        //when

        //then
        assertThatThrownBy(()->underTest.addHotel( hotel ))
                .isInstanceOf( IllegalStateException.class )
                .hasMessageContaining( "Hotel is already exists!" );

        verify( hotelRepo, never() ).save( any() );
    }

    @Test
    void canfindAllHotels()
    {
        //when
        underTest.findAllHotels();
        //then
        verify(hotelRepo).findAll();
    }

    @Test
    @Disabled
    void updateHotel()
    {
    }

    @Test
    @Disabled
    void findHotelById()
    {
    }

    @Test
    @Disabled
    void deleteHotel()
    {
    }
}