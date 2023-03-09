package alexis.airbnb.menu;

import java.util.Scanner;
import alexis.airbnb.utilisateurs.Hote;

class GestionHotes {

    static void listerHotes() {

        System.out.println("-------------------------------------");
        listeDesHotes();
        System.out.println("-------------------------------------");

        System.out.println("Saisir une option : ");
        System.out.println("1 : Ajouter un hôte");
        System.out.println("2 : Supprimer un hôte");
        System.out.println("3 : Retour");

        switch (Menu.choix(3)) {
            case 1:
                try {
                    ajouterHote();
                    break;
                } catch (Exception e) {
                    System.out.println("Une erreur est survenue lors de l'entrée du nouvel hôte.");
                    Menu.scanner.next();
                    listerHotes();
                }
                break;
            case 2:
                try {
                    supprimerHote();
                    break;
                } catch (Exception e) {
                    System.out.println("Une erreur est survenue lors de la suppression d'un hôte.");
                    Menu.scanner.next();
                    listerHotes();
                }
            case 3:
                Menu.listerMenu();
                break;
        }
    }

    static void listeDesHotes() {
        System.out.println("Liste des hôtes ");
        for (int i=0;i<Menu.listHotes.size();i++) {
            System.out.print((i + 1) + " : ");
            Menu.listHotes.get(i).afficher();
        }
    }

    private static void ajouterHote() throws Exception {

        System.out.println("-------------------------------------");
        System.out.println("Ajouter un nouvel hôte");
        System.out.println("-------------------------------------");

        String pattern = "[A-Za-z ]*";
        System.out.println("Veuillez entrer son nom :");
        String nom = Menu.scanner.next(pattern);
        System.out.println("Veuillez entrer son prénom :");
        String prenom = Menu.scanner.next(pattern);
        System.out.println("Veuillez entrer son âge :");
        int age = Menu.scanner.nextInt();
        Hote newHote = new Hote(prenom, nom, age);
        Menu.listHotes.add(newHote);

        listerHotes();
    }

    private static void supprimerHote() throws Exception {

        System.out.println("-------------------------------------");
        System.out.println("Supprimer un hôte");
        System.out.println("-------------------------------------");

        System.out.println("Saisir une option : ");
        listeDesHotes();

        int choix = (Menu.scanner.nextInt() - 1);
        if (choix >=0 && choix <= Menu.listHotes.size()) {
            Menu.listHotes.remove(choix);
        } else {
            System.out.println("Veuillez choisir un élément existant dans la liste des hôtes.");
        }

        listerHotes();
    }

    static void listeDesLogements() {
        System.out.println("Liste des logements ");
        for (int i=0;i<Menu.listHotes.size();i++) {
            System.out.print((i + 1) + " : ");
            Menu.listLogements.get(i).afficher();
        }
    }

}
