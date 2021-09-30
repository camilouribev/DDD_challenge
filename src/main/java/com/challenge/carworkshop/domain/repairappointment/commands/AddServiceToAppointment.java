package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.Diagnostic;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;

import java.util.Set;

public class AddServiceToAppointment extends Command {
    private final RepairAppointmentId appointmentId;
    private final Diagnostic diagnostic;
    private final Set<Procedure> procedureList;

    public AddServiceToAppointment(RepairAppointmentId appointmentId, Diagnostic diagnostic, Set<Procedure> procedureList) {
        this.appointmentId = appointmentId;
        this.diagnostic = diagnostic;
        this.procedureList = procedureList;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public Set<Procedure> getProcedureList() {
        return procedureList;
    }
}
