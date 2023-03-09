package alexis.airbnb.reservations;

import alexis.airbnb.erreurs.MesExceptions;
import alexis.airbnb.logements.Logement;
import java.util.Date;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

    public SejourCourt(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
    }

    @Override
    public void miseAJourDuTarif() {
        tarif = nbNuits * logement.getTarifParNuit();
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return nbNuits >= 1 && nbNuits < MAX_NUITS_SEJOUR_COURT;
    }

    @Override
    public boolean beneficiePromotion() {
        return false;
    }

    @Override
    public int getTarif() {
        return tarif;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour court est de " + tarif + "€.");
    }

}
