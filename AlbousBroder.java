package AC2018;

import java.util.ArrayList;
import java.util.Random;

public class AlbousBroder {
	Graph graph;
	public AlbousBroder(Graph g) {
		graph=g;
	}
	
	public Graph getArbreCouvant(){
		int nbSommet=graph.vertices();
		Graph arbre = new Graph (nbSommet);
		ArrayList <Integer> sommetVisite= new ArrayList<>();
		Random r = new Random();
		int sommetEnCour= r.nextInt(nbSommet);
		sommetVisite.add(sommetEnCour);
		while( sommetVisite.size()<nbSommet){
			Edge e = adjAleatoire(graph.adj(sommetEnCour),r);
			if(nAPasEteVisite(sommetVisite,e.other(sommetEnCour))){
				arbre.addEdge(e);
				e.used=true;
				sommetEnCour = e.other(sommetEnCour);
				sommetVisite.add(sommetEnCour);
			}
		}
		return graph;
	}

	private boolean nAPasEteVisite(ArrayList<Integer> sommetVisite, int sommetEnCour) {
		boolean b= true;
		for (int i: sommetVisite){
			if (i==sommetEnCour)
				b=false;
		}
		return b;
	}

	private Edge adjAleatoire(ArrayList<Edge> adj, Random r) {
		
		return adj.get(r.nextInt(adj.size()));
	}

}
