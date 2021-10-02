package com.challenge.carworkshop.domain.car;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.entities.CarOwner;
import com.challenge.carworkshop.domain.car.entities.Insurance;
import com.challenge.carworkshop.domain.car.entities.LicensePlate;
import com.challenge.carworkshop.domain.car.events.*;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;


import java.util.List;
import java.util.Objects;


public class Car extends AggregateEvent<CarId> {
    protected CarOwner carOwner;
    protected Insurance insurance;
    protected LicensePlate license;
    protected CarEngineCapacity engineCapacity;
    protected Brand brand;
    protected Model model;
    protected Color color;

    public Car(CarId entityId, Name carOwnerName, InsuredAmount insuredAmount, CityOfOrigin city, LicenseCode code, CarEngineCapacity engineCapacity, Brand brand, Model model, Color color) {
        super(entityId);
        appendChange(new CreatedCar(carOwnerName,insuredAmount,city,code,engineCapacity,brand, model,color)).apply();

    }

    private Car(CarId entityId){
        super(entityId);
        subscribe(new CarChange(this));

    }

    public static Car from(CarId entityId, List<DomainEvent> events){
        var car = new Car(entityId);
        events.forEach(car::applyEvent);
        return car;
    }

    public void assignCarOwner(CarOwnerId ownerId, Name ownerName){
        Objects.requireNonNull(ownerId);
        appendChange(new AssignedCarOwner(ownerId, ownerName)).apply();
    }

    public void assignLicensePlate(LicensePlateId licenseId, CityOfOrigin city, LicenseCode code){
        Objects.requireNonNull(licenseId);
        appendChange(new AssignedLicensePlate(licenseId, city, code)).apply();
    }

    public void assignInsurance(InsuranceId insuranceId, InsuredAmount insuredAmount){
        Objects.requireNonNull(insuranceId);
        Objects.requireNonNull(insuredAmount);
        appendChange(new AssignedInsurance(insuranceId, insuredAmount)).apply();
    }


    public void changeInsuranceAmount(InsuredAmount insuranceAmount){
        Objects.requireNonNull(insuranceAmount);
        appendChange(new ChangedInsuranceAmount(insuranceAmount)).apply();
    }

    public void changeCarOwnerName(CarId carId, CarOwnerId carOwnerId, Name name){
        Objects.requireNonNull(name);
        appendChange(new ChangedCarOwnerName(carId, carOwnerId, name)).apply();
    }


    public CarOwner getCarOwner() {
        return carOwner;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public LicensePlate getLicense() {
        return license;
    }

    public CarEngineCapacity getEngineCapacity() {
        return engineCapacity;
    }

    public Brand getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public Color getColor() {
        return color;
    }
}
