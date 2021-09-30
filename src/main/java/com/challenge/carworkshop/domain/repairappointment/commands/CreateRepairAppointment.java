package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.values.*;

import java.util.Set;

public class CreateRepairAppointment extends Command {
    private final RepairAppointmentId entityId;
    private final CarId carId;
    private final Invoice invoice;
    private final Service service;
    private final Mechanic mechanic;
    private final AppointmentDate date;
    private final InsuredAmount insuredAmount;
    private final CarEngineCapacity engineCapacity;
    private final Workshop workshop;
    private final AppointmentStatus appointmentStatus;
    private final Set<Procedure> procedureList;
    private final Diagnostic diagnostic;

    public CreateRepairAppointment(RepairAppointmentId entityId, CarId carId, Fee fee, Name mechanicName, AppointmentDate date, InsuredAmount insuredAmount,
                                   CarEngineCapacity engineCapacity, Workshop workshop, AppointmentStatus appointmentStatus,
                                   Set<Procedure> procedureList, Diagnostic diagnostic) {
        this.entityId = entityId;
        this.carId = carId;
        this.invoice = new Invoice(new InvoiceId(), fee);
        this.service = new Service(new ServiceId(), procedureList);
        this.mechanic = new Mechanic(new MechanicId(), mechanicName) ;
        this.date = date;
        this.insuredAmount = insuredAmount;
        this.engineCapacity = engineCapacity;
        this.workshop = workshop;
        this.appointmentStatus = appointmentStatus;
        this.procedureList = procedureList;
        this.diagnostic = diagnostic;
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

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public Set<Procedure> getProcedureList() {
        return procedureList;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }
}
