package katas;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        kata Accum!
        System.out.println(accum("LeoPold"));

//        Kata count vowels
        System.out.println(countVowel("Eleonor"));

//        Kata high and LOW
        System.out.println(HighAndLow("8 9 3 4 -5 6"));
//        Kata Mot le plus court de la phrase
        System.out.println(motLePlusCourt("nous sommes confinés dans la maison depuis 1 jour"));
//        Kata isSquare
        if (isSquare(-25)) {
            System.out.println("is square");
        } else {
            System.out.println("is not square");
        }
//        Kata isIsogram
        if (isIsogram("BonjOur")) {
            System.out.println("est un Isogramme");
        } else {
            System.out.println("n'est pas un Isogramme");
        }

//        Kata longest
        System.out.println(longest("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"));
    }

    static String longest(String str1, String str2) {
        String result = "";

        Set<String> lettreDejaPresente = new TreeSet<>(Arrays.asList((str1 + str2).split("")));
//        lettreDejaPresente.addAll(Arrays.asList((str1 + str2).split("")));
//        for (String lettre : (str1 + str2).split("")) {
//                lettreDejaPresente.add(lettre);
//        }
        for (String caractere : lettreDejaPresente) {
//            result += caractere;
            result = result.concat(caractere);
        }
        return result;
    }

     static boolean isIsogram(String mot) {
        Set<String> lettreDejaPresente = new HashSet<>();
         for (String lettre : mot.split("")) {
             if (lettreDejaPresente.contains(lettre.toLowerCase())) {
                 return false;
             } else {
                 lettreDejaPresente.add(lettre.toLowerCase());
             }
         }
         return true;
    }

    static String accum(String str) {
//        Controle de la chaîne du paramètre transmis
        for (int i = 0; i < str.length(); i++) {
            char caractere = str.charAt(i);
            if (!((caractere >= 'a') && (caractere <= 'z') || (caractere >= 'A') && (caractere <= 'Z') )) {
                return "Veuillez saisir des lettres minuscule ou MAJUSCULE uniquement !";
            }
        }
//        Si OK, on poursuit
        String result = "";
        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < i ; j++) {
                if ((j==0)) {
//                    result += str.toUpperCase().charAt(i-1);
                    result = result.concat(Character.toString(str.toLowerCase().charAt(i-1)));
                } else {
                    result = result.concat(Character.toString(str.toLowerCase().charAt(i-1)));
//                    result += str.toLowerCase().charAt(i-1);
                }
            }
            if ((i!=str.length())) {
                result = result.concat("-");
            }
        }
        return result;
    }

    static int countVowel(String str) {
        int compteur = 0;
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.toLowerCase().charAt(i))) {
                compteur +=1;
            }
        }
        return compteur;
    }

    static String HighAndLow(String str) {
        String result;
//        String[] number = str.split(" ");
        int min = Integer.parseInt(str.split(" ")[0]);
        int max = Integer.parseInt(str.split(" ")[0]);
        for (String element : str.split(" ")) {
            if ((Integer.parseInt(element) < min)) {
                min = Integer.parseInt(element);
            }
            if ((Integer.parseInt(element) > max)) {
                max = Integer.parseInt(element);
            }
        }
        result = min + " " + max;
        return result;
    }
    static int motLePlusCourt( String phrase) {
        int lg = phrase.length();
//        String[] tableDeMot = phrase.split(" ");
        for (String element : phrase.split(" ")) {
            if ((element.length() < lg)) {
                lg = element.length();
            }
        }
        return lg;
    }

    static boolean isSquare(int nombre) {
        if ((nombre < 0)) {
            return false;
        } else {
            for (int i = 1; i <= nombre ; i++) {
                if ((i*i == nombre)) {
                    return true;
                } else {
                    if ((i*i > nombre)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
