package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.commands.AssignMechanicToAppointment;

public class AssignMechanicToAppointmentUseCase extends UseCase<RequestCommand<AssignMechanicToAppointment>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AssignMechanicToAppointment> assignMechanicToAppointmentRequestCommand) {
        var command = assignMechanicToAppointmentRequestCommand.getCommand();

        var car = RepairAppointment.from(command.getAppointmentId(), retrieveEvents(command.getMechanicId().value()));
        car.assignMechanic(command.getMechanicId(),  command.getMechanicName());

        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }
}
