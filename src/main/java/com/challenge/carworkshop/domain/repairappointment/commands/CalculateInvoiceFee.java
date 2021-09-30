package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.Fee;
import com.challenge.carworkshop.domain.repairappointment.values.InvoiceId;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class CalculateInvoiceFee extends Command {
    private final RepairAppointmentId appointmentId;
    private final InvoiceId invoiceId;
    private final Fee fee;

    public CalculateInvoiceFee(RepairAppointmentId appointmentId, InvoiceId invoiceId, Fee fee) {
        this.appointmentId = appointmentId;
        this.invoiceId = invoiceId;
        this.fee = fee;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public Fee getFee() {
        return fee;
    }
}
