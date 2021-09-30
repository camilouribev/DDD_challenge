package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.Fee;
import com.challenge.carworkshop.domain.repairappointment.values.InvoiceId;

public class CalculatedInvoiceFee extends DomainEvent {
    private final InvoiceId id;
    private final Fee fee;


    public CalculatedInvoiceFee(InvoiceId id, Fee fee) {
        super("carworkshop.domain.repairappointment.addedproceduretoservice");
        this.id = id;
        this.fee = fee;
    }

    public InvoiceId getId() {
        return id;
    }

    public Fee getFee() {
        return fee;
    }

}
