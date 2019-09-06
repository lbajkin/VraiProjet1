package Planetes;

import Items.Caruburants.PetrolCanadaPackage;

public class Mars extends Planete{

    public Mars() {
        setNom("Mars");
        setLore("Mars. Il faut faire attention ici, le NASA-TANG clan reside sur cette planete.");
        setDistance(38);
        setItem(new PetrolCanadaPackage());

    }
}
