package AC2018;

import java.util.ArrayList;
import java.util.Random;

public class AlbousBroder {
	
	public AlbousBroder(Graph g) {
		
	}
	
	public static Graph getArbreCouvant(Graph graph){
		int nbSommet=graph.vertices();
		Graph arbre = new Graph (graph);
		ArrayList <Integer> sommetVisite= new ArrayList<>();
		Random r = new Random();
		int sommetEnCour= r.nextInt(nbSommet);
		sommetVisite.add(sommetEnCour);
		while( sommetVisite.size()<nbSommet){
			ArrayList<Edge> adj = arbre.adj(sommetEnCour);
			Edge e = adj.get(r.nextInt(adj.size()));//adjAleatoire(arbre.adj(sommetEnCour),r);
			if(nAPasEteVisite(sommetVisite,e.other(sommetEnCour))){
				e.used=true;
				sommetEnCour = e.other(sommetEnCour);
				sommetVisite.add(sommetEnCour);
			}
		}
		return arbre;
	}

	private static boolean nAPasEteVisite(ArrayList<Integer> sommetVisite, int sommetEnCour) {
		boolean b= true;
		for (int i: sommetVisite){
			if (i==sommetEnCour)
				b=false;
		}
		return b;
	}

	private static Edge adjAleatoire(ArrayList<Edge> adj, Random r) {
		
		return adj.get(r.nextInt(adj.size()));
	}

}
