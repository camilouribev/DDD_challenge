package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.commands.AddServiceToAppointment;

public class AddServiceToAppointmentUseCase extends UseCase<RequestCommand<AddServiceToAppointment>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddServiceToAppointment> addServiceToAppointmentRequestCommand) {
        var command = addServiceToAppointmentRequestCommand.getCommand();
        var repairAppointment = RepairAppointment.from(command.getAppointmentId(), retrieveEvents(command.getServiceId().value()));


        repairAppointment.addService( command.getServiceId(), command.getDiagnostic());

        emit().onResponse(new ResponseEvents(repairAppointment.getUncommittedChanges()));

    }
}
