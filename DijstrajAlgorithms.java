import java.util.Vector;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;



class Graph
{
    class heapnode
    {
        int vertex;
        int parent;
        int cost;
        heapnode(int vertex1, int vertex2, int cost){
            this.vertex = vertex1;
            this.parent = vertex2;
            this.cost = cost;   
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

    void swapping(heapnode harray[], int index1, int index2)
    {
        heapnode temp = harray[index1];
        harray[index1] = harray[index2];
        harray[index2] = temp;
        return;
    }
    void h_update(heapnode harray[],int n,int vertex,int cost,int parent,int parentcost){
        int index = -1;
        for(int i=0;i<n;i++){
            if(harray[i].vertex == vertex){
                index = i;
                break;
            }
        }
        if(index!=-1){
            if(harray[index].cost > cost+parentcost){
                harray[index].cost = cost + parentcost;
                harray[index].parent = parent;
                while(index>0){
                    if(harray[index].cost > harray[(int)(index-1)/2].cost){
                        this.swapping(harray,index,(int)(index-1)/2);
                        index = (int)(index-1)/2;
                    }
                    else{
                        break;
                    }
                }

            }
        }
    }

    heapnode h_delete(heapnode harray[],int n){
        int index=0;
        heapnode temp = harray[index];
        harray[index] = harray[n-1];
        n = n-1;
        while(2*index+1<=n-1){
            if(2*index+1==n-1){
                if(harray[2*index+1].cost < harray[index].cost){
                    this.swapping(harray, index, 2*index+1);
                    index = 2*index+1;
                }
                else{
                    break;
                }
            }
            else{
                if((harray[2*index+1].cost < harray[index].cost) || (harray[2*index+2].cost < harray[index].cost))
                {
                    if(harray[2*index+1].cost < harray[2*index+2].cost){
                        this.swapping(harray,index,2*index+1);
                        index = 2*index+1;
                    }
                    else{
                        this.swapping(harray,index,2*index+2);
                        index = 2*index+2;
                    }
                }
                else{
                    break;
                }
            }
        }

        return temp;
    }
    void DijstrajAlgo(){
        heapnode h1[] = new heapnode[this.V];
        Vector<heapnode> edges = new Vector<>();

        for(int i=0;i<this.V;i++){
            if(i==0){
                h1[i] = new heapnode(i,-1,0);
            }
            else{
                h1[i] = new heapnode(i,-1,10000000);
            }
        }
        int n=this.V;
        while(n>0){
            heapnode temp = this.h_delete(h1,n);
            edges.add(temp);
            GraphNode temp1 = this.Adj[temp.vertex];
            while(temp1!=null){
                this.h_update(h1,n, temp1.vertex, temp1.cost, temp.vertex, temp.cost);
                temp1 = temp1.next;
            }
        }

        
        return;
    }
}

public class DijstrajAlgorithms
{
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

    }
}
