package logistyka;
import logistyka.region_address.Address;
import logistyka.region_address.Region;

public class Main {

    public static void main(String[] args) {
        Photo photo = new Photo();
        Region ownerRegion = new Region(new Address(0,0),60);
        Region walkerRegion = new Region(new Address(10,0),40);
    Pet pet = new Pet("Buba",1,ownerRegion,photo,"Super zwierz 10/10","heterodontozaur",4);
    Owner owner = new Owner(new Description("Małgośka mówią mi",20,ownerRegion,photo,"Warta jednej łzy"), 100);
    Walker walker = new Walker(new Description("Chciałem mieć tatuaże", 21,walkerRegion,photo,"Chciałem mieć pełne sale"), 0);
    }
}
