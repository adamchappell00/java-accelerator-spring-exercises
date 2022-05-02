package com.example.spring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {
    @RequestMapping(value="/echo/{numberToEcho}", method= RequestMethod.GET)
    public int echoInt(@PathVariable int numberToEcho) {
        System.out.println("Oh. You want to echo " + numberToEcho);
        return numberToEcho;
    }
}