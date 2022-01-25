package logistyka;

import logistyka.errand.ErrandList;
import logistyka.review.Review;

import java.util.ArrayList;

public class Walker {
    private Description walkerDescription;
    private ArrayList<Review> reviewsOfWalker;
    private ErrandList listOfActiveErrands;
    private ErrandList listOfArchivalErrands;
    //private Schedule schedule;

    public Walker(Description walkerDescription_) {
        this.walkerDescription = walkerDescription_;
        this.reviewsOfWalker = new ArrayList<>();
        this.listOfActiveErrands = new ErrandList();
        this.listOfArchivalErrands = new ErrandList();
    }

    public Description getWalkerDescription() {
        return walkerDescription;
    }

    @Override
    public String toString() {
        return walkerDescription.getName();
    }
}
