package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class Walker extends User{



    public Walker(Description walkerDescription, ArrayList<Review> reviews, ArrayList<Errand> listOfErrands, int walletSatus) {
        super(walkerDescription,walletSatus);
        this.reviews = reviews;
        this.listOfErrands = listOfErrands;

    }

    public Walker(Description walkerDescription_, int walletStatus_) {
        super(walkerDescription_,walletStatus_);
    }

    public Walker(Description walkerDescription) {
        super(walkerDescription,0);
    }

}
