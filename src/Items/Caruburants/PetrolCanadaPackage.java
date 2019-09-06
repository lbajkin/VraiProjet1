package Items.Caruburants;

import Items.Item;

public class PetrolCanadaPackage extends Item {

    public PetrolCanadaPackage() {
        setNom("Petrol Canada Package");
        setValue(500);
        setEffet(getNom() + " restaure " + getValue() + " carburant");
        setType(2);
    }
}
