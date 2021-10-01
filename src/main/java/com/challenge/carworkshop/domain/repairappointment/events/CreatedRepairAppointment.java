package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.values.*;

import java.util.Set;

public class CreatedRepairAppointment extends DomainEvent {

    private final AppointmentDate date;

    private final Workshop workshop;
    private final AppointmentStatus appointmentStatus;



    public CreatedRepairAppointment(AppointmentDate date , Workshop workshop, AppointmentStatus appointmentStatus) {
        super("carworkshop.domain.repairappointment.createdrepairappointment");

        this.date = date;
        this.workshop = workshop;
        this.appointmentStatus = appointmentStatus;

    }


    public AppointmentDate getDate() {
        return date;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }
}
