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


    public Owner(Description ownerDescription_) {
        this.ownerDescription = ownerDescription_;
        this.reviewsOfOwner = new ArrayList<>();
        this.listOfActiveErrands = new ErrandList();
        this.listOfArchivalErrands = new ErrandList();
        this.listOfPets = new PetList();

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
