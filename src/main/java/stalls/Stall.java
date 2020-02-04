package stalls;

import people.Visitor;

public abstract class Stall {

    private String name;
    private String ownerName;
    private ParkingSpot parkingSpot;
    private int rating;

    public Stall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        this.name = name;
        this.ownerName = ownerName;
        this.parkingSpot = parkingSpot;
        this.rating = rating;
    }

    public String getName() {
        return this.name;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }

    public int getRating() { return this.rating; }

    public boolean isAllowedTo(Visitor visitor){
        return true;
    }
}
