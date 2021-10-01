package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.car.Car;
import com.challenge.carworkshop.domain.car.commands.AssignLicensePlate;

public class AssignLicensePlateUseCase extends UseCase<RequestCommand<AssignLicensePlate>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AssignLicensePlate> assignLicensePlateRequestCommand) {
        var command = assignLicensePlateRequestCommand.getCommand();

        var car = Car.from(command.getCarId(), retrieveEvents(command.getLicenseId().value()));
        car.assignLicensePlate(command.getLicenseId(), command.getCity(), command.getCode());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));

    }
}
