package com.Suntravels.service;

import com.Suntravels.model.Contract;
import com.Suntravels.repo.ContractRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;


@ExtendWith( MockitoExtension.class )
class ContractServiceTest
{
    @Mock private ContractRepo contractRepo;

    private ContractService underTest;

    @BeforeEach
    void setUp()
    {
        underTest = new ContractService( contractRepo );
    }

    @Test
    void addContract()
    {
        //given
        Contract contract = new Contract("Galadari", 23);
        //when
        underTest.addContract( contract );
        //then
        ArgumentCaptor <Contract> contractArgumentCaptor = ArgumentCaptor.forClass( Contract.class );
        verify(contractRepo).save( contractArgumentCaptor.capture() );
        Contract capturedContract = contractArgumentCaptor.getValue();
        assertThat( capturedContract ).isEqualTo( contract );
    }

    @Test
    void canFindAllContracts()
    {
        //when
        underTest.findAllContracts();

        //then
        verify( contractRepo ).findAll();
    }

    @Test
    @Disabled
    void findContractById()
    {
        //give
        Contract contract = new Contract("Galadari", 12);
        underTest.addContract( contract );
        //when
        Contract receivedContract = underTest.findContractById( 1L );
        //then
        assertThat(receivedContract).isEqualTo( contract );
    }
}