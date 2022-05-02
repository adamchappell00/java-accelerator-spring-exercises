package com.example.spring.models;

public class Student {
    private String name;
    private double gradePointAverage;

    public Student(){}
    public Student(String name, double gradePointAverage){
        this.setName(name);
        this.gradePointAverage = gradePointAverage;
    }

    public double getGradePointAverage() {return gradePointAverage;}
    public void setGradePointAverage(double gradePointAverage) {this.gradePointAverage = gradePointAverage;}

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}