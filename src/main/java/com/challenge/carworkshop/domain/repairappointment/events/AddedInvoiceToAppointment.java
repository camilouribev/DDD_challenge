package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.Fee;
import com.challenge.carworkshop.domain.repairappointment.values.InvoiceId;

public class AddedInvoiceToAppointment extends DomainEvent {
    private final InvoiceId invoiceId;
    private final Fee fee;


    public AddedInvoiceToAppointment( Fee fee) {
        super("carworkshop.domain.repairappointment.addedinvoicetoappointment");
        this.invoiceId = new InvoiceId();
        this.fee = fee;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public Fee getFee() {
        return fee;
    }
}
