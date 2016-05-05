package graphs;
import lists.SListInt;
import queues.Squeue;

public class GraphLA implements IGraph{
	//an array of lists of integers
		SListInt[] vertices;
		//maximum number of vertices
		int maxVertices;
		//current number of vertices
		int numVertices;
		//true if the graph is directed, false eoc
		boolean directed;
		
		//Constructor
		public GraphLA(int max, boolean d) {
			vertices = new SListInt[max];
			maxVertices = max;
			numVertices = 0;
			directed = d;
		}
		
		@Override
		public void createVertices(int n) {
			if(numVertices+n > maxVertices){
				System.out.println("Sorry, you are already at the max.\n");
				return;
			}
			numVertices += n;
		}

		@Override
		public int sizeVertices() {
			return numVertices;
		}

		@Override
		public int getDegree(int i) {
		
			return 0;
		}

		@Override
		public int getInDegree(int i) {
			int degree = 0;
			if(checkIndex(i)){
				for(int j=0 ; j<numVertices ; j++){
					if(vertices[j] !=null){
						if(vertices[j].contains(i)) degree++;
					}
				}
			}
			return degree;
		}

		@Override
		public int getOutDegree(int i) {
			int degree = 0;
			if(checkIndex(i)){
				if(vertices[i]!=null){
					degree= vertices[i].getSize();
				}
			}
			return degree;			
		}

		public void addEdge(int i, int j) {
			if(checkIndex(i) && checkIndex(j)){
				if(vertices[i] == null){
					vertices[i] = new SListInt();
				}
				vertices[i].addLast(j);
				
				if ( !directed){
					if(vertices[j] == null){
						vertices[j] = new SListInt();
					}
					vertices[j].addLast(i);
				}
			}
		}
		
		//check if the index i is a correct index for a vertix
		private boolean checkIndex(int i) {
		
			return true;
		}

		@Override
		public void addEdge(int i, int j, double w) {
			//This method is not implemented because 
			//this is a graph no labeled

		}

		@Override
		public void removeEdge(int i, int j) {
			if(checkIndex(i) && checkIndex(j)){
				if(vertices[i] != null){
					int index = vertices[i].getIndexOf(j);
					if(index!=-1) vertices[i].removeAt(index);
				}
				
				if ( !directed){
					if(vertices[j] != null){
						int index = vertices[j].getIndexOf(i);
						if(index!=-1) vertices[j].removeAt(index);
					}
				}
			}
		}

		@Override
		public int sizeEdges() {
		
			return 0;
		}

		@Override
		public boolean isEdge(int i, int j) {
			if(checkIndex(i) && checkIndex(j)){
				if(vertices[i]==null) return false;
				int index= vertices[i].getIndexOf(j);
				if(index==-1) return false;
				return true;
			}
			return false;
		}

		@Override
		public double getWeightEdge(int i, int j) {
			return 0;
		}

		public void show() {
			for (int i=0;i<numVertices;i++) {
				System.out.print("Adjacents of " + i+ " :");
				if (vertices[i]!=null) {
					System.out.print(vertices[i].toString()+"\t");
				}
				System.out.println();
			 }
			System.out.println();
		}

		public boolean isDirected() {
			return false;
		}
		
		public void depthTrasversal() {
		
		}
		  
		public void depthTrasversal(int vertex, boolean[] visited) {
		
	  	}
		
		public void breadthTrasversal() {
			Squeue q = new Squeue();
			boolean[] visited = new boolean[numVertices];
			
			for( int i=0 ; i<numVertices ; i++){
				if ( !visited[i]){
					q.enqueue(i);
					
					while(!q.isEmpty()){
						int vertex = q.dequeue();
						visited[vertex] = true;
						System.out.println(vertex);
						
						for( int j=0 ; j<numVertices; j++){
							if(j!=vertex && !visited[j] && isEdge(i,j)){
								q.enqueue(j);
							}
						}
					}
				}
			}
		}

		public static void main(String args[]) {
			GraphMA obj=new GraphMA(10,false);
			obj.show();
			obj.createVertices(5);
			obj.addEdge(0, 0);
			obj.addEdge(0, 1);
			obj.show();
			obj.addEdge(1, 1);
			obj.addEdge(2, 3);
			obj.addEdge(1, 4);
			obj.show();
			obj.neighbors(4);
			obj.neighbors(1);
			obj.neighbors(2);
			obj.neighbors(3);
		}
}
