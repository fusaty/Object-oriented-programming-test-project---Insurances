package com.insurance.project.insuranceapp.item.domain;

import java.time.LocalDate;

public interface Insurance {

    long getId();
    long getUserId();
    LocalDate getStartDate();
    LocalDate getEndDate();
    Float getPrice();
    Float getMonthlyPrice();
}
