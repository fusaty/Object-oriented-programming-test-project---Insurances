package com.insurance.project.insuranceapp.item.enums;

import lombok.Getter;

@Getter
public enum Garage {
    YES( "Has garage"),
    NO( "Doesn't have garage");


    public final String name;

    Garage(String name) {
        this.name = name;
    }

}
