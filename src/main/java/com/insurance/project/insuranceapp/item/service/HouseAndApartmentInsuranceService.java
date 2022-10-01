package com.insurance.project.insuranceapp.item.service;

import com.insurance.project.insuranceapp.item.domain.HouseAndApartmentInsurance;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface HouseAndApartmentInsuranceService {

    void addHouseAndApartmentInsurance(HouseAndApartmentInsurance insurance);

    Map<Long, HouseAndApartmentInsurance> findAllHouseAndApartmentInsurances();

    Optional<HouseAndApartmentInsurance> findHouseAndApartmentInsuranceById(long id);

}
