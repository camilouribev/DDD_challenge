package com.challenge.carworkshop.domain.car;

import co.com.sofka.domain.generic.AggregateEvent;
import com.challenge.carworkshop.domain.car.values.CarId;
import com.challenge.carworkshop.domain.common.values.CarEngineCapacity;
import com.challenge.carworkshop.domain.common.values.InsuredAmount;
import com.challenge.carworkshop.domain.repairappointment.entities.Invoice;
import com.challenge.carworkshop.domain.repairappointment.entities.Mechanic;
import com.challenge.carworkshop.domain.repairappointment.entities.Service;
import com.challenge.carworkshop.domain.repairappointment.values.AppointmentDate;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;

public class Car extends AggregateEvent<CarId> {

}
