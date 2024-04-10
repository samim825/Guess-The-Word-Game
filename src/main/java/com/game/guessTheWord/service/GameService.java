package com.game.guessTheWord.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    public String randomlySelectedWord;
    public String[] randomWords = {"father", "mother", "sister", "hello", "world", "light", "java","html"};
    private Random random = new Random();
    private char[] allCharactersOfTheWord;

    public GameService(){
        randomlySelectedWord = randomWords[random.nextInt(randomWords.length)];
        System.out.println("Randomly selected word is : "+ randomlySelectedWord);
        allCharactersOfTheWord = new char[randomlySelectedWord.length()];
    }

    @Override
    public String toString() {

        String ret = "";
        for (char c: allCharactersOfTheWord) {
            if(c == '\u0000') {
                ret = ret + "_";
            }
            ret = ret + " ";
        }

        return ret;
    }
}
