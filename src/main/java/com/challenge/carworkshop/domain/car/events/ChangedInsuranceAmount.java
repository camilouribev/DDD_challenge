package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;

public class ChangedInsuranceAmount extends DomainEvent {
    private final InsuredAmount insuredAmount;

    public ChangedInsuranceAmount(InsuredAmount insuredAmount) {
        super("carworkshop.domain.car.changedinsuredamount");
        this.insuredAmount = insuredAmount;
    }

    public InsuredAmount getInsuredAmount() {
        return insuredAmount;
    }

}
