package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.ServiceId;

public class AddProcedureToService extends Command {

    private final RepairAppointmentId appointmentId;
    private final ServiceId serviceId;
    private final Procedure procedure;

    public AddProcedureToService(RepairAppointmentId appointmentId, ServiceId serviceId, Procedure procedure) {
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.procedure = procedure;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public Procedure getProcedure() {
        return procedure;
    }
}
