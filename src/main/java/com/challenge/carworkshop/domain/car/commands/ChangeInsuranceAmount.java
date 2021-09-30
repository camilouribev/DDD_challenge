package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;

public class ChangeInsuranceAmount extends Command {
    private final InsuredAmount insuranceAmount;

    public ChangeInsuranceAmount(InsuredAmount insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public InsuredAmount getInsuranceAmount() {
        return insuranceAmount;
    }
}
