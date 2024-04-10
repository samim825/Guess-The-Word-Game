package com.game.guessTheWord.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class GameService {

    public String[] randomWords = {"father", "mother", "sister", "hello", "world", "light", "java","html"};
    Random random = new Random();

    @Override
    public String toString() {
        return randomWords[random.nextInt(randomWords.length)];
    }
}
