package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.Identity;

public class CarId extends Identity {
    public CarId(){

    }
    private CarId(String id ){ super(id);}
    public static CarId of(String id){ return new CarId();}
}
