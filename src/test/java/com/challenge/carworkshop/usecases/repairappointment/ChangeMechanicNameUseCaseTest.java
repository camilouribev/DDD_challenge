package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.commands.ChangeMechanicName;
import com.challenge.carworkshop.domain.repairappointment.events.AssignedMechanicToAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.ChangedMechanicName;
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
class ChangeMechanicNameUseCaseTest {
    private static final String MECHANIC_ID = "134";
    private final static String APPOINTMENT_ID = "55555";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeMechanicNameDefault(){

        //arrange
        var command = new ChangeMechanicName( RepairAppointmentId.of(APPOINTMENT_ID),
                new MechanicId(MECHANIC_ID),
                new Name("Mark", "Hughes"));


        var useCase = new ChangeMechanicNameUseCase();

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(MECHANIC_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventUpdatedMechanicName = (ChangedMechanicName) events.get(0);
        Assertions.assertEquals("Mark", eventUpdatedMechanicName.getMechanicName().value().name());
        Assertions.assertEquals("Hughes", eventUpdatedMechanicName.getMechanicName().value().lastName());
        Mockito.verify(repository).getEventsBy("134");

    }

    private List<DomainEvent> EventStored() {

       var  createdAppointmentEvent = new CreatedRepairAppointment(new AppointmentDate(),new Workshop("Downtown"), AppointmentStatus.PENDING);

       var assignedMechanicEvent = new AssignedMechanicToAppointment(new MechanicId(MECHANIC_ID), new Name("Manuel", "Velez"));

        return List.of(createdAppointmentEvent, assignedMechanicEvent);

    }

}