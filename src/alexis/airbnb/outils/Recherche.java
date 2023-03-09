package alexis.airbnb.outils;

import alexis.airbnb.logements.Appartement;
import alexis.airbnb.logements.Logement;
import alexis.airbnb.logements.Maison;
import alexis.airbnb.outils.AirBnBData;

import java.util.ArrayList;

public class Recherche {

    private static final int YES = 1;
    private static final int NO = 2;
    private static final int WE_DONT_CARE = 3;

    private int nbVoyageurs;
    private int tarifMin;
    private int tarifMax;
    private int possedePiscine;
    private int possedeBalcon;

    private Recherche(RechercheBuilder builder) {
        this.nbVoyageurs = builder.nbVoyageursBuilder;
        this.tarifMin = builder.tarifMinBuilder;
        this.tarifMax = builder.tarifMaxBuilder;
        this.possedePiscine = builder.possedePiscineBuilder;
        this.possedeBalcon = builder.possedeBalconBuilder;
    }

    public ArrayList<Logement> result() {

        ArrayList<Logement> result = new ArrayList<>();

        for (Logement logement : AirBnBData.getInstance().getLogements()) {

            // Test nombre de voyageur
            if (logement.getNbVoyageursMax() < nbVoyageurs)
                continue;

            // Test du tarif par nuit
            if (logement.getTarifParNuit() < tarifMin || logement.getTarifParNuit() > tarifMax)
                continue;

            // Test pour la piscine
            if (possedePiscine == YES) {
                // Oui pour la piscine du coup c'est forcément une maison
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // La maison n'a pas de piscine, on ne la prend pas
                    if (!maison.hasPiscine())
                        continue;
                } else
                    continue;

            } else if (possedePiscine == NO) {
                // Non pour la piscine
                if (logement instanceof Maison) {
                    Maison maison = (Maison) logement;
                    // Si la maison a une piscine, on ne la prend pas
                    if (maison.hasPiscine())
                        continue;
                }
            }

            // Test pour le balcon
            if (possedeBalcon == YES) {
                // Oui pour le balcon, c'est forcément un appartement
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement n'a pas de balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() == 0)
                        continue;
                } else
                    continue;
            } else if (possedeBalcon == NO) {
                // Non pour le balcon
                if (logement instanceof Appartement) {
                    Appartement appartement = (Appartement) logement;
                    // Si l'appartement a pas un balcon, on ne le prend pas
                    if (appartement.getSuperficieBalcon() != 0)
                        continue;
                }

            }

            result.add(logement);
        }

        return result;
    }

    public static class RechercheBuilder {

        private final int nbVoyageursBuilder;
        private int tarifMinBuilder;
        private int tarifMaxBuilder;
        private int possedePiscineBuilder;
        private int possedeBalconBuilder;

        public RechercheBuilder(int nbVoyageurs) {
            this.nbVoyageursBuilder = nbVoyageurs;
            tarifMinBuilder = 0;
            tarifMaxBuilder = Integer.MAX_VALUE;
            possedePiscineBuilder = WE_DONT_CARE;
            possedeBalconBuilder = WE_DONT_CARE;
        }

        public RechercheBuilder tarifMinParNuit(int tarifMin) {
            this.tarifMinBuilder = tarifMin;
            return this;
        }

        public RechercheBuilder tarifMaxParNuit(int tarifMax) {
            this.tarifMaxBuilder = tarifMax;
            return this;
        }

        public RechercheBuilder possedePiscine(boolean possedePiscine) {
            this.possedePiscineBuilder = possedePiscine ? YES : NO;
            return this;
        }

        public RechercheBuilder possedeBalcon(boolean possedeBalcon) {
            this.possedeBalconBuilder = possedeBalcon ? YES : NO;
            return this;
        }

        public Recherche build() {
            return new Recherche(this);
        }
    }
}
