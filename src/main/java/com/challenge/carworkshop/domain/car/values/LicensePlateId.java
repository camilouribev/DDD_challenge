package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.Identity;

public class LicensePlateId extends Identity {
    public LicensePlateId(){

    }
    private LicensePlateId(String id ){ super(id);}
    public static LicensePlateId of(String id){ return new LicensePlateId();}
}
