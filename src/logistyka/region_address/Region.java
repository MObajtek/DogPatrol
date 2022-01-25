package logistyka.region_address;

public class Region {
    Address currentAddress;
    int radius;

    public Region(Address currentAddress, int radius) {
        this.currentAddress = currentAddress;
        this.radius = radius;
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
}