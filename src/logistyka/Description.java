package logistyka;

public class Description {
    private String name;
    private int age; //czy bawimy się w zmianę z czasem? w sensie że wpisuje datę i potem program liczy?
    private Region homeRegion;
    private Photo photo; // czy robimy więcej zdjęć? czy robimy ekran do zmiany zdjęcia?
    String bio; // W zwierzaku można jego te info szczególne, u ludzi wiadomo

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
    public void setHomeRegion(Region homeRegion) {
        this.homeRegion = homeRegion;
    }

}
