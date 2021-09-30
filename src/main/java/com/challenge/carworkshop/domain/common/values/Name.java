package com.challenge.carworkshop.domain.common.values;

import co.com.sofka.domain.generic.ValueObject;
import com.challenge.carworkshop.domain.repairappointment.values.Procedure;

import java.util.Objects;

public class Name implements ValueObject<Name.Props> {

    private final String name;
    private final String lastName;

    public Name(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;

        if(this.name.isBlank() || this.name.length() < 3){
            throw new IllegalArgumentException("Names must have at least three characters");
        }
        if(this.lastName.isBlank()){
            throw new IllegalArgumentException("Last names must have at least three characters ");
        }
    }

    @Override
    public Name.Props value() {
        return new Name.Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String lastName() {
                return lastName;
            }
        };
    }

    public  interface  Props{
        String name();
        String lastName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name) && Objects.equals(lastName, name1.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName);
    }
}
