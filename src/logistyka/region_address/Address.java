package logistyka.region_address;

public class Address {
    private double x;
    private double y;

    public Address(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {

        return x;
    }
    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString(){
        return (String.valueOf(this.getX())+" "+String.valueOf(this.getY()));
    }
}
