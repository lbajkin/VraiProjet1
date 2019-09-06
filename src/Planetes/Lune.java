package Planetes;

import Items.Autres.GoldCamo;
import Items.Autres.OmegaBooster;
import Items.Item;

public class Lune extends Planete{

    public Lune() {
        setNom("Lune");
        setLore("la lune. Ce n'est pas une planete mais bon, apres avoir vu des milliers d'hipsters prendre des selfies sur la lune, ca vous a toujours interesse de le voir avec vos yeux.");
        setDistance(4);
        setItem(new OmegaBooster());
    }
}
