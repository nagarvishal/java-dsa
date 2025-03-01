package DynamicProgramming;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

class Solution {
    String trimZero(String str)
    {
        boolean temp = true;
        String str2 = "";
        for(int i=0;i<str.length();){
            if(str.charAt(i) == '0' && temp == true){
                i++;
            }
            else{
                temp = false;
                str2 = str2 + str.charAt(i);
                i++;
            }
        }
        if(str2.length()==0)return "0";
        return str2;
    }
    public String multiply(String num1, String num2) {
        Vector<Vector<Integer>> v1 = new Vector<Vector<Integer>>();
        Vector<Integer> v2;
        int reminder = 0;
        for(int i=num2.length()-1;i>=0;i--){
            reminder = 0;
            v2 = new Vector<Integer>();
            for(int j=num1.length()-1;j>=0;j--){
                int data = (((int)num1.charAt(j)-48)*((int)num2.charAt(i)-48))+reminder;
                v2.add((data)%10);
                reminder = (int)data/10;
            }
            while(reminder>0){
                v2.add(reminder%10);reminder = (int)reminder/10;
            }
            v1.add(v2);
        }
        for(int i=0;i<v1.size();i++) for(int j=1;j<=i;j++) v1.get(i).addFirst(0);
        int maxlength = -1;
        for(int i=0;i<v1.size();i++){
            if(v1.get(i).size() > maxlength){
                maxlength = v1.get(i).size();
            }
        }

        Vector<Integer> vec = new Vector<Integer>();
        reminder = 0;
        int sum = 0;
        for(int i=0;i<maxlength;i++){
            sum = 0;
            for(int j=0;j<v1.size();j++){
                if(i < v1.get(j).size()){
                    sum = sum + v1.get(j).get(i);
                }
            }
            vec.add((sum+reminder)%10); reminder = (int)(reminder+sum)/10;
        }
        while(reminder>0){
            vec.add((reminder)%10); reminder = (int)reminder/10;
        }
        Collections.reverse(vec);
        String s1 = "";
        for(int i=0;i<vec.size();i++){
            s1 = s1 + vec.get(i)+"";
        }
        return trimZero(s1);
    }
}

public class MultiplyingString {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String num1 = sc.nextLine();
        String num2 = sc.nextLine();
        Solution s1 = new Solution();
        String num3 = s1.multiply(num1, num2);
        System.out.println(num3);
        return;
    }
}
