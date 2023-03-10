package alexis.airbnb.outils;

import alexis.airbnb.logements.Appartement;
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
    private ArrayList<Logement> logementArrayList;


    //Constructeur
    private  AirBnBData(){
        //jeu de test
        Hote hote1 = new Hote("Robert", "Siu", 20, 5);
        Hote hote2 = new Hote("Jean", "Gui", 27, 7);
        ArrayList<Hote> hoteArrayList = new ArrayList<>();
        hoteArrayList.add(hote1);
        hoteArrayList.add(hote2);

        Logement maison1 = new Maison("maison1", hote1, 60, "10 rue de Darius 37100 LaFaille", 500, 6, 100, true);
        Logement appartement1 = new Appartement("appartement1", hote2, 350, "2 rue de Neeko 37000 LaJungle", 100, 7, 2, 12);
        ArrayList<Logement> logementArrayList = new ArrayList<>();
        logementArrayList.add(maison1);
        logementArrayList.add(appartement1);

        this.hoteArrayList = hoteArrayList;
        this.logementArrayList = logementArrayList;


    }

    //Méthodes
    public static AirBnBData getInstance(){
        return instance;
    }

    public ArrayList<Logement> getLogements() {
        return logementArrayList;
    }

    public ArrayList<Hote> getHotes() {
        return hoteArrayList;
    }
}
