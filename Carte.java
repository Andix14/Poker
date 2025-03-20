import java.util.*;

public class Carte {
    String couleur;
    String valeur;
    static List<Carte> cartes = new ArrayList<>();  // Définition de la liste d'objets 'Carte'

    public Carte (String couleur, String valeur){   // Définition de l'objet Carte
        this.couleur = couleur;
        this.valeur = valeur;
        cartes.add(this);   // Ajout de la carte à la liste de Cartes dès sa création
    }

    @Override
    public String toString() {
        return valeur + " (" + couleur + ")";   // Mise en forme de l'affichage des cartes
    }

    // Création manuelle (sans boucle) des cartes
    public static void main(String[] arg){

        //System.out.println("Avant tri :" + cartes);
        String[] couleurs = {"Coeur", "Carreau", "Pique", "Trèfle"};
        String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "Ace"};
        cartes = new ArrayList<>();

        for (String couleur : couleurs) {
            for (String valeur : valeurs) {
                cartes.add(new Carte(couleur, valeur));
            }
        }
        Collections.shuffle(cartes);    // Mélange du "paquet" de cartes
    }
}
