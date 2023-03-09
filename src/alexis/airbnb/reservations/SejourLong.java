package alexis.airbnb.reservations;

import alexis.airbnb.erreurs.MesExceptions;
import alexis.airbnb.logements.Logement;
import java.util.Date;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

    private static final int PROMOTION_EN_POURCENTAGE = 20;
    private int promotion;

    public SejourLong(Date pDateArrivee, int pNbNuits, Logement pLogement, int pNbVoyageurs) {
        super(pDateArrivee, pNbNuits, pLogement, pNbVoyageurs);
    }

    @Override
    public void miseAJourDuTarif() {
        int tarifSansPromo = nbNuits * logement.getTarifParNuit();
        promotion = (tarifSansPromo * PROMOTION_EN_POURCENTAGE) / 100;
        tarif = tarifSansPromo - promotion;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return nbNuits >= MAX_NUITS_SEJOUR_COURT && nbNuits <= 31;
    }

    @Override
    public boolean beneficiePromotion() {
        return true;
    }

    @Override
    public int getTarif() {
        return tarif;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour long est de " + tarif + "€ (" + promotion + "€ de promotion).");
    }

}
