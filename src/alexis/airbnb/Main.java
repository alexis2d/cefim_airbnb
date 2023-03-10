package alexis.airbnb;

import alexis.airbnb.erreurs.MesExceptions;
import alexis.airbnb.logements.Appartement;
import alexis.airbnb.logements.Logement;
import alexis.airbnb.logements.Maison;
import alexis.airbnb.outils.AirBnBData;
import alexis.airbnb.outils.MaDate;
import alexis.airbnb.outils.Recherche;
import alexis.airbnb.reservations.*;
import alexis.airbnb.utilisateurs.Hote;
import alexis.airbnb.utilisateurs.Personne;
import alexis.airbnb.utilisateurs.Voyageur;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Main {

    public static Scanner scanner;

    public static void main(String[] args) throws MesExceptions {

        scanner = new Scanner(System.in);

        //AirBnBData airBnBData = AirBnBData.getInstance();
        /*Recherche rechercheBuilder = new Recherche.RechercheBuilder(4).possedePiscine(true).build();
        for (Logement logement : rechercheBuilder.result()) {
            logement.afficher();
        }*/

        Recherche rechercheBuilder = new Recherche.RechercheBuilder(2).tarifMinParNuit(50).tarifMaxParNuit(400).build();
        List<Logement> logementArrayList = rechercheBuilder.result();
        logementArrayList.forEach(logement -> logement.afficher());
        System.out.println(rechercheBuilder.resultAverage());
        System.out.println("Le moins cher :");
        rechercheBuilder.resultMoinsCher().get().afficher();

        /*Personne alexis = new Personne("Alexis", "Duquenet", 28);
        Hote alexisHote = new Hote(alexis, 10);
        Voyageur alexisVoyageur = new Voyageur(alexis);
        Hote peterHote = new Hote("Peter", "Bardu", 29, 12);

        Maison maison = new Maison("Maison Peter", peterHote, 40, "81 Rue Colbert, 37000 Tours", 140, 15, 200, false);
        Appartement appartement = new Appartement("Appart Alexis" ,alexisHote, 20, "40 rue du Gui, 37100 Tours", 60, 5, 1, 10);
*/
        /*Sejour voyageStValentin = new SejourStValentin(maison);
        Sejour voyageMaison = new SejourCourt(new MaDate("09/02/2023"), 4, maison, 10);
        Sejour voyageAppart = new SejourLong(new MaDate(12, 02, 2023),7, appartement,5);

        Reservation reservationStValentin = new Reservation(voyageStValentin, alexisVoyageur);
        Reservation reservation = new Reservation(voyageMaison, alexisVoyageur);
        Reservation reservation2 = new Reservation(voyageAppart, alexisVoyageur);

        System.out.println("Reservation St Valentin :");
        reservationStValentin.afficher();
        System.out.println();
        System.out.println("Reservation 1 :");
        reservation.afficher();
        System.out.println();
        System.out.println("Reservation 2 :");
        reservation2.afficher();*/

        //Sejour sejour = Sejour.creationSejour(maison);
        /*Sejour sejour = new SejourCourt(new MaDate("12/02/2023"), 4, maison, 10);
        try {
            Reservation reservationFabrique = new Reservation(sejour, alexisVoyageur);
            reservationFabrique.afficher();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/

        /*Date dateArrivee = new MaDate("09/04/2023");
        int nbNuits = 2;
        int nbVoyageurs = 3;*/

        // pb n°1
        /*Sejour sejour = new SejourLong(dateArrivee, nbNuits, maison, nbVoyageurs);
        dateArrivee.setYear(98);
        sejour.afficher();*/

        // pb n°2
        /*Sejour sejour = new SejourLong(dateArrivee, nbNuits, maison, nbVoyageurs);
        Date date = sejour.getDateArrivee();
        date.setYear(98);
        sejour.afficher();*/

        // pb n°3
        /*Sejour sejour = new SejourLong(dateArrivee, nbNuits, maison, nbVoyageurs);
        sejour.setLogement(appartement);
        sejour.afficher();*/



    }

}