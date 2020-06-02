package Echec;

import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.String.valueOf;

public class Main {
    public static void main(String[] args) {

        HashSet<ArrayList<String>> solutions = resoudreEchiquier(8);

        System.out.println(solutions.size());
        for (ArrayList<String> element : solutions) {
            System.out.println(element.toString());
        }
    }
    private static HashSet<ArrayList<String>> resoudreEchiquier(int dimension){
        HashSet<ArrayList<String>> setResultat = new HashSet<ArrayList<String>>();
        String[][] grille = new String[dimension][dimension];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length ; j++) {
                recherchecombinaison(i,j,grille,setResultat);
            }
        }
        return setResultat;
    }

    private static void recherchecombinaison(int ligne, int colonne, String[][] grille, HashSet<ArrayList<String>> monSet) {
        String[][] grilleDeTravail = clonerGrille(grille);
        placerEtNeutraliser(ligne,colonne, grilleDeTravail);
        // traitement de la "sous-grille" obtenu après placement.
        for (int i = 0; i < grilleDeTravail.length ; i++) {
            for (int j = 0; j < grilleDeTravail.length ; j++) {
                if ((grilleDeTravail[i][j] != "R") && (grilleDeTravail[i][j] != ".")) {
                    recherchecombinaison(i, j, grilleDeTravail, monSet);
                }
            }
        }

//      traitement de la grille transmise dans la methode
        for (int i = 0; i < grilleDeTravail.length ; i++) {
            for (int j = 0; j < grilleDeTravail.length ; j++) {
                if ((grilleDeTravail[i][j] != "R") && (grilleDeTravail[i][j] != ".")) {
                    placerEtNeutraliser(i,j,grilleDeTravail);
                }
            }
        }

        ArrayList<String> maCombinaison = extraireCombinaison(grilleDeTravail);
        if (maCombinaison.size() == grilleDeTravail.length) {
            monSet.add(extraireCombinaison(grilleDeTravail));
        }
    }

    private static void placerEtNeutraliser(int indiceColonne, int indiceLigne, String[][] grilleDeTravail) {
        for (int i = 0; i < grilleDeTravail.length ; i++) {
            for (int j = 0; j < grilleDeTravail.length ; j++) {
                if (i == indiceColonne) {
                    grilleDeTravail[i][j] = ".";
                }
                if (j == indiceLigne) {
                    grilleDeTravail[i][j] = ".";
                }
                for (int k = 1; k <grilleDeTravail.length ; k++) {
                    if (((i == indiceColonne + k) && ( j == indiceLigne + k)) ||
                            ((i == indiceColonne - k) && ( j == indiceLigne + k)) ||
                            ((i == indiceColonne + k) && ( j == indiceLigne - k)) ||
                            ((i == indiceColonne - k) && ( j == indiceLigne - k))) {
                        grilleDeTravail[i][j] = ".";
                    }
                }
                if ((i == indiceColonne) &&  (j == indiceLigne)) {
                    grilleDeTravail[i][j] = "R";
                }

            }
        }
    }

    private static void afficherGrille(String[][] grille) {
        for (int i = 0; i < grille.length; i++) {
            System.out.print(" " + valueOf(i+1) + " !");
            for (int j = 0; j < grille.length; j++) {
                System.out.print(grille[i][j]);
                System.out.print(" ! ");
            }
            System.out.println("");
        }
        System.out.println("*********************************");
    }
    private static String[][] clonerGrille(String[][] grille) {
        String[][] clone = new String[grille.length][grille.length];
        for (int i = 0; i < grille.length ; i++) {
            for (int j = 0; j < grille.length ; j++) {
                clone[i][j]=grille[i][j];
            }
        }
        return clone;
    }

    private static ArrayList<String> extraireCombinaison(String[][] grilleDeTravail) {
        ArrayList<String> combinaison = new ArrayList<>();
        for (int i = 0; i < grilleDeTravail.length ; i++) {
            for (int j = 0; j < grilleDeTravail.length ; j++) {
                if (grilleDeTravail[i][j] == "R"){
                    combinaison.add(Integer.toString(i)+Integer.toString(j));
                }
            }
        }
        return combinaison;
    }

}