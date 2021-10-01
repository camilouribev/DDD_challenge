package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.commands.CreateRepairAppointment;


public class CreateRepairAppointmentUseCase extends UseCase<RequestCommand<CreateRepairAppointment>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreateRepairAppointment> createRepairAppointmentRequestCommand) {
        var command = createRepairAppointmentRequestCommand.getCommand();

        RepairAppointment appointment;

        appointment = new RepairAppointment(command.getEntityId(), command.getDate(),command.getWorkshop(),command.getAppointmentStatus());
        emit().onResponse(new ResponseEvents(appointment.getUncommittedChanges()));

    }

}
