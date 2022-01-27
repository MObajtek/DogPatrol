package logistyka;

import logistyka.errand.Errand;
import logistyka.review.Review;

import java.util.ArrayList;

public class Owner extends User{


    private ArrayList<Pet> listOfPets;

    public ArrayList<Pet> getListOfPets() {
        return listOfPets;
    }

    public Owner(Description description, ArrayList<Review> reviews, ArrayList<Errand> listOfErrands, ArrayList<Pet> listOfPets, int walletStatus_) {
        super(description,walletStatus_);
        this.reviews = reviews;
        this.listOfErrands = listOfErrands;
        this.listOfPets = listOfPets;

    }

    public Owner(Description ownerDescription_, int walletStatus_) {
        super(ownerDescription_,walletStatus_);

    }

    public Owner(Description description){
        super(description,0);
    }

}
