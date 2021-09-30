package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.Identity;

public class RepairAppointmentId extends Identity {
    public RepairAppointmentId(){

    }
    private RepairAppointmentId(String id ){ super(id);}
    public static RepairAppointmentId of(String id){ return new RepairAppointmentId();}
}
