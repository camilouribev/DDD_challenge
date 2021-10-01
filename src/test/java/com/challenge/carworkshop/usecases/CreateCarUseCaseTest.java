package com.challenge.carworkshop.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
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


@ExtendWith({MockitoExtension.class})
class CreateCarUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    @Test
    void createDefaultCar(){
        //arrange
        var aggregateId= "xxx-xxx";
        var event = new CreatedCar(
                new Name("Camilo","Uribe"),
                new InsuredAmount(2000.00),
                new CityOfOrigin("Medellin"),
                new LicenseCode("DED908"),
                new CarEngineCapacity(2000),
                new Brand("Toyota"),
                new Model("Corolla"),
                new Color("Gray")

        );
        event.setAggregateRootId(aggregateId);

        var useCase = new CreateCarUseCase();

        Mockito.when(repository.getEventsBy(aggregateId)).thenReturn(eventStored());
        useCase.addRepository(repository);
        //act

      var events= UseCaseHandler.getInstance()
              .setIdentifyExecutor(aggregateId)
              .syncExecutor(useCase, new TriggeredEvent<>(event))
              .orElseThrow()
              .getDomainEvents();


        //assert

        var creationEvent = (CreatedCar)events.get(0);
        Assertions.assertEquals("Camilo", creationEvent.getCarOwner().getName().value().name());


    }

    private List<DomainEvent> eventStored() {
        var event = new CreatedCar(
                new Name("Camilo","Uribe"),
                new InsuredAmount(2000.00),
                new CityOfOrigin("Medellin"),
                new LicenseCode("DED908"),
                new CarEngineCapacity(2000),
                new Brand("Toyota"),
                new Model("Corolla"),
                new Color("Gray")

        );
        return List.of(event);

    }
}