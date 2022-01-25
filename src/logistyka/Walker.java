package logistyka;

import logistyka.errand.ErrandList;
import logistyka.review.ReviewList;

public class Walker {
    private Description walkerDescription;
    private ReviewList reviewsOfWalker;
    private ErrandList listOfActiveErrands;
    private ErrandList listOfArchivalErrands;
    //private Schedule schedule;

    public Walker(Description walkerDescription_) {
        this.walkerDescription = walkerDescription_;
        this.reviewsOfWalker = new ReviewList();
        this.listOfActiveErrands = new ErrandList();
        this.listOfArchivalErrands = new ErrandList();
    }

    public Description getWalkerDescription() {
        return walkerDescription;
    }


}
