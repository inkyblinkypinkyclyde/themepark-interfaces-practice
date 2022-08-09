import attractions.Dodgems;
import attractions.Park;
import attractions.Playground;
import attractions.RollerCoaster;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    RollerCoaster rollerCoaster;
    Playground playground;
    Park park;
    Dodgems dodgems;
    TobaccoStall tobaccoStall;
    IceCreamStall iceCreamStall;
    CandyflossStall candyflossStall;
    Visitor visitorTallandOld;
    Visitor visitorShortandOld;
    Visitor visitorTallandYoung;
    Visitor visitorShortandYoung;



    @Before
    public void beforeEach(){
        themePark = new ThemePark();
        visitorTallandOld = new Visitor(18, 201, 0);
        visitorShortandOld = new Visitor(18, 140, 0);
        visitorTallandYoung = new Visitor(10, 200, 0);
        visitorShortandYoung = new Visitor(10, 140, 0);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        playground = new Playground("Fun Zone", 7);
        park = new Park("Leafy Meadows", 9);
        dodgems = new Dodgems("Bumper Cars", 5);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 4);
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 8);

    }

    @Test
    public void themeParkStartsWithNoStallsOrAttractions(){
        assertEquals(0, themePark.getNumberOfStalls());
        assertEquals(0, themePark.getNumberOfAttractions());
    }

    @Test
    public void themParkStartsWithNoThings(){
        assertEquals(0, themePark.getNumberOfThings());
    }

    @Test
    public void canAddAttractions(){
        themePark.addAttraction(rollerCoaster);
        assertEquals(1, themePark.getNumberOfAttractions());
        assertEquals(1, themePark.getNumberOfThings());

    }

    @Test
    public void canAddStalls(){
        themePark.addStall(iceCreamStall);
        assertEquals(1, themePark.getNumberOfStalls());
        assertEquals(1, themePark.getNumberOfThings());
    }

    @Test
    public void canGetAllIReviewedThings(){
        ArrayList<IReviewed> newThings = new ArrayList<>();
        newThings.add(rollerCoaster);
        newThings.add(playground);
        newThings.add(park);
        themePark.addAttraction(rollerCoaster);
        themePark.addAttraction(playground);
        themePark.addAttraction(park);
        assertEquals(newThings, themePark.getAllReviewed());
    }

    @Test
    public void canRegisterVisitsVisitAllowed(){
        themePark.addAttraction(rollerCoaster);
        themePark.registerVisit(rollerCoaster, visitorTallandOld);
        assertEquals(1, rollerCoaster.getVisitCount());
        assertEquals(1, visitorTallandOld.getNumberOfVisitedAttractions());
    }

    @Test
    public void canRegisterVisitsVisitNotAllowed(){
        themePark.addAttraction(rollerCoaster);
        themePark.registerVisit(rollerCoaster, visitorShortandYoung);
        assertEquals(0, rollerCoaster.getVisitCount());
        assertEquals(0, visitorShortandYoung.getNumberOfVisitedAttractions());
    }
}
