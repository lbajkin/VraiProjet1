package Vaisseau;

public class Personnage { // base pour le vaisseau et les enemies

    private int HP;
    private int gas;
    private int atk;
    private int def;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public void attaquer(Personnage attaqeur, Personnage victime) {
        victime.setHP(victime.getHP() - (attaqeur.getAtk() - victime.getDef()));
        if (victime.getHP() < 0) {
            victime.setHP(0);
        }
        System.out.println(attaqeur.getNom() + " attaque pour faire " + (attaqeur.getAtk() - victime.getDef()) + " degats!");
        System.out.println(victime.getNom() + " a " + victime.getHP() + " HP!");
        if (victime.getHP() == 0) {
            System.out.println(victime.getNom() + " est mort!");
        }
        System.out.println("");
    }

}
