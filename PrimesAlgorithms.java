import java.util.Vector;

class Graph
{
    int V;
    int E;
    int INF = 100000000;
    class GraphNode
    {
        int vertex;
        int cost;
        GraphNode next;
        GraphNode(int vertex,int cost)
        {
            this.vertex = vertex;
            this.cost = cost;
            this.next = null;
        }
    }

    class heap
    {
        int vertex;
        int cost;
        int parent;
        heap(int vertex,int cost,int parent)
        {
            this.vertex = vertex;
            this.cost = cost;
            this.parent = parent;
        }
    }
    GraphNode Adj[];
    Graph(int V){
        this.V = V;
        this.E = 0;
        this.Adj = new GraphNode[this.V];
        for(int i=0;i<this.V;i++){
            this.Adj[i] = null;
        }
    }
    void insert(int vertex1,int vertex2,int cost)
    {
        GraphNode temp = new GraphNode(vertex2,cost);temp.next = this.Adj[vertex1];this.Adj[vertex1]=temp;
        temp = new GraphNode(vertex1,cost);temp.next = this.Adj[vertex2];this.Adj[vertex2]=temp;
        return;
    }
    void showGraph(){
        GraphNode temp;
        for(int i=0;i<this.V;i++){
            System.out.print(i);
            temp = this.Adj[i];
            while(temp!=null){
                System.out.println(" ("+temp.vertex+" , "+temp.cost+") ");
                temp = temp.next;
            }
        }
        return;
    }
    void swapping(heap harray[],int index1,int index2)
    {
        heap temp = harray[index1];
        harray[index1] = harray[index2];
        harray[index2] = temp;
        return;
    }

    heap h_delete(heap harray[],int size)
    {
        heap temp = harray[0];
        int index = 0;harray[index] = harray[size-1];
        size = size-1;
        while(2*index+1<=size-1){
            if(2*index+1==size-1){
                if(harray[index].cost > harray[2*index+1].cost){
                    this.swapping(harray,index,2*index+1);
                    index = 2*index+1;
                }
                else{
                    break;
                }
            }
            else{
                if(harray[index].cost > harray[2*index+1].cost || harray[index].cost > harray[2*index+2].cost ){
                    if(harray[2*index+1].cost > harray[2*index+2].cost){
                        this.swapping(harray,index,2*index+2);
                        index = 2*index+2;
                    }
                    else{
                        this.swapping(harray,index,2*index+1);
                        index = 2*index+1;
                    }
                }
                else{
                    break;
                }
            }
        }
        return temp;
    }


    void updateheap(heap harray[],int n,int vertex1,int cost,int parent)
    {
        int index = -1;
        for(int i=0;i<n;i++){
            if(harray[i].vertex == vertex1){
                index = i;
                break;
            }
        }
        if(index != -1){
            if(harray[index].cost > cost){
                harray[index].cost = cost;
                harray[index].parent = parent;
                while(index>0){
                    if(harray[index].cost < harray[(int)(index-1)/2].cost){
                        this.swapping(harray,index,(int)(index-1)/2);
                        index = (int)(index-1)/2;
                    }
                    else{
                        break;
                    }
                }
            }
            return;
        }
    }
    void PrimseAlgorithms()
    {
        heap harray[] = new heap[this.V];
        Vector<heap> edges = new Vector<>(); 

        for(int i=0;i<this.V;i++){
            if(i==0){
                harray[i] = new heap(i,0,-1);
            }
            else{
                harray[i] = new heap(i,this.INF,-1);
            }
        }
        int n = this.V;
        while(n>0){
            heap temp = this.h_delete(harray,n);
            n = n-1;
            edges.add(temp);
            GraphNode temp1 = this.Adj[temp.vertex];
            while(temp1!=null){
                this.updateheap(harray,n,temp1.vertex,temp1.cost,temp.vertex);
                temp1 = temp1.next;
            }

        }

        for(int i=0;i<edges.size();i++){
            System.out.print(edges.get(i).vertex+" "+edges.get(i).cost+" "+edges.get(i).parent);
            System.out.print("\n");
        }

        Graph g2 = new Graph(this.V);
        for(int i=0;i<edges.size();i++){
            if(i!=0){
                g2.insert(edges.get(i).vertex,edges.get(i).parent,edges.get(i).cost);
            }
        }

    }
}
public class PrimesAlgorithms {
    public static void main(String args[])
    {
        Graph g1 = new Graph(6);
        g1.insert(0,1,3);
        g1.insert(0,2 ,4);
        g1.insert(1,2,3);
        g1.insert(1,4,4);
        g1.insert(1,3,7);
        g1.insert(2,3,4);
        g1.insert(4,3,2);
        g1.insert(4,5,6);
        g1.insert(5,3,1);

        // g1.showGraph();
        g1.PrimseAlgorithms();
        // g1.showGraph();
        

        return;
    }
}
