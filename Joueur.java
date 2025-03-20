import java.util.*;

public class Joueur {

    static int nbj;
    static List<List<Carte>> joueurs = new ArrayList<>();

    // Récupération du nombre de joueurs
    static {
        System.out.println("Entrez le nombre de joueurs :");
        Scanner scanner = new Scanner(System.in);
        nbj = scanner.nextInt();

        if (nbj>10){
            System.out.println("Erreur : le nombre de joueurs est trop élevé.");
            System.exit(0);
        }
    }


    public static void main(String[] arg) {
        Carte.main(null);

        // Génération d'un index aléatoire pour tirer les cartes de la liste
        Random rand = new Random();
        int randomInt = rand.nextInt(52);   // Index compris entre 0 et 51 (inclu)
        for (int i=0; i<nbj; i++){
            List<Carte> jeu = new ArrayList<>();
            while (jeu.size() < 5) {    // Chaque joueur possède 5 cartes
                if (randomInt == 52){   // Condition pour repartir du premier indice si on arrive au bord
                    randomInt = 0;
                }
                jeu.add(Carte.cartes.get(randomInt));   // On tire les cartes de la liste à partir de l'index
                randomInt += 1; // Incrémentation de l'index pour la prochaine carte
            }
            joueurs.add(jeu);   // Ajout des cartes du joueur dans la liste des cartes de chaque joueur
            //System.out.println("Joueur " + (i+1) + " : " + joueurs.get(i));
        }
    }
}

