package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.EventChange;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.events.*;

import java.util.HashSet;

public class RepairAppointmentChange extends EventChange {
    public RepairAppointmentChange(RepairAppointment repairAppointment){
        apply((CreatedRepairAppointment event)->{
            repairAppointment.carId = event.getCarId();
            repairAppointment.invoice = event.getInvoice();
            repairAppointment.service = event.getService();
            repairAppointment.mechanic = event.getMechanic();
            repairAppointment.date = event.getDate();
            repairAppointment.insuredAmount = event.getInsuredAmount();
            repairAppointment.engineCapacity = event.getEngineCapacity();
            repairAppointment.appointmentStatus = event.getAppointmentStatus();

        });

        apply((AssignedCarToAppointment event)->{
            repairAppointment.carId = event.getCarId();
        });

        apply((AddedInvoiceToAppointment event)->{
            repairAppointment.invoice = new Invoice(event.getInvoiceId(), event.getFee());
        });

        apply((AddedServiceToAppointment event)->{
            repairAppointment.service = new Service(event.getServiceId(),event.getProcedureList());
        });

        apply((AssignedMechanicToAppointment event)->{
            repairAppointment.mechanic = new Mechanic(event.getMechanicId(), event.getMechanicName());
        });

        apply((ChangedAppointmentDate event)->{
            repairAppointment.date = event.getAppointmentDate();
        });

        apply((ChangedCarEngineCapacity event)->{
            repairAppointment.engineCapacity = event.getEngineCapacity();
        });

        apply((ChangedWorkshop event)->{
            repairAppointment.workshop = event.getWorkshop();
        });

        apply((AddedProcedureToService event)->{
           repairAppointment.service.addProcedure(event.getNewProcedure());
        });

        apply((CalculatedInvoiceFee event)->{
            repairAppointment.invoice.calculateFee(event.getFee());
        });

        apply((ChangedMechanicName event)->{
            repairAppointment.mechanic.changeMechanicName(event.getMechanicName());
        });


    }
}
