package com.challenge.carworkshop.usecases.triggeredbyevents;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.events.AddedProcedureToService;
import com.challenge.carworkshop.domain.repairappointment.events.AddedServiceToAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.CreatedRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AddProcedureToServiceUseCaseTest {
    private static final String SERVICE_ID = "222";
    private final static String APPOINTMENT_ID = "98744";

    @Mock
    private DomainEventRepository repository;


    @Test
    void addProcedureToServiceUseCaseTest(){

        //arrange
        var event = new CreatedRepairAppointment(new AppointmentDate(),new Workshop("Downtown"), AppointmentStatus.PENDING);
        event.setAggregateRootId(APPOINTMENT_ID);

        var useCase = new AddProcedureToServiceUseCase();

        Mockito.when(repository.getEventsBy(APPOINTMENT_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(APPOINTMENT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventAddedService = (AddedServiceToAppointment) events.get(0);
        var addedProcedureToService = (AddedProcedureToService) events.get(1);



        Assertions.assertEquals(SERVICE_ID, eventAddedService.getServiceId().value());
        Assertions.assertEquals(50000.00, addedProcedureToService.getNewProcedure().value().price());
        Mockito.verify(repository).getEventsBy("98744");

    }

    private List<DomainEvent> EventStored() {

        var  createdAppointmentEvent = new CreatedRepairAppointment(new AppointmentDate(),new Workshop("Downtown"), AppointmentStatus.PENDING);

        var assignedServiceEvent = new AddedServiceToAppointment(new ServiceId(SERVICE_ID), new Diagnostic("Scratches"));

        var addedProcedureToServiceEvent = new AddedProcedureToService(new ServiceId(SERVICE_ID), new Procedure("Scratches",0.00));

        return List.of(createdAppointmentEvent, assignedServiceEvent,  addedProcedureToServiceEvent);

    }
}