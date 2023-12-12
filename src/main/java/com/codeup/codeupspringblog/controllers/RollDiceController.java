package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String guessANumber() {
        return "roll-dice";
    }


    @GetMapping("/dice-result")
    public String userGuess(@RequestParam(name = "userGuess") int userGuess, Model model, Integer randomNumber) {
        randomNumber = (int)(Math.random() * 6) + 1;
        model.addAttribute("userGuess", userGuess);
        model.addAttribute(randomNumber);
        return "dice-result";
    }

}






