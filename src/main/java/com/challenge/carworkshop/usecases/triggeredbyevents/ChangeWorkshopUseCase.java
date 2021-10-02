package com.challenge.carworkshop.usecases.triggeredbyevents;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.carworkshop.domain.repairappointment.RepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.CreatedRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.values.*;

public class ChangeWorkshopUseCase extends UseCase<TriggeredEvent<CreatedRepairAppointment>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CreatedRepairAppointment> createdRepairAppointmentTriggeredEvent) {
        var event  = createdRepairAppointmentTriggeredEvent.getDomainEvent();
        var appointment = RepairAppointment.from( RepairAppointmentId.of(event.aggregateRootId()), this.retrieveEvents());


        if(appointment.getEngineCapacity().value()> 3000){

            appointment.changeWorkshop( new Workshop( "Main Insurance workshop - North"));
            emit().onResponse(new ResponseEvents(appointment.getUncommittedChanges()));
        }


    }
}
