package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.AggregateEvent;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentDate;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.Status;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;

public class RepairAppointment  extends AggregateEvent<RepairAppointmentId> {
    protected CarId carId;
    protected Invoice invoice;
    protected Service service;
    protected Mechanic mechanic;
    protected AppointmentDate date;
    protected InsuredAmount insuredAmount;
    protected CarEngineCapacity engineCapacity;
    protected Workshop workshop;
    protected Status status;



    public RepairAppointment(RepairAppointmentId entityId) {
        super(entityId);
    }
}
