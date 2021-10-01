package com.challenge.carworkshop.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.challenge.carworkshop.domain.car.commands.CreateCar;
import com.challenge.carworkshop.domain.car.events.CreatedCar;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.usecases.car.CreateCarUseCaseCommand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateCarUseCaseCommandTest {

    @Test
    void createCarDefault(){
        var command = new CreateCar(CarId.of("xxx"),
                new Name("Camilo","Uribe"),
                new InsuredAmount(2000),
                new CityOfOrigin("Medellin"),
                new LicenseCode("WWW999"),
                new CarEngineCapacity(2000),
                new Brand("Toyota"),
                new Model("Corolla"),
                new Color("yellow")
                );

        var useCase = new CreateCarUseCaseCommand();

        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().getDomainEvents();

        //assert
        var event = (CreatedCar)events.get(0);

        Assertions.assertEquals("Camilo", event.getCarOwner().getName().value().name());


    }

}