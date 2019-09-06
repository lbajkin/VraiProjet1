package Items.Caruburants;

import Items.Item;

public class IrvingMegaBox extends Item {

    public IrvingMegaBox() {
        setNom("Irving Mega Box");
        setValue(1250);
        setEffet(getNom() + " restaure " + getValue() + " carburant");
        setType(2);
    }
}
