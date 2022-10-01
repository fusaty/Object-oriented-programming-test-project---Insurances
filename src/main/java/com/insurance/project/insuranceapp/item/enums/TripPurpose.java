package com.insurance.project.insuranceapp.item.enums;

import lombok.Getter;

@Getter
public enum TripPurpose {
    WORK( "Work"),
    SPORT( "Sport"),
    RECREATION("Recreation"),
    DIFFERENT("Different purpose");

    public final String name;

    TripPurpose(String name) {
        this.name = name;
    }

}
