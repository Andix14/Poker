import java.util.*;

public class Combinaison {

    static int nbj = Joueur.nbj;    // Récupération du nombre de joueur
    String combinaisons;
    List<Carte> jeu = new ArrayList<>();
    String mains;
    String exception;
    String reste;
    int index = 1;
    static List<Combinaison> comb = new ArrayList<>();


    /*static List<List<Carte>> joueurs = new ArrayList<>();
    static List<Carte> jeu = new ArrayList<>();
    static Carte un = new Carte("Coeur", "Q");
    static Carte deux = new Carte("Coeur", "K");
    static Carte trois = new Carte("Coeur", "J");
    static Carte quatre = new Carte("Coeur", "10");
    static Carte cinq = new Carte("Coeur", "Ace");

    static {
        jeu.add(un);
        jeu.add(deux);
        jeu.add(trois);
        jeu.add(quatre);
        jeu.add(cinq);
        joueurs.add(jeu);
    }*/

    public Combinaison (String combinaisons, List<Carte> jeu, String mains, String exception, String reste, int joueur){
        this.combinaisons = combinaisons;
        this.jeu = jeu;
        this.mains = mains;
        this.exception = exception;
        this.reste = reste;
        this.index = joueur;
        comb.add(this);
    }

    @Override
    public String toString() {
        return "[" + combinaisons + ", " + jeu + ", " + mains + ", " + exception + ", " + reste + ", " + index + "]";
    }



    public static void jeu(){
        for (int i=0; i<nbj; i++){
            Tri.parValeur(Joueur.joueurs.get(i));
            //Tri.parValeur(Joueur.joueurs.get(i));   // Tri des cartes de chaque joueur pour mieux chercher les combinaisons
            //System.out.println("Joueur " + (i+1) + " : " + Joueur.joueurs.get(i));
            System.out.println("Joueur " + (i+1) + " : " + Joueur.joueurs.get(i));
        }

        int index = 1;

        for (List<Carte> j : Joueur.joueurs){
            //System.out.println(j.getFirst());
            //System.out.println(Tri.ordreMap.get(j.getFirst().valeur));
            String k = "";
            String e = "";
            String l = "";
            if (Tri.ordreMap.get(j.get(0).valeur) == Tri.ordreMap.get(j.get(1).valeur) ||
                    Tri.ordreMap.get(j.get(1).valeur) == Tri.ordreMap.get(j.get(2).valeur)){ // Paire ds les 3 premières cartes


                if (Tri.ordreMap.get(j.get(0).valeur) == Tri.ordreMap.get(j.get(1).valeur)) { // 2 premières cartes même valeur

                    if (Tri.ordreMap.get(j.get(2).valeur) == Tri.ordreMap.get(j.get(3).valeur) ||
                            Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)) { // Paire ds les 3 cartes restantes

                        if (Tri.ordreMap.get(j.get(2).valeur) == Tri.ordreMap.get(j.get(3).valeur)){ // Cartes 3 et 4

                            if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)){ // Cartes 3 à 5 même valeur
                                System.out.println("Vous avez un full : Joueur " + index);
                                System.out.println(j);
                                k = j.get(2).valeur;
                                l = j.get(0).valeur;
                                new Combinaison("Full", j, k, e, l, index);
                            } else if (Tri.ordreMap.get(j.get(1).valeur) == Tri.ordreMap.get(j.get(2).valeur)) { // Cartes 1 à 4 même valeur
                                System.out.println("Vous avez un carré : Joueur " + index);
                                System.out.println(j.get(0) + " " + j.get(1) + " " + j.get(2) + " " + j.get(3));
                                k = j.get(0).valeur;
                                l = j.get(4).valeur;
                                new Combinaison("Carré", j, k, e, l,  index);
                            }
                            else { // Paires 1/2 et 3/4
                                System.out.println("Vous avez une double paire : Joueur " + index);
                                System.out.println(j.get(0) + " " + j.get(1) + "\t" + j.get(2) + " " + j.get(3));
                                k = j.get(0).valeur;
                                e = j.get(2).valeur;
                                l = j.get(4).valeur;
                                new Combinaison("Double Paire", j, k, e, l, index);
                            }
                        } else if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)){ // Cartes 4 et 5

                            if (Tri.ordreMap.get(j.get(1).valeur) == Tri.ordreMap.get(j.get(2).valeur)){ // Cartes 2 et 3 même valeur
                                System.out.println("Vous avez un full : Joueur " + index);
                                System.out.println(j);
                                k = j.get(0).valeur;
                                l = j.get(4).valeur;
                                new Combinaison("Full", j, k, e, l, index);
                            }
                            else { // Paires 1/2 et 4/5
                                System.out.println("Vous avez une double paire : Joueur " + index);
                                System.out.println(j.get(0) + " " + j.get(1) + "\t" + j.get(3) + " " + j.get(4));
                                k = j.get(0).valeur;
                                e = j.get(3).valeur;
                                l = j.get(2).valeur;
                                new Combinaison("Double Paire", j, k, e, l, index);
                            }
                        }
                    }
                    else if (Tri.ordreMap.get(j.get(1).valeur) == Tri.ordreMap.get(j.get(2).valeur)){ // Cartes 2 et 3 même valeur
                        System.out.println("Vous avez un brelan : Joueur " + index);
                        System.out.println(j.get(0) + " " + j.get(1) + " " + j.get(2));
                        k = j.get(0).valeur;
                        l = j.get(3).valeur;
                        new Combinaison("Brelan", j, k, e, l, index);
                    }
                    else { // Seulement paire 1/2
                        System.out.println("Vous avez une paire : Joueur " + index);
                        System.out.println(j.get(0) + " " + j.get(1));
                        k = j.get(0).valeur;
                        e = j.get(2).valeur;
                        l = j.get(3).valeur;
                        new Combinaison("Paire", j, k, e, l, index);
                    }

                } else if (Tri.ordreMap.get(j.get(1).valeur) == Tri.ordreMap.get(j.get(2).valeur)){ // Cartes 2 et 3 même valeur

                    if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)){ // Cartes 4 et 5

                        if (Tri.ordreMap.get(j.get(2).valeur) == Tri.ordreMap.get(j.get(3).valeur)){ // Cartes 2 à 5 même valeur
                            System.out.println("Vous avez un carré : Joueur " + index);
                            System.out.println(j.get(1) + " " + j.get(2) + " " + j.get(3) + " " + j.get(4));
                            k = j.get(1).valeur;
                            l = j.get(0).valeur;
                            new Combinaison("Carré", j, k, e, l, index);
                        }
                        else { // Paires 2/3 et 4/5
                            System.out.println("Vous avez une double paire : Joueur " + index);
                            System.out.println(j.get(1) + " " + j.get(2) + "\t" + j.get(3) + " " + j.get(4));
                            k = j.get(1).valeur;
                            e = j.get(3).valeur;
                            l = j.get(0).valeur;
                            new Combinaison("Double Paire", j, k, e, l, index);
                        }
                    }
                }
                else { // Seuleument une paire 2/3
                    System.out.println("Vous avez une paire : Joueur " + index);
                    System.out.println(j.get(1) + " " + j.get(2));
                    k = j.get(1).valeur;
                    e = j.get(3).valeur;
                    l = j.get(0).valeur;
                    new Combinaison("Paire", j, k, e, l, index);
                }

            } else if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(2).valeur) ||
                    Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)) { // Paires ds les 3 dernières cartes

                if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(2).valeur)) { // Cartes 3 et 4 même valeur

                    if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)){ // Cartes 4 et 5 même valeur

                        System.out.println("Vous avez un brelan : Joueur " + index);
                        System.out.println(j.get(2) + " " + j.get(3) + " " + j.get(4));
                        k = j.get(2).valeur;
                        l = j.get(0).valeur;
                        new Combinaison("Brelan", j, k, e, l, index);
                    }
                    else { // Seulement paire 3/4
                        System.out.println("Vous avez une paire : Joueur " + index);
                        System.out.println(j.get(2) + " " + j.get(3));
                        k = j.get(2).valeur;
                        e = j.get(0).valeur;
                        l = j.get(1).valeur;
                        new Combinaison("Paire", j, k, e, l, index);
                    }
                } else if (Tri.ordreMap.get(j.get(3).valeur) == Tri.ordreMap.get(j.get(4).valeur)){
                    // Seulement paire 4/5
                    System.out.println("Vous avez une paire : Joueur " + index);
                    System.out.println(j.get(3) + " " + j.get(4));
                    k = j.get(3).valeur;
                    e = j.get(0).valeur;
                    l = j.get(1).valeur;
                    new Combinaison("Paire", j, k, e, l, index);
                }
            }
            else {
                if (j.get(0).couleur == j.get(1).couleur &&
                        j.get(1).couleur == j.get(2).couleur &&
                        j.get(2).couleur == j.get(3).couleur &&
                        j.get(3).couleur == j.get(4).couleur){ // Couleur

                    if (Tri.ordreMap.get(j.get(0).valeur) == (Tri.ordreMap.get(j.get(1).valeur) - 1) &&
                            Tri.ordreMap.get(j.get(1).valeur) == (Tri.ordreMap.get(j.get(2).valeur) - 1) &&
                            Tri.ordreMap.get(j.get(2).valeur) == (Tri.ordreMap.get(j.get(3).valeur) - 1) &&
                            Tri.ordreMap.get(j.get(3).valeur) == (Tri.ordreMap.get(j.get(4).valeur) - 1)){ // Suite

                        if (Tri.ordreMap.get(j.get(0).valeur) == 0){ // Si la première carte est l'As
                            System.out.println("Vous avez une quinte flush royale : Joueur " + index);
                            System.out.println(j.get(4) + " " + j.get(3) + " " + j.get(2) + " " + j.get(1) + " " + j.get(0));
                            new Combinaison("Quinte Flush Royale", j, k, e, l, index);
                        }

                        else {
                            System.out.println("Vous avez une quinte flush : Joueur " + index);
                            System.out.println(j.get(4) + " " + j.get(3) + " " + j.get(2) + " " + j.get(1) + " " + j.get(0));
                            k = j.get(0).valeur;
                            new Combinaison("Quinte Flush", j, k, e, l, index);
                        }
                    }

                    else {
                        if (Tri.ordreMap.get(j.get(0).valeur) == 0 &&
                                Tri.ordreMap.get(j.get(4).valeur) == 12 &&
                                Tri.ordreMap.get(j.get(3).valeur) == 11 &&
                                Tri.ordreMap.get(j.get(2).valeur) == 10 &&
                                Tri.ordreMap.get(j.get(1).valeur) == 9) { // Couleur et suite avec As Deux ...
                            System.out.println("Vous avez une quinte flush : Joueur " + index);
                            System.out.println(j.get(0) + " " + j.get(4) + " " + j.get(3) + " " + j.get(2) + " " + j.get(1));
                            k = j.get(1).valeur;
                            new Combinaison("Quinte Flush", j, k, e, l, index);
                        }
                        else { // Seulement couleur
                            System.out.println("Vous avez une couleur : Joueur " + index);
                            System.out.println(j);
                            k = j.get(0).valeur;
                            new Combinaison("Couleur", j, k, e, l, index);
                        }
                    }
                } else if (Tri.ordreMap.get(j.get(0).valeur) == (Tri.ordreMap.get(j.get(1).valeur) - 1) &&
                        Tri.ordreMap.get(j.get(1).valeur) == (Tri.ordreMap.get(j.get(2).valeur) - 1) &&
                        Tri.ordreMap.get(j.get(2).valeur) == (Tri.ordreMap.get(j.get(3).valeur) - 1) &&
                        Tri.ordreMap.get(j.get(3).valeur) == (Tri.ordreMap.get(j.get(4).valeur) - 1)){ // Suite
                    System.out.println("Vous avez une suite : Joueur " + index);
                    System.out.println(j.get(4) + " " + j.get(3) + " " + j.get(2) + " " + j.get(1) + " " + j.get(0));
                    k = j.get(0).valeur;
                    new Combinaison("Suite", j, k, e, l, index);
                }
                else {
                    if (Tri.ordreMap.get(j.get(0).valeur) == 0 &&
                            Tri.ordreMap.get(j.get(4).valeur) == 12 &&
                            Tri.ordreMap.get(j.get(3).valeur) == 11 &&
                            Tri.ordreMap.get(j.get(2).valeur) == 10 &&
                            Tri.ordreMap.get(j.get(1).valeur) == 9) { // Suite avec As Deux ...
                        System.out.println("Vous avez une suite : Joueur " + index);
                        System.out.println(j.get(0) + " " + j.get(4) + " " + j.get(3) + " " + j.get(2) + " " + j.get(1));
                        k = j.get(1).valeur;
                        new Combinaison("Suite", j, k, e, l, index);
                    }
                    else { // Aucune combinaison
                        System.out.println("Vous n'avez aucune combinaison : Joueur " + index);
                        System.out.println(j.getFirst()); // Affichage de la carte haute
                        k = j.get(0).valeur;
                        new Combinaison("Carte Haute", j, k, e, l, index);
                    }
                }
            }
            index +=1; // Joueur suivant
        }
    }


    public static void main(String[] arg){
        Joueur.main(null);
        jeu();
        //System.out.println(comb.getFirst());
    }
}
