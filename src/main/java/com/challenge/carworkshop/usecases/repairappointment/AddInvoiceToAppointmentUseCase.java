package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.commands.AddInvoiceToAppointment;

public class AddInvoiceToAppointmentUseCase extends UseCase<RequestCommand<AddInvoiceToAppointment>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddInvoiceToAppointment> addInvoiceToAppointmentRequestCommand) {
        var command = addInvoiceToAppointmentRequestCommand.getCommand();

        var repairAppointment = RepairAppointment.from(command.getAppointmentId(), retrieveEvents(command.getInvoiceId().value()));
        repairAppointment.addInvoice(command.getAppointmentId(), command.getInvoiceId(), command.getFee());

        emit().onResponse(new ResponseEvents(repairAppointment.getUncommittedChanges()));
    }
}
