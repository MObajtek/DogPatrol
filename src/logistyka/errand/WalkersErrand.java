package logistyka.errand;

import logistyka.Walker;
import logistyka.errand.Errand;

import java.util.Random;

public class WalkersErrand extends Errand {
    Walker walker;


    @Override
    public String toString() {
        return String.valueOf(this.address.distance(walker.getDescription().getHomeRegion().getCurrentAddress())).replaceAll("\\..*","") +
                " od ciebie, " +
                this.petName +
                ", " +
                String.valueOf(this.payment) +
                "zł";
    }

    public WalkersErrand(Errand errand, Walker walker){
        this.errandID = errand.errandID;
        this.address = errand.address;
        this.payment = errand.payment;
        this.time = errand.time;
        this.active = errand.active;
        this.petName = errand.petName;
        this.walker = walker;
    }
}
