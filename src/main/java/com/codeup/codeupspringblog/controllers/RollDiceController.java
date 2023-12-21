package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/roll-dice")
public class RollDiceController {

    @GetMapping({"", "/"})
    public String guessANumber() {
        return "/roll-dice";
    }


    @GetMapping("/{n}")
    public String userGuess(@PathVariable int n, Model model) {
        int diceRoll = (int) (Math.random() * 6) + 1;
        model.addAttribute("n", n);
        model.addAttribute("diceRoll", diceRoll);

        return "/n";
    }

}






