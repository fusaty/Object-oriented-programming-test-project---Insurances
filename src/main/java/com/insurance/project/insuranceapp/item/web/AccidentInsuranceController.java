package com.insurance.project.insuranceapp.item.web;


import com.insurance.project.insuranceapp.item.domain.AccidentInsurance;
import com.insurance.project.insuranceapp.item.resource.AccidentInsuranceResource;
import com.insurance.project.insuranceapp.item.service.AccidentInsuranceService;
import com.insurance.project.insuranceapp.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/accidentInsurance")
public class AccidentInsuranceController {
    private final AccidentInsuranceService accidentInsuranceService;
    private final UserService userService;

    @Autowired
    public AccidentInsuranceController(AccidentInsuranceService accidentInsuranceService, UserService userService) {
        this.accidentInsuranceService = accidentInsuranceService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("accidentInsurances", accidentInsuranceService.findAllAccidentInsurances());
        model.addAttribute("users", userService.findAllUsers());
        return "accidentInsurance/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<AccidentInsurance> insuranceById = accidentInsuranceService.findAccidentInsuranceById(id);
        if (insuranceById.isPresent()) {
            AccidentInsurance insurance = insuranceById.get();
            model.addAttribute("accidentInsurance", insurance);
            model.addAttribute("user", userService.findById(insurance.getUserId()));
        }
        return "accidentInsurance/one";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("accidentInsurance", new AccidentInsurance());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("insured", userService.findAllUsers());

        return "accidentInsurance/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid AccidentInsurance insurance, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/accidentInsurance/add/";
        }
        accidentInsuranceService.addAccidentInsurance(insurance);
        return "redirect:/accidentInsurance/";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable long id, Model model) {
        model.addAttribute("accidentInsurance", new AccidentInsuranceResource(accidentInsuranceService.findAllAccidentInsurances().get(id)));
        return "accidentInsurance/modify";
    }


    @PostMapping("/modify/{id}")
    public String submit(@PathVariable long id, @ModelAttribute  @Valid AccidentInsuranceResource accidentInsuranceResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/accidentInsurance/modify/{id}";
        }

        accidentInsuranceService.findAllAccidentInsurances().replace(id,accidentInsuranceResource.toInsurance(id));

        return "redirect:/accidentInsurance/";
    }
}
