package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.car.values.CityOfOrigin;
import com.challenge.carworkshop.domain.car.values.LicenseCode;
import com.challenge.carworkshop.domain.car.values.LicensePlateId;

public class AssignLicensePlate extends Command {
    private final CarId carId;
    private final LicensePlateId licenseId;
    private final CityOfOrigin city;
    private final LicenseCode code;

    public AssignLicensePlate(CarId carId, LicensePlateId licenseId, CityOfOrigin city, LicenseCode code) {
        this.carId = carId;
        this.licenseId = licenseId;
        this.city = city;
        this.code = code;
    }



    public LicensePlateId getLicenseId() {
        return licenseId;
    }

    public CityOfOrigin getCity() {
        return city;
    }

    public LicenseCode getCode() {
        return code;
    }

    public CarId getCarId() {
        return carId;
    }
}
