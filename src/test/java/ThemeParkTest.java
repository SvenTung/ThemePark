import attractions.*;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themepark;
    CandyflossStall candyflossStall;
    Dodgems dodgems;
    IceCreamStall iceCreamStall;
    Park park;
    Playground playground;
    RollerCoaster rollerCoaster;
    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;
    ArrayList<Stall> stalls;
    ArrayList<Attraction> attractions;
    ArrayList<IReviewed> reviews;


    @Before
    public void before(){
        themepark = new ThemePark();
        candyflossStall = new CandyflossStall("Candy Land", "Harry Belafonte", ParkingSpot.A1, 7);
        dodgems = new Dodgems("Bumper Cars", 5);
        iceCreamStall = new IceCreamStall("Dream Cones", "Vanilla Ice", ParkingSpot.A4, 8);
        park = new Park("Leafy Meadows", 9);
        playground = new Playground("Fun Zone", 7);
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1, 7);
        stalls = new ArrayList<>();
        attractions = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    @Test
    public void canAddAndGetStall(){
        themepark.addStall(tobaccoStall);
        stalls.add(tobaccoStall);
        assertEquals(stalls, themepark.getAllStalls());
    }

    @Test
    public void canAddAndGetAttraction(){
        themepark.addAttraction(playground);
        attractions.add(playground);
        assertEquals(attractions, themepark.getAllAttractions());
    }

    @Test
    public void canAddAndGetReviews(){
        themepark.addReview(rollerCoaster);
        reviews.add(rollerCoaster);
        assertEquals(reviews, themepark.getAllReviews());
    }

    @Test
    public void visitorCanVisit(){
        visitor1 = new Visitor(18, 1.72, 55);
        themepark.visit(visitor1, dodgems);
        attractions.add(dodgems);
        assertEquals(50.5, visitor1.getMoney(),0);
        assertEquals(attractions, visitor1.getVisitedAttractions());
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void canGetReviewHashMap(){
        themepark.addReview(iceCreamStall);
        assertEquals("{Dream Cones=8}", themepark.getReviewHashMap().toString());
    }

    @Test
    public void canGetAllAllowedFor(){
        visitor2 = new Visitor(11, 1.20, 40);
        themepark.addReview(tobaccoStall);
        themepark.addReview(candyflossStall);
        themepark.addReview(park);
        themepark.addReview(rollerCoaster);
        reviews.add(candyflossStall);
        reviews.add(park);
        assertEquals(reviews, themepark.getAllAllowedFor(visitor2));
    }
}
