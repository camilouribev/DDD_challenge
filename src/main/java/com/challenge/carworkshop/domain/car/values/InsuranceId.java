package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.Identity;

public class InsuranceId extends Identity {
    public InsuranceId(){

    }
    private InsuranceId(String id ){ super(id);}
    public static InsuranceId of(String id){ return new InsuranceId();}
}
