package com.Suntravels.repo;

import com.Suntravels.model.Contract;
import com.Suntravels.model.RoomType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class ContractRepoTest
{

    @Autowired
    private ContractRepo underTest;

    @Test
    void itShouldSelectHotelByHotelName()
    {
        //given
        RoomType roomType1 = new RoomType("Sea view", 20, 3, 23450);
        Date startingDate = new Date(2012,03,12);
        Date endingDate = new Date(2013,03,11);
        Integer markupValue = 23;
        String hotelName = "Galadari";

        Contract contract = new Contract("Hotel Riu Sri Lanka", 12);
        underTest.save( contract );
        //when
        List<Contract> contracts = underTest.findByHotelName( hotelName );

        //then
        assertThat( contracts ).isNotNull();
    }
}