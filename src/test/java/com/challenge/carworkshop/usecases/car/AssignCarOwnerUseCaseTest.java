package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.commands.AssignCarOwner;
import com.challenge.carworkshop.domain.car.events.AssignedCarOwner;
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

@ExtendWith(MockitoExtension.class)
class AssignCarOwnerUseCaseTest {
    private static final String CAR_ID = "12345";
    private static final String CAR_OWNER_ID = "54321";

    @Mock
    private DomainEventRepository repository;


    @Test
    void assignCarOwnerDefault(){

        //Arrange
        var command = new AssignCarOwner(CarId.of(CAR_ID),new CarOwnerId(CAR_OWNER_ID),new Name("Johanna","Manrique"));
        var useCase = new AssignCarOwnerUseCase();
        Mockito.when(repository.getEventsBy(CAR_OWNER_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                    .setIdentifyExecutor(CAR_OWNER_ID)
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow()
                    .getDomainEvents();

        //Assert
        var ownerAssignedEvent = (AssignedCarOwner)events.get(0);
        Assertions.assertEquals("Johanna", ownerAssignedEvent.getOwnerName().value().name());
        Assertions.assertEquals("Manrique", ownerAssignedEvent.getOwnerName().value().lastName());
        Assertions.assertEquals(CAR_OWNER_ID, ownerAssignedEvent.getOwnerId().value());


    }


    private List<DomainEvent> EventStored() {

        var event =  new CreatedCar(
                new Name("Johanna", "Manrique"),
                new InsuredAmount(1233),
                new CityOfOrigin("Cucuta"),
                new LicenseCode("JGG099"),
                new CarEngineCapacity(1600),
                new Brand("Chevrolet"),
                new Model("Aveo"),
                new Color("Black")

        );

        return List.of(event);
    }

}