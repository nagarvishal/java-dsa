package DynamicProgramming;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {

    class hashtable
    {
        int index;
        String str;

        hashtable(int index,String str){
            this.index = index;
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            this.str = new String(chars);
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        hashtable arr[] = new hashtable[strs.length];
        for(int i=0;i<strs.length;i++) arr[i] = new hashtable(i, strs[i]);

        Arrays.sort(arr, new Comparator<hashtable>() {
            @Override
            public int compare(hashtable p1, hashtable p2) {
                return p1.str.compareTo(p2.str);
            }
        });

        List<List<String>> liststr = new ArrayList<List<String>>();
        List<String> l1;
        int j;
        for(int i=0;i<arr.length;){
            l1 = new ArrayList<String>();l1.add(strs[arr[i].index]);
            for(j=i+1;j<arr.length;j++){
                if(arr[i].str.compareTo(arr[j].str)==0){
                    l1.add(strs[arr[j].index]);
                }
                else{
                    i = j;break;
                }
            }
            liststr.add(l1);
            if(j==arr.length){
                break;
            }
        }
        return liststr;
    }
    
}
public class GroupAnagram {
    public static void main(String args[])
    {
        Scanner s1 = new Scanner(System.in);
        String str[] = new String[5];
        for(int i=0;i<5;i++){
            str[i] = s1.nextLine();
        }


        Solution s = new Solution();
        s.groupAnagrams(str);

        return;   
    }
}
