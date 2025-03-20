import java.util.*;

public class Tri {

    // Définition d'un ordre personnalisé pour les valeurs des cartes
    static List<String> ordreValeurs = Arrays.asList("Ace", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2");

    // Création d'une Map pour assigner une priorité numérique à chaque valeur
    static Map<String, Integer> ordreMap = new HashMap<>();

    // Association de l'ordre des valeurs à leur numéro respectif de priorité
    static {
        for (int i = 0; i < ordreValeurs.size(); i++) {
            ordreMap.put(ordreValeurs.get(i), i);   // Ajout dans la Map de la valeur avec son numéro
        }
    }

    // Créaton de la méthode de tri par couleur
    public static void parCouleur(List<Carte> jeu){
        //System.out.println("Avant tri :" + jeu);

        Collections.sort(jeu, Comparator.comparing(c -> c.couleur));
        //System.out.println("Apres tri : " + jeu);
    }

    // Créaton de la méthode de tri par valeur
    public static void parValeur(List<Carte> jeu){
        //System.out.println("Avant tri :" + jeu);

        Collections.sort(jeu, Comparator.comparingInt(c ->
                ordreMap.getOrDefault(c.valeur, Integer.MAX_VALUE) // Remplace `null` par MAX_VALUE
        ));

        // Insertion d'une gestion d'erreur
        for (Carte c : jeu) {
            if (!ordreMap.containsKey(c.valeur)) {  // En cas de valeur différente des valeurs de la Map
                System.out.println("Erreur : Valeur inconnue -> " + c.valeur);  // Affichage de la valeur ayant généré l'erreur
            }
        }
        //System.out.println("Apres tri : " + jeu);
    }

    // Créaton de la méthode de tri par couleur puis par valeur
    public static void parCouleurEtValeur(List<Carte> jeu){
        //System.out.println("Avant tri :" + jeu);

        Collections.sort(jeu, Comparator
                .comparing((Carte c) -> c.couleur)
                .thenComparingInt(c -> ordreMap.getOrDefault(c.valeur, Integer.MAX_VALUE))
        );

        for (Carte c : jeu) {
            if (!ordreMap.containsKey(c.valeur)) {
                System.out.println("⚠️ Erreur : Valeur inconnue -> " + c.valeur);
            }
        }
        //System.out.println("Apres tri : " + jeu);
    }

    // Demande du choix de tri à l'utilisateur
    public static void main(String[] arg){
        Carte.main(null);
        System.out.println("Entrez le choix de tri : 1.Couleur 2.Valeur 3.Les deux");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        switch (n){
            case 1:
                parCouleur(Carte.cartes); break;
            case 2:
                parValeur(Carte.cartes); break;
            case 3:
                parCouleurEtValeur(Carte.cartes); break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);  // Affichage du message d'erreur si choix incorrect
        }
        System.out.println(Carte.cartes.size());
        scanner.close();
    }
}
