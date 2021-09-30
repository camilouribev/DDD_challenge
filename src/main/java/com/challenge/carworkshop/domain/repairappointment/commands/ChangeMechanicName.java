package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.values.MechanicId;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class ChangeMechanicName extends Command {

    private final RepairAppointmentId appointmentId;
    private final MechanicId mechanicId;
    private final Name mechanicName;

    public ChangeMechanicName(RepairAppointmentId appointmentId, MechanicId mechanicId, Name mechanicName) {
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
