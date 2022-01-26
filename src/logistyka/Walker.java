package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class Walker {
    private Description walkerDescription;
    private ArrayList<Review> reviews;
    private ArrayList<Errand> listOfActiveErrands;
    private ArrayList<Errand> listOfArchivalErrands;
    private Photo photo;
    //private Schedule schedule;

    public Walker(Description walkerDescription_) {
        this.walkerDescription = walkerDescription_;
        this.reviews = new ArrayList<>();
        this.listOfActiveErrands = new ArrayList<Errand>();
        this.listOfArchivalErrands = new ArrayList<Errand>();
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public Description getWalkerDescription() {
        return walkerDescription;
    }

    @Override
    public String toString() {
        return walkerDescription.getName();
    }
}
