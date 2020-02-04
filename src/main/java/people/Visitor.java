package people;

import attractions.Attraction;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private ArrayList<Attraction> visitedAttractions;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visitedAttractions = new ArrayList<>();
    }

    public int getAge() {
        return this.age;
    }

    public double getHeight() {
        return this.height;
    }

    public double getMoney() {
        return this.money;
    }

    public void pay(double price) { this.money -= price; }

    public void visitAttraction(Attraction attraction){
        this.visitedAttractions.add(attraction);
    }

    public ArrayList<Attraction> getVisitedAttractions() {
        return visitedAttractions;
    }


}
