package com.insurance.project.insuranceapp.item.web;

import com.insurance.project.insuranceapp.item.domain.HouseholdInsurance;
import com.insurance.project.insuranceapp.item.resource.HouseholdInsuranceResource;
import com.insurance.project.insuranceapp.item.service.HouseholdInsuranceService;
import com.insurance.project.insuranceapp.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/insurance")
public class HouseholdInsuranceController {

    private final HouseholdInsuranceService insuranceService;
    private final UserService userService;

    @Autowired
    public HouseholdInsuranceController(HouseholdInsuranceService householdInsuranceService, UserService userService) {
        this.insuranceService = householdInsuranceService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("insurances", insuranceService.findAllHouseholdInsurances());
        model.addAttribute("users", userService.findAllUsers());
        return "insurance/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<HouseholdInsurance> insuranceById = insuranceService.findHouseholdInsuranceById(id);
        if (insuranceById.isPresent()) {
            HouseholdInsurance insurance = insuranceById.get();
            model.addAttribute("insurance", insurance);
            model.addAttribute("user", userService.findById(insurance.getUserId()));
        }
        return "insurance/one";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("insurance", new HouseholdInsurance());
        model.addAttribute("users", userService.findAllUsers());
        return "insurance/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid HouseholdInsurance insurance, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/insurance/add/";
        }
        insuranceService.addHouseholdInsurance(insurance);
        return "redirect:/insurance/";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable long id, Model model) {
        model.addAttribute("insurance", new HouseholdInsuranceResource(insuranceService.findAllHouseholdInsurances().get(id)));
        return "insurance/modify";
    }


    @PostMapping("/modify/{id}")
    public String submit(@PathVariable long id, @ModelAttribute @Valid HouseholdInsuranceResource householdInsuranceResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/insurance/modify/{id}";
        }
        insuranceService.findAllHouseholdInsurances().replace(id,householdInsuranceResource.toInsurance(id));
        return "redirect:/insurance/";
    }
}
