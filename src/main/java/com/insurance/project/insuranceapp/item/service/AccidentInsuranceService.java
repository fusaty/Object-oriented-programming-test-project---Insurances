package com.insurance.project.insuranceapp.item.service;

import com.insurance.project.insuranceapp.item.domain.AccidentInsurance;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public interface AccidentInsuranceService {

    void addAccidentInsurance(AccidentInsurance insurance);

    Map<Long, AccidentInsurance> findAllAccidentInsurances();

    Optional<AccidentInsurance> findAccidentInsuranceById(long id);

}
