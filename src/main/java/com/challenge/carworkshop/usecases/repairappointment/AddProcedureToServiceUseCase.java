package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.commands.AddProcedureToService;

public class AddProcedureToServiceUseCase extends UseCase<RequestCommand<AddProcedureToService>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddProcedureToService> addProcedureToServiceRequestCommand) {
        var command  = addProcedureToServiceRequestCommand.getCommand();
        var appointment = RepairAppointment.from(command.getAppointmentId(), retrieveEvents(command.getServiceId().value()));

        appointment.addProcedureToService(command.getServiceId(),command.getProcedure());

        emit().onResponse(new ResponseEvents(appointment.getUncommittedChanges()));
    }
}
