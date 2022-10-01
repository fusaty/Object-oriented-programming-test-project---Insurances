package com.insurance.project.insuranceapp.item.web;

import com.insurance.project.insuranceapp.item.domain.HouseAndApartmentInsurance;
import com.insurance.project.insuranceapp.item.enums.Garage;
import com.insurance.project.insuranceapp.item.resource.HouseAndApartmentInsuranceResource;
import com.insurance.project.insuranceapp.item.service.HouseAndApartmentInsuranceService;
import com.insurance.project.insuranceapp.item.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/houseAndApartmentInsurance")
public class HouseAndApartmentInsuranceController {

    private final HouseAndApartmentInsuranceService houseAndApartmentInsuranceService;
    private final UserService userService;

    @Autowired
    public HouseAndApartmentInsuranceController(HouseAndApartmentInsuranceService houseAndApartmentInsuranceService, UserService userService) {
        this.houseAndApartmentInsuranceService = houseAndApartmentInsuranceService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("insurances", houseAndApartmentInsuranceService.findAllHouseAndApartmentInsurances());
        model.addAttribute("users", userService.findAllUsers());
        return "houseAndApartmentInsurance/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<HouseAndApartmentInsurance> insuranceById = houseAndApartmentInsuranceService.findHouseAndApartmentInsuranceById(id);
        if (insuranceById.isPresent()) {
            HouseAndApartmentInsurance insurance = insuranceById.get();
            model.addAttribute("insurance", insurance);
            model.addAttribute("user", userService.findById(insurance.getUserId()));
        }
        return "houseAndApartmentInsurance/one";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("insurance", new HouseAndApartmentInsurance());
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("garage", Garage.values());
        return "houseAndApartmentInsurance/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid HouseAndApartmentInsurance insurance, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/houseAndApartmentInsurance/add/";
        }
        houseAndApartmentInsuranceService.addHouseAndApartmentInsurance(insurance);
        return "redirect:/houseAndApartmentInsurance/";
    }

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable long id, Model model) {
        model.addAttribute("houseAndApartmentInsurance", new HouseAndApartmentInsuranceResource(houseAndApartmentInsuranceService.findAllHouseAndApartmentInsurances().get(id)));
        return "houseAndApartmentInsurance/modify";
    }


    @PostMapping("/modify/{id}")
    public String submit(@PathVariable long id, @ModelAttribute @Valid HouseAndApartmentInsuranceResource houseAndApartmentInsuranceResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/houseAndApartmentInsurance/modify/{id}";
        }
        houseAndApartmentInsuranceService.findAllHouseAndApartmentInsurances().replace(id,houseAndApartmentInsuranceResource.toInsurance(id));

        return "redirect:/houseAndApartmentInsurance/";
    }


}

