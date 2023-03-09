package alexis.airbnb.utilisateurs;

import alexis.airbnb.outils.CompareInterface;

public class Hote extends Personne implements CompareInterface {

    private int delaiDeReponse;

    public Hote(String pPrenom, String pNom, int pAge) {
        super(pPrenom, pNom, pAge);
    }

    public Hote(String pPrenom, String pNom, int pAge, int pDelaiDeReponse) {
        super(pPrenom, pNom, pAge);
        delaiDeReponse = pDelaiDeReponse;
    }

    public Hote(Personne personne, int pDelaiDeReponse) {
        super(personne.prenom, personne.nom, personne.age);
        delaiDeReponse = pDelaiDeReponse;
    }

    public int getElementToCompare(){
        return delaiDeReponse;
    }

    public int getDelaiDeReponse() {
        return delaiDeReponse;
    }

    @Override
    public void afficher() {
        super.afficher();
        if (delaiDeReponse == 1) {
            System.out.println(" qui s'engage à répondre dans l'heure");
        } else {
            System.out.println(" qui s'engage à répondre dans les " + delaiDeReponse + " heures");
        }
    }

}
