package com.insurance.project.insuranceapp.item.service;

import com.insurance.project.insuranceapp.item.domain.HouseholdInsurance;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface HouseholdInsuranceService {

    void addHouseholdInsurance(HouseholdInsurance insurance);

    Map<Long, HouseholdInsurance> findAllHouseholdInsurances();

    Optional<HouseholdInsurance> findHouseholdInsuranceById(long id);

}