package com.example.spring.controllers;

import com.example.spring.models.webservice.Answer;
import com.example.spring.models.webservice.Quote;
import com.example.spring.models.webservice.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class WebServiceController {


    private List<Quote> quotesOfTheDay;
    private List<Word> wordsOfTheDay;
    private List<Answer> answerList;
    private List<String> answerStrings;
    private int serial;

    public WebServiceController(){
        quotesOfTheDay = new ArrayList<>();
        wordsOfTheDay = new ArrayList<>();
        answerList = new ArrayList<>();
        answerStrings = new ArrayList<>();
        serial = 0;
        quotesOfTheDay.add(new Quote(0, "All good things are wild and free.", "Henry David Thoreau"));
        quotesOfTheDay.add(new Quote(1, "You miss 100% of the tacos you dont eat.", "Adam Chappell"));
        quotesOfTheDay.add(new Quote(2, "That is not dead which can eternal lie,\n" +
                "And with strange aeons even death may die.", "HP Lovecraft"));
        quotesOfTheDay.add(new Quote(3, "I know.", "Han Solo"));
        quotesOfTheDay.add(new Quote(4, "Third time is a charm", "Someone"));
        quotesOfTheDay.add(new Quote(5, "I am become death, destroyer of world", "Jay R. Oppenheimer"));
        quotesOfTheDay.add(new Quote(6, "Yippy Ki Yay MotherFu****", "John McClain"));
        quotesOfTheDay.add(new Quote(7, "No Cable! That sucks!", "Any Air Force Personnel"));
        quotesOfTheDay.add(new Quote(8, "I'm really sick of this string of bad military quotes", "Adam"));
        quotesOfTheDay.add(new Quote(9, "If at first you don't succeed, try a bigger hammer.", "Adam"));

        wordsOfTheDay.add(new Word(10, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(1, "Marine", "A person the ability to fail at finding a word he knows."));
        wordsOfTheDay.add(new Word(2, "Abeyance", "A state of temporary inactivity, commonly preceded by the preposition in."));
        wordsOfTheDay.add(new Word(3, "Bird", "It's the word."));
        wordsOfTheDay.add(new Word(4, "Schmooze", "Ask Alonzo."));
        wordsOfTheDay.add(new Word(5, "Banal", "so lacking in originality as to be obvious and boring.."));
        wordsOfTheDay.add(new Word(6, "Taco", "A major source of joy in the world, contained in tortilla."));
        wordsOfTheDay.add(new Word(7, "Nefarious", "Evil, flagrantly wicked."));
        wordsOfTheDay.add(new Word(8, "Flummox", "to confuse."));
        wordsOfTheDay.add(new Word(9, "Nihilism", "the rejection of all religious and moral principles, in the belief that life is meaningless."));

        answerStrings.add("It is Certain");
        answerStrings.add("Most Likely");
        answerStrings.add("Yes");
        answerStrings.add("You may rely on it");
        answerStrings.add("Ask again later");
        answerStrings.add("Cannot Predict Now");
        answerStrings.add("Reply hazy, try again");
        answerStrings.add("Don't count on it");
        answerStrings.add("My sources say no");
        answerStrings.add("Very Doubtful");
    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Quote getQuoteOfTheDay(){
        int random = (int) ((Math.random() * quotesOfTheDay.size()));
        return quotesOfTheDay.get(random);
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    private Word getWordOfTheDay(){
       /* int random = (int) ((Math.random() * wordsOfTheDay.size()));
        return wordsOfTheDay.get(random);*/
        Collections.shuffle(wordsOfTheDay);
        return wordsOfTheDay.get(0);
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    private Answer getMagicResponse(@RequestBody Answer answer){
        answer.setId(serial++);
        int random = (int) ((Math.random() * 10));
        answer.setAnswer(answerStrings.get(random));
       // answerList.add(answer); // YAGNI-fication
        return answer;
    }
}