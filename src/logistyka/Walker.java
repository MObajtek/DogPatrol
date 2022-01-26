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
    private int walletSatus;
    //private Schedule schedule;

    public Walker(Description walkerDescription_, int walletStatus_) {
        this.walkerDescription = walkerDescription_;
        this.reviews = new ArrayList<>();
        this.listOfActiveErrands = new ArrayList<Errand>();
        this.listOfArchivalErrands = new ArrayList<Errand>();
        this.walletSatus = walletStatus_;
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
