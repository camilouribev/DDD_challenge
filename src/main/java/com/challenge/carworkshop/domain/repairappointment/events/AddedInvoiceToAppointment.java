package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.Fee;
import com.challenge.carworkshop.domain.repairappointment.values.InvoiceId;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class AddedInvoiceToAppointment extends DomainEvent {
    private final RepairAppointmentId appointmentId;
    private final InvoiceId invoiceId;
    private final Fee fee;


    public AddedInvoiceToAppointment(RepairAppointmentId appointmentId, InvoiceId invoiceId, Fee fee) {
        super("carworkshop.domain.repairappointment.addedinvoicetoappointment");
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
