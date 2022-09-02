package bg.softuni.springmvc.web;

import bg.softuni.springmvc.model.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String newUser() {
        return "newuser";
    }

    @PostMapping
    public String createUser(UserDto userDto){
        System.out.println("Creating new user " + userDto);
        return "usercreated";
    }
}


