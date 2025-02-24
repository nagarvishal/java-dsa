
class Mwayclass
{
    int m;
    class MWayNode
    {
        int array[];
        int n;
        MWayNode pointer[];
        MWayNode(){
            this.n = 0;
            this.array = new int[m-1];
            for(int i=0;i<m-1;i++)this.array[i] = -1;
            for(int i=0;i<m;i++){
                this.pointer[i] = null;
            }
        }
    }
    MWayNode root;
    boolean find(MWayNode root,int data) {
        if(root==null)return false;
        else{
            for(int i=0;i<=root.n;i++){
                if(i==0){
                    if(root.array[i] == data) return true;
                    if(root.array[i] > data){
                        return this.find(root.pointer[i],data);
                    }                    
                }
                else if(i==root.n){
                    if(root.array[i-1] < data){
                        return this.find(root.pointer[i],data);  
                    }
                }
                else{
                    if(root.array[i] == data)return true;
                    if(root.array[i-1] < data && root.array[i] > data){
                        return this.find(root.pointer[i],data);
                    }
                }
            }
            return true;
        }
    }
    int findMax(MWayNode root){
        MWayNode temp = root;
        while(temp.pointer[temp.n]!=null) temp = temp.pointer[temp.n];
        return temp.array[temp.n-1];
    }
    MWayNode delete(MWayNode root,int data){
        if(root==null)return null;
        else{
            for(int i=0;i<=root.n;i++){
                if(i==0){
                    if(root.array[i] == data){
                        if(root.pointer[i] != null && root.pointer[i+1]!=null) {
                            int maxdata = this.findMax(root);
                            root.array[i] = maxdata;
                            root.pointer[i] = this.delete(root.pointer[i], maxdata);
                            return root;
                        }
                        else if(root.pointer[i]==null && root.pointer[i+1]!=null) {
                            if(root.n==1)return root.pointer[i+1];
                            else{
                                for(int j=i;j<root.n-1;j++)this.root.array[j] = this.root.array[j+1];
                                for(int j=i+1;j<root.n;j++)this.root.pointer[j] = this.root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                        }
                        else if(root.pointer[i]!=null && root.pointer[i+1]==null) {
                            if(root.n==1)return root.pointer[i];
                            else{
                                for(int j=i;j<root.n-1;j++)this.root.array[j] = this.root.array[j+1];
                                for(int j=i+1;j<root.n;j++)this.root.pointer[j] = this.root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                        }
                        else {
                            if(root.n==1) return null;
                            else{
                                for(int j=i;j<root.n-1;j++)this.root.array[j] = this.root.array[j+1];
                                for(int j=i;j<root.n;j++)this.root.pointer[j] = this.root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                            
                        }
                    }
                    if(root.array[i] > data){
                        root.pointer[i] =  this.delete(root.pointer[i], data);
                        return root;
                    }
                }
                else if(i==root.n){
                    if(root.array[i-1] < data){
                        root.pointer[i] = this.delete(root.pointer[i],data);
                        return root;
                    }
                }
                else{
                    if(root.array[i] == data){
                        if(root.pointer[i] != null && root.pointer[i+1]!=null) {
                            int maxdata = this.findMax(root);
                            root.array[i] = maxdata;
                            root.pointer[i] = this.delete(root.pointer[i], maxdata);
                            return root;
                        }
                        else if(root.pointer[i]==null && root.pointer[i+1]!=null) {
                            for(int j=i;j<root.n-1;j++)this.root.array[j] = this.root.array[j+1];
                            for(int j=i+1;j<root.n;j++)this.root.pointer[j] = this.root.pointer[j+1];
                            root.n = root.n-1;
                            return root;
                        }
                        else if(root.pointer[i]!=null && root.pointer[i+1]==null) {
                            for(int j=i;j<root.n-1;j++)this.root.array[j] = this.root.array[j+1];
                            for(int j=i+1;j<root.n;j++)this.root.pointer[j] = this.root.pointer[j+1];
                            root.n = root.n-1;
                            return root;
                        }
                        else {
                            for(int j=i;j<root.n-1;j++)this.root.array[j] = this.root.array[j+1];
                            for(int j=i;j<root.n;j++)this.root.pointer[j] = this.root.pointer[j+1];
                            root.n = root.n-1;
                            return root;
                        }
                    }
                    if(root.array[i-1] < data && root.array[i+1] > data){
                        root.pointer[i] = this.delete(root.pointer[i],data);
                        return root;
                    }
                }
            }
        }
        return root;
    }
    MWayNode insert(MWayNode root,int data){
        if(root == null){
            MWayNode temp = new MWayNode();
            temp.n = temp.n+1;
            temp.array[temp.n-1] = data;
            return temp;
        }
        else{
            if(root.n == m-1){
                for(int i=0;i<=root.n;i++){
                    if(i==0){
                        if(data < root.array[i]){
                            root.pointer[i] = this.insert(root.pointer[i], data); return root;
                        }
                    }
                    else if(i==root.n){
                        if(data > root.array[i-1]){
                            root.pointer[i] = this.insert(root.pointer[i], data); return root;
                        }
                    }
                    else{
                        if(data > root.array[i-1] && data < root.array[i]){
                            root.pointer[i] = this.insert(root.pointer[i], data); return root;
                        }
                    }
                }
            }
            else{
                for(int i=0;i<=root.n;i++){
                    if(i==0){
                        if(data < root.array[i]){
                            if(root.pointer[i] == null){
                                for(int j=root.n;j>i;j--){ root.array[j] = root.array[j-1]; }
                                for(int j=root.n+1;j>0;j++){ root.pointer[j] = root.pointer[j-1]; }
                                root.array[i] = data;
                                root.n = root.n+1;
                                return root;
                            }
                            else{
                                root.pointer[i] = this.insert(root.pointer[i], data);
                                return root;
                            }
                        }
                    }
                    else if(i==root.n){
                        if(data > root.array[i-1]){
                            if(root.pointer[i] == null){
                                root.array[i] = data;
                                root.n = root.n+1;
                                return root;
                            }
                            else{
                                root.pointer[i] = this.insert(root.pointer[i],data);
                                return root;
                            }
                        }
                    }
                    else{
                        if(data > root.array[i-1] && data < root.array[i]){
                            if(root.pointer[i] == null){
                                for(int j=root.n;j>i;j--) root.array[j] = root.array[j-1];
                                for(int j=root.n+1;j>i;j--) root.pointer[j] = root.pointer[j-1];
                                root.n = root.n + 1;
                                root.array[i] = data;
                                return root;
                            }
                            else{
                                root.pointer[i] = this.insert(root.pointer[i],data);
                                return root;
                            }
                        }
                    }
                }
            }
            return new MWayNode();
        }
    }


}

public class MwayTree {

}
