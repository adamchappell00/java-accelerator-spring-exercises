package com.example.spring.models;

import java.util.Objects;

public class TVShow {

  //  TV shows have the following properties:
    private int id;
    private String name;
    private int year;
    private double averageReview;
    private String service;

    // Static Var for ID
    private static int count = 1;

    public TVShow(){
        this.id= count++;
    }

    public TVShow(String name, int year, double averageReview, String service) {
        this.id= count;
        count++;
        this.name = name;
        this.year = year;
        this.averageReview = averageReview;
        this.service = service;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAverageReview() {
        return averageReview;
    }

    public void setAverageReview(double averageReview) {
        this.averageReview = averageReview;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVShow tvShow = (TVShow) o;
        return year == tvShow.year && Double.compare(tvShow.averageReview, averageReview) == 0 && Objects.equals(name, tvShow.name) && Objects.equals(service, tvShow.service);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, averageReview, service);
    }

    @Override
    public String toString() {
        return "TVShow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", averageReview=" + averageReview +
                ", service='" + service + '\'' +
                '}';
    }
}
