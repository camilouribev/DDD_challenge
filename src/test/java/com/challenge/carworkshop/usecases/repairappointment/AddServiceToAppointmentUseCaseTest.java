package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.repairappointment.commands.AddServiceToAppointment;
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

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class AddServiceToAppointmentUseCaseTest {
    private static final String APPOINTMENT_ID = "s23423233";
    private static final String SERVICE_ID = "122233";

    @Mock
    private DomainEventRepository repository;
    @Test
    void addServiceToAppointmentDefault(){
        //Arrange
        var command = new AddServiceToAppointment(RepairAppointmentId.of(APPOINTMENT_ID), new ServiceId(SERVICE_ID),new Diagnostic("Damaged front Bumper"));
        var useCase = new AddServiceToAppointmentUseCase();
        Mockito.when(repository.getEventsBy(SERVICE_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(SERVICE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var addedServiceEvent = (AddedServiceToAppointment)events.get(0);
        //Assertions.assertEquals(APPOINTMENT_ID,addedServiceEvent.getAppointmentId().value());
        Assertions.assertEquals("Damaged front Bumper", addedServiceEvent.getDiagnostic().value());
        Assertions.assertEquals(SERVICE_ID, addedServiceEvent.getServiceId().value());
    }


    private List<DomainEvent> EventStored() {

        var event =  new CreatedRepairAppointment(
                new AppointmentDate(),
                new Workshop("Zona Norte"),
                AppointmentStatus.PENDING

        );

        return List.of(event);
    }

}