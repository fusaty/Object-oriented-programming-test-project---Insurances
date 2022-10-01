package com.insurance.project.insuranceapp.item.web;

import com.insurance.project.insuranceapp.item.domain.User;
import com.insurance.project.insuranceapp.item.resource.UserResource;
import com.insurance.project.insuranceapp.item.service.BasicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    private final BasicService basicService;

    @Autowired
    public UserController( BasicService basicService) {
        this.basicService = basicService;
    }


    @GetMapping("/")
    public String all(Model model) {
        model.addAttribute("users", basicService.findAllUsers());
        return "user/all";
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String addSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/add";
        }

        basicService.addUser(user);
        model.addAttribute("users", basicService.findAllUsers());
        return "user/all";
    }

    @GetMapping("/id/{id}")
    public String byId(@PathVariable long id, Model model) {
        Optional<User> userById = basicService.findUserById(id);
        if (userById.isPresent()) {
            User user = userById.get();
            model.addAttribute("users", basicService.findAllUsers());
            model.addAttribute("user", user);
            model.addAttribute("accidents", basicService.findAllAccidentInsurances());
            model.addAttribute("households", basicService.findAllHouseholdInsurances());
            model.addAttribute("houseAndApartments", basicService.findAllHouseAndApartmentInsurances());
            model.addAttribute("travels", basicService.findAllTravelInsurances());
        }
        return "user/one";
    }


    @GetMapping("/modify/{id}")
    public String modify(@PathVariable long id, Model model) {
        model.addAttribute("user", new UserResource(basicService.findAllUsers().get(id)));
        return "user/modify";
    }


    @PostMapping("/modify/{id}")
    public String submit(@PathVariable long id, @ModelAttribute @Valid UserResource userResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/user/modify/{id}";
        }
        basicService.findAllUsers().replace(id,userResource.toUser(id));
        return "redirect:/user/";
    }


}
