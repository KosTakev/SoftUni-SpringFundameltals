package com.example.CoffeeShop.web;

import com.example.CoffeeShop.models.biding.UserRegisterBidingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBidingModel userRegisterBidingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() ||
        !userRegisterBidingModel.getPassword().equals(userRegisterBidingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBidingModel", userRegisterBidingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterBidingModel", bindingResult);

            return "redirect:register";
        }
        //TODO: save in db!

        return "redirect:login";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @ModelAttribute
    public UserRegisterBidingModel userRegisterBidingModel() {
        return new UserRegisterBidingModel();
        //Same as to do an if(model.containsAttribute(bidingModel) statement in register() to check if there isn't added bidingModel earlier
    }
}
