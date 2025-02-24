import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.Stack;

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
    void breadthFirstSearch(){
        int status[] = new int[this.V];
        Vector<GraphNode> v1 = new Vector<>(this.V, 2);
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        for(int i=0;i<this.V;i++){
            status[i] = 0;
        }
        int vertex = 0;
        GraphNode temp = this.Adj[vertex];status[vertex] = status[vertex] + 1;
        GraphNode temp1;
        queue.add(temp);
        while(!queue.isEmpty()){
            temp = queue.remove();
            v1.add(temp);
            status[temp.vertex] = status[temp.vertex] + 1;
            temp1 = this.Adj[temp.vertex];
            while(temp1!=null){
                if(status[temp1.vertex]==0){
                    status[temp1.vertex] = status[temp.vertex] + 1;
                    queue.add(temp1);
                }
                temp1 = temp1.next;
            }
        }
        for(int i=0;i<v1.size();i++){
            System.out.print(v1.elementAt(i).vertex+" ");
        }
    }

    void defthFirstSearch(){
        int status[] = new int[this.V];
        Vector<GraphNode> v1 = new Vector<>(this.V, 2);
        Stack<GraphNode> ST = new Stack<>();
        for(int i=0;i<this.V;i++){
            status[i] = 0;
        }
        int vertex = 0;
        GraphNode temp = this.Adj[vertex];status[vertex] = status[vertex] + 1;
        GraphNode temp1;
        ST.push(temp);
        while(!ST.isEmpty()){
            temp = ST.pop();
            status[temp.vertex] = status[temp.vertex]+1;
            v1.add(temp);
            temp1 = this.Adj[temp.vertex];
            while(temp1!=null){
                if(status[temp1.vertex] == 0){
                    status[temp1.vertex] = status[temp1.vertex]+1;
                    ST.push(temp1);
                }
                temp1 = temp1.next;
            }
        }
        for(int i=0;i<v1.size();i++){
            System.out.print(v1.elementAt(i).vertex+" ");
        }
    }
}
public class BreadthFirstSearch {
    public static void main(String args[]){
        int edges[][] = new int[5][3];
        edges[0][0] = 0;edges[0][1] = 1;edges[0][2] = 3;
        edges[1][0] = 0;edges[1][1] = 2;edges[1][2] = 2;
        edges[2][0] = 1;edges[2][1] = 2;edges[2][2] = 1;
        edges[3][0] = 1;edges[3][1] = 3;edges[3][2] = 4;
        edges[4][0] = 3;edges[4][1] = 4;edges[4][2] = 8;
        
        GraphLinkList g1 = new GraphLinkList(5 ,5 , edges );
        // g1.breadthFirstSearch();
        g1.defthFirstSearch();
        return;

    }
}
