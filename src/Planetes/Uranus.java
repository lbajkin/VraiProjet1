package Planetes;

import Items.HP.Sauce;

public class Uranus extends Planete{

    public Uranus() {
        setNom("Uranus");
        setDistance(397);
        setItem(new Sauce());
        setLore("Uranus. Ah, c'est degoutant.");
    }
}
