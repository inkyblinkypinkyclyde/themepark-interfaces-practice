package people;

import behaviours.IReviewed;

import java.util.ArrayList;

public class Visitor {

    private int age;
    private double height;
    private double money;
    private ArrayList<IReviewed> visited;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
        this.visited = new ArrayList<IReviewed>();
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }
    public int getNumberOfVisitedAttractions(){
        return visited.size();
    }
    public void addVisit(IReviewed place){
        visited.add(place);
    }
}
