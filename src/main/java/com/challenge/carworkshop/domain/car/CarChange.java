package com.challenge.carworkshop.domain.car;

import co.com.sofka.domain.generic.EventChange;
import com.challenge.carworkshop.domain.car.entities.CarOwner;
import com.challenge.carworkshop.domain.car.entities.Insurance;
import com.challenge.carworkshop.domain.car.entities.LicensePlate;
import com.challenge.carworkshop.domain.car.events.*;

public class CarChange extends EventChange {
    public CarChange(Car car){
        apply((CreatedCar event)->{
            car.carOwner = event.getCarOwner();
            car.brand = event.getBrand();
            car.color = event.getColor();
            car.engineCapacity = event.getEngineCapacity();
            car.insurance = event.getInsurance();
            car.license = event.getLicense();
            car.model = event.getModel();

        });

        apply((AssignedCarOwner event)->{
            car.carOwner = new CarOwner(event.getOwnerId(),event.getOwnerName());

        });

        apply((AssignedInsurance event)->{
            car.insurance = new Insurance(event.getInsuranceId(),event.getInsuredAmount());

        });

        apply((AssignedLicensePlate event)->{
            car.license = new LicensePlate(event.getLicensePlateId(), event.getCity(), event.getCode());
        });

        apply((ChangedCarOwnerName event)->{
            car.carOwner.changeCarOwnerName(event.getCarOwnerName());
        });




    }


}
