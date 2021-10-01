package com.challenge.carworkshop.domain.car.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Locale;
import java.util.Objects;

public class LicenseCode implements ValueObject<String> {
    private final String code;


    public LicenseCode(String code) {
        this.code = Objects.requireNonNull(code);
        if (this.code.length() != 6) {
            throw new IllegalArgumentException("LicenseCode must contain at 6 characters");
        }

        // Verifies license plate consists of 3 letters and 3 numbers
        if (!this.code.toUpperCase(Locale.ROOT).matches("[A-Z]{3}\\d{3}")) {
            throw new IllegalArgumentException("License Code must have three letters and three numbers");
        }
    }
    @Override
    public String value() {
        return code.toUpperCase(Locale.ROOT);
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
