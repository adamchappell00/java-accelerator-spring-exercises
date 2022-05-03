package com.example.spring.controllers;

import com.example.spring.models.TVShow;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TVShowController {

    //  The TV shows API will handle CRUD of TV shows (get all, get by id, create, delete, update)

    private List<TVShow> theTVList;

    public TVShowController() {
        theTVList = new ArrayList<>();
        theTVList.add(new TVShow("Peaky Blinders", 2020, 4.7, "Netflix"));
        theTVList.add(new TVShow("Breaking Bad", 2008, 4.5, "AMC"));
        theTVList.add(new TVShow("The Sopranos", 1999, 4.1, "HBO"));
        theTVList.add(new TVShow("Peppa Pig", 2002, 5.0, "Nick Jr."));
    }

    @RequestMapping(value= "/shows", method = RequestMethod.GET )
    @ResponseStatus(HttpStatus.OK)
    public List<TVShow> showsIndex(){
        return theTVList;
    }

    @RequestMapping(value="/shows", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TVShow createShow(@RequestBody TVShow newShow){
        theTVList.add(newShow);
        return newShow;
    }

    @RequestMapping(value = "/shows/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TVShow showOneShow(@PathVariable int id){
        return theTVList.get(id - 1);
    }

    @RequestMapping(value = "/shows/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteShow(@PathVariable int id){
        for (int i = 0; i < theTVList.size(); i++) {
            if (theTVList.get(i).getId() == id) {
                theTVList.remove(i);
                return;
            }
        }
    }

    @RequestMapping(value="/shows/{id}", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public TVShow updateShow(@PathVariable int id, @RequestBody TVShow show) {
        for (int i = 0; i < theTVList.size(); i++) {
            if (theTVList.get(i).getId() == id) {
                show.setId(id);
                theTVList.set(i, show);
                return theTVList.get(i);
            }
        }
        return null;
    }
}
