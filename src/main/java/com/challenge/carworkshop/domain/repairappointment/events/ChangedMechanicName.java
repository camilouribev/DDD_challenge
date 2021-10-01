package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.values.MechanicId;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class ChangedMechanicName extends DomainEvent {
    private final RepairAppointmentId appointmentId;
    private final MechanicId mechanicId;
    private final Name mechanicName;

    public ChangedMechanicName(RepairAppointmentId appointmentId, MechanicId mechanicId, Name mechanicName) {

        super("carworkshop.domain.repairappointment.changedmechanicname");
        this.appointmentId = appointmentId;
        this.mechanicId = mechanicId;
        this.mechanicName = mechanicName;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public MechanicId getMechanicId() {
        return mechanicId;
    }

    public Name getMechanicName() {
        return mechanicName;
    }
}
