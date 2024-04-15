package com.game.guessTheWord.controller;

import com.game.guessTheWord.service.GameService;
import com.game.guessTheWord.utils.GameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {


    @Autowired
    private GameService gameService;
    @Autowired
    private GameUtils gameUtils;

    @GetMapping("/game-home")
    public String showGameHomePage(Model model, @RequestParam(value = "guessedChar", required = false) String guessedChar) {

        System.out.println("The guessed character is : "+guessedChar);
        String randomWord = gameService.toString();

        if(guessedChar != null) {
            System.out.println("Fetch 0th character from the guessed character : "+guessedChar.charAt(0));
            boolean isGuessCorrect = gameService.addGuessedChar(guessedChar.charAt(0));
            randomWord = gameService.toString();
            if (!isGuessCorrect) {
                gameUtils.reduceTry();
            }
        }
        model.addAttribute("randomWord", randomWord);
        model.addAttribute("remainingTimes", gameUtils.getTriesRemaining());

        return "game-home-page";
    }
}
