package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.entities.CarOwner;
import com.challenge.carworkshop.domain.car.entities.Insurance;
import com.challenge.carworkshop.domain.car.entities.LicensePlate;
import com.challenge.carworkshop.domain.car.values.*;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.common.values.Name;

public class CreatedCar extends DomainEvent {
    private final CarOwner carOwner;
    private final Insurance insurance;
    private final LicensePlate license;
    private final CarEngineCapacity engineCapacity;
    private final Brand brand;
    private final Model model;
    private final Color color;


    public CreatedCar(Name carOwnerName, InsuredAmount insuredAmount, CityOfOrigin city, LicenseCode code, CarEngineCapacity engineCapacity, Brand brand, Model model, Color color) {
        super("carworkshop.domain.car.createdcar");
        this.carOwner = new CarOwner(new CarOwnerId(), carOwnerName );
        this.insurance = new Insurance(new InsuranceId(), insuredAmount);
        this.license = new LicensePlate(new LicensePlateId(),city, code);
        this.engineCapacity = engineCapacity;
        this.brand = brand;
        this.model = model;
        this.color = color;
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
