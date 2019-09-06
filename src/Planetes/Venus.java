package Planetes;

import Items.HP.Dressing;

public class Venus extends Planete {

    public Venus() {
        setNom("Venus");
        setDistance(-34);
        setItem(new Dressing());
        setLore("Venus. Putain! Il fait chaud ici.");
    }
}
