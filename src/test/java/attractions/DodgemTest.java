package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class DodgemTest {

    Dodgems dodgems;
    Visitor visitorTallandOld;
    Visitor visitorShortandOld;
    Visitor visitorTallandYoung;
    Visitor visitorShortandYoung;

    @Before
    public void setUp() throws Exception {
        dodgems = new Dodgems("Bumper Cars", 5);
        visitorTallandOld = new Visitor(18, 201, 0);
        visitorShortandOld = new Visitor(18, 140, 0);
        visitorTallandYoung = new Visitor(10, 200, 0);
        visitorShortandYoung = new Visitor(10, 140, 0);
    }


    @Test
    public void hasName() {
        assertEquals("Bumper Cars", dodgems.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(5, dodgems.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, dodgems.getVisitCount());
    }

    @Test
    public void canGetCorrectPrice(){
        assertEquals(2.25, dodgems.priceFor(visitorTallandYoung), 0.01);
        assertEquals(4.5, dodgems.priceFor(visitorTallandOld), 0.01);
    }

    @Test
    public void canIncrememntVisitorCount(){
        dodgems.addVisitor();
        assertEquals(1, dodgems.getVisitCount());
    }
}
