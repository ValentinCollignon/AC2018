package AC2018.partie1;
class Edge
{
   int from;
   int to;
   boolean used;
    Edge(int x, int y)
    {
	this.from = x;
	this.to = y;
	this.used = false;
    }
    
    public Edge(Edge e) {
    	this.from = e.from;
    	this.to = e.to;
    	this.used = false;
	}

	final int other(int v)
    {
	if (this.from == v) return this.to; else return this.from;
    }    
	public String toString(){
		return ("from " + from +" to "+ to +" : " + used);
	}
	
	 public boolean equals(Object o){
	    	
	    	if (o.getClass()!=getClass()){
	    		return false;
	    	}
	    	Edge e = (Edge)o;
	    	if ((from != e.from && from != e.to)||(to != e.from && to != e.to)){
	    		return false;
	    	}
	    	
	    	if (used!=e.used)
	    		return false;
			return true;
	    	
	    }
}
