package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class Owner {
    private Description description;
    private ArrayList<Review> reviews = new ArrayList<>();
    private ArrayList<Errand> listOfErrands = new ArrayList<>();
    private ArrayList<Pet> listOfPets = new ArrayList<>();
    private Photo photo;

    public Owner(Description description, ArrayList<Review> reviews, ArrayList<Errand> listOfErrands, ArrayList<Pet> listOfPets) {
        this.description = description;
        this.reviews = reviews;
        this.listOfErrands = listOfErrands;
        this.listOfPets = listOfPets;
    }

    public Owner(Description ownerDescription_) {
        this.description = ownerDescription_;

    }

    public Description getDescription() {
        return description;
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
        return "Owner{" +
                "description=" + description +
                ", reviews=" + reviews +
                ", listOfErrands=" + listOfErrands +
                ", listOfPets=" + listOfPets +
                '}';
    }
}
