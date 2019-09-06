package Items.Armes;

import Items.Item;

public class VodkaBottle extends Item{
    public VodkaBottle() {
        setNom("Vodka Bottle");
        setValue(35);
        setEffet(getNom() + " vous donne " + getValue() + " attaque");
        setType(3);
    }}
