package alexis.airbnb.logements;

import alexis.airbnb.outils.CompareInterface;
import alexis.airbnb.utilisateurs.Hote;

public abstract class Logement implements CompareInterface {

    private static int count = 0;
    private final int id;
    private String name;
    private final Hote hote;
    private final int tarifParNuit;
    private final String adresse;
    protected int superficie;
    private final int nbVoyageursMax;

    public Logement(String pName, Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax) {
        name = pName;
        hote = pHote;
        tarifParNuit = pTarifParNuit;
        adresse = pAdresse;
        superficie = pSuperficie;
        nbVoyageursMax = pNbVoyageursMax;
        count++;
        id = count;
    }

    public int getElementToCompare(){
        return tarifParNuit;
    }

    public int getNbVoyageursMax() {
        return nbVoyageursMax;
    }

    public void afficherBase() {
        hote.afficher();
        System.out.print("Le Logement est situé " + adresse);
    }

    public abstract void afficher();

    public int getTarifParNuit() {
        return tarifParNuit;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
