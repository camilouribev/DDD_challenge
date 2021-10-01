package com.challenge.carworkshop.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.challenge.carworkshop.domain.car.Car;
import com.challenge.carworkshop.domain.car.events.CreatedCar;
import com.challenge.carworkshop.domain.car.values.*;


public class CreateCarUseCase extends UseCase<TriggeredEvent<CreatedCar>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<CreatedCar> createdCarTriggeredEvent) {

        var event = createdCarTriggeredEvent.getDomainEvent();
/*

        var car = new Car (CarId.of(event.aggregateRootId()), new Name(event.getCarOwner().getName().value().name(), event.getCarOwner().getName().value().lastName()),
                new InsuredAmount(event.getInsurance().getInsuredAmount().value()), new CityOfOrigin(event.getLicense().getCityOfOrigin().value()), new LicenseCode(event.getLicense().getLicenseCode().value()),
                new CarEngineCapacity(event.getEngineCapacity().value()), new Brand(event.getBrand().value()), new Model(event.getModel().value()),
                new Color(event.getColor().value()));
*/

        var car = Car.from(CarId.of(event.aggregateRootId()), this.retrieveEvents());


        emit().onResponse(new ResponseEvents(car.getUncommittedChanges()));
    }

   /* public static class Request implements UseCase.RequestValues{
        private final String entityId;
        private final String carOwnerName;
        private final String carOwnerLastName;
        private final Double insuredAmount;
        private final String city;
        private final String code;
        private final Double engineCapacity;
        private final String brand;
        private final String model;
        private final String color;

        public Request(String entityId, String carOwnerName, String carOwnerLastName, Double insuredAmount, String city, String code, Double engineCapacity,
                       String brand, String model, String color) {
            this.entityId = entityId;
            this.carOwnerName = carOwnerName;
            this.carOwnerLastName = carOwnerLastName;
            this.insuredAmount = insuredAmount;
            this.city = city;
            this.code = code;
            this.engineCapacity = engineCapacity;
            this.brand = brand;
            this.model = model;
            this.color = color;
        }

        public String getEntityId() {
            return entityId;
        }

        public String getCarOwnerName() {
            return carOwnerName;
        }

        public String getCarOwnerLastName() {
            return carOwnerLastName;
        }

        public Double getInsuredAmount() {
            return insuredAmount;
        }

        public String getCity() {
            return city;
        }

        public Double getEngineCapacity() {
            return engineCapacity;
        }

        public String getBrand() {
            return brand;
        }

        public String getCode() {
            return code;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }
    }
*/

}
