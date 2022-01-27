package logistyka.region_address;

public class Address {
    private double x = -1;
    private double y = -1;

    public Address(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Address address){
        return (Math.sqrt(Math.pow(address.getX() - this.x, 2) + Math.pow(address.getY() - this.y, 2)));
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

    @Override
    public String toString() {
        return x + "," + y;
    }
}
