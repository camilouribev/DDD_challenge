package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.values.MechanicId;

public class Mechanic extends Entity<MechanicId> {
    private Name name;

    public Mechanic(MechanicId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void changeMechanicName(Name name) {
        this.name = name;
    }
}
