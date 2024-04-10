package com.game.guessTheWord.controller;

import com.game.guessTheWord.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GameController {


    @Autowired
    private GameService gameService;

    @GetMapping("/game-home")
    public String showGameHomePage(Model model) {

        String randomWord = gameService.toString();
        model.addAttribute("randomWord", randomWord);
        return "game-home-page";
    }
}
