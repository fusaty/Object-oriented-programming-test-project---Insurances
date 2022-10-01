package com.insurance.project.insuranceapp.item.resource;

import com.insurance.project.insuranceapp.item.domain.AccidentInsurance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AccidentInsuranceResource {

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
    @NotNull
    @Min(0)
    private Float consequencesPrice;
    @NotNull
    @Min(0)
    private Float deathPrice;
    @NotNull
    @Min(0)
    private Float dailyPrice;
    private long insuredId;

    public AccidentInsuranceResource(AccidentInsurance insurance) {
        this.id=insurance.getId();
        this.name=insurance.getName();
        this.Date=insurance.getDate();
        this.userId=insurance.getUserId();
        this.StartDate=insurance.getStartDate();
        this.EndDate=insurance.getEndDate();
        this.price=insurance.getPrice();
        this.MonthlyPrice=insurance.getMonthlyPrice();
        this.consequencesPrice=insurance.getConsequencesPrice();
        this.deathPrice=insurance.getDeathPrice();
        this.dailyPrice=insurance.getDailyPrice();
        this.insuredId=insurance.getInsuredId();
    }

    public AccidentInsurance toInsurance(long id) {
        return new AccidentInsurance(
                name,
                id,
                Date,
                userId,
                StartDate,
                EndDate,
                price,
                MonthlyPrice,
                consequencesPrice,
                deathPrice,
                dailyPrice,
                insuredId
        );
    }
}
