package behaviours;

import people.Visitor;

public interface IReviewed {

    int getRating();

    String getName();

    boolean isAllowedTo(Visitor visitor);
}
