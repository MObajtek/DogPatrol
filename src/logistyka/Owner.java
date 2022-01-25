package logistyka;

import logistyka.errand.ErrandList;
import logistyka.review.ReviewList;

public class Owner {
    private Description ownerDescription;
    private ReviewList reviewsOfOwner;
    private ErrandList listOfActiveErrands;
    private ErrandList listOfArchivalErrands;
    private PetList listOfPets;


    public Owner(Description ownerDescription_) {
        this.ownerDescription = ownerDescription_;
        this.reviewsOfOwner = new ReviewList();
        this.listOfActiveErrands = new ErrandList();
        this.listOfArchivalErrands = new ErrandList();
        this.listOfPets = new PetList();

    }
}
