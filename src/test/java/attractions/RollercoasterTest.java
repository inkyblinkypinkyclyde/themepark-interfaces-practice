package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitorTallandOld;
    Visitor visitorShortandOld;
    Visitor visitorTallandYoung;
    Visitor visitorShortandYoung;


    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitorTallandOld = new Visitor(18, 201, 0);
        visitorShortandOld = new Visitor(18, 140, 0);
        visitorTallandYoung = new Visitor(10, 200, 0);
        visitorShortandYoung = new Visitor(10, 140, 0);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canAdmitCorrectly(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitorTallandOld));
        assertEquals(false, rollerCoaster.isAllowedTo(visitorShortandOld));
        assertEquals(false, rollerCoaster.isAllowedTo(visitorTallandYoung));
        assertEquals(false, rollerCoaster.isAllowedTo(visitorShortandYoung));
    }

    @Test
    public void canGetCorrectPriceFor(){
        assertEquals(16.8, rollerCoaster.priceFor(visitorTallandOld), 0.01);
        assertEquals(8.4, rollerCoaster.priceFor(visitorShortandOld), 0.01);
    }
}
