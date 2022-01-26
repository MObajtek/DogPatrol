package logistyka.errand;

import logistyka.Pet;
import logistyka.region_address.Address;

public class Errand {
    Address address;
    int payment;
    int time;
    boolean active;  // 0(false) - archiwalne, 1(true) - aktywne
    String petName;

    public Errand(Address address, int payment, int time, boolean active, String petName) {
        this.address = address;
        this.payment = payment;
        this.time = time;
        this.active = active;
        this.petName = petName;
    }

    @Override
    public String toString() {
        return address.toString() + ":" +
                payment + ":" +
                time + ":" +
                active + ":" +
                petName;
    }
}
