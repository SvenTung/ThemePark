import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {
    private ArrayList<Stall> stalls;
    private ArrayList<Attraction> attractions;
    private ArrayList<IReviewed> reviews;

    public ThemePark(){
        this.stalls = new ArrayList<>();
        this.attractions = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void addStall(Stall stall) {
        this.stalls.add(stall);
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public void addReview(IReviewed reviewed) {
        this.reviews.add(reviewed);
    }

    public ArrayList<Stall> getAllStalls() {
        return this.stalls;
    }

    public ArrayList<Attraction> getAllAttractions() {
        return this.attractions;
    }

    public ArrayList<IReviewed> getAllReviews() {
        return this.reviews;
    }

    public void visit(Visitor visitor, Attraction attraction){
        if (visitor.getMoney() > attraction.priceFor(visitor)){
            visitor.pay(attraction.priceFor(visitor));
            visitor.visitAttraction(attraction);
            attraction.addVisit();
        }

    }

    public HashMap getReviewHashMap(){
        HashMap reviewHashMap = new HashMap();
        for (IReviewed review: this.reviews){
            reviewHashMap.put(review.getName(), review.getRating());
        }
        return reviewHashMap;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor){
        ArrayList<IReviewed> allowedStallsAndAttractions = new ArrayList<>();
        for (IReviewed review: this.reviews){
            if (review.isAllowedTo(visitor)) {
                allowedStallsAndAttractions.add(review);
            }
        }
        return allowedStallsAndAttractions;
    }

}
