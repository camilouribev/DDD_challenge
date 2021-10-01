package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.commands.ChangeMechanicName;

public class ChangeMechanicNameUseCase extends UseCase<RequestCommand<ChangeMechanicName>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ChangeMechanicName> changeMechanicNameRequestCommand) {
        var command = changeMechanicNameRequestCommand.getCommand();
        var appointment = RepairAppointment.from(command.getAppointmentId(), retrieveEvents(command.getMechanicId().value()));
        appointment.changeMechanicName(
                command.getAppointmentId(),
               command.getMechanicId(),
                command.getMechanicName()
        );
        emit().onResponse(new ResponseEvents(appointment.getUncommittedChanges()));
    }
}
