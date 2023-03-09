package alexis.airbnb.reservations;

import alexis.airbnb.erreurs.MesExceptions;
import alexis.airbnb.logements.Appartement;
import alexis.airbnb.logements.Logement;
import alexis.airbnb.outils.MaDate;

import java.util.Date;

import static alexis.airbnb.Main.scanner;

public abstract class Sejour implements SejourInterface {

    protected final Date dateArrivee;
    protected final int nbNuits;
    protected Logement logement;
    protected final int nbVoyageurs;
    protected int tarif;

    protected static final int MAX_NUITS_SEJOUR_COURT = 6;

    public Sejour(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        dateArrivee = (Date) pDateArrivee.clone(); // aussi possible en faisant une new Date/MaDate
        nbNuits = pNbNuits;
        logement = pLogement;
        nbVoyageurs = pNbVoyageurs;
        miseAJourDuTarif();
    }

    public static Sejour creationSejour(Logement logement) {
        System.out.println("Bienvenue dans le créateur de séjour !");
        System.out.println("PROMO SPECIAL ST VALENTIN : Tous les séjours à seulement 140€ (parmis une séléction de logements, pour 2 personnes, pour 2 nuits et pour un séjour commençant le 14 février).");
        System.out.println("Veuillez entrer une date au format dd/MM/yyyy.");
        String strDate = scanner.next();

        if (strDate.equals("14/02/2023")) {
            return new SejourStValentin(logement);
        }

        System.out.println("Veuillez entrer le nombre de nuits souhaitées (entre 1 et 31 nuits).");
        int nbNuits = scanner.nextInt();
        System.out.println("Veuillez entrer le nombre de voyageurs.");
        int nbVoyageurs = scanner.nextInt();

        Sejour sejour;
        if (nbNuits < 6) {
            sejour = new SejourCourt(new MaDate(strDate), nbNuits, logement, nbVoyageurs);
        } else {
            sejour = new SejourLong(new MaDate(strDate), nbNuits, logement, nbVoyageurs);
        }
        return sejour;
    }

    public abstract void miseAJourDuTarif();

    @Override
    public abstract boolean verificationNombreDeNuits();

    @Override
    public boolean verificationDateArrivee() {
        return dateArrivee.getTime() > new Date().getTime();
    }

    @Override
    public boolean verificationNombreDeVoyageurs() {
        return nbVoyageurs <= logement.getNbVoyageursMax();
    }

    @Override
    public void afficher() {
        logement.afficher();
        System.out.println("La date d'arrivée est le " + dateArrivee + " pour " + nbNuits + " nuits.");
    }

    public Date getDateArrivee() {
        return (Date) dateArrivee.clone();
    }

    public void setLogement(Logement logement) {
        if (logement == null) {
            throw new IllegalArgumentException();
        } else {
            this.logement = logement;
        }
    }
}
