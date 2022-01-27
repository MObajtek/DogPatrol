package logistyka.errand;

import logistyka.region_address.Address;

import java.util.Random;

public class Errand {
    Integer errandID;
    Address address;
    int payment;
    int time;
    boolean active;  // 0(false) - archiwalne, 1(true) - aktywne
    String petName;

    public Errand(Errand errand){
        this.errandID = errand.errandID;
        this.address = errand.address;
        this.payment = errand.payment;
        this.time = errand.time;
        this.active = errand.active;
        this.petName = errand.petName;
    }

    public Errand(){
        this.errandID = new Random().nextInt(1_000_000);
        this.address = new Address(0d,0d);
        this.payment = 0;
        this.time = 0;
        this.active = false;
        this.petName = "";
    }

    public Errand(Address address, int payment, int time, boolean active, String petName) {
        this.errandID = new Random().nextInt(1_000_000);
        this.address = address;
        this.payment = payment;
        this.time = time;
        this.active = active;
        this.petName = petName;
    }

    public Errand(Integer errandID, Address address, int payment, int time, boolean active, String petName) {
        this.errandID = errandID;
        this.address = address;
        this.payment = payment;
        this.time = time;
        this.active = active;
        this.petName = petName;
    }

    public String toStringForSaveLoad() {
        return errandID + ":" +
                address.toString() + ":" +
                payment + ":" +
                time + ":" +
                active + ":" +
                petName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getErrandID() {
        return errandID;
    }

    public Address getAddress() {
        return address;
    }

    public int getPayment() {
        return payment;
    }

    public int getTime() {
        return time;
    }

    public String getPetName() {
        return petName;
    }

    @Override
    public String toString() {
        return petName + ", " + address;
    }

    public boolean isActive() {
        return active;
    }
}
