package people;

import attractions.RollerCoaster;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {

    Visitor visitor;
    RollerCoaster rollerCoaster;

    @Before
    public void before(){
        visitor = new Visitor(14, 1.2, 40.0);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
    }

    @Test
    public void hasAge() {
        assertEquals(14, visitor.getAge());
    }

    @Test
    public void hasHeight() {
        assertEquals(1.2, visitor.getHeight(), 0.1);
    }

    @Test
    public void hasMoney() {
        assertEquals(40.0, visitor.getMoney(), 0.1);
    }
    @Test
    public void hasVisitedList(){
        assertEquals(0, visitor.getNumberOfVisitedAttractions());
    }
    @Test
    public void canAddVisit(){
        visitor.addVisit(rollerCoaster);
        assertEquals(1, visitor.getNumberOfVisitedAttractions());
    }
}