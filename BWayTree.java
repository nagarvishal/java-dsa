class BWayClass
{
    class BWayNode
    {
        int n;
        int array[];
        BWayNode pointer[];
        BWayNode(){
            this.n = 0;
            this.array = new int[m-1];
            this.pointer = new BWayNode[m];
            for(int i=0;i<m-1;i++)this.array[i] = -1;
            for(int i=0;i<m;i++)this.pointer[i] = null;
        }
    }
    int m = 5;
    BWayNode root = null;
    BWayNode splitnode(BWayNode root,int data){
        BWayNode temp = new BWayNode();
        BWayNode temp1 = new BWayNode();
        BWayNode temp2 = new BWayNode();
        int count = 0;
        boolean bool = false;
        for(int i=0; i<root.n; i++){
            if(count >= (int)(root.n)/2){
                if((bool == false) && (root.array[i] > data)){
                    temp2.array[temp2.n] = data;temp2.n = temp2.n + 1;
                    i--;
                }
                else{
                    temp2.array[temp2.n] = root.array[i];temp2.n = temp2.n+1;
                }
            }
            if(count == (int)(root.n)/2){
                if((bool == false) && (root.array[i] > data)){
                    temp.array[temp.n] = data;
                    temp.n = temp.n + 1;
                    bool = true;
                }
                else{
                    temp.array[temp.n] = root.array[i]; temp.n = temp.n + 1;
                }
            }
            else{
                if((bool == false) && (root.array[i] > data)){
                    temp1.array[temp1.n] = data;temp1.n = temp1.n + 1;
                    i--;
                    bool = true;

                }
                else{
                    temp1.array[temp1.n] = root.array[i];temp1.n = temp1.n+1;
                }
                
            }
        }
        for(int i=0;i<=(int)(root.n)/2;i++)temp1.pointer[i] = root.pointer[i];
        for(int i=((int)(root.n)/2)+1;i<=(int)(root.n);i++)temp2.pointer[i-(((int)(root.n)/2)+1)] = root.pointer[i];
        temp.pointer[temp.n-1] = temp1;
        temp.pointer[temp.n] = temp2;
        return temp;
        
    }
    BWayNode breakNode(BWayNode root,BWayNode temp,int i){
        int array1[] = new int[root.n+temp.n];
        BWayNode pointer[] = new BWayNode[root.n + 1 + temp.n+1];
        BWayNode temp1 = new BWayNode();
        BWayNode temp2 = new BWayNode();
        BWayNode temp3 = new BWayNode();
        if(i==0){
            int middle = (int)(root.n)/2;
            temp2.array[temp2.n] = temp.array[temp.n-1];temp2.n = temp2.n+1;
            temp2.pointer[temp2.n-1] = temp.pointer[temp.n-1];temp2.pointer[temp2.n] = temp.pointer[temp.n];
            for(int j=0; j<=middle; j++){
                temp2.array[temp2.n] = root.array[j]; temp2.pointer[temp2.n+1] = root.pointer[j];
            }
            for(int j=middle+1;j<root.n;j++){
                temp3.array[temp3.n] = root.array[j]; temp3.pointer[temp3.n] = root.pointer[j-1];
                temp3.n = temp3.n+1;
            }
            temp3.pointer[temp3.n] = root.pointer[root.n]; 

        }
        else if(i==root.n+1){
            int middle = (int)(root.n)/2;
            int middle = (int)(root.n)/2;
            temp2.array[temp2.n] = temp.array[temp.n-1];temp2.n = temp2.n+1;
            temp2.pointer[temp2.n-1] = temp.pointer[temp.n-1];temp2.pointer[temp2.n] = temp.pointer[temp.n];
            for(int j=0; j<=middle; j++){
                temp2.array[temp2.n] = root.array[j]; temp2.pointer[temp2.n+1] = root.pointer[j];
            }
            for(int j=middle+1;j<root.n;j++){
                temp3.array[temp3.n] = root.array[j]; temp3.pointer[temp3.n] = root.pointer[j-1];
                temp3.n = temp3.n+1;
            }
            temp3.pointer[temp3.n] = root.pointer[root.n]; 
        }
        else{
            int middle = (int)(root.n)/2;
            temp2.array[temp2.n] = temp.array[temp.n-1];temp2.n = temp2.n+1;
            temp2.pointer[temp2.n-1] = temp.pointer[temp.n-1];temp2.pointer[temp2.n] = temp.pointer[temp.n];
            for(int j=0; j<=middle; j++){
                temp2.array[temp2.n] = root.array[j]; temp2.pointer[temp2.n+1] = root.pointer[j];
            }
            for(int j=middle+1;j<root.n;j++){
                temp3.array[temp3.n] = root.array[j]; temp3.pointer[temp3.n] = root.pointer[j-1];
                temp3.n = temp3.n+1;
            }
            temp3.pointer[temp3.n] = root.pointer[root.n]; 
        }
        return null;
    }
    BWayNode insert(BWayNode root, int data){
        if(root == null){
            BWayNode temp = new BWayNode();
            temp.array[temp.n] = data; temp.n = temp.n + 1;
            return temp;
        }
        else{
            int i;
            for(i=0;i<=root.n;i++){
                if(i==0){
                    if(root.array[i] >= data){
                        if(root.pointer[i] != null){
                            BWayNode temp = this.insert(root.pointer[i], data);
                            if((temp.n + root.n) <= this.m && temp.n==1){
                                if(temp.n+root.n == this.m){
                                     return this.breakNode(root,temp,i);
                                }
                                else{
                                    root.array[i] = temp.array[temp.n-1]; root.pointer[i] = temp.pointer[temp.n-1];
                                    root.pointer[i+1] = temp.pointer[temp.n];
                                    temp.n = temp.n + 1;
                                    return root;
                                }
                            }
                            else{
                                root.pointer[i] = temp;return root;
                            }
                        }
                        else{
                            if(this.m-1 == root.n){
                                BWayNode temp = this.splitnode(root,data);
                                return temp;
                            } else{
                                for(int j=root.n;j>i;j--)root.array[j] = root.array[j-1];
                                for(int j=root.n+1;j>i;j--)root.pointer[j] = root.pointer[j-1];
                                root.n = root.n+1;
                                return root;
                            }
                        }
                    }
                }
                else if(i==root.n){
                    if(root.array[i-1] < data){
                        if(root.pointer[i] !=null){
                            BWayNode temp = this.insert(root.pointer[i], data);
                            if((temp.n + root.n) <= this.m && temp.n==1){
                                if(temp.n+root.n == this.m){
                                    return this.breakNode(root,temp,i);
                                }
                                else{
                                    for(int j=temp.n; j>i; j--)root.array[i] = root.array[i-1]; for(int j=temp.n+1;j>i;j--)root.pointer[j] = root.pointer[j-1];
                                    root.array[i] = temp.array[temp.n-1]; root.pointer[i] = temp.pointer[temp.n-1];
                                    root.pointer[i+1] = temp.pointer[temp.n]; temp.n = temp.n + 1;
                                    return root;
                                }
                            }
                            else{
                                root.pointer[i] = temp;return root;
                            }
                        }
                        else{
                            if(this.m-1 == root.n){
                                BWayNode temp = this.splitnode(root,data);
                                return temp;
                            }
                            else{
                                for(int j=root.n;j>i;j--)root.array[j] = root.array[j-1];
                                for(int j=root.n+1;j>i;j--)root.pointer[j] = root.pointer[j-1];
                                root.n = root.n+1;
                                return root;
                            }
                        }
                    }
                }
                else{
                    if(root.array[i-1] <= data && root.array[i] >= data){
                        if(root.pointer[i] != null){
                            BWayNode temp = this.insert(root.pointer[i], data);
                            if((temp.n + root.n) <= this.m && temp.n==1){
                                if(temp.n+root.n == this.m){
                                    return this.breakNode(root,temp,i);
                                }
                                else{
                                    for(int j=temp.n; j>i; j--)root.array[i] = root.array[i-1];
                                    for(int j=temp.n+1;j>i;j--)root.pointer[j] = root.pointer[j-1];
                                    root.array[i] = temp.array[temp.n-1];
                                    root.pointer[i] = temp.pointer[temp.n-1];
                                    root.pointer[i+1] = temp.pointer[temp.n];
                                    temp.n = temp.n + 1;
                                    return root;
                                }
                            }
                            else{
                                root.pointer[i] = temp;return root;
                            }
                        }
                        else{
                            if(this.m-1 == root.n){
                                BWayNode temp = this.splitnode(root,data);
                                return temp;
                            }else{
                                for(int j=root.n;j>i;j--)root.array[j] = root.array[j-1];
                                for(int j=root.n+1;j>i;j--)root.pointer[j] = root.pointer[j-1];
                                root.n = root.n+1;
                                return root;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    int findMax(BWayNode root){
        BWayNode temp = root;
        while(temp.pointer[temp.n]!=null){
            temp = temp.pointer[temp.n];
        }
        return temp.array[temp.n-1];
    }

    BWayNode operation(BWayNode root,int i)
    {

        return null;
    }
    BWayNode delete(BWayNode root, int data){
        if(root == null)return null;
        else{
            for(int i=0;i<=root.n;i++){
                if(i==0){
                    if(root.array[i] > data){
                        root.pointer[i] = this.delete(root.pointer[i],data);
                        return root;
                        
                    }
                    if(root.array[i] == data){
                        if(root.pointer[i] == null && root.pointer[i+1] == null){
                            if(root.n == 1)return null;
                            else{
                                for(int j=0;j<root.n-1;j++)root.array[j] =root.array[j+1]; for(int j=0;j<root.n;j++)root.pointer[j] = root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            } 
                        }
                        else if(root.pointer[i] != null && root.pointer[i+1] == null){
                            if(root.n == 1)return root.pointer[i];
                            else{
                                for(int j=i;j<root.n-1;j++)root.array[j] =root.array[j+1]; for(int j=i+1;j<root.n;j++)root.pointer[j] = root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                        }
                        else if(root.pointer[i] == null && root.pointer[i+1] != null){
                            if(root.n==1)return root.pointer[i+1];
                            else{
                                for(int j=i;j<root.n-1;j++)root.array[j] =root.array[j+1]; for(int j=i;j<root.n;j++)root.pointer[j] = root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                        }
                        else{
                            int maxdata = this.findMax(root);
                            root.array[i] = maxdata;
                            root.pointer[i] = this.delete(root.pointer[i],maxdata);
                            //perform operation at i
                            
                        }
                    }
                }
                else if(i == root.n){
                    if(root.array[i] > data){
                        return root;
                    }
                    
                }
                else{
                    if(root.array[i-1] < data && root.array[i] > data){
                        root.pointer[i] = this.delete(root.pointer[i],data);
                        return root;
                        // need to change
                    }
                    if(root.array[i] == data){
                        if(root.pointer[i] == null && root.pointer[i+1] == null){
                            if(root.n == 1)return null;
                            else{
                                for(int j=0;j<root.n-1;j++)root.array[j] =root.array[j+1]; for(int j=0;j<root.n;j++)root.pointer[j] = root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            } 
                        }
                        else if(root.pointer[i] != null && root.pointer[i+1] == null){
                            if(root.n == 1)return root.pointer[i];
                            else{
                                for(int j=i;j<root.n-1;j++)root.array[j] =root.array[j+1]; for(int j=i+1;j<root.n;j++)root.pointer[j] = root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                        }
                        else if(root.pointer[i] == null && root.pointer[i+1] != null){
                            if(root.n==1)return root.pointer[i+1];
                            else{
                                for(int j=i;j<root.n-1;j++)root.array[j] =root.array[j+1]; for(int j=i;j<root.n;j++)root.pointer[j] = root.pointer[j+1];
                                root.n = root.n-1;
                                return root;
                            }
                        }
                        else{
                            int maxdata = this.findMax(root);
                            root.array[i] = maxdata;
                            root.pointer[i] = this.delete(root.pointer[i],maxdata);
                        }
                    }
                }
            }
        }
    }
    boolean findData(BWayNode root, int data){
        return true;
    }

}
public class BWayTree {

}
