package ExoVoyageur;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Voyageur voyageur1 = new Voyageur(1,545,"toto", Classe.BUSINESS);
        Voyageur voyageur2 = new Voyageur(8,55,"titi",Classe.BUSINESS);
        Voyageur voyageur3 = new Voyageur(4,125,"tata",Classe.ECO);
        Voyageur voyageur4 = new Voyageur(2,595,"papa",Classe.ECO);
        Voyageur voyageur5 = new Voyageur(54,85,"maman",Classe.PREMIERE);
        Voyageur voyageur6 = new Voyageur(36,1545,"zoe",Classe.PREMIERE);

        Voyageur v1 = new Voyageur(45, 2, "v1", Classe.BUSINESS);
        Voyageur v2 = new Voyageur(15,1, "v2", Classe.ECO);
        Voyageur v3 = new Voyageur(4,3, "v3", Classe.PREMIERE);
        Voyageur v4 = new Voyageur(10,5, "v4", Classe.BUSINESS);
        Voyageur v5 = new Voyageur(16,6, "v5", Classe.ECO);
        Voyageur v6 = new Voyageur(17,20, "v5", Classe.ECO);
        Voyageur v7 = new Voyageur(11,10, "v7", Classe.PREMIERE);
        Voyageur v8 = new Voyageur(45, 7, "v8", Classe.ECO);

        Queue<Voyageur> maFile= new PriorityQueue<>(new ClassComparator());
        //Queue<Voyageur> maFile= new PriorityQueue<>();
        maFile.add(voyageur1);
        maFile.add(voyageur2);
        maFile.add(voyageur3);
        maFile.add(voyageur4);
        maFile.add(voyageur5);
        maFile.add(voyageur6);
        maFile.add(v1);
        maFile.add(v2);
        maFile.add(v3);
        maFile.add(v4);
        maFile.add(v5);
        maFile.add(v6);
        maFile.add(v7);
        maFile.add(v8);
//        System.out.println(maFile);

        while (!maFile.isEmpty()) {
            embarquementVoyageur(maFile);
        }
    }

    private static void embarquementVoyageur(Queue<Voyageur> maFile) {
        System.out.println("Embarquement de :" + maFile.poll());
    }
}
