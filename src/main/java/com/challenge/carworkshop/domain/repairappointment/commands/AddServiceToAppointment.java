package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.Diagnostic;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.ServiceId;

import java.util.HashSet;
import java.util.Set;

public class AddServiceToAppointment extends Command {
    private final RepairAppointmentId appointmentId;
    private final ServiceId serviceId;
    private final Diagnostic diagnostic;
    private final Set<Procedure> procedureList;

    public AddServiceToAppointment(RepairAppointmentId appointmentId, ServiceId serviceId, Diagnostic diagnostic) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.diagnostic = diagnostic;
        this.procedureList = new HashSet<>();
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public Set<Procedure> getProcedureList() {
        return procedureList;
    }
}
