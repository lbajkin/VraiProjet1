package Planetes;

import Items.Autres.FidgetSpinner;

public class Saturne extends Planete {

    public Saturne() {
        setNom("Saturne");
        setDistance(244);
        setItem(new FidgetSpinner());
        setLore("Saturne. Vous trouvez un fidget spinner flotant dans l'atmosphere, quelle chance!");
    }
}
