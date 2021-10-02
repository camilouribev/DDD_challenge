package com.challenge.carworkshop.domain.repairappointment.commands;

import co.com.sofka.domain.generic.Command;
import com.challenge.carworkshop.domain.repairappointment.values.RepairAppointmentId;
import com.challenge.carworkshop.domain.repairappointment.values.Workshop;

public class ChangeWorkshop extends Command {

    private final Workshop workshop;

    public ChangeWorkshop( Workshop workshop) {
        this.workshop = workshop;
    }


    public Workshop getWorkshop() {
        return workshop;
    }
}
