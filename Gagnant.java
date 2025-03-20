import java.util.*;

public class Gagnant {

    static List<String> ordreCombinaisons = Arrays.asList("Quinte Flush Royale", "Quinte Flush", "Carré", "Full", "Couleur", "Suite", "Brelan", "Double Paire", "Paire", "Carte Haute");

    static Map<String, Integer> ordreMap2 = new HashMap<>();

    static {
        for (int i = 0; i < ordreCombinaisons.size(); i++) {
            ordreMap2.put(ordreCombinaisons.get(i), i);   // Ajout dans la Map de la valeur avec son numéro
        }
    }


    public static void main(String[] arg){
        Combinaison.main(null);
        Collections.sort(Combinaison.comb, Comparator
                .comparing((Combinaison c) -> ordreMap2.getOrDefault(c.combinaisons, Integer.MAX_VALUE)));

        for (int i=0; i<(Combinaison.comb.size()-1); i++){

            if (Combinaison.comb.get(i).combinaisons == Combinaison.comb.get(i+1).combinaisons){ // Même comb entre 2 joueurs

                if (Combinaison.comb.get(i).combinaisons == "Double Paire" || Combinaison.comb.get(i).combinaisons == "Paire" ){
                    Collections.sort(Combinaison.comb, Comparator
                            .comparing((Combinaison c) -> ordreMap2.getOrDefault(c.combinaisons, Integer.MAX_VALUE))
                            .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.mains, Integer.MAX_VALUE)));

                    if (Combinaison.comb.get(i).mains == Combinaison.comb.get(i+1).mains){
                        Collections.sort(Combinaison.comb, Comparator
                                .comparing((Combinaison c) -> ordreMap2.getOrDefault(c.combinaisons, Integer.MAX_VALUE))
                                .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.mains, Integer.MAX_VALUE))
                                .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.exception, Integer.MAX_VALUE)));

                        if (Combinaison.comb.get(i).exception == Combinaison.comb.get(i+1).exception) {
                            Collections.sort(Combinaison.comb, Comparator
                                    .comparing((Combinaison c) -> ordreMap2.getOrDefault(c.combinaisons, Integer.MAX_VALUE))
                                    .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.mains, Integer.MAX_VALUE))
                                    .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.exception, Integer.MAX_VALUE))
                                    .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.reste, Integer.MAX_VALUE)));
                        }
                    }
                }

                else {
                    Collections.sort(Combinaison.comb, Comparator
                            .comparing((Combinaison c) -> ordreMap2.getOrDefault(c.combinaisons, Integer.MAX_VALUE))
                            .thenComparing((Combinaison c) -> Tri.ordreMap.getOrDefault(c.mains, Integer.MAX_VALUE)));
                }
            }
        }
        System.out.println("Joueur " + Combinaison.comb.getFirst().index + " a gagné la manche avec : " + Combinaison.comb.getFirst().combinaisons);
    }
}
