package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.Identity;

public class CarOwnerId extends Identity {
    public CarOwnerId(){

    }
    private CarOwnerId(String id ){ super(id);}
    public static CarOwnerId of(String id){ return new CarOwnerId();}
}
