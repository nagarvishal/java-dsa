import java.util.Vector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Graph
{
    class Edges implements Comparable<Edges>
    {
        int vertex1;
        int vertex2;
        int cost;
        Edges(int vertex1, int vertex2, int cost){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.cost = cost;   
        }
        @Override
        public int compareTo(Edges edge) {
            return Integer.compare(this.cost, edge.cost);  // Ascending order
        }
    }
    class GraphNode
    {
        int vertex;
        int cost;
        GraphNode next;
        GraphNode(int vertex , int cost){
            this.vertex = vertex;
            this.cost = cost;
            this.next = null;
        }
    }
    int V;
    int E;
    GraphNode Adj[];
    Graph(int V){
        this.V = V;
        this.E = 0;
        this.Adj = new GraphNode[this.V];
        for(int i=0;i<this.V;i++){
            this.Adj[i] = null;
        }
    }
    void addEdge(int vertex1, int vertex2, int cost)
    {
        this.E = this.E + 1;
        GraphNode temp = new GraphNode(vertex2,cost);temp.next = this.Adj[vertex1];this.Adj[vertex1] = temp;
        temp = new GraphNode(vertex1,cost);temp.next = this.Adj[vertex2];this.Adj[vertex2] = temp;
        return;
    }
    void showGraph(){
        for(int i=0;i<this.V;i++){
            GraphNode temp = this.Adj[i];
            System.out.print(i+" => ");
            while(temp!=null){
                System.out.print("("+temp.vertex+" "+temp.cost+")");
                temp = temp.next;
            }
            System.out.print("\n");
        }
    }

    int findset(Set<Integer>[] s1,int vertex1)
    {
        for(int i=0;i<this.V;i++){
            if(s1[i].contains(vertex1)){
                return i;
            }
        } 
        return -1;
    }
    void mergeSet(Set<Integer>[] s1,int index1, int index2)
    {
        if(s1[index1].size() > s1[index2].size()){
            s1[index1].addAll(s1[index2]);
            s1[index2].clear();
        }
        else{
            s1[index2].addAll(s1[index1]);
            s1[index2].clear();
        }
    }
    void dijkstrajAlgo(){
        Vector<Edges> edges = new Vector<>(); 
        Vector<Edges> edges1 = new Vector<>();
        for(int i=0;i<this.V;i++){
            GraphNode temp = this.Adj[i];
            while(temp!=null){
                if(temp.vertex <= i){
                    edges.add(new Edges(temp.vertex,i,temp.cost));
                }
                temp = temp.next;
            }
        }
        Collections.sort(edges);
        Set<Integer>[] setArray = new HashSet[this.V];
        for(int i=0;i<this.V;i++){
            setArray[i] = new HashSet<>(); setArray[i].add(i);
        }
        int vertex1,vertex2,set1,set2;
        for(int i=0;i<edges.size();i++){
            vertex1 = edges.get(i).vertex1;
            vertex2 = edges.get(i).vertex2;
            set1 = this.findset(setArray, vertex1);set2 = this.findset(setArray, vertex2);
            if(set1!=set2){
                edges1.add(edges.get(i));
            }
        }
        Graph G2 = new Graph(this.V);
        for(int i=0;i<edges1.size();i++){
            G2.addEdge(edges1.get(i).vertex1, edges.get(i).vertex2, edges.get(i).cost);
        }
        G2.showGraph();
        return;
    }
}

public class DijkstrajAlgo {
    public static void main(String args[])
    {
        Graph G1 = new Graph(5);
        G1.addEdge(0,1, 1);
        G1.addEdge(2,3, 4);
        G1.addEdge(1,4, 2);
        G1.addEdge(3,4, 7);
        G1.addEdge(0,3, 1);
        G1.addEdge(2,4, 7);
        G1.showGraph();
        G1.dijkstrajAlgo();
        return;
    }
}
