package Planetes;

import Items.Caruburants.EssoSupremeTank;

public class Pluton extends Planete{

    public Pluton() {
        setNom("Pluton");
        setDistance(500);
        setItem(new EssoSupremeTank());
        setLore("Pluton. Je sais, je sais ce n'est pas une planete. En tout cas il fait moins froid ici qu'a Saguenay l'hiver dernier.");
    }
}
