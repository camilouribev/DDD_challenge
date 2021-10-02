package com.challenge.carworkshop.usecases.triggeredbyevents;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.AddedProcedureToService;
import com.challenge.carworkshop.domain.repairappointment.events.CreatedRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.values.*;

public class AddProcedureToServiceUseCase extends UseCase<TriggeredEvent<CreatedRepairAppointment>, ResponseEvents>  {


    @Override
    public void executeUseCase(TriggeredEvent<CreatedRepairAppointment> addedProcedureToServiceTriggeredEvent) {
        var event  = addedProcedureToServiceTriggeredEvent.getDomainEvent();
        var appointment = RepairAppointment.from( RepairAppointmentId.of(event.aggregateRootId()), this.retrieveEvents());

         if(appointment.getAppointmentStatus().equals(AppointmentStatus.PENDING) ){
             ServiceId serviceId = new ServiceId("222");
             appointment.addService(serviceId, new Diagnostic("Unreported Damages"));
             appointment.addProcedureToService(serviceId, new Procedure("Valoration of damages", 50000.00));
             emit().onResponse(new ResponseEvents(appointment.getUncommittedChanges()));
         }




    }
}
