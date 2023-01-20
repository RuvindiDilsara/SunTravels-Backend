package com.Suntravels.controller;

import com.Suntravels.model.Contract;
import com.Suntravels.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contract")
public class ContractController
{
    private final ContractService contractService;

    public ContractController( ContractService contractService )
    {
        this.contractService = contractService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contract>> getAllContracts(){
        List<Contract> contracts = contractService.findAllContracts();
        return new ResponseEntity<>( contracts, HttpStatus.OK );
    }

    @GetMapping("/find/{contractId}")
    public ResponseEntity<Contract> getContractById( @PathVariable("contractId") Long contractId ){
        Contract contract = contractService.findContractById( contractId );
        return new ResponseEntity<>( contract, HttpStatus.OK );
    }

    @PostMapping("/add")
    public ResponseEntity<Contract> addContract( @RequestBody Contract contract ){
        Contract newContract = contractService.addContract( contract );
        return new ResponseEntity<>( newContract, HttpStatus.CREATED );
    }

    //put mapping and delete mapping  - if necessary
}