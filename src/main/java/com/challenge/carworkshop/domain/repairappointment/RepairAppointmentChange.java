package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.EventChange;

public class RepairAppointmentChange extends EventChange {
    public RepairAppointmentChange(RepairAppointment repairAppointment){
        apply(()->{});
    }
}
