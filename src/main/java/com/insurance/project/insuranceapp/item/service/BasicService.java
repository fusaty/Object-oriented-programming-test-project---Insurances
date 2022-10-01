package com.insurance.project.insuranceapp.item.service;

import com.insurance.project.insuranceapp.item.domain.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class BasicService implements UserService, HouseholdInsuranceService, TravelInsuranceService, HouseAndApartmentInsuranceService, AccidentInsuranceService {

    private final Map<Long, User> users;
    private final Map<Long, HouseholdInsurance> insurances;
    private final Map<Long, TravelInsurance> travelInsurances;
    private final Map<Long, HouseAndApartmentInsurance> houseAndApartmentInsurances;
    private final Map<Long, AccidentInsurance> accidentInsurances;

    public BasicService() {
        users = new HashMap<>();
        insurances = new HashMap<>();
        travelInsurances = new HashMap<>();
        houseAndApartmentInsurances = new HashMap<>();
        accidentInsurances = new HashMap<>();
    }


    @Override
    public void addHouseholdInsurance(HouseholdInsurance insurance) {
        insurances.put(insurance.getId(), insurance);
    }

    @Override
    public Map<Long, HouseholdInsurance> findAllHouseholdInsurances() {
        return insurances;
    }

    @Override
    public Optional<HouseholdInsurance> findHouseholdInsuranceById(long id) {
        return Optional.ofNullable(insurances.get(id));
    }




    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public Map<Long, User> findAllUsers() {
        return users;
    }

    @Override
    public User findById(long id) {
        return users.get(id);
    }

    @Override
    public Optional<User> findUserById(long id) {
        return Optional.ofNullable(users.get(id));
    }


    @Override
    public void addTravelInsurance(TravelInsurance insurance) {
        travelInsurances.put(insurance.getId(), insurance);
    }

    @Override
    public Map<Long, TravelInsurance> findAllTravelInsurances() {
        return travelInsurances;
    }

    @Override
    public Optional<TravelInsurance> findTravelInsuranceById(long id) {
        return Optional.ofNullable(travelInsurances.get(id));
    }



    @Override
    public void addHouseAndApartmentInsurance(HouseAndApartmentInsurance insurance) {
        houseAndApartmentInsurances.put(insurance.getId(), insurance);
    }

    @Override
    public Map<Long, HouseAndApartmentInsurance> findAllHouseAndApartmentInsurances() {
        return houseAndApartmentInsurances;
    }

    @Override
    public Optional<HouseAndApartmentInsurance> findHouseAndApartmentInsuranceById(long id) {
        return Optional.ofNullable(houseAndApartmentInsurances.get(id));
    }


    @Override
    public void addAccidentInsurance(AccidentInsurance insurance) {
        accidentInsurances.put(insurance.getId(), insurance);
    }

    @Override
    public Map<Long, AccidentInsurance> findAllAccidentInsurances() {
        return accidentInsurances;
    }

    @Override
    public Optional<AccidentInsurance> findAccidentInsuranceById(long id) {
        return Optional.ofNullable(accidentInsurances.get(id));
    }

   
}

