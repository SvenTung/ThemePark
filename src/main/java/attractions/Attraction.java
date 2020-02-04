package attractions;

import people.Visitor;

public abstract class Attraction {
    private String name;
    private int rating;
    private int visitCount;

    public Attraction(String name, int rating) {
        this.name = name;
        this.rating = rating;
        this.visitCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void addVisit(){
        this.visitCount += 1;
    }

    public boolean isAllowedTo(Visitor visitor){
        return true;
    }

    public double priceFor(Visitor visitor){
        return 0;
    }
}
