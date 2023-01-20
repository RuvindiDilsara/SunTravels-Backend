package com.Suntravels.service;

import com.Suntravels.model.Contract;
import com.Suntravels.model.Hotel;
import com.Suntravels.repo.ContractRepo;
import com.Suntravels.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService
{
    private final ContractRepo contractRepo;
    private final HotelRepo hotelRepo;


    @Autowired
    public ContractService( ContractRepo contractRepo,
                            HotelRepo hotelRepo)
    {
        this.contractRepo = contractRepo;
        this.hotelRepo = hotelRepo;
    }

    public Contract addContract(Contract contract){
        return contractRepo.save( contract );
    }

    public List<Contract> findAllContracts(){
        return contractRepo.findAll();
    }

    //updateContract & delete contract - if necessary

    public Contract findContractById(Long contractId){
        return contractRepo.findById( contractId )
                       .orElseThrow(()-> new IllegalStateException
                                                 ("contract id "+contractId+" was not found!"));
    }
}
