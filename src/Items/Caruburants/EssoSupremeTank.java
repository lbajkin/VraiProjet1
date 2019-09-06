package Items.Caruburants;

import Items.Item;

public class EssoSupremeTank extends Item {

    public EssoSupremeTank() {
        setNom("Esso Supreme Tank");
        setValue(2500);
        setEffet(getNom() + " restaure " + getValue() + " carburant");
        setType(2);
    }
}
