package logistyka;
import logistyka.errand.Errand;
import logistyka.region_address.Address;
import logistyka.region_address.Region;
import logistyka.review.Review;
import logistyka.save_load.Save;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Photo photo = new Photo();
        Region ownerRegion = new Region(new Address(0,0),60);
        Region walkerRegion = new Region(new Address(10,0),40);
        Pet pet1 = new Pet(new Description("Buba", 4, ownerRegion, photo,"Dobry dinozałr"),"Heterodontozaur",3);
        Pet pet2 = new Pet(new Description("Dziuba", 2, ownerRegion, photo,"Dobry dinozałr"),"Kanarek",5);
        Owner owner = new Owner(new Description("Małgośka mówią mi",20,ownerRegion,photo,"Warta jednej łzy"));
//        Walker walker = new Walker(new Description("Chciałem mieć tatuaże", 21,walkerRegion,photo,"Chciałem mieć pełne sale"));
        owner.getListOfPets().add(pet1);
        owner.getListOfPets().add(pet2);

        owner.getListOfErrands().add(new Errand(new Address(100d,200d),200,3,true,pet2));
        owner.getListOfErrands().add(new Errand(new Address(100d,200d),30,10,false,pet1));

        owner.getReviews().add(new Review(5,"Fajny Gość"));
        owner.getReviews().add(new Review(5,"Spoko sie robilo biznes"));
        owner.getReviews().add(new Review(3,"Spoznil sie"));

        Save.saveOwner(owner);


    }
}
