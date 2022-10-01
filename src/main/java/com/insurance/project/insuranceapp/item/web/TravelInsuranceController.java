package com.insurance.project.insuranceapp.item.web;

import com.insurance.project.insuranceapp.item.domain.TravelInsurance;
import com.insurance.project.insuranceapp.item.enums.*;
import com.insurance.project.insuranceapp.item.resource.TravelInsuranceResource;
import com.insurance.project.insuranceapp.item.service.TravelInsuranceService;
import com.insurance.project.insuranceapp.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/travelInsurance")
public class TravelInsuranceController {

    private final TravelInsuranceService travelInsuranceService;
    private final UserService userService;

    @Autowired
    public TravelInsuranceController(TravelInsuranceService travelInsuranceService, UserService userService) {
        this.travelInsuranceService = travelInsuranceService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("travelInsurances", travelInsuranceService.findAllTravelInsurances());
        model.addAttribute("users", userService.findAllUsers());
        return "travelInsurance/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<TravelInsurance> insuranceById = travelInsuranceService.findTravelInsuranceById(id);
        if (insuranceById.isPresent()) {
            TravelInsurance insurance = insuranceById.get();
            model.addAttribute("travelInsurance", insurance);
            model.addAttribute("user", userService.findById(insurance.getUserId()));
        }
        return "travelInsurance/one";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("travelInsurance", new TravelInsurance());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("eus", EU.values());
        model.addAttribute("purpose", TripPurpose.values());
        return "travelInsurance/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid TravelInsurance insurance, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/travelInsurance/add/";
        }
        travelInsuranceService.addTravelInsurance(insurance);
        return "redirect:/travelInsurance/";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable long id, Model model) {
        model.addAttribute("travelInsurance", new TravelInsuranceResource(travelInsuranceService.findAllTravelInsurances().get(id)));
        return "travelInsurance/modify";
    }


    @PostMapping("/modify/{id}")
    public String submit(@PathVariable long id, @ModelAttribute @Valid TravelInsuranceResource travelInsuranceResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/travelInsurance/modify/{id}";
        }
        travelInsuranceService.findAllTravelInsurances().replace(id,travelInsuranceResource.toInsurance(id));

        return "redirect:/travelInsurance/";
    }


}
