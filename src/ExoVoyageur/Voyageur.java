package ExoVoyageur;

public class Voyageur {
    int numeroVoyageur;
    int numeroSiege;
    String nom;
    Classe classe;

    public Voyageur(int numeroVoyageur, int numeroSiege, String nom, Classe classe) {
        this.numeroVoyageur = numeroVoyageur;
        this.numeroSiege = numeroSiege;
        this.nom = nom;
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "[" + this.nom + ", " + this.classe + ", " + numeroSiege + "]";
    }

    public int getNumeroVoyageur() {
        return numeroVoyageur;
    }

    public int getNumeroSiege() {
        return numeroSiege;
    }

    public String getNom() {
        return nom;
    }

    public Classe getClasse() {
        return classe;
    }

/*
    @Override
    public int compareTo(Object voyageur) {
        if (this.classe.ordinal() <((Voyageur)voyageur).getClasse().ordinal()) {
            return -1;
        } else {
            if (this.classe.ordinal() == ((Voyageur)voyageur).getClasse().ordinal()) {
                if (this.numeroSiege < ((Voyageur)voyageur).getNumeroSiege()) {
                    return -1;
                } else {
                    if (this.numeroSiege == ((Voyageur)voyageur).getNumeroSiege()) {
                        if (this.numeroVoyageur == ((Voyageur)voyageur).getNumeroVoyageur()) {
                            if (this.nom.equals(((Voyageur)voyageur).getNom())) {
                                return 0;
                            }
                        }
                        System.out.println("Voyageur incoherent\n" + this + "\n" + voyageur);
                        return -1;
                    } else {
                        return 1;
                    }
                }
            } else {
                return 1;
            }
        }
    }*/
}

