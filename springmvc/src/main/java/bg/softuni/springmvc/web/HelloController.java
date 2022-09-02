package bg.softuni.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

//    Mapping with Model:
//    @GetMapping("/hello")
//    public String hello(Model model) {
//        model.addAttribute("num",3);
//        return "helloWorld";
//    }

    //Mapping with ModelMap:
//    @GetMapping("/hello")
//    public String hello(ModelMap model) {
//        model.put("num",3);
//        return "helloWorld";
//    }

    @GetMapping("/hello")
    public String hello(ModelAndView modelAndView) {
        modelAndView.addObject("num", 3);
        modelAndView.setViewName("helloWorld");
        return modelAndView;
    }

}
