package com.challenge.carworkshop.domain.repairappointment.entities;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.repairappointment.values.Diagnostic;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;
import com.challenge.carworkshop.domain.repairappointment.values.ServiceId;
import jdk.jshell.Diag;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Service extends Entity<ServiceId> {
    private  Set<Procedure> procedureList;
    private  Diagnostic diagnostic;

    public Service(ServiceId entityId, Diagnostic diagnostic) {
        super(entityId);
        this.procedureList = new HashSet<>();
        this.diagnostic = diagnostic;
    }

    public void addProcedure(Procedure newProcedure){
        this.procedureList.add(newProcedure);
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public Set<Procedure> getProcedureList() {
        return procedureList;
    }


}
