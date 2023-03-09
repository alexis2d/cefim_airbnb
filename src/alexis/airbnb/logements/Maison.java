package alexis.airbnb.logements;

import alexis.airbnb.utilisateurs.Hote;

public class Maison extends Logement {

    private int superficieJardin;
    private boolean possedePiscine;

    public Maison(String pName, Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax) {
        super(pName, pHote, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax);
    }

    public Maison(String pName, Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, int pSuperficieJardin, boolean pPossedePiscine) {
        super(pName, pHote, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax);
        superficieJardin = pSuperficieJardin;
        possedePiscine = pPossedePiscine;
    }

    @Override
    public void afficher() {
        super.afficherBase();
        System.out.println(".");
        System.out.println("Superficie : " + superficie + "m2");
        if (superficieJardin > 0) {
            System.out.println("Jardin : Oui (" + superficieJardin + "m2)");
        } else {
            System.out.println("Jardin : Non");
        }
        if (possedePiscine) {
            System.out.println("Piscine : Oui");
        } else {
            System.out.println("Piscine : Non");
        }
    }

    public boolean hasPiscine() {
        return possedePiscine;
    }
}
