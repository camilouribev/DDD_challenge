package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.values.MechanicId;

public class AssignedMechanicToAppointment extends DomainEvent {
    private final MechanicId mechanicId;
    private final Name mechanicName;

    public AssignedMechanicToAppointment(MechanicId entityId, Name mechanicName) {
        super("carworkshop.domain.repairappointment.assignedmechanictoappointment");
        this.mechanicId = entityId;
        this.mechanicName = mechanicName;
    }

    public MechanicId getMechanicId() {
        return mechanicId;
    }

    public Name getMechanicName() {
        return mechanicName;
    }
}
