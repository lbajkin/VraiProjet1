package Planetes;

import Items.Autres.GoldCamo;

public class FazeSpaceship extends Planete {

    public FazeSpaceship() {
        setNom("Faze Spaceship");
        setDistance(69);
        setItem(new GoldCamo());
        setLore("La maison de Faze Banks. C'est ici ou le monde perfectionne le legendaire quickscope.");
    }
}
