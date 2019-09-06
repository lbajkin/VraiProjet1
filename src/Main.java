import Vaisseau.Vaisseau;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Vaisseau vaisseau = new Vaisseau();
        boolean game = true;
        int choix = 0;
        Scanner sc = new Scanner(System.in);

        vaisseau.start(vaisseau);

        while (game) {
            System.out.println("Que voulez vous faire?");
            System.out.println("1 - Examiner le vaisseau");
            System.out.println("2 - Explorer une planète");
            System.out.println("3 - Utiliser un objet dans l’inventaire");
            System.out.println("4 - Revenir en arriere");
            choix = sc.nextInt();
            System.out.println("");
            System.out.println("");

            switch (choix) {
                case 1:
                    vaisseau.etat(vaisseau);
                    break;

                case 2:
                    vaisseau.explorer(vaisseau);
                    break;

                case 3:
                    vaisseau.item(vaisseau);
                    break;

                case 4:
                    vaisseau.uturn(vaisseau);
                    break;

                default:
                    System.out.println("Choix invalide!");
                    break;

            }

            System.out.println("");
            System.out.println("");

        }

    }
}
