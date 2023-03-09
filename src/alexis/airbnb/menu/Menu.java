package alexis.airbnb.menu;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import alexis.airbnb.logements.Appartement;
import alexis.airbnb.logements.Logement;
import alexis.airbnb.logements.Maison;
import alexis.airbnb.outils.CompareGeneric;
import alexis.airbnb.reservations.Reservation;
import alexis.airbnb.utilisateurs.Hote;
import alexis.airbnb.utilisateurs.Personne;
import alexis.airbnb.utilisateurs.Voyageur;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Menu {

    static Scanner scanner;

    static ArrayList<Hote> listHotes;
    static ArrayList<Logement> listLogements;
    //static ArrayList<Voyageur> listVoyageurs;
    //static ArrayList<Reservation> listReservations;

    public static void main(String[] args) {

        Hote alexis = new Hote("Alexis", "Duquenet", 28, 15);
        Hote peter = new Hote("Peter", "Bardu", 29, 12);

        listHotes = new ArrayList<>();
        listLogements = new ArrayList<>();
        listHotes.add(new Hote("Ella","Lapêche",31,12));
        CompareGeneric<Hote> compareGenericHote = new CompareGeneric(alexis, peter);
        Hote hote = compareGenericHote.getHigher();

        //initLogements();

        /*listHotes.add(alexis);
        listHotes.add(peter);

        System.out.println("Bienvenu chez AirBnB");

        scanner = new Scanner(System.in);

        //init();

        listerMenu();

        scanner.close();*/
    }

    static void listerMenu() {

        System.out.println("-------------------------------------");
        System.out.println("Saisir une option : ");
        System.out.println("1 : Liste des hôtes");
        System.out.println("2 : Liste des logements");
        System.out.println("3 : Liste des voyageurs");
        System.out.println("4 : Liste des réservations");
        System.out.println("5 : Fermer le programme");

        switch (choix(5)) {
            case 1:
                GestionHotes.listerHotes();
                break;
            case 2:
                //GestionLogements.listerLogements();
                break;
            case 3:
                //GestionVoyageurs.listerVoyageurs();
                break;
            case 4:
                //GestionReservations.listerReservations();
                break;
            case 5:
                System.out.println("A bientôt");
                break;
        }
    }

    static int choix(int maxValue) {

        int choix = 0;

        while(true) {
            try {
                choix = scanner.nextInt();
                if (choix < 1 || choix > maxValue) {
                    System.out.println("Veuillez écrire un chiffre entre 1 et " + maxValue + ".");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Veuillez écrire un chiffre entier.");
                scanner.next();
            }
        }

        return choix;
    }

    private static void initLogements() {
        try
        {
            File file = new File("logements.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList logementsNodeList = doc.getElementsByTagName("Logements").item(0).getChildNodes();

            for (int i=0;i<logementsNodeList.getLength();i++)
            {
                Node node = logementsNodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element logementElement = (Element) node;
                    int logementType = 0;
                    if (logementElement.getNodeName().equals("Appartement")) {
                        logementType = 1;
                    } else if (logementElement.getNodeName().equals("Maison")) {
                        logementType = 2;
                    }

                    NodeList childNodeList = logementElement.getElementsByTagName("hote");
                    Hote hote = null;
                    for (int j=0;j<childNodeList.getLength();j++) {
                        Node childNode = childNodeList.item(j);
                        if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element childElement = (Element) childNode;
                            String nom = childElement.getElementsByTagName("nom").item(0).getTextContent();
                            String prenom = childElement.getElementsByTagName("prenom").item(0).getTextContent();
                            String age = childElement.getElementsByTagName("age").item(0).getTextContent();
                            String delaiReponse = childElement.getElementsByTagName("delaiReponse").item(0).getTextContent();
                            hote = new Hote(prenom, nom, Integer.parseInt(age), Integer.parseInt(delaiReponse));
                            if (!alreadyExist(hote)) {
                                listHotes.add(hote);
                            } else {
                                System.out.println(prenom + " " + nom + " existe déjà.");
                            }
                            //hote = new Hote(prenom, nom, Integer.parseInt(age), Integer.parseInt(delaiReponse));
                        }
                    }

                    int tarifParNuit = Integer.parseInt(logementElement.getElementsByTagName("tarifParNuit").item(0).getTextContent());
                    String adresse = logementElement.getElementsByTagName("adresse").item(0).getTextContent();
                    int superficie = Integer.parseInt(logementElement.getElementsByTagName("superficie").item(0).getTextContent());
                    int nbVoyageursMax = Integer.parseInt(logementElement.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());

                    Logement logement = null;
                    if (hote != null) {
                        if (logementType == 1) {
                            String numeroEtage = logementElement.getElementsByTagName("numeroEtage").item(0).getTextContent();
                            String superficieBalcon = logementElement.getElementsByTagName("superficieBalcon").item(0).getTextContent();
                            logement = new Appartement("Appartement 1", hote, tarifParNuit, adresse, superficie, nbVoyageursMax, Integer.parseInt(numeroEtage), Integer.parseInt(superficieBalcon));
                        } else if (logementType == 2) {
                            String superficieJardin = logementElement.getElementsByTagName("superficieJardin").item(0).getTextContent();
                            String possedePiscine = logementElement.getElementsByTagName("possedePiscine").item(0).getTextContent();
                            logement = new Maison("Maison 1", hote, tarifParNuit, adresse, superficie, nbVoyageursMax, Integer.parseInt(superficieJardin), Boolean.getBoolean(possedePiscine));
                        }
                    }
                    if (logement != null) {
                        listLogements.add(logement);
                    }
                }
            }
            GestionHotes.listeDesHotes();
            //GestionHotes.listeDesLogements();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static boolean alreadyExist(Hote hote1) {
        for (int i=0;i<listHotes.size();i++) {
            Hote hote2 = listHotes.get(i);
            if (hote1.getPrenom().equals(hote2.getPrenom()) && hote1.getNom().equals(hote2.getNom()) && hote1.getAge() == hote2.getAge() && hote1.getDelaiDeReponse() == hote2.getDelaiDeReponse()) {
                return true;
            }
        }
        return false;
    }

    //On cherche un logement, T représente tous les enfants de logement, et on veut retourner T ou null si pas de logement correspondant
    public static <T extends Logement> T findLogementByNameWithGenericity(String name){
        for (Logement logement : Menu.listLogements) {
            if(logement.getName().equals(name)){
                System.out.println("un logement existe déjà avec ce nom " + name);
                logement.afficher();
                return (T) logement;
            }
        }
        System.out.println("pas de logement avec ce nom : " + name);
        return null;
    }

/*
	private static void init() {

		listHotes = new ArrayList<>();
		listLogements = new ArrayList<>();
		listVoyageurs = new ArrayList<>();
		listReservations = new ArrayList<>();


		// Création des Hotes
		Hote hote1 = new Hote("alexis", "Bardu", 28, 12);
		Hote hote2 = new Hote("Patrick", "Martin", 32, 12);
		Hote hote3 = new Hote("Jeanne", "Voisin", 26, 24);
		Hote hote4 = new Hote("Maurice", "Meunier", 46, 12);

		listHotes.add(hote1);
		listHotes.add(hote2);
		listHotes.add(hote3);
		listHotes.add(hote4);

		// Création de Logement
		Maison maison1 = new Maison(hote1, 40, "18 rue De Tours, 37000 Tours", 140, 2, 500, true);
		Maison maison2 = new Maison(hote1, 35, "146 Rue George Sand, 59553 Cuincy", 120, 2, 200, false);
		Maison maison3 = new Maison(hote1, 60, "13 Rue de la Liberté, 62800 Liévin", 90, 4, 2000, true);
		Appartement appartement1 = new Appartement(hote1, 35, "46 Rue des Canonniers, 59800 Lille", 72, 2, 3, 20);
		Appartement appartement2 = new Appartement(hote1, 35, "111 Rue Colbert, 37000 Tours", 42, 2, 2, 0);

		listLogements.add(maison1);
		listLogements.add(maison2);
		listLogements.add(maison3);
		listLogements.add(appartement1);
		listLogements.add(appartement2);

		// Création de voyageurs
		Voyageur voyageur1 = new Voyageur("Alain", "Favre", 54);
		Voyageur voyageur2 = new Voyageur("Maxime", "Albert", 29);

		listVoyageurs.add(voyageur1);
		listVoyageurs.add(voyageur2);
	}
*/
}
