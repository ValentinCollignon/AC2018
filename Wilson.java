package AC2018;

import java.util.ArrayList;
import java.util.Random;

public class Wilson {

	/**
	 * 
	 */
	public Wilson() {
		// TODO Auto-generated constructor stub
	}
	

	private static void supprElement(ArrayList<Integer> sommetsNonVisitees,int sommetEnCour) {
		int i = 0;
		while(sommetsNonVisitees.get(i) != sommetEnCour && i<sommetsNonVisitees.size()) {
			i++;
		}
		if(sommetsNonVisitees.get(i) == sommetEnCour) {
			sommetsNonVisitees.remove(i);
		}
		
	}
	
	public static Graph getArbreCouvant(Graph graph){
		
		Graph arbre = new Graph(graph);
		int nbSommet = graph.vertices();
		ArrayList<Edge> edges = arbre.edges();
		ArrayList<Integer> sommetsNonVisitees = new ArrayList<>();
		for (int i = 0; i < nbSommet; i++) {
			sommetsNonVisitees.add(i);
		}
		int sommetEnCour = 0;
		supprElement(sommetsNonVisitees,sommetEnCour);
		Random r = new Random();
		while(sommetsNonVisitees.size()>=0) {
			sommetEnCour= r.nextInt(sommetsNonVisitees.size());
		}
		
		/*		
		
		Random r = new Random();
		int sommetEnCour= r.nextInt(nbSommet);
		sommetVisite.add(sommetEnCour);
		while( sommetVisite.size()<nbSommet){
			Edge e = adjAleatoire(arbre.adj(sommetEnCour),r);
			if(nAPasEteVisite(sommetVisite,e.other(sommetEnCour))){
				e.used=true;
				sommetEnCour = e.other(sommetEnCour);
				sommetVisite.add(sommetEnCour);
			}
		}
		*/
		
		return arbre;
	}
	
}
