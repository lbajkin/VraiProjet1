package Vaisseau;

import Items.Armes.KimJongGigaBlaster;
import Items.Armes.Scimitar;
import Items.Armes.VodkaBottle;
import Items.Armures.CykaReflector;
import Items.Armures.FailedNuclearExperiment;
import Items.Item;
import Planetes.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Vaisseau extends Personnage {

    private boolean boost = false;
    private Planete[] listePlanetes = new Planete[9];
    private Stack<Planete> planetesVisitees = new Stack<>();
    private int exploreCount;
    private int oldRng;
    private ArrayList<Item> items = new ArrayList<>();


    public Vaisseau() {
        setHP(100);
        setGas(999);
        setAtk(25);
        setDef(0);
        getListePlanetes()[0] = new Mercure();
        getListePlanetes()[1] = new Venus();
        getListePlanetes()[2] = new Lune();
        getListePlanetes()[3] = new Mars();
        getListePlanetes()[4] = new FazeSpaceship();
        getListePlanetes()[5] = new Jupitre();
        getListePlanetes()[6] = new Saturne();
        getListePlanetes()[7] = new Uranus();
        getListePlanetes()[8] = new Pluton();
    }

    public void start(Vaisseau vaisseau) {
        getPlanetesVisitees().push(new Terre());
        System.out.println("Bienvenue a space explorers.");
        System.out.println("");
        System.out.println("Veuillez nommez votre vaisseau: ");
        Scanner sc = new Scanner(System.in);
        String nom = sc.next();
        vaisseau.setNom(nom);
        System.out.println("Le " + vaisseau.getNom() + " commence son voyage...");
    }

    public void etat(Vaisseau vaisseau) {
        System.out.println("Etat du " + getNom());
        System.out.println("");
        System.out.println("Planete : " + getPlanetesVisitees().peek().getNom());
        System.out.println("Carburant : " + getGas());
        System.out.println("HP : " + getHP());
        System.out.println("Attaque : " + getAtk());
        System.out.println("Defense : " + getDef());
        System.out.print("Items : ");
        for (int i=0;i<getItems().size();i++) {
            System.out.print(getItems().get(i).getNom() + ", ");
        }
    }

    public void explorer(Vaisseau vaisseau) {
        setExploreCount(getExploreCount()+1);
        int x0 = getPlanetesVisitees().peek().getDistance();
        int x1;

        int rng = (int)(Math.random()*9);
        if (rng == getOldRng()) {
            rng = (int)(Math.random()*9);
        }

        getPlanetesVisitees().push(getListePlanetes()[rng]);

        // carburant
        x1 = getPlanetesVisitees().peek().getDistance();
        if (!isBoost()) { // le Omega Booster gaspille 2 fois moins de carburant
            vaisseau.setGas(vaisseau.getGas() - (Math.abs(x0 - x1)));
            System.out.println("Vous depensez " + (Math.abs(x0 - x1)) + " carburant. Il vous en reste " + getGas());
        }
        else {
            vaisseau.setGas(vaisseau.getGas() - ((Math.abs(x0 - x1) / 2)));
            System.out.println("Vous depensez " + (Math.abs(x0 - x1) / 2) + " carburant. Il vous en reste " + getGas());
        }
        if (vaisseau.getGas() <= 0) {
            gameoverLose();
        }

        // items
        getItems().add(getPlanetesVisitees().peek().getItem());

        // enemies
        if (getExploreCount() == 3) {
            battle(vaisseau, new SomalianPirate(), 0);
            getItems().add(new Scimitar());
        }
        if (getExploreCount() == 6) {
            battle(vaisseau, new KimJongUnDemolishers(), 0);
            getItems().add(new KimJongGigaBlaster());
            getItems().add(new FailedNuclearExperiment());
        }
        if (getExploreCount() == 9) {
            battle(vaisseau, new PutinEliteSpaceTravellers(), 0);
            getItems().add(new CykaReflector());
            getItems().add(new VodkaBottle());
        }
        if (getExploreCount() == 12) {
            battle(vaisseau, new TrumpIntergalacticSquad(), 1);
            gameoverWin();
        }


        System.out.println("Vous arriviez sur " + getPlanetesVisitees().peek().getLore());
        System.out.println("Vous trouvez un " + getPlanetesVisitees().peek().getItem().getNom());

        setOldRng(rng);
    }

    public void item(Vaisseau vaisseau) {
        boolean[] existe = new boolean[100];
        if (getItems().size() > 0) {
            System.out.println("Quelle item voulez vous utilizer?");
            System.out.println("");
            for (int i=0;i<getItems().size();i++) {
                System.out.println(i + " - " + getItems().get(i).getNom());
                existe[i] = true;
            }
            System.out.println("Autre - Rien faire");

            Scanner sc = new Scanner(System.in);

            int choix = sc.nextInt();

            if (existe[choix]) {
                useItem(vaisseau, getItems().get(choix).getValue(), getItems().get(choix).getType(), getItems().get(choix));
                getItems().remove(choix);
            }
        }
        else System.out.println("Vous n'avez pas d'items");
    }

    public void useItem(Vaisseau vaisseau, int value, int type, Item item) {
        // type 1 = HP, type 2 = Gas, type 3 = Atk, type 4 = def, type 5 = OmegaBooster, type 6 = GoldCamo, type 7 = FidgetSpinner :)
        switch (type) {
            case 1:
                vaisseau.setHP(vaisseau.getHP() + value);
                break;

            case 2:
                vaisseau.setGas(vaisseau.getGas() + value);
                break;

            case 3:
                vaisseau.setAtk(vaisseau.getAtk() + value);
                break;

            case 4:
                vaisseau.setDef(vaisseau.getDef() + value);
                break;

            case 5:
                vaisseau.setBoost(true);
                break;

            case 6:
                vaisseau.setNom("*" + vaisseau.getNom() + "*");
                break;

            case 7:
                System.out.println("WOohoo! Vous spinnez votre fidget spinner");
                break;

        }

        System.out.println(item.getEffet());
    }

    public void uturn(Vaisseau vaisseau) {
        if (planetesVisitees.size() > 1) {
            int x0 = planetesVisitees.pop().getDistance();
            int x1 = planetesVisitees.peek().getDistance();

            if (!isBoost()) { // le Omega Booster gaspille 2 fois moins de carburant
                vaisseau.setGas(vaisseau.getGas() - (Math.abs(x0 - x1)));
                System.out.println("Vous depensez " + (Math.abs(x0 - x1)) + " carburant. Il vous en reste " + getGas());
            }
            else {
                vaisseau.setGas(vaisseau.getGas() - ((Math.abs(x0 - x1) / 2)));
                System.out.println("Vous depensez " + (Math.abs(x0 - x1) / 2) + " carburant. Il vous en reste " + getGas());
            }

            System.out.println("Vous retournez sur " + planetesVisitees.pop().getLore());
        }
        else System.out.println("Vous n'avez meme pas parti de la Terre encore? Que faites-vous??");
    }

    public void battle(Personnage vaisseau, Personnage enemie, int x) {
        boolean fight = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Oh non! " + enemie.getNom() + " vous attaque!");
        if (x == 0) {
            System.out.println("Est-ce que vous voullez vous defendre ou fuir?");
            System.out.println("1 - Defendre");
            System.out.println("Autre - Fuir");
            System.out.println(" ");

            x = sc.nextInt();
        }

        if (x == 1) {
            while (fight) {

                vaisseau.attaquer(vaisseau, enemie);

                if (enemie.getHP() <= 0) {
                    System.out.println(enemie.getNom() + " a ete battu!");
                    fight = false;
                }

                else {
                    enemie.attaquer(enemie, vaisseau);

                    if (vaisseau.getHP() <= 0) {
                        gameoverLose();
                        fight = false;
                    }
                }
            }

            System.out.println(" ");
        }
    }

    public void gameoverLose() {
        System.out.println("VOUS ETES MORT");
        System.exit(0);
    }

    public void gameoverWin() {
        System.out.println("VOUS AVEZ SAUVEZ L'UNIVERS");
        System.exit(0);
    }

    public boolean isBoost() {
        return boost;
    }

    public void setBoost(boolean boost) {
        this.boost = boost;
    }
    public int getOldRng() {
        return oldRng;
    }

    public void setOldRng(int oldRng) {
        this.oldRng = oldRng;
    }

    public Planete[] getListePlanetes() {
        return listePlanetes;
    }

    public void setListePlanetes(Planete[] listePlanetes) {
        this.listePlanetes = listePlanetes;
    }

    public Stack<Planete> getPlanetesVisitees() {
        return planetesVisitees;
    }

    public void setPlanetesVisitees(Stack<Planete> planetesVisitees) {
        this.planetesVisitees = planetesVisitees;
    }

    public int getExploreCount() {
        return exploreCount;
    }

    public void setExploreCount(int exploreCount) {
        this.exploreCount = exploreCount;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
