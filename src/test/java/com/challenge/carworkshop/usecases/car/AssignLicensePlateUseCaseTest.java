package com.challenge.carworkshop.usecases.car;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.commands.AssignLicensePlate;
import com.challenge.carworkshop.domain.car.events.AssignedLicensePlate;
import com.challenge.carworkshop.domain.car.events.CreatedCar;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class AssignLicensePlateUseCaseTest {
    private static final String CAR_ID = "12345";
    private static final String LICENSE_PLATE_ID = "333332221";

    @Mock
    private DomainEventRepository repository;

    @Test
    void assignLicenseStatusDefault() {
        //Arrange
        var command = new AssignLicensePlate(CarId.of(CAR_ID), new LicensePlateId(LICENSE_PLATE_ID), new CityOfOrigin("Armenia"), new LicenseCode("CCW344"));
        var useCase = new AssignLicensePlateUseCase();
        Mockito.when(repository.getEventsBy(LICENSE_PLATE_ID)).thenReturn(EventStored());
        useCase.addRepository(repository);


        //Act
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(LICENSE_PLATE_ID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //Assert
        var licenseAssigned = (AssignedLicensePlate) events.get(0);
        Assertions.assertEquals("CCW344", licenseAssigned.getCode().value());
        Assertions.assertEquals("Armenia", licenseAssigned.getCity().value());
        Assertions.assertEquals(LICENSE_PLATE_ID, licenseAssigned.getLicensePlateId().value());

    }

    private List<DomainEvent> EventStored() {

        var event =  new CreatedCar(
                new Name("Sara", "Martinez"),
                new InsuredAmount(30000),
                new CityOfOrigin("Armenia"),
                new LicenseCode("CCW334"),
                new CarEngineCapacity(1200),
                new Brand("Suzuki"),
                new Model("Swift"),
                new Color("White")

        );

        return List.of(event);
    }
}