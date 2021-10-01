package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.ServiceId;

import java.util.Set;

public class AddedProcedureToService extends DomainEvent {
    private final RepairAppointmentId appointmentId;

    private final ServiceId serviceId;
    private final Procedure newProcedure;


    public AddedProcedureToService(RepairAppointmentId appointmentId, ServiceId serviceId, Procedure newProcedure) {
        super("carworkshop.domain.repairappointment.addedproceduretoservice");
        this.appointmentId = appointmentId;
        this.serviceId = serviceId;
        this.newProcedure  = newProcedure;
    }

    public RepairAppointmentId getAppointmentId() {
        return appointmentId;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Procedure getNewProcedure() {
        return newProcedure;
    }
}
