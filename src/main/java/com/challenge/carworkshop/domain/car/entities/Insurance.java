package com.challenge.carworkshop.domain.car.entities;

import co.com.sofka.domain.generic.Entity;
import com.challenge.carworkshop.domain.car.values.InsuranceId;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;

public class Insurance extends Entity<InsuranceId> {
    private InsuredAmount insuredAmount;

    public Insurance(InsuranceId entityId, InsuredAmount insuredAmount) {
        super(entityId);
        this.insuredAmount = insuredAmount;
    }

    public InsuredAmount getInsuredAmount() {
        return insuredAmount;
    }

    public void changeInsuredAmount(InsuredAmount insuredAmount) {
        this.insuredAmount = insuredAmount;
    }
}
