package com.example.spring.controllers;

import com.example.spring.models.webservice.Answer;
import com.example.spring.models.webservice.Quote;
import com.example.spring.models.webservice.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        quotesOfTheDay.add(new Quote(2, "Quote 2", "Alonzo"));
        quotesOfTheDay.add(new Quote(3, "Yup that's a quote.", "Joe"));
        quotesOfTheDay.add(new Quote(4, "Third time is a charm", "Someone"));
        quotesOfTheDay.add(new Quote(5, "Uhhhhh", "Alonzo"));
        quotesOfTheDay.add(new Quote(6, "We did the thing", "Us"));
        quotesOfTheDay.add(new Quote(7, "No Cable! That sucks!", "Any Air Force Personell"));
        quotesOfTheDay.add(new Quote(8, "I'm really sick of this string of bad military quotes", "Adam"));
        quotesOfTheDay.add(new Quote(9, "Ugh my tank is broke.", "Some Private"));

        wordsOfTheDay.add(new Word(10, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(1, "Marine", "A person the ability to fail at finding a word he knows."));
        wordsOfTheDay.add(new Word(2, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(3, "Bird", "It's the word."));
        wordsOfTheDay.add(new Word(4, "Schmooze", "Ask Alonzo."));
        wordsOfTheDay.add(new Word(5, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(6, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(7, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(8, "Bro", "A person with whom one shares a brotherly relationship."));
        wordsOfTheDay.add(new Word(9, "Bro", "A person with whom one shares a brotherly relationship."));

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
        int random = (int) ((Math.random() * wordsOfTheDay.size()));
        return wordsOfTheDay.get(random);
    }

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    private Answer getMagicResponse(@RequestBody Answer answer){
        answer.setId(serial++);
        int random = (int) ((Math.random() * 10));
        answer.setAnswer(answerStrings.get(random));
        answerList.add(answer);
        return answer;
    }
}