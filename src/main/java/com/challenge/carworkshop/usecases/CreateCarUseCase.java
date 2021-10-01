package com.challenge.carworkshop.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.carworkshop.domain.car.events.CreatedCar;


import java.util.List;


public class CreateCarUseCase extends UseCase<TriggeredEvent<CreatedCar>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CreatedCar> createdCarTriggeredEvent) {

        var event = createdCarTriggeredEvent.getDomainEvent();
        emit().onResponse(new ResponseEvents(List.of(event)));
    }



}
