package Items.Armes;

import Items.Item;

public class KimJongGigaBlaster extends Item {
    public KimJongGigaBlaster() {
        setNom("Kim Jong Giga Blaster");
        setValue(20);
        setEffet(getNom() + " vous donne " + getValue() + " attaque");
        setType(3);
    }
}
