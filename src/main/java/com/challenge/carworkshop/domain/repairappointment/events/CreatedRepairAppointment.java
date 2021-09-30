package com.challenge.carworkshop.domain.repairappointment.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.repairappointment.Invoice;
import com.challenge.carworkshop.domain.repairappointment.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.Service;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentDate;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;

public class CreatedRepairAppointment extends DomainEvent {
    private final CarId carId;
    private final Invoice invoice;
    private final Service service;
    private final Mechanic mechanic;
    private final AppointmentDate date;
    private final InsuredAmount insuredAmount;
    private final CarEngineCapacity engineCapacity;
    private final Workshop workshop;



    public CreatedRepairAppointment(CarId carId, ) {
        super("carworkshop.domain.repairappointment.createdrepairappointment");
        this.carId = carId;
        this.invoice = new Invoice();
        this.service = new Service();
        this.mechanic = new Mechanic();
        this.date = date;
        this.insuredAmount = insuredAmount;
        this.engineCapacity = engineCapacity;
        this.workshop = workshop;

    }


    public CarId getCarId() {
        return carId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Service getService() {
        return service;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public AppointmentDate getDate() {
        return date;
    }

    public InsuredAmount getInsuredAmount() {
        return insuredAmount;
    }

    public CarEngineCapacity getEngineCapacity() {
        return engineCapacity;
    }

    public Workshop getWorkshop() {
        return workshop;
    }
}
