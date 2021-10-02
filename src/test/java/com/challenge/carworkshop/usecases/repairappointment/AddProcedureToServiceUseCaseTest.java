package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.commands.AddProcedureToService;
import com.challenge.carworkshop.domain.repairappointment.events.*;
import com.challenge.carworkshop.domain.repairappointment.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class AddProcedureToServiceUseCaseTest {
    private static final String SERVICE_ID = "213";
    private final static String APPOINTMENT_ID = "98744";

    @Mock
    private DomainEventRepository repository;


    @Test
    void addProcedureToServiceUseCaseTest(){

        //arrange
        var command = new AddProcedureToService(RepairAppointmentId.of(APPOINTMENT_ID),
                new ServiceId(SERVICE_ID), new Procedure("Painting", 120000.00));


        var useCase = new AddProcedureToServiceUseCase();

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SERVICE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventAddedProcedure = (AddedProcedureToService) events.get(0);
        Assertions.assertEquals("Painting", eventAddedProcedure.getNewProcedure().value().type());
        Assertions.assertEquals(120000.00, eventAddedProcedure.getNewProcedure().value().price());
        Assertions.assertEquals(SERVICE_ID, eventAddedProcedure.getServiceId().value());
        Mockito.verify(repository).getEventsBy("213");

    }

    private List<DomainEvent> EventStored() {

        var  createdAppointmentEvent = new CreatedRepairAppointment(new AppointmentDate(),new Workshop("Calle colombia"), AppointmentStatus.PENDING);

        var assignedServiceEvent = new AddedServiceToAppointment(new ServiceId(SERVICE_ID), new Diagnostic("Scratches"));

        var addedProcedureToServiceEvent = new AddedProcedureToService(new ServiceId(SERVICE_ID), new Procedure("Scratches",120000.00));

        return List.of(createdAppointmentEvent, assignedServiceEvent,  addedProcedureToServiceEvent);

    }

}