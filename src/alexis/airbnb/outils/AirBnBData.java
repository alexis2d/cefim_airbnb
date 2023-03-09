package alexis.airbnb.outils;

import alexis.airbnb.logements.Logement;
import alexis.airbnb.logements.Maison;
import alexis.airbnb.utilisateurs.Hote;
import alexis.airbnb.utilisateurs.Voyageur;

import java.util.ArrayList;

public class AirBnBData {
    //Attributs
    private static AirBnBData instance = new AirBnBData();
    //Attributs de l'instance du singleton
    private ArrayList<Hote> hoteArrayList;
    private Voyageur voyageur;
    private Logement logement;


    //Constructeur
    private  AirBnBData(){
        //jeu de test
        ArrayList<Hote> hoteArrayList1 = new ArrayList<>();
        Hote hote1 = new Hote("Mohamed", "KC", 17, 5);
        Voyageur voyageur1 = new Voyageur("Adolphe", "Petain", 25);
        Logement maison1 = new Maison("maison1", hote1, 250, "10 rue de Darius 37100 LaFaille", 500, 10, 100, false);

        this.hoteArrayList = hoteArrayList1;
        this.voyageur = voyageur1;
        this.logement = maison1;


    }

    //Méthodes
    public static AirBnBData getInstance(){
        return instance;
    }

    public Logement getLogement() {
        return logement;
    }

    public ArrayList<Hote> getHoteArrayList() {
        return hoteArrayList;
    }

    public Voyageur getVoyageur() {
        return voyageur;
    }
}
