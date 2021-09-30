package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;


public class AppointmentDate implements ValueObject<LocalDate> {
    private final LocalDate date = LocalDate.now();


    @Override
    public LocalDate value() {
        return date;
    }
}
