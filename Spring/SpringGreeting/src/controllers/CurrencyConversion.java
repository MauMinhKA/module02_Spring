package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
@GetMapping("/money")
    public String money(){
     return "money";
}
@PostMapping("/money")
    public String convert(@RequestParam("usd") double usd,@RequestParam("rate") double rate,Model model){
    double vnd=rate*usd;
    model.addAttribute("vnd",vnd);
    return "money";


}

}
