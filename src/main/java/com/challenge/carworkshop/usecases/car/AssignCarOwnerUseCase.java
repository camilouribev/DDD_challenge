package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.car.Car;
import com.challenge.carworkshop.domain.car.commands.AssignCarOwner;

public class AssignCarOwnerUseCase  extends UseCase<RequestCommand<AssignCarOwner>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignCarOwner> assignCarOwnerRequestCommand) {
        var command = assignCarOwnerRequestCommand.getCommand();

        var car = Car.from(command.getCarId(), retrieveEvents(command.getOwnerId().value()));
        car.assignCarOwner(command.getOwnerId(), command.getOwnerName());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));

    }
}
