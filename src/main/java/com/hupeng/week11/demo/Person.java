package com.hupeng.week11.demo;

public class Person {
    private String name;
    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Person(String name, Dog dog) {
        this.name = name;
        this.dog = dog;
    }
    public Person(){

    }
}
