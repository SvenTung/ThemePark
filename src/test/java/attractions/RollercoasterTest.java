package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(13, 146, 20);
        visitor2 = new Visitor(12, 145, 20);
        visitor3 = new Visitor(18, 201, 40);
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
    public void canRide() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void cannotRide() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void canGetPrice() {
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0);
    }

    @Test
    public void normalPriceForVisitor(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor1), 0);
    }

    @Test
    public void doublePriceForVisitor(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor3), 0);
    }
}
