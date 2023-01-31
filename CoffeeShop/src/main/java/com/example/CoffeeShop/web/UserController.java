package com.example.CoffeeShop.web;

import com.example.CoffeeShop.models.biding.UserLoginBidingModel;
import com.example.CoffeeShop.models.biding.UserRegisterBidingModel;
import com.example.CoffeeShop.models.service.UserServiceModel;
import com.example.CoffeeShop.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

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
        userService.registerUser(modelMapper
                .map(userRegisterBidingModel, UserServiceModel.class));

        return "redirect:login";
    }

    @GetMapping("login")
    public String login(Model model) {

        if (!model.containsAttribute("isFound")) {
            model.addAttribute("isFound", true);
        }
        return "/login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBidingModel userLoginBidingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBidingModel", userLoginBidingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginBidingModel",
                    bindingResult);
            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUsernameAndPassword(userLoginBidingModel.getUsername(),
                userLoginBidingModel.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginBidingModel", userLoginBidingModel);
            redirectAttributes.addFlashAttribute("isFound", false);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), userLoginBidingModel.getUsername());

        return "redirect:/";
    }

    @ModelAttribute
    public UserRegisterBidingModel userRegisterBidingModel() {
        return new UserRegisterBidingModel();
        //Same as to do an if(model.containsAttribute(bidingModel) statement in register() to check if there isn't added bidingModel earlier
    }

    @ModelAttribute
    public UserLoginBidingModel userLoginBidingModel() {
        return new UserLoginBidingModel();
    }
}
