package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.events.*;
import com.challenge.carworkshop.domain.repairappointment.values.*;

import java.util.List;
import java.util.Objects;

public class RepairAppointment  extends AggregateEvent<RepairAppointmentId> {
    protected CarId carId;
    protected Invoice invoice;
    protected Service service;
    protected Mechanic mechanic;
    protected AppointmentDate date;
    protected InsuredAmount insuredAmount;
    protected CarEngineCapacity engineCapacity;
    protected Workshop workshop;
    protected AppointmentStatus appointmentStatus;




    public RepairAppointment(RepairAppointmentId entityId, AppointmentDate date, Workshop workshop , AppointmentStatus appointmentStatus ) {
        super(entityId);
        appendChange(new CreatedRepairAppointment(date, workshop, appointmentStatus)).apply();
    }

    private RepairAppointment(RepairAppointmentId entityId){
        super(entityId);
        subscribe(new RepairAppointmentChange(this));

    }

    public static RepairAppointment from(RepairAppointmentId entityId, List<DomainEvent> events){
        var repairAppointment = new RepairAppointment(entityId);
        events.forEach(repairAppointment::applyEvent);
        return repairAppointment;
    }

    public void assignCar(CarId carId){
        Objects.requireNonNull(carId);
        appendChange(new AssignedCarToAppointment(carId)).apply();

    }

    public void addInvoice(RepairAppointmentId appointmentId, InvoiceId invoiceId, Fee fee){
        Objects.requireNonNull(invoiceId);
        Objects.requireNonNull(fee);
        appendChange(new AddedInvoiceToAppointment(appointmentId, invoiceId, fee)).apply();
    }

    public void addService(ServiceId serviceId,  Diagnostic diagnostic){

        Objects.requireNonNull(diagnostic);

        appendChange(new AddedServiceToAppointment(serviceId, diagnostic)).apply();
    }

    public void assignMechanic(MechanicId mechanicId, Name mechanicName){
        Objects.requireNonNull(mechanicId);
        Objects.requireNonNull(mechanicName);
        appendChange(new AssignedMechanicToAppointment(mechanicId,mechanicName)).apply();
    }

    public void changeMechanicName(RepairAppointmentId appointmentId, MechanicId mechanicId, Name mechanicName){
        Objects.requireNonNull(mechanicId);
        Objects.requireNonNull(mechanicName);
        appendChange(new ChangedMechanicName(appointmentId, mechanicId, mechanicName)).apply();
    }

    public void addProcedureToService(ServiceId serviceId,Procedure procedure){
        Objects.requireNonNull(procedure);

        appendChange(new AddedProcedureToService( serviceId,procedure)).apply();
    }

    public void changeCarEngineCapacity(CarEngineCapacity engineCapacity){
        Objects.requireNonNull(engineCapacity);
        appendChange(new ChangedCarEngineCapacity(engineCapacity)).apply();
    }

    public void changeWorkshop(Workshop workshop){
        Objects.requireNonNull(workshop);
        appendChange(new ChangedWorkshop(workshop)).apply();
    }



    public void calculateInvoiceFee(InvoiceId invoiceId, Fee fee){
        Objects.requireNonNull(fee);
        appendChange(new CalculatedInvoiceFee(invoiceId, fee)).apply();

    }


    public CarId getCarId() {
        return carId;
    }

    public void setCarId(CarId carId) {
        this.carId = carId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public AppointmentDate getDate() {
        return date;
    }

    public void setDate(AppointmentDate date) {
        this.date = date;
    }

    public InsuredAmount getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(InsuredAmount insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public CarEngineCapacity getEngineCapacity() {
        return engineCapacity;
    }



    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
