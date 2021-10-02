package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.commands.AssignMechanicToAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.AssignedMechanicToAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.CreatedRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.values.*;
import com.challenge.carworkshop.usecases.car.AssignCarOwnerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;


@ExtendWith(MockitoExtension.class)
class AssignMechanicToAppointmentUseCaseTest {
    private static final String APPOINTMENT_ID = "333333";
    private static final String MECHANIC_ID = "54321";


    @Mock
    private DomainEventRepository repository;
    @Test
    void assignMechanicToAppointmentDefault(){

        //Arrange
        var command = new AssignMechanicToAppointment(RepairAppointmentId.of(APPOINTMENT_ID),new MechanicId(MECHANIC_ID),new Name("Alvaro","Soto"));
        var useCase = new AssignMechanicToAppointmentUseCase();
        Mockito.when(repository.getEventsBy(MECHANIC_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(MECHANIC_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var mechanicAssignedEvent = (AssignedMechanicToAppointment)events.get(0);
        Assertions.assertEquals("Alvaro", mechanicAssignedEvent.getMechanicName().value().name());
        Assertions.assertEquals("Soto", mechanicAssignedEvent.getMechanicName().value().lastName());
        Assertions.assertEquals(MECHANIC_ID, mechanicAssignedEvent.getMechanicId().value());
    }


    private List<DomainEvent> EventStored() {

        var event =  new CreatedRepairAppointment(
                new AppointmentDate(),
                new Workshop("Zona sur"),
               AppointmentStatus.PENDING,
                new CarEngineCapacity(2000)

        );

        return List.of(event);
    }

}