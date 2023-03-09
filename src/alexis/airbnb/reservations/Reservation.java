package alexis.airbnb.reservations;

import alexis.airbnb.outils.MaDate;
import alexis.airbnb.utilisateurs.Voyageur;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class Reservation {

    private static int count = 0;
    private final int id;
    private final Sejour sejour;
    private final Voyageur voyageur;
    private boolean estValidee;
    private final Date dateDeReservation;

    public Reservation(Sejour pSejour, Voyageur pVoyageur) throws Exception {
        if (!pSejour.verificationDateArrivee()) {
            Exception e = new Exception("Date incorrect.");
            throw e;
        }
        if (!pSejour.verificationNombreDeVoyageurs()) {
            Exception e = new Exception("Nombre de voyageur(s) incorrect.");
            throw e;
        }
        if (!pSejour.verificationNombreDeNuits()) {
            Exception e = new Exception("Nombre de nuit(s) incorrect.");
            throw e;
        }
        sejour = pSejour;
        voyageur = pVoyageur;
        dateDeReservation = new Date();
        estValidee = false;
        count++;
        id = count;
        creerFichier();
    }

    public int getId() {
        return id;
    }

    public void afficher() {
        voyageur.afficher();
        System.out.print(" a fait une réservation chez ");
        sejour.afficher();
    }

    public void creerFichier() {
        String sautLigne = System.getProperty("line.separator");
        String contenu = "Numéro du voyageur : " + voyageur.getId() + sautLigne + "Numéro du logement : " + sejour.logement.getId() + sautLigne + "Date d'arrivée (DD/MM/YYYY) : " + MaDate.staticToString(sejour.dateArrivee) + sautLigne + "Nombre de nuits : " + sejour.nbNuits + sautLigne + "Nombre de personnes : " + sejour.nbVoyageurs;

        try {
            PrintWriter pw = new PrintWriter("reservation.txt", StandardCharsets.UTF_8);
            pw.write(contenu);
            pw.close();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création du fichier.");
        }

        System.out.println("-------------------------------------");
    }

}
