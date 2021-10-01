package com.challenge.carworkshop.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.carworkshop.domain.car.events.CreatedCar;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateCarUseCaseTest {

    @Test
    void createDefaultCar(){
        //arrange

        var event = new CreatedCar(
                new Name("Camilo","Uribe"),
                new InsuredAmount(2000),
                new CityOfOrigin("Medellin"),
                new LicenseCode("ded908"),
                new CarEngineCapacity(2000),
                new Brand("Toyota"),
                new Model("Corolla"),
                new Color("Gray")

        );


        var useCase = new CreateCarUseCase();


        //act

      var events= UseCaseHandler.getInstance()
              .syncExecutor(useCase, new TriggeredEvent<>(event))
              .orElseThrow()
              .getDomainEvents();


        //assert

        var creationEvent = (CreatedCar)events.get(0);
        Assertions.assertEquals("Camilo", creationEvent.getCarOwner().getName().value().name());
        Assertions.assertEquals(2000, creationEvent.getInsurance().getInsuredAmount().value());
        Assertions.assertEquals("DED908", creationEvent.getLicense().getLicenseCode().value());

    }

}