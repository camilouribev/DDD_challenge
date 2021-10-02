package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.car.Car;
import com.challenge.carworkshop.domain.car.commands.ChangeCarOwnerName;

public class ChangeCarOwnerUseCase extends UseCase<RequestCommand<ChangeCarOwnerName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeCarOwnerName> changeCarOwnerNameRequestCommand) {
        var command = changeCarOwnerNameRequestCommand.getCommand();

        var car = Car.from(command.getCarId(), retrieveEvents(command.getCarOwnerId().value()));

        car.changeCarOwnerName(command.getCarId(),command.getCarOwnerId(), command.getName());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
