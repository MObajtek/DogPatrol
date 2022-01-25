package logistyka;

import logistyka.region_address.Region;

public class Description {
    private String name;
    private int age; //czy bawimy się w zmianę z czasem? w sensie że wpisuje datę i potem program liczy?
    private Region homeRegion;
    private Photo photo; // czy robimy więcej zdjęć? czy robimy ekran do zmiany zdjęcia?
    private String bio; // W zwierzaku można jego te info szczególne, u ludzi wiadomo

    public Description(String name, int age, Region homeRegion, Photo photo, String bio) {
        this.name = name;
        this.age = age;
        this.homeRegion = homeRegion;
        this.photo = photo;
        this.bio = bio;
    }

    public Photo getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Region getHomeRegion() {
        return homeRegion;
    }
    public String getBio() {
        return bio;
    }
    public void setHomeRegion(Region homeRegion) {
        this.homeRegion = homeRegion;
    }

}
