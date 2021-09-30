package com.challenge.carworkshop.domain.car.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.common.values.Name;

public class ChangeCarOwnerName extends Command {
    private final Name name;

    public ChangeCarOwnerName(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
