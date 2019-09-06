package Items.Armes;

import Items.Item;

public class Scimitar extends Item {
    public Scimitar() {
        setNom("Scimitar");
        setValue(10);
        setEffet(getNom() + " vous donne " + getValue() + " attaque");
        setType(3);
    }}
