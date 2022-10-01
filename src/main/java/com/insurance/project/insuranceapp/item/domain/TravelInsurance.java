package com.insurance.project.insuranceapp.item.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.insurance.project.insuranceapp.item.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TravelInsurance implements Insurance {

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
    private EU eu;
    @NotNull
    private TripPurpose trip;

}
