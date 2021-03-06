package com.challenge.carworkshop.domain.repairappointment;

import co.com.sofka.domain.generic.EventChange;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.events.*;

import java.util.HashSet;

public class RepairAppointmentChange extends EventChange {
    public RepairAppointmentChange(RepairAppointment repairAppointment){
        apply((CreatedRepairAppointment event)->{
            repairAppointment.workshop= event.getWorkshop();
            repairAppointment.date = event.getDate();
            repairAppointment.appointmentStatus = event.getAppointmentStatus();
            repairAppointment.engineCapacity = event.getEngine();

        });



        apply((AddedInvoiceToAppointment event)->{
            repairAppointment.invoice = new Invoice(event.getInvoiceId(), event.getFee());
        });

        apply((AddedServiceToAppointment event)->{
            repairAppointment.service = new Service(event.getServiceId(), event.getDiagnostic());
        });

        apply((AssignedMechanicToAppointment event)->{
            repairAppointment.mechanic = new Mechanic(event.getMechanicId(), event.getMechanicName());
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



        apply((ChangedMechanicName event)->{
            repairAppointment.mechanic.changeMechanicName(event.getMechanicName());
        });


    }
}
