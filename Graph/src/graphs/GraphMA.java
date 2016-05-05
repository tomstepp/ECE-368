package graphs;

public class GraphMA implements IGraph{
	//matrix of connections
		boolean matrix[][];
		//maximum number of vertices
		int maxVertices;
		//current number of vertices
		int numVertices;
		//true if the graph is directed, false eoc
		boolean directed;

		//constructor
		public GraphMA(int max, boolean d) {
			matrix = new boolean[max][max];
			maxVertices = max;
			numVertices = 0;
			directed = d;
		}
		
		//create n new vertices 
		public void createVertices(int n) {
			if(numVertices+n > maxVertices){
				System.out.println("Sorry, you are already at the max.\n");
				return;
			}
			numVertices += n;
		}
			
		public void show(){
			if (numVertices==0) {
				System.out.println("The graph is empty!!\n");
				return;
			}
			for (int i=0;i<numVertices;i++) {
				for (int j=0;j<numVertices;j++) {
					//System.out.println("matrix["+i+","+j+"]="+matrix[i][j]);
					System.out.print(matrix[i][j]+"\t");
				}
				System.out.println("");
			}
			System.out.println();
		}

		public void addEdge(int i, int j) {
			if (checkIndex(i) && checkIndex(j)){
				matrix[i][j] = true;
				if( !directed){
					matrix[j][i] = true;
				}
			}
		}
		
		//check if the index i is a correct index for a vertix
		private boolean checkIndex(int i) {
			if(i < 0 || i >= numVertices){
				System.out.println("Wrong index of vertix: " + i + ".");
				return false;
			}
			return true;
		}
		
		public int getInDegree(int i) {
			int degree = 0;
			if (checkIndex(i)){
				for(int row=0; row < numVertices ; row++){
					if(matrix[row][i]) degree++;
				}
			}
			return degree;
		}

		public int getOutDegree(int i) {
			int degree = 0;
			if (checkIndex(i)){
				for(int col=0; col < numVertices ; col++){
					if(matrix[i][col]) degree++;
				}
			}
			return degree;
		}

		public int getDegree(int i) {
		
			return 0;
		}

		@Override
		public void addEdge(int i, int j, double w) {
			//We do not implement this method 
			//because this graph is not labelled
		}

		public void removeEdge(int i, int j) {
			if(checkIndex(i) && checkIndex(j)){
				matrix[i][j] = false;
				if ( !directed){
					matrix[j][i] = false;
				}
			}
		}

		public int sizeVertices() {
			return numVertices;
		}
		
		public int sizeEdges() {
			int numEdges = 0;
			for (int i=0; i <numVertices ; i++){
				for(int j=0; j<numVertices ; j++){
					if(matrix[i][j]) numEdges++;
				}
			}
			if( !directed) numEdges = numEdges/2;
			return numEdges;
		}
		
		public boolean isDirected() {
			return false;
		}
		
		@Override
		public boolean isEdge(int i, int j) {
			if (checkIndex(i) && checkIndex(j)){
				return matrix[i][j];
			}
			return false;
		}

		@Override
		public double getWeightEdge(int i, int j) {
			//We do not implement this method 
			//because this graph is not labeled
			return 0;
		}

		public void neighbors(int i) {
		
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
