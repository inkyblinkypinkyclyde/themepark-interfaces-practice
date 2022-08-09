import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private ArrayList<IReviewed> things;
    private HashMap<IReviewed, String> reviews;

    public ThemePark(){
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
        this.things = new ArrayList<>();
        this.reviews = new HashMap<>();
    }

    public int getNumberOfStalls(){
        return stalls.size();
    }

    public int getNumberOfAttractions(){
        return attractions.size();
    }

    public int getNumberOfThings(){
        return things.size();
    }

    public void addStall(Stall stall){
        stalls.add(stall);
        things.add(stall);
    }
    public void addAttraction(Attraction attraction){
        attractions.add(attraction);
        things.add(attraction);
    }

    public ArrayList<IReviewed> getAllReviewed(){
        return things;
    }

    public void registerVisit(Attraction attraction, Visitor visitor){
        if (attraction instanceof  ISecurity){
            if (((ISecurity) attraction).isAllowedTo(visitor)){
                attraction.addVisitor();
                visitor.addVisit(attraction);
            }
        } else {
            attraction.addVisitor();
            visitor.addVisit(attraction);
        }
    }
}
