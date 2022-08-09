package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitorYoungShortAndPoor;
    Visitor visitorOldRichAndTall;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 5);
        visitorOldRichAndTall = new Visitor(20, 201, 10);
        visitorYoungShortAndPoor = new Visitor(10, 120, 4);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void canAdmitVisitorIfOldEnough(){
        assertEquals(true, tobaccoStall.isAllowedTo(visitorOldRichAndTall));
    }

    @Test
    public void cannotAdmitVisitorIfTooYoung(){
        assertEquals(false, tobaccoStall.isAllowedTo(visitorYoungShortAndPoor));
    }
}
