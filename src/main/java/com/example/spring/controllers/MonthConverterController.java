package com.example.spring.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

// With Joe and Alonzo 4 May 22
@RestController
public class MonthConverterController {

    @RequestMapping(value="/month/{monthNumber}", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getMonth(@PathVariable int monthNumber) {

        switch (monthNumber) {
            case 1 : return "January";
            case 2 : return "February";
            case 3 : return "March";
            case 4 : return "April";
            case 5 : return "May";
            case 6 : return "June";
            case 7 : return "July";
            case 8 : return "August";
            case 9 : return "September";
            case 10 : return "October";
            case 11 : return "November";
            case 12 : return "December";
            default : throw new IllegalArgumentException("Must be a integer between 1 and 12");
        }
    }
}