package logistyka;

public class Pet extends Description {
    //age - zwierzaki mogą mieć wiek w miesiącach, trzeba to uwzględnić
    String breed;
    int activityScale; // out of 5

    public Pet(String name, int age, Region homeRegion, Photo photo, String bio, String breed, int activityScale) {
        super(name, age, homeRegion, photo, bio);
        this.breed = breed;
        this.activityScale = activityScale;
    }
}
