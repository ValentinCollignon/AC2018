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
		ArrayList<Edge> edges;
		ArrayList<Integer> sommetsNonVisitees = new ArrayList<>();
		ArrayList<Integer> sommetsVisitees = new ArrayList<>();
		for (int i = 0; i < nbSommet-1; i++) {
			sommetsNonVisitees.add(i);
		}
		sommetsVisitees.add(nbSommet-1);
		do{
		edges = marcheAlea(arbre,sommetsNonVisitees.get(0),sommetsVisitees);
		sommetsNonVisitees = majSommetsVisitees(sommetsNonVisitees,sommetsVisitees);
		supressionCycle(edges);
		addEdgeArbre(arbre,edges);
		}while(sommetsNonVisitees.size()>0);
				
		return arbre;
	}


	private static void addEdgeArbre(Graph arbre, ArrayList<Edge> edges) {
		ArrayList<Edge> eds = arbre.edges();
		for(Edge e1: edges){
			for(Edge e2: eds){
				if(e1.equals(e2)){
					e2.used=true;
				}
			}
		}
		
	}


	private static void supressionCycle(ArrayList<Edge> edges) {
		boolean b = false;
		int j; 
		System.out.println(edges);
		for (int i=0;i < edges.size();i++){
			j=i+1;
			b=false;
			while (!b && j<edges.size()){
				b=edges.get(i).equals(edges.get(j));
				j++;
			}
			if(b){
				edges= suppretion(edges,i,j);
			}
		}
	}


	private static ArrayList<Edge> suppretion(ArrayList<Edge> edges, int i, int j) {
		ArrayList<Edge> edg= new ArrayList<>();
		for(int k=0;k<i;k++){
			edg.add(edges.get(k));
		}
		for(int k=j;k<edges.size();k++){
			edg.add(edges.get(k));
		}
		return edg;
	}


	private static ArrayList<Integer> majSommetsVisitees(ArrayList<Integer> sommetsNonVisitees, ArrayList<Integer> sommetsVisitees) {
		ArrayList<Integer> sommetsNV = new ArrayList<>();
		for(int i:sommetsNonVisitees ){
			if(!sommetsVisitees.contains(i)){
				sommetsNV.add(i);
			}
		}
		
		return sommetsNV;
		
	}


	private static ArrayList<Edge> marcheAlea(Graph arbre, int sommet, ArrayList<Integer> sommetsVisitees) {
		ArrayList<Edge> edg = new ArrayList<>();
		ArrayList<Edge> adj;
		Edge e ;
		Random r= new Random();
		do {
			adj = arbre.adj(sommet);
			e =   adj.get(r.nextInt(adj.size()));
			edg.add(e);
			sommetsVisitees.add(sommet);
			sommet = e.other(sommet);
		}while (sommetsVisitees.contains(sommet));
		return edg;
	}
	
}
