package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;

public class ChangedCarEngineCapacity extends DomainEvent {
    private final CarEngineCapacity engineCapacity;

    public ChangedCarEngineCapacity(CarEngineCapacity engineCapacity) {
        super("carworkshop.domain.repairappointment.changedcarenginecapacity");
        this.engineCapacity = engineCapacity;
    }

    public CarEngineCapacity getEngineCapacity() {
        return engineCapacity;
    }
}
