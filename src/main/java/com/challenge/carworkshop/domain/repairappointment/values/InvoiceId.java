package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.Identity;

public class InvoiceId extends Identity {

    public InvoiceId() {
    }

    public InvoiceId(String id){ super(id);}
    public static InvoiceId of(String id){ return new InvoiceId();}
}
