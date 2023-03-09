package alexis.airbnb.utilisateurs;

public class Voyageur extends Personne {

    public Voyageur(String pPrenom, String pNom, int pAge) {
        super(pPrenom, pNom, pAge);
    }

    public Voyageur(Personne personne) {
        super(personne.prenom, personne.nom, personne.age);
    }

}
