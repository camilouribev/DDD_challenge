package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.repairappointment.values.Fee;
import com.challenge.carworkshop.domain.repairappointment.values.InvoiceId;

public class Invoice extends Entity<InvoiceId>{
    private Fee fee;

    public Invoice(InvoiceId entityId, Fee fee) {
        super(entityId);
        this.fee = fee;
    }

    public Fee getFee() {
        return fee;
    }

    public void CalculateFee(Fee fee) {
        this.fee = fee;
    }
}
