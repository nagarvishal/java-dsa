import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class Group
{
    class Subgroup implements Comparable<Subgroup>
    {
        String str;
        int index;

        @Override
        public int compareTo(Subgroup other) {
            return this.str.compareTo(other.str); // Compare names lexicographically
        }
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Group.Subgroup[] arrsg = new Subgroup[n];
        for(int i=0;i<n;i++){
            arrsg[i] = new Subgroup();
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            arrsg[i].str = new String(charArray);
            arrsg[i].index = i;
        }
        Arrays.sort(arrsg);

        List<List<String>> al1 = new ArrayList<List<String>>();
        List<String> al;
        int i,j;

        for(i=0;i<arrsg.length;i++){
            al = new ArrayList<>();
            al.add(arrsg[i].str);
            for(j=i+1;j<arrsg.length;j++){
                if(arrsg[i].str == arrsg[j].str){
                    al.add(arrsg[j].str); 
                }
                else{
                    break;
                }
            }
            al1.add(al);
        }

        return al1;   
    }
}
public class Graphanagram {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        String ptr[] = new String[n];
        for(int i=0;i<n;i++){
            ptr[i] = sc.next();
        }

        System.out.println(n);
        for(int i=0;i<n;i++){
            System.out.println(ptr[i]);
        }

        Group g1 = new Group();
        g1.groupAnagrams(ptr);

        
        // al.add("vishal");
        // al.add("keshave");
        // al.add("mayank");
        // System.out.println(al);

        // List<List<String>> al1 = new ArrayList<List<String>>();
        // al1.add(al);
        // System.out.println(al1);
        return;
    }
}
