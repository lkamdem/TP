package ExoVoyageur;

import java.util.Comparator;

public class ClassComparator implements Comparator<Voyageur> {
    @Override
    public int compare(Voyageur o1, Voyageur o2) {
        if ((o1.getClasse().ordinal() == o2.getClasse().ordinal())) {
            return (o1.getNumeroSiege() - o2.getNumeroSiege());
        } else {
            return (o1.getClasse().ordinal() - o2.getClasse().ordinal());
        }
    }
}

