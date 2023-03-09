package alexis.airbnb.reservations;

import alexis.airbnb.erreurs.MesExceptions;
import alexis.airbnb.logements.Logement;
import alexis.airbnb.outils.MaDate;

import java.util.Date;

public class SejourStValentin extends Sejour implements ConditionsTarifairesInterface {

    public SejourStValentin(Logement pLogement) {
        super(new MaDate(14, 02, 2023), 2, pLogement, 2);
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
    public void miseAJourDuTarif() {
        tarif = 140;
    }

    @Override
    public boolean verificationNombreDeNuits() {
        return nbNuits == 2;
    }

}
