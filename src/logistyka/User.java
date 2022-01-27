package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class User {
    protected Description description;
    protected ArrayList<Review> reviews = new ArrayList<>();
    protected ArrayList<Errand> listOfErrands = new ArrayList<>();
    //private Photo photo;
    protected int walletStatus = 0;

    public User(Description description,  int walletSatus) {
        this.description = description;
        this.reviews = new ArrayList<>();
        this.listOfErrands = new ArrayList<Errand>();
        this.walletStatus = walletSatus;
    }

    public int getWalletStatus() {
        return walletStatus;
    }
    public void setWalletStatus(int walletStatus) {
        this.walletStatus = walletStatus;
    }
    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description.getName();
    }

    public ArrayList<Errand> getListOfErrands() {
        return listOfErrands;
    }
}

