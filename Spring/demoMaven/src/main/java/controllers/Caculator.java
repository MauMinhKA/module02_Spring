package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.plugin2.message.Message;

@Controller
public class Caculator {
    @GetMapping("/caculator")
    public String caculate() {
        return "caculator";
    }

    @PostMapping("/caculator")
    public String Cong(Model model,
                       @RequestParam("first_Operand") float first_Operand,
                       @RequestParam("secondOperand") float secondOperand, @RequestParam String tinhtoan
    ) {
        String result;
        switch (tinhtoan){
            case "cong":
                result= String.valueOf(first_Operand + secondOperand);
                break;
            case "tru":
                result= String.valueOf(first_Operand - secondOperand);
                break;
            case "nhan":
                result= String.valueOf(first_Operand * secondOperand);
                break;
            case "chia":
                if (secondOperand!=0){
                    result= String.valueOf(first_Operand/secondOperand);
                }else {
                    result= "khong the chia cho 0";
                }
              break;
            default:
                throw new RuntimeException("Invalid operation");
        }

        model.addAttribute("result", result);
        return "caculator";

    }

}
