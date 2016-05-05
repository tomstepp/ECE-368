package graphs;

public interface IGraph {
	//create n new vertices 
	public void createVertices(int n);
	
	//return the number of vertices
	public int sizeVertices();
		
	//returns the degree a vertex
	public int getDegree(int i);
	//return the inward-bound degree 
	public int getInDegree(int i);
	//return the outward-bound degree 
	public int getOutDegree(int i);
		
	//create an edge between the vertices i and j
	public void addEdge(int i, int j);
	//create an edge between the vertices i and j with weight w
	public void addEdge(int i, int j, double w);
	//remove the edge between the vertices i and j
	public void removeEdge(int i, int j);
	
	//return the number of edges
	public int sizeEdges();
	
	//check if the pair of vertices (i,j) is an edge. 
	public boolean isEdge(int i, int j);
	//returns the weight of the edge (i,j)
	public double getWeightEdge(int i, int j);
}
