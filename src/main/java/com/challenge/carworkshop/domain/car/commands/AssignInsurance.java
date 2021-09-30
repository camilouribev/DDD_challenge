package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.car.values.InsuranceId;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;

public class AssignInsurance extends Command {
    private final InsuranceId insuranceId;
    private final InsuredAmount insuredAmount;

    public AssignInsurance(InsuranceId insuranceId, InsuredAmount insuredAmount) {
        this.insuranceId = insuranceId;
        this.insuredAmount = insuredAmount;
    }

    public InsuranceId getInsuranceId() {
        return insuranceId;
    }

    public InsuredAmount getInsuredAmount() {
        return insuredAmount;
    }
}
