package alexis.airbnb.utilisateurs;

import alexis.airbnb.outils.CompareInterface;

public class Personne implements CompareInterface {

    private static int count = 0;
    private final int id;
    protected final String prenom;
    protected final String nom;
    protected final int age;

    public Personne(String pPrenom, String pNom, int pAge) {
        prenom = pPrenom;
        nom = pNom;
        age = pAge;
        count++;
        id = count;
    }

    public void afficher() {
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }

    public int getElementToCompare(){
        return age;
    }

    public int getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }
}
