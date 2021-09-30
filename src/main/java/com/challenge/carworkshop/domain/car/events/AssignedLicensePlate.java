package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.CityOfOrigin;
import com.challenge.carworkshop.domain.car.values.LicenseCode;
import com.challenge.carworkshop.domain.car.values.LicensePlateId;

public class AssignedLicensePlate extends DomainEvent {
    private final LicensePlateId licenseId;
    private final CityOfOrigin city;
    private final LicenseCode code;

    public AssignedLicensePlate(LicensePlateId licenseId, CityOfOrigin city, LicenseCode code) {
        super("carworkshop.domain.car.assignedlicenseplate");
        this.licenseId = licenseId;
        this.city = city;
        this.code = code;
    }

    public LicensePlateId getLicensePlateId() {
        return licenseId;
    }

    public CityOfOrigin getCity() {
        return city;
    }

    public LicenseCode getCode() {
        return code;
    }
}
