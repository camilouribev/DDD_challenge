package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.Identity;

public class MechanicId extends Identity {
    public MechanicId(){

    }
    public MechanicId(String id){ super(id);}
    public static MechanicId of(String id){ return new MechanicId();}
}
