package ru.nikolaenko.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/calc")
    public String calculate(@RequestParam("firstValue") int firstValue,
                            @RequestParam("secondValue") int secondValue,
                            @RequestParam("action") String action,
                            Model model) {

        double result;
        switch (action) {
            case "multiplication":
                result= firstValue*secondValue;
                break;
            case "addition":
                result = firstValue+secondValue;
                break;
            case "subtraction":
                result = firstValue-secondValue;
                break;
            case "division":
                result = firstValue/(double)secondValue;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("answer", "Answer " + action + ": " + result);

        return "calculator/calc";
    }
}
