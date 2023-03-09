package alexis.airbnb.logements;

import alexis.airbnb.utilisateurs.Hote;

public class Appartement extends Logement {

    private int numeroEtage;
    private int superficieBalcon;

    public Appartement(String pName, Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax) {
        super(pName, pHote, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax);
    }

    public Appartement(String pName, Hote pHote, int pTarifParNuit, String pAdresse, int pSuperficie, int pNbVoyageursMax, int pNumeroEtage, int pSuperficieBalcon) {
        super(pName, pHote, pTarifParNuit, pAdresse, pSuperficie, pNbVoyageursMax);
        numeroEtage = pNumeroEtage;
        superficieBalcon = pSuperficieBalcon;
    }

    @Override
    public void afficher() {
        super.afficherBase();
        if (numeroEtage > 1) {
            System.out.println(" au " + numeroEtage + "ème étage.");
        } else if (numeroEtage == 1) {
            System.out.println(" au 1er étage.");
        } else {
            System.out.println(" au rez-de-chaussée.");
        }
        System.out.println("Superficie : " + superficie + "m2");
        if (superficieBalcon > 0) {
            System.out.println("Balcon : Oui (" + superficieBalcon + "m2)");
        } else {
            System.out.println("Balcon : Non");
        }
    }

    public int getSuperficieBalcon() {
        return superficieBalcon;
    }
}
