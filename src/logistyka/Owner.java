package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class Owner {
    private Description ownerDescription;
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<Errand> listOfErrands = new ArrayList<>();
    private ArrayList<Pet> listOfPets = new ArrayList<>();
    private Photo photo;


    public Owner(Description ownerDescription_) {
        this.ownerDescription = ownerDescription_;

    }

    public Description getOwnerDescription() {
        return ownerDescription;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public ArrayList<Pet> getListOfPets() {
        return listOfPets;
    }

    public ArrayList<Errand> getListOfErrands() {
        return listOfErrands;
    }

    @Override
    public String toString() {
        return ownerDescription.getName();
    }
}
