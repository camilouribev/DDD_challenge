package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.Identity;

public class ServiceId extends Identity {
    public ServiceId(){

    }
    public ServiceId(String id){ super(id);}
    public static ServiceId of(String id){ return new ServiceId();}
}
