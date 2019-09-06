package Items.Armures;

import Items.Item;

public class CykaReflector extends Item{
    public CykaReflector() {
        setNom("Cyke Reflector");
        setValue(12);
        setEffet(getNom() + " vous donne " + getValue() + " defense");
        setType(4);
    }}
