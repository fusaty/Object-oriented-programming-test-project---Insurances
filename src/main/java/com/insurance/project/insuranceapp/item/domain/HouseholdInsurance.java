package com.insurance.project.insuranceapp.item.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseholdInsurance implements Insurance {

    private String name;
    @Min(0)
    private long id;
    private LocalDate Date = LocalDate.now();
    @NotNull
    private long userId;
    @NotNull
    @DateTimeFormat
    private LocalDate StartDate;
    @NotNull
    @DateTimeFormat
    private LocalDate EndDate;
    @NotNull
    @Min(0)
    private Float price;
    @NotNull
    @Min(0)
    private Float MonthlyPrice;
    @NotNull
    @Size(min = 1)
    private String address;
    @NotNull
    @Min(0)
    private Float propertyValue;
    @NotNull
    @Min(0)
    private Float equipmentValue;
}
