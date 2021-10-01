package com.challenge.carworkshop.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.car.Car;
import com.challenge.carworkshop.domain.car.commands.CreateCar;

public class CreateCarUseCaseCommand extends UseCase<RequestCommand<CreateCar>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateCar> createCarRequestCommand) {
        var command = createCarRequestCommand.getCommand();

        Car car;

        car = new Car(command.getEntityId(),
                command.getCarOwner().getName(),
                command.getInsurance().getInsuredAmount(),
                command.getLicense().getCityOfOrigin(),
                command.getLicense().getLicenseCode(),
                command.getEngineCapacity(),
                command.getBrand(),
                command.getModel(),
                command.getColor()
                );

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
