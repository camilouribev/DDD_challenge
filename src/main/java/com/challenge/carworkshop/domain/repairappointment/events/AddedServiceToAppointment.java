package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AddedServiceToAppointment extends DomainEvent {
    private final ServiceId serviceId;
    private final Diagnostic diagnostic;
    private final Set<Procedure> procedureList;

    public AddedServiceToAppointment(ServiceId serviceId ,   Diagnostic diagnostic) {
        super("carworkshop.domain.repairappointment.addedservicetoappointment");
        this.serviceId = serviceId;
        this.diagnostic = diagnostic;
        this.procedureList = new HashSet<>();
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
