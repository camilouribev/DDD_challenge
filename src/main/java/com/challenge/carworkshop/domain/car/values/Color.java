package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Color implements ValueObject<String> {

    private final String color;

    public Color(String color) {
        this.color = Objects.requireNonNull(color);
        if (this.color.isBlank() || this.color.length() < 3) {
            throw new IllegalArgumentException("Color must contain at least 3 characters");
        }

        if (this.color.isBlank() || this.color.length() > 20) {
            throw new IllegalArgumentException("Color must contain 20 characters at most");
        }
    }
    @Override
    public String value() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color1 = (Color) o;
        return Objects.equals(color, color1.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
