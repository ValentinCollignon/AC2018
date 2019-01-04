package AC2018;
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
}
