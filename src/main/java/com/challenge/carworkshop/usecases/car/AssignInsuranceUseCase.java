package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.car.Car;
import com.challenge.carworkshop.domain.car.commands.AssignInsurance;

public class AssignInsuranceUseCase extends UseCase<RequestCommand<AssignInsurance>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<AssignInsurance> assignInsuranceRequestCommand) {
        var command = assignInsuranceRequestCommand.getCommand();

        var car = Car.from(command.getCarId(), retrieveEvents(command.getInsuranceId().value()));
        car.assignInsurance(command.getInsuranceId(), command.getInsuredAmount());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));

    }
}
