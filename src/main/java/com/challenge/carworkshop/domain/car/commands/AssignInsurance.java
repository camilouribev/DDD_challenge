package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.car.values.InsuranceId;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;

public class AssignInsurance extends Command {
    private final CarId carId;

    private final InsuranceId insuranceId;
    private final InsuredAmount insuredAmount;

    public AssignInsurance(CarId carId, InsuranceId insuranceId, InsuredAmount insuredAmount) {
        this.carId = carId;
        this.insuranceId = insuranceId;
        this.insuredAmount = insuredAmount;
    }


    public CarId getCarId() {
        return carId;
    }

    public InsuranceId getInsuranceId() {
        return insuranceId;
    }

    public InsuredAmount getInsuredAmount() {
        return insuredAmount;
    }
}
