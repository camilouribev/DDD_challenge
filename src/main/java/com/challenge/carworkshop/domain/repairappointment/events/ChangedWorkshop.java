package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;

public class ChangedWorkshop extends DomainEvent {
    private final Workshop workshop;

    public ChangedWorkshop(Workshop workshop) {
        super("carworkshop.domain.repairappointment.changedappointmentworkshop");
        this.workshop = workshop;
    }

    public Workshop getWorkshop() {
        return workshop;
    }
}
