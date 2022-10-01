package com.insurance.project.insuranceapp.item.enums;

import lombok.Getter;

@Getter
public enum EU {
    IN( "In EU"),
    OUT( "Out of EU");

    public final String name;

    EU(String name) {
        this.name = name;
    }
}

