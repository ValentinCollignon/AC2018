package AC2018;

//package graphe;
import java.io.*;

import java.util.*;

import javax.security.auth.login.CredentialExpiredException;

public class Test {

	public static final int KRUSKAL = 0;
	public static final int ALBOUSBRODER = 1;

	public static void printLaby(Graph G, int size, String file) {
		{
			/*
			 * suppose que G est une grille de taille size x size et crée un
			 * .tex qui contient le labyrinthe correspondant
			 */

			try {
				PrintWriter writer = new PrintWriter(file, "UTF-8");
				writer.println("\\documentclass{article}\\usepackage{tikz}\\begin{document}");
				writer.println("\\begin{tikzpicture}");

				for (int i = 0; i < size; i++)
					for (int j = 0; j < size; j++) {
						writer.println(String.format(Locale.US, "\\begin{scope}[xshift=%dcm, yshift=%dcm]", i, j));
						writer.println("\\draw (0.1,0.1) -- (0.4,0.1);");
						writer.println("\\draw (0.6,0.1) -- (0.9,0.1);");
						writer.println("\\draw (0.1,0.9) -- (0.4,0.9);");
						writer.println("\\draw (0.6,0.9) -- (0.9,0.9);");
						writer.println("\\draw (0.1,0.1) -- (0.1, 0.4);");
						writer.println("\\draw (0.1,0.6) -- (0.1, 0.9);");
						writer.println("\\draw (0.9,0.1) -- (0.9,0.4);");
						writer.println("\\draw (0.9,0.6) -- (0.9,0.9);");
						writer.println("\\end{scope}");
					}

				/* bord */
				for (int i = 0; i < size; i++) {
					writer.println(String.format(Locale.US, "\\begin{scope}[xshift=%dcm, yshift=%dcm]", i, 0));
					writer.println("\\draw(0.4,0.1) -- (0.6, 0.1);");
					writer.println("\\end{scope}");
					writer.println(String.format(Locale.US, "\\begin{scope}[xshift=%dcm, yshift=%dcm]", i, size - 1));
					writer.println("\\draw(0.4,0.9) -- (0.6, 0.9);");
					writer.println("\\end{scope}");
					if (i > 0) {
						writer.println(String.format(Locale.US, "\\begin{scope}[xshift=%dcm, yshift=%dcm]", 0, i));
						writer.println("\\draw(0.1,0.4) -- (0.1, 0.6);");
						writer.println("\\end{scope}");

					}
					if (i < size - 1) {
						writer.println(
								String.format(Locale.US, "\\begin{scope}[xshift=%dcm, yshift=%dcm]", size - 1, i));
						writer.println("\\draw(0.9,0.4) -- (0.9, 0.6);");
						writer.println("\\end{scope}");

					}
					writer.println("\\draw (0,0.4) -- (0.1, 0.4);");
					writer.println("\\draw (0,0.6) -- (0.1, 0.6);");
					writer.println(
							String.format(Locale.US, "\\draw (%d, %d) ++ (0, 0.4)  -- ++ (-0.1, 0); ", size, size - 1));
					writer.println(
							String.format(Locale.US, "\\draw (%d, %d) ++ (0, 0.6)  -- ++ (-0.1, 0); ", size, size - 1));

				}

				for (Edge e : G.edges()) {
					int i = e.from % size;
					int j = e.from / size;
					writer.println(String.format(Locale.US, "\\begin{scope}[xshift=%dcm, yshift=%dcm]", i, j));
					if (e.to == e.from + size) {
						/* arête verticale */
						if (!e.used) {
							writer.println("\\draw (0.4,0.9) -- (0.6,0.9);");
							writer.println("\\draw (0.4,1.1) -- (0.6,1.1);");
						} else {
							writer.println("\\draw (0.4,0.9) -- (0.4,1.1);");
							writer.println("\\draw (0.6,0.9) -- (0.6,1.1);");
						}
					} else {
						/* arête horizontale */

						if (!e.used) {
							writer.println("\\draw (0.9,0.4) -- (0.9,0.6);");
							writer.println("\\draw (1.1,0.4) -- (1.1,0.6);");
						} else {
							writer.println("\\draw (0.9,0.4) -- (1.1,0.4);");
							writer.println("\\draw (0.9,0.6) -- (1.1,0.6);");
						}
					}
					writer.println("\\end{scope}");
				}
				writer.println("\\end{tikzpicture}");
				writer.println("\\end{document}");
				writer.close();
			} catch (IOException e) {
			}


		}

	}

	public static void testMillion( int algo ){
    	Graph arbre1 = Graph.example();
    	Graph arbre2 = Graph.example();
    	Graph arbre3 = Graph.example();
    	Graph arbre4 = Graph.example();
    	Graph arbre5 = Graph.example();
    	Graph arbre6 = Graph.example();
    	Graph arbre7 = Graph.example();
    	Graph arbre8 = Graph.example();
    	
    	// arbre 1 
    	List<Edge> e = arbre1.edges();
    	e.get(1).used=true;
    	e.get(3).used=true;
    	e.get(4).used=true;
    	
    	// arbre 2 
    	e = arbre2.edges();
    	e.get(0).used=true;
    	e.get(1).used=true;
    	e.get(4).used=true;

    	
    	// arbre 3 
    	e = arbre3.edges();
    	e.get(0).used=true;
    	e.get(1).used=true;
    	e.get(2).used=true;

    	
    	// arbre 4 
    	e = arbre4.edges();
    	e.get(1).used=true;
    	e.get(2).used=true;
    	e.get(4).used=true;

    	
    	// arbre 5 
    	e = arbre5.edges();
    	e.get(0).used=true;
    	e.get(3).used=true;
    	e.get(4).used=true;

    	
    	// arbre 6 
    	e = arbre6.edges();
    	e.get(2).used=true;
    	e.get(4).used=true;
    	e.get(3).used=true;

    	// arbre 7 
    	e = arbre7.edges();
    	e.get(2).used=true;
    	e.get(1).used=true;
    	e.get(3).used=true;

    	
    	// arbre 8 
    	e = arbre8.edges();
    	e.get(0).used=true;
    	e.get(2).used=true;
    	e.get(3).used=true;

    	int cmp1=0,cmp2=0,cmp3=0,cmp4=0,cmp5=0,cmp6=0,cmp7=0,cmp8=0;
    	
    	for (int i=0 ; i<1000000; i++){
    		Graph g=null;
    		switch(algo){
    		case KRUSKAL:
    			g=Kruskal.getArbreCouvant(Graph.example());
    			break;
    		case ALBOUSBRODER:
    			g=AlbousBroder.getArbreCouvant(Graph.example());
    			break;
    		}
    		
    		if(g.equals(arbre8))
    			
    			cmp8++;
    		else if(g.equals(arbre2))
    			cmp2++;
    		else if(g.equals(arbre3))
        		cmp3++;
    		else if(g.equals(arbre4))
            	cmp4++;
    		else if(g.equals(arbre5))
                cmp5++;
    		else if(g.equals(arbre6))
                cmp6++;
    		else if(g.equals(arbre7))
                cmp7++;
    		else if(g.equals(arbre1))
                cmp1++;
    		
    		
    		
    	}
    	System.out.println("arbre de type 1 : "+cmp1);
		System.out.println("arbre de type 2 : "+cmp2);
		System.out.println("arbre de type 3 : "+cmp3);
		System.out.println("arbre de type 4 : "+cmp4);
		System.out.println("arbre de type 5 : "+cmp5);
		System.out.println("arbre de type 6 : "+cmp6);
		System.out.println("arbre de type 7 : "+cmp7);
		System.out.println("arbre de type 8 : "+cmp8);

	}
	public static void creerLabyrintheKruskal(int size,String nomFichier) {
		Graph G = Graph.Grid(size);
		printLaby(Kruskal.getArbreCouvant(G), size, nomFichier);
	}
	public static void creerLabyrintheAlbousBroder(int size,String nomFichier) {
		Graph G = Graph.Grid(size);
		printLaby(AlbousBroder.getArbreCouvant(G), size, nomFichier);
	}
	

	public static void main(String[] args) {
		
		int size = 16;
		/*Graph G = Graph.example();
		Display d = new Display();
		// d.setImage(G.toImage());
		Display d2 = new Display();
		for (int i = 0; i < 1; i++) {
			d2.setImage(AlbousBroder.getArbreCouvant(G).toImage());
			System.out.println("appuyez sur une touche");
			new Scanner(System.in).nextLine();
		}
		// d.setImage(AlbousBroder.getArbreCouvant(G).toImage());
		System.out.println("appuyez sur une touche");
		new Scanner(System.in).nextLine();
		d.close();
		d2.close();*/
		
		
		//printLaby(AlbousBroder.getArbreCouvant(G), size, "toto.tex");
		creerLabyrintheKruskal(size,"kruskal.tex");
		creerLabyrintheAlbousBroder(size, "AlbousBroder.tex");
		//Test.testMillion(0);

	}
}
