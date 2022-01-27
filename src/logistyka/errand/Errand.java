package logistyka.errand;

import logistyka.Pet;
import logistyka.region_address.Address;

import java.util.Random;

public class Errand {
    Integer errandID;
    Address address;
    int payment;
    int time;
    boolean active;  // 0(false) - archiwalne, 1(true) - aktywne
    String petName;

    public Errand(Address address, int payment, int time, boolean active, String petName) {
        this.errandID = new Random().nextInt(1_000_000);
        this.address = address;
        this.payment = payment;
        this.time = time;
        this.active = active;
        this.petName = petName;
    }

    @Override
    public String toString() {
        return errandID + ":" +
                address.toString() + ":" +
                payment + ":" +
                time + ":" +
                active + ":" +
                petName;
    }

    public boolean isActive() {
        return active;
    }
}
