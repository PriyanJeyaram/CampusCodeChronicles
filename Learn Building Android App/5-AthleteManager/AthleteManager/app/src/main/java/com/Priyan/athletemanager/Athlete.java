package com.Priyan.athletemanager;

public class Athlete {

    String name, game;
    int age, id;
    double height, weight;

    public Athlete(String name, String game, int age, int id, double height, double weight) {
        this.name = name;
        this.game = game;
        this.age = age;
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calcBMI(double height, double weight) {
//        Ht in meters
//        Wt in Kg
//        BMI = Wt/(Ht^2)
        return weight/(Math.pow(height,2));
    }
}
