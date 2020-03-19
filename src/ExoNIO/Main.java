package ExoNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<String> listeLignes = new ArrayList<>();
        listeLignes.add("premiere ligne de ma chanson préféré, premier couplet");
        listeLignes.add("seconde ligne de ma chanson préféré, premier couplet");
        listeLignes.add("troisième ligne de ma chanson préféré, premier couplet");
        listeLignes.add("refrain ma");
        listeLignes.add("première ligne de ma chanson préféré, second couplet");
        System.out.println(listeLignes);


        Path monFichier =  Paths.get("texte.txt");
        if (Files.exists(monFichier)) {
            suppressionFichier(monFichier);
        }
        creerFichier(monFichier);
        ecrireFichier(listeLignes, monFichier);

        System.out.println(compterMot(monFichier));
        List<String> ligneEcriture = new ArrayList<>();
        Map<String, Integer> dico = compterMot(monFichier);
        int totalMots = 0;
        for (String key : dico.keySet()) {
            ligneEcriture.add(key + " : " + dico.get(key));
            totalMots += dico.get(key);
        }
        ligneEcriture.add("Total des mots = " + totalMots);
        Path secondFichier =  Paths.get("occurence.txt");
        if (Files.exists(secondFichier)) {
            suppressionFichier(secondFichier);
        }
        creerFichier(secondFichier);
        ecrireFichier(ligneEcriture, secondFichier);

        System.out.println(motPlusPresent(monFichier));
    }

    private static void ecrireFichier(List<String> listeLignes, Path monFichier) {
        try {
            Files.write(monFichier, listeLignes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void creerFichier(Path monFichier) {
        try {
            Files.createFile(monFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void suppressionFichier(Path monFichier) {
        try {
            Files.delete(monFichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Map<String, Integer> compterMot(Path fichier) {
        Map<String,Integer> dicoMot = new HashMap<>();
        List<String> lecture = new ArrayList<>();
        try {
            lecture = Files.readAllLines(fichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String ligne : lecture) {
            for (String mot : ligne.split(" ")) {
                int compteur = getCompteur(mot, dicoMot);
                dicoMot.put(mot,compteur+1);
            }
        }
        return dicoMot;
    }

    private static int getCompteur(String mot, Map<String,Integer> dictionnaire) {
        if (dictionnaire.get(mot) != null) {
            return dictionnaire.get(mot);
        } return 0;
    }

    private static List<String> motPlusPresent(Path fichier) {
        List<String> listeresult = new ArrayList<>();
        Map<String, Integer> monDico = compterMot(fichier);
        int valeurMax = 0;
        for (String key : monDico.keySet()) {
            if (monDico.get(key) > valeurMax) {
                listeresult.clear();
                listeresult.add(key);
                valeurMax = monDico.get(key);
            } else {
                if (monDico.get(key) == valeurMax) {
                    listeresult.add(key);
                }
            }
        }
        return listeresult;
    }
}
