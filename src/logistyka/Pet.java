package logistyka;

import logistyka.region_address.Region;

public class Pet  {
    private Description description;
    private Photo photo;
    String breed;
    int activityScale; // out of 5

    public Pet(Description description, String breed, int activityScale) {
        this.description = description;
        this.breed = breed;
        this.activityScale = activityScale;
    }

    public Description getDescription() {
        return description;
    }

    public Photo getPhoto() {
        return photo;
    }

    public String getBreed() {
        return breed;
    }

    public int getActivityScale() {
        return activityScale;
    }
}
