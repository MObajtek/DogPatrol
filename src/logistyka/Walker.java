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
    private int walletStatus;

    public void setWalletStatus(int walletStatus) {
        this.walletStatus = walletStatus;
    }

    public int getWalletStatus() {
        return walletStatus;
    }
    public ArrayList<Review> getReviewsOfWalker() {
        return reviewsOfWalker;
    }

    public ErrandList getListOfActiveErrands() {
        return listOfActiveErrands;
    }

    public ErrandList getListOfArchivalErrands() {
        return listOfArchivalErrands;
    }



    public Walker(Description walkerDescription_, int walletStatus_) {
        this.walkerDescription = walkerDescription_;
        this.reviewsOfWalker = new ArrayList<>();
        this.listOfActiveErrands = new ErrandList();
        this.listOfArchivalErrands = new ErrandList();
        this.walletStatus = walletStatus_;
    }

    public Description getWalkerDescription() {
        return walkerDescription;
    }

    @Override
    public String toString() {
        return walkerDescription.getName();
    }
}
