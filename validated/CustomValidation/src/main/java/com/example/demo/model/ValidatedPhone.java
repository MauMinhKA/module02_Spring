package com.example.demo.model;

import com.example.demo.validated.ContactNumberConstraint;

public class ValidatedPhone {
    @ContactNumberConstraint
    private String numberPhone;

    public ValidatedPhone() {
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
