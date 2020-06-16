package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class dictionary {
    public static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("computer", "máy tính");
        dictionary.put("book", "quyển sách");
        dictionary.put("how", "thế nào");
    }

    @GetMapping("/dictionary")
    public String english() {
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public ModelAndView show(@RequestParam("word") String word){
        ModelAndView modelAndView=new ModelAndView("dictionary");
        String resultWords=dictionary.get(word);
        modelAndView.addObject("word",word);
        modelAndView.addObject("result",resultWords);
        return modelAndView;
    }

}

