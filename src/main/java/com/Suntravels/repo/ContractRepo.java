package com.Suntravels.repo;

import com.Suntravels.model.Contract;
import com.Suntravels.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepo extends JpaRepository<Contract, Long>
{
    List<Contract> findByHotelName( String hotelName );
}
