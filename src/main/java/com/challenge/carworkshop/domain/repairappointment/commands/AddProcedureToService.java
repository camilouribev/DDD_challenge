package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

public class AddProcedureToService extends Command {
    private final RepairAppointmentId appointmentId;
    private final Procedure procedure;

    public AddProcedureToService(RepairAppointmentId appointmentId, Procedure procedure) {
        this.appointmentId = appointmentId;
        this.procedure = procedure;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public Procedure getProcedure() {
        return procedure;
    }
}
