package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.commands.AssignCarOwner;
import com.challenge.carworkshop.domain.car.commands.AssignInsurance;
import com.challenge.carworkshop.domain.car.events.AssignedCarOwner;
import com.challenge.carworkshop.domain.car.events.AssignedInsurance;
import com.challenge.carworkshop.domain.car.events.AssignedLicensePlate;
import com.challenge.carworkshop.domain.car.events.CreatedCar;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AssignInsuranceUseCaseTest {

    private static final String CAR_ID = "12345";
    private static final String INSURANCE_ID = "88888888";


    @Mock
    private DomainEventRepository repository;

    @Test
    void assignInsuranceDefault(){
        //Arrange
        var command = new AssignInsurance(CarId.of(CAR_ID),new InsuranceId(INSURANCE_ID),new InsuredAmount(12000));
        var useCase = new AssignInsuranceUseCase();
        Mockito.when(repository.getEventsBy(INSURANCE_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(INSURANCE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var insuranceAssigned = (AssignedInsurance)events.get(0);
        Assertions.assertEquals(12000, insuranceAssigned.getInsuredAmount().value());
        Assertions.assertEquals(INSURANCE_ID, insuranceAssigned.getInsuranceId().value());
    }

    private List<DomainEvent> EventStored() {

        var event =  new CreatedCar(
                new Name("Mario", "Sanchez"),
                new InsuredAmount(12000),
                new CityOfOrigin("Aguachica"),
                new LicenseCode("HHY622"),
                new CarEngineCapacity(2000),
                new Brand("Volkswagen"),
                new Model("Jetta"),
                new Color("Gray")

        );

        return List.of(event);
    }

}