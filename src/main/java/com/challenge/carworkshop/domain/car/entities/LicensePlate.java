package com.challenge.carworkshop.domain.car.entities;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.car.values.CityOfOrigin;
import com.challenge.carworkshop.domain.car.values.LicenseCode;
import com.challenge.carworkshop.domain.car.values.LicensePlateId;

public class LicensePlate extends Entity<LicensePlateId> {
    private CityOfOrigin cityOfOrigin;
    private LicenseCode licenseCode;


    public LicensePlate(LicensePlateId entityId, CityOfOrigin cityOfOrigin, LicenseCode licenseCode) {
        super(entityId);
        this.cityOfOrigin = cityOfOrigin;
        this.licenseCode = licenseCode;
    }

    public CityOfOrigin getCityOfOrigin() {
        return cityOfOrigin;
    }

    public void ChangeCityOfOrigin(CityOfOrigin cityOfOrigin) {
        this.cityOfOrigin = cityOfOrigin;
    }

    public LicenseCode getLicenseCode() {
        return licenseCode;
    }

    public void ChangeLicenseCode(LicenseCode licenseCode) {
        this.licenseCode = licenseCode;
    }
}
