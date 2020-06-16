package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Sandwich {
    @GetMapping("/sandwich")
    public String sandwich() {
        return "Sandwich";
    }


    @PostMapping("/saveSandwich")
    public String saveSandwich(Model model,
                               @RequestParam(value = "condiment", required = false, defaultValue = "") String[] condiment) {
        model.addAttribute("condiment", condiment);
        return "Sandwich";
    }
}

