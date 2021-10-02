package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;

import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.repairappointment.commands.CreateRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.CreatedRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentDate;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentStatus;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreateRepairAppointmentUseCaseTest {

    @Test
    void createAppointmentDefault(){
        var command = new CreateRepairAppointment(RepairAppointmentId.of("306677"),
                new AppointmentDate(), new Workshop("Barrio Prado"), AppointmentStatus.PENDING,
                new CarEngineCapacity(2000)
        );

        var useCase = new CreateRepairAppointmentUseCase();

        var events = UseCaseHandler.getInstance().
                syncExecutor(useCase, new RequestCommand<>(command)).
                orElseThrow().getDomainEvents();

        //assert
        var event = (CreatedRepairAppointment)events.get(0);

        Assertions.assertEquals("Barrio Prado", event.getWorkshop().value());
        Assertions.assertEquals("PENDING" , event.getAppointmentStatus().name());

    }

}