class GraphMatrix
{
    int V;
    int E;
    int Adj[][];
    int INF = 100000000;
    GraphMatrix(int V, int E, int Edges[][]){
        this.V = V;
        this.E = E;
        this.Adj = new int[this.V][this.V];
        int vertex1;
        int vertex2;
        int cost;
        for(int i=0;i<this.V;i++){
            for(int j=0;j<this.V;j++){
                if(i!=j){
                    this.Adj[i][j] = this.INF;
                }
                else{
                    this.Adj[i][j] = 0;
                }
            }
        }
        for(int i=0;i<Edges.length;i++){
            vertex1 = Edges[i][0]; vertex2 = Edges[i][1]; cost = Edges[i][2];
            this.Adj[vertex1][vertex2] = cost;
            this.Adj[vertex2][vertex1] = cost;
        }
    }

    void display(){
        for(int i=0;i<this.V;i++){
            System.out.print(i);
            for(int j=0;j<this.V;j++){
                if(this.Adj[i][j] != this.INF){
                    System.out.print("--->"+j+"  "+this.Adj[i][j]);
                }
            }
            System.out.print("\n\n");
        }
    }

    void floyedWarshellAlgorithms(){
        for(int i=0;i<this.V;i++){
            for(int j=0;j<this.V;j++){
                for(int k=0;k<this.V;k++){
                    if(i!=j){
                        if(this.Adj[i][k]+this.Adj[k][j] < this.Adj[i][j]){
                            this.Adj[i][j] = this.Adj[i][k]+this.Adj[k][j];
                        }
                    }
                }
            }
        }
        return;
    }
}
public class FloyedWarshellAlgo {
    public static void main(String args[]){
        int edges[][] = new int[4][3];
        edges[0][0] = 0;edges[0][1] = 1;edges[0][2] = 3;
        edges[1][0] = 0;edges[1][1] = 2;edges[1][2] = 2;
        edges[2][0] = 0;edges[2][1] = 3;edges[2][2] = 1;
        edges[3][0] = 1;edges[3][1] = 3;edges[3][2] = 4;
        GraphMatrix g1 = new GraphMatrix(4 ,4 , edges );
        g1.display();
        g1.floyedWarshellAlgorithms();
        g1.display();
        return;
    }
}
