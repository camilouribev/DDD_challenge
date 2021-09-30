package com.challenge.carworkshop.domain.repairappointment.entities;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.ServiceId;

import java.util.Objects;
import java.util.Set;

public class Service extends Entity<ServiceId> {
    private Set<Procedure> procedureList;

    public Service(ServiceId entityId, Set<Procedure> procedureList) {
        super(entityId);
        this.procedureList = procedureList;
    }

    public Set<Procedure> getProcedureList() {
        return procedureList;
    }

    public void setProcedureList(Set<Procedure> procedureList) {
        this.procedureList = Objects.requireNonNull(procedureList) ;
    }
}
