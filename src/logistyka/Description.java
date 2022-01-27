package logistyka;

import logistyka.region_address.Region;

public class Description {
    private String name = "";
    private Integer age = -1; //czy bawimy się w zmianę z czasem? w sensie że wpisuje datę i potem program liczy?
    private Region homeRegion;
    private String bio = ""; // W zwierzaku można jego te info szczególne, u ludzi wiadomo

    public Description(String name, int age, Region homeRegion, String bio) {
        this.name = name;
        this.age = age;
        this.homeRegion = homeRegion;
        this.bio = bio;
    }



    public Description() {
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Description{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", homeRegion=" + homeRegion +
                ", bio='" + bio + '\'' +
                '}';
    }
}
