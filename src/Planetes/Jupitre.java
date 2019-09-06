package Planetes;

import Items.Caruburants.IrvingMegaBox;

public class Jupitre extends Planete{

    public Jupitre() {
        setNom("Jupiter");
        setDistance(142);
        setItem(new IrvingMegaBox());
        setLore("Jupiter. La plus grosse planete dans le system solaire! Cool :)");
    }
}
