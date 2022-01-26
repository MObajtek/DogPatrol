package logistyka.errand;

import logistyka.Pet;
import logistyka.region_address.Address;

public class Errand {
    Address address;
    int payment;
    int time;
    boolean active;  // 0(false) - archiwalne, 1(true) - aktywne
    Pet pet;

    public Errand(Address address, int payment, int time, boolean active, Pet pet) {
        this.address = address;
        this.payment = payment;
        this.time = time;
        this.active = active;
        this.pet = pet;
    }

    @Override
    public String toString() {
        return  active + "," + address + "," + payment + "," + time;
    }
}
