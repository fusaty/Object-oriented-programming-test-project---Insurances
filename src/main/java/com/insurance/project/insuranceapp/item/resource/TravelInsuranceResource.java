package com.insurance.project.insuranceapp.item.resource;

import com.insurance.project.insuranceapp.item.domain.TravelInsurance;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.insurance.project.insuranceapp.item.enums.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TravelInsuranceResource {
    private String name;
    @Min(0)
    private long id;
    private LocalDate Date = LocalDate.now();
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
    private EU eu;
    private TripPurpose trip;


    public TravelInsuranceResource(TravelInsurance insurance) {
        this.id=insurance.getId();
        this.name=insurance.getName();
        this.Date=insurance.getDate();
        this.userId=insurance.getUserId();
        this.StartDate=insurance.getStartDate();
        this.EndDate=insurance.getEndDate();
        this.price=insurance.getPrice();
        this.MonthlyPrice=insurance.getMonthlyPrice();
        this.eu=insurance.getEu();
        this.trip=insurance.getTrip();


    }

    public TravelInsurance toInsurance(long id) {
        return new TravelInsurance(
                name,
                id,
                Date,
                userId,
                StartDate,
                EndDate,
                price,
                MonthlyPrice,
                eu,
                trip
        );
    }
}
