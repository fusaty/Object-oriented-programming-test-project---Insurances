package com.insurance.project.insuranceapp.item.service;

import com.insurance.project.insuranceapp.item.domain.TravelInsurance;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface TravelInsuranceService {

    void addTravelInsurance(TravelInsurance insurance);

    Map<Long, TravelInsurance> findAllTravelInsurances();

    Optional<TravelInsurance> findTravelInsuranceById(long id);

}
