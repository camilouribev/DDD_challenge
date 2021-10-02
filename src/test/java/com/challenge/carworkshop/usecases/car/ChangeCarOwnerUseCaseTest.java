package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.commands.ChangeCarOwnerName;
import com.challenge.carworkshop.domain.car.entities.CarOwner;
import com.challenge.carworkshop.domain.car.events.AssignedCarOwner;
import com.challenge.carworkshop.domain.car.events.ChangedCarOwnerName;
import com.challenge.carworkshop.domain.car.events.CreatedCar;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import com.challenge.carworkshop.domain.repairappointment.commands.ChangeMechanicName;
import com.challenge.carworkshop.domain.repairappointment.events.AssignedMechanicToAppointment;
import com.challenge.carworkshop.domain.repairappointment.events.ChangedMechanicName;
import com.challenge.carworkshop.domain.repairappointment.events.CreatedRepairAppointment;
import com.challenge.carworkshop.domain.repairappointment.values.*;
import com.challenge.carworkshop.usecases.repairappointment.ChangeMechanicNameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ChangeCarOwnerUseCaseTest {
    private static final String CAR_ID = "666";
    private final static String CAR_OWNER_ID = "55555";

    @Mock
    private DomainEventRepository repository;

    @Test
    void changeCarOwnerDefault(){

        //arrange
        var command = new ChangeCarOwnerName( CarId.of(CAR_OWNER_ID),
                new CarOwnerId(CAR_ID),
                new Name("Laura", "Marquez"));


        var useCase = new ChangeCarOwnerUseCase();

        Mockito.when(repository.getEventsBy(Mockito.any())).thenReturn(EventStored());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(CAR_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventUpdateCarOwnerName = (ChangedCarOwnerName) events.get(0);
        Assertions.assertEquals("Laura", eventUpdateCarOwnerName.getCarOwnerName().value().name());
        Assertions.assertEquals("Marquez", eventUpdateCarOwnerName.getCarOwnerName().value().lastName());
        Mockito.verify(repository).getEventsBy("666");

    }

    private List<DomainEvent> EventStored() {

        var  createdCarEvent = new CreatedCar(new Name("Aubrey", "Jhonson"), new InsuredAmount(200000),
                new CityOfOrigin("Toronto"), new LicenseCode("SWW286"),
                new CarEngineCapacity(1493), new Brand("Subaru"),
                new Model("Impreza"), new Color("Red"));

        var assignedCarOwnerEvent = new AssignedCarOwner(new CarOwnerId(CAR_OWNER_ID), new Name("Aubrey", "Jhonson"));

        return List.of(createdCarEvent, assignedCarOwnerEvent);

    }

}