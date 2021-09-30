package com.challenge.carworkshop.domain.repairappointment.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Diagnostic implements ValueObject<String> {
    private final String diagnostic;


    public Diagnostic(String diagnostic) {
        this.diagnostic = Objects.requireNonNull(diagnostic);
        if (this.diagnostic.isBlank() || this.diagnostic.length() < 3) {
            throw new IllegalArgumentException("Diagnostic must contain at least 3 characters");
        }
    }

    @Override
    public String value() {
        return diagnostic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnostic that = (Diagnostic) o;
        return Objects.equals(diagnostic, that.diagnostic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagnostic);
    }
}
