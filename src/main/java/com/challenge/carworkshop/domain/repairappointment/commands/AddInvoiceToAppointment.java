package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.Fee;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class AddInvoiceToAppointment extends Command {
    private final RepairAppointmentId appointmentId;
    private final Fee fee;

    public AddInvoiceToAppointment(RepairAppointmentId appointmentId, Fee fee) {
        this.appointmentId = appointmentId;
        this.fee = fee;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public Fee getFee() {
        return fee;
    }
}
