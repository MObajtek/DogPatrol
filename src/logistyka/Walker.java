package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class Walker {
    private Description walkerDescription;
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<Errand> listOfErrands = new ArrayList<>();
    private Photo photo;

    public int getWalletSatus() {
        return walletSatus;
    }

    public void setWalletSatus(int walletSatus) {
        this.walletSatus = walletSatus;
    }

    private int walletSatus = 0;
    //private Schedule schedule;


    public Walker(Description walkerDescription, ArrayList<Review> reviews, ArrayList<Errand> listOfErrands, int walletSatus) {
        this.walkerDescription = walkerDescription;
        this.reviews = reviews;
        this.listOfErrands = listOfErrands;
        this.walletSatus = walletSatus;
    }

    public Walker(Description walkerDescription_, int walletStatus_) {
        this.walkerDescription = walkerDescription_;
        this.reviews = new ArrayList<>();
        this.listOfErrands = new ArrayList<Errand>();
        this.walletSatus = walletStatus_;
    }

    public Walker(Description walkerDescription) {
        this.walkerDescription = walkerDescription;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public Description getDescription() {
        return walkerDescription;
    }

    @Override
    public String toString() {
        return walkerDescription.getName();
    }

    public ArrayList<Errand> getListOfErrands() {
        return listOfErrands;
    }
}
