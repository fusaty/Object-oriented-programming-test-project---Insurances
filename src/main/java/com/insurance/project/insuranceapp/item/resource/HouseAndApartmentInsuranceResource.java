package com.insurance.project.insuranceapp.item.resource;

import com.insurance.project.insuranceapp.item.domain.HouseAndApartmentInsurance;
import com.insurance.project.insuranceapp.item.enums.Garage;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class HouseAndApartmentInsuranceResource {

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
    @Size(min = 1)
    String address;
    @NotNull
    @Min(0)
    Float propertyValue;
    Garage garage;

    public HouseAndApartmentInsuranceResource(HouseAndApartmentInsurance insurance) {
        this.id=insurance.getId();
        this.name=insurance.getName();
        this.Date=insurance.getDate();
        this.userId=insurance.getUserId();
        this.StartDate=insurance.getStartDate();
        this.EndDate=insurance.getEndDate();
        this.price=insurance.getPrice();
        this.MonthlyPrice=insurance.getMonthlyPrice();
        this.address=insurance.getAddress();
        this.propertyValue=insurance.getPropertyValue();
        this.garage=insurance.getGarage();
    }

    public HouseAndApartmentInsurance toInsurance(long id) {
        return new HouseAndApartmentInsurance(
                name,
                id,
                Date,
                userId,
                StartDate,
                EndDate,
                price,
                MonthlyPrice,
                address,
                propertyValue,
                garage
        );
    }
}
