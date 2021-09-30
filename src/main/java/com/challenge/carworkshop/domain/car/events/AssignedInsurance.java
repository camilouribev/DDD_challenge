package com.challenge.carworkshop.domain.car.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.challenge.carworkshop.domain.car.values.InsuranceId;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;

public class AssignedInsurance extends DomainEvent {
    private final InsuranceId insuranceId;
    private final InsuredAmount insuredAmount;

    public AssignedInsurance(InsuranceId insuranceId, InsuredAmount insuredAmount) {
        super("carworkshop.domain.car.assignedinsurance");
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
