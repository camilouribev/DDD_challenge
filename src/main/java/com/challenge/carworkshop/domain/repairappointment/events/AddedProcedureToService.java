package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.ServiceId;

import java.util.Set;

public class AddedProcedureToService extends DomainEvent {
    private final ServiceId serviceId;
    private final Set<Procedure> procedureList;


    public AddedProcedureToService(ServiceId serviceId, Set<Procedure> procedureList) {
        super("carworkshop.domain.repairappointment.addedproceduretoservice");
        this.serviceId = serviceId;
        this.procedureList  = procedureList;
    }

    public ServiceId getServiceId() {
        return serviceId;
    }

    public Set<Procedure> getProcedureList() {
        return procedureList;
    }
}
