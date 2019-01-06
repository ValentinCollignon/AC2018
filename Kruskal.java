package AC2018;

import java.util.ArrayList;
import java.util.Random;

public class Kruskal {

	public static Graph getArbreCouvant(Graph graph){
		Graph arbre = new Graph (graph);
		ArrayList<Edge> edges = melange(arbre.edges());
		for(Edge e : edges){
			if (peutEtrePrise(arbre,e))
				e.used = true;
		}
		return arbre;
	}

	private static boolean peutEtrePrise(Graph arbre, Edge e) {
		return (!ilYAUnCheminPris(e.from,e.to,arbre,e));

	}

	private static boolean ilYAUnCheminPris(int from, int to, Graph arbre, Edge precedent) {
//si les 2 sommets sont déjà attachée à une arrête utilisé dans l'arbre alors il y a deja un chemin pris
		// faux a refaire

		ArrayList<Edge> edges= new ArrayList<>();
		boolean b = false;
		for (Edge e : arbre.adj(from)){
			if (e!= precedent){
				if (e.used){
					b=true;
					edges.add(e);
				}
			}
		}
		
		if (!b)
			return false;
		
		for(Edge e : edges){
			if (e.other(from)==to){
				return true;
			}
			b= true;
			b=(b&& ilYAUnCheminPris(e.other(from) , to, arbre,e) );
			if (b)
				return true;
		}
		System.out.println(precedent.toString() + " : "+b);
		return false;
	}

	

	private static ArrayList<Edge> melange(ArrayList<Edge> edges) {
		ArrayList<Edge> melange = new ArrayList<>();
		ArrayList<Integer> dejaPris = new ArrayList<>(); 
		int e;
		Random r = new Random();
		do {
			e = r.nextInt(edges.size());
			if(!melange.contains(edges.get(e)))
				melange.add(edges.get(e));
			
		}while(melange.size()<edges.size());
		return melange;
	}

}
