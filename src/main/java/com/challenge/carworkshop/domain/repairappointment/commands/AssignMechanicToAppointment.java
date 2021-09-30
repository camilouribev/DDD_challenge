package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class AssignMechanicToAppointment extends Command {
    private final RepairAppointmentId appointmentId;
    private final Name mechanicName;

    public AssignMechanicToAppointment(RepairAppointmentId appointmentId, Name mechanicName) {
        this.appointmentId = appointmentId;
        this.mechanicName = mechanicName;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public Name getMechanicName() {
        return mechanicName;
    }
}
