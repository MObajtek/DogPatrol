package logistyka;

import logistyka.errand.ErrandList;
import logistyka.review.Review;

import java.util.ArrayList;
import java.util.HashMap;

public class Owner {
    private Description ownerDescription;
    private ArrayList<Review> reviewsOfOwner;
    private ErrandList listOfActiveErrands;
    private ErrandList listOfArchivalErrands;
    private PetList listOfPets;
    private int walletStatus;

    public void setWalletStatus(int walletStatus) {
        this.walletStatus = walletStatus;
    }

    public int getWalletStatus() {
        return walletStatus;
    }



    public Description getOwnerDescription() {
        return ownerDescription;
    }

    public ArrayList<Review> getReviewsOfOwner() {
        return reviewsOfOwner;
    }

    public ErrandList getListOfActiveErrands() {
        return listOfActiveErrands;
    }

    public ErrandList getListOfArchivalErrands() {
        return listOfArchivalErrands;
    }

    public PetList getListOfPets() {
        return listOfPets;
    }




    public Owner(Description ownerDescription_, int walletStatus_) {
        this.ownerDescription = ownerDescription_;
        this.reviewsOfOwner = new ArrayList<>();
        this.listOfActiveErrands = new ErrandList();
        this.listOfArchivalErrands = new ErrandList();
        this.listOfPets = new PetList();
        this.walletStatus = walletStatus_;
    }

    public HashMap<String, Object> toHashmap(){
        HashMap<String, Object> owner = new HashMap<>();
        owner.put("name",ownerDescription.getName());
        owner.put("age",ownerDescription.getAge());
        owner.put("address",ownerDescription.getHomeRegion().getCurrentAddress());
        owner.put("radius",ownerDescription.getHomeRegion().getRadius());
        owner.put("bio",ownerDescription.getBio());

        return owner;
    }

    @Override
    public String toString() {
        return ownerDescription.getName();
    }
}
