package logistyka.region_address;

public class Region {
    Address currentAddress;
    int radius = -1;

    public Region(Address currentAddress, int radius) {
        this.currentAddress = currentAddress;
        this.radius = radius;
    }

    public Region(Address currentAddress) {
        this.currentAddress = currentAddress;
        this.radius = 0;
    }

    public void setCurrentAddress(Address currentAddress) {
        this.currentAddress = currentAddress;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    public boolean inRegion(Address a){
        return (((Math.sqrt(Math.pow(a.getX() - currentAddress.getX(), 2) + Math.pow(a.getY() - currentAddress.getY(), 2))))<=radius);
    }
    public Address getCurrentAddress() {
        return currentAddress;
    }
    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return currentAddress +
                "," + radius;
    }
}
