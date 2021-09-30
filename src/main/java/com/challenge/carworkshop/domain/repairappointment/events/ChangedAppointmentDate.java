package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentDate;

public class ChangedAppointmentDate extends DomainEvent {
    private final AppointmentDate appointmentDate;

    public ChangedAppointmentDate( AppointmentDate appointmentDate) {
        super("carworkshop.domain.repairappointment.changedappointmentdate");
        this.appointmentDate = appointmentDate;
    }

    public AppointmentDate getAppointmentDate() {
        return appointmentDate;
    }
}
