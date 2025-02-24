
class GraphLinkList
{
    class GraphNode
    {
        int vertex;
        int cost;
        GraphNode next;
        GraphNode(int vertex,int cost){
            this.vertex = vertex;
            this.cost = cost;
            this.next = null;
        }
    }
    int V;
    int E;
    GraphNode Adj[];
    GraphLinkList(int V,int E,int Edges[][])
    {
        this.V = V;
        this.E = E;
        this.Adj = new GraphNode[this.V];
        for(int i=0;i<this.V;i++){
            this.Adj[i] = null;
        }
        for(int i=0;i<Edges.length;i=i+1){
            this.insert(Edges[i][0],Edges[i][1],Edges[i][2]);
            this.insert(Edges[i][1],Edges[i][0],Edges[i][2]);
        }
        return;
    }
    void insert(int vertex1,int vertex2,int cost)
    {
        if(this.Adj[vertex1] == null)this.Adj[vertex1] = new GraphNode(vertex2 , cost);
        else{
            GraphNode temp = this.Adj[vertex1];
            while(temp.next!=null)temp = temp.next;
            temp.next = new GraphNode(vertex2, cost);
        }
        return;
    }

    int findcost(int vertex1,int vertex2)
    {
        GraphNode temp = this.Adj[vertex1];
        while(temp!=null){
            if(temp.vertex == vertex2){
                return temp.cost;
            }
        }
        return -1;
    }
    void display(){
        GraphNode temp;
        for(int i=0; i<this.V; i++){
            temp = this.Adj[i];
            if(temp!=null){
                System.out.print(temp.vertex+"  "+temp.cost);
            }
            while(temp!=null){
                System.out.print(" --> "+temp.vertex+"  "+temp.cost);
                temp = temp.next;
            }
            System.out.print("\n");
        }
    }
}
class GraphMatrix
{
    int V;
    int E;
    int Adj[][];
    GraphMatrix(int V, int E, int Edges[][]){
        this.V = V;
        this.E = E;
        this.Adj = new int[this.V][this.V];
        int vertex1;
        int vertex2;
        int cost;
        for(int i=0;i<this.V;i++){
            for(int j=0;j<this.V;j++){
                this.Adj[i][j] = -1;
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
            System.out.println(i);
            for(int j=0;j<this.V;j++){
                if(this.Adj[i][j] != -1){
                    System.out.println(this.Adj[i][j]);
                }
            }
        }
    }
    int finddistance(int vertex1,int vertex2){
        if(this.Adj[vertex1][vertex2] == -1)return -1;
        return this.Adj[vertex1][vertex2];
    }
}

public class Graph {
    public static void main(String args[]){
        int v = 4;
        int e = 4;
        int edges[][] = new int[4][3];
        edges[0][0] = 0;edges[0][1] = 1;edges[0][2] = 3;
        edges[1][0] = 0;edges[1][1] = 2;edges[1][2] = 2;
        edges[2][0] = 0;edges[2][1] = 3;edges[2][2] = 1;
        edges[3][0] = 1;edges[3][1] = 3;edges[3][2] = 4;
        GraphLinkList g1 = new GraphLinkList(4 ,4 , edges );
        g1.display();
    }
}
