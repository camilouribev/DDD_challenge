package com.challenge.carworkshop.usecases.repairappointment;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.repairappointment.commands.AddInvoiceToAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.AddedInvoiceToAppointment;
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
class AddInvoiceToAppointmentUseCaseTest {
    private static final String APPOINTMENT_ID = "333333";
    private static final String INVOICE_ID = "201234";
    @Mock
    private DomainEventRepository repository;
    @Test
    void addInvoiceToAppointmentDefault(){
        //Arrange
        var command = new AddInvoiceToAppointment(RepairAppointmentId.of(APPOINTMENT_ID), new InvoiceId(INVOICE_ID),new Fee(80000.00));
        var useCase = new AddInvoiceToAppointmentUseCase();
        Mockito.when(repository.getEventsBy(INVOICE_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(INVOICE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var addedInvoiceEvent = (AddedInvoiceToAppointment)events.get(0);
        //Assertions.assertEquals(APPOINTMENT_ID,addedInvoiceEvent.getAppointmentId().value());
        Assertions.assertEquals(80000.00, addedInvoiceEvent.getFee().value());
        Assertions.assertEquals(INVOICE_ID, addedInvoiceEvent.getInvoiceId().value());
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