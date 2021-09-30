package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class LicenseCode implements ValueObject<String> {
    private final String code;


    public LicenseCode(String code) {
        this.code = Objects.requireNonNull(code);
        if (this.code.length() != 6) {
            throw new IllegalArgumentException("LicenseCode must contain at 6 characters");
        }
    }
    @Override
    public String value() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LicenseCode that = (LicenseCode) o;
        return Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
