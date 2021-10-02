package com.challenge.carworkshop.usecases.triggeredbyevents;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
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
class ChangeWorkshopUseCaseTest {
    private static final String SERVICE_ID = "222";
    private final static String APPOINTMENT_ID = "98744";

    @Mock
    private DomainEventRepository repository;


    @Test
    void addProcedureToServiceUseCaseTest(){

        //arrange
        var event = new CreatedRepairAppointment(new AppointmentDate(),new Workshop("Downtown"), AppointmentStatus.PENDING, new CarEngineCapacity(1200));
        event.setAggregateRootId(APPOINTMENT_ID);


        var useCase = new ChangeWorkshopUseCase();

        Mockito.when(repository.getEventsBy(APPOINTMENT_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(APPOINTMENT_ID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var changedWorkshop = (ChangedWorkshop) events.get(0);




        Assertions.assertEquals("Main Insurance workshop - North", changedWorkshop.getWorkshop().value());
        Mockito.verify(repository).getEventsBy("98744");

    }

    private List<DomainEvent> EventStored() {

        var  createdAppointmentEvent = new CreatedRepairAppointment(new AppointmentDate(),new Workshop("Downtown"), AppointmentStatus.PENDING, new CarEngineCapacity(1600));

        var changedCarEngine = new ChangedCarEngineCapacity(new CarEngineCapacity(5000));

        var changedWorkshop = new ChangedWorkshop(new Workshop("Downtown"));


        return List.of(createdAppointmentEvent,changedCarEngine, changedWorkshop);

    }
}

