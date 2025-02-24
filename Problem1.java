/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the run-length encoding of countAndSay(n - 1).
Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".

Given a positive integer n, return the nth element of the count-and-say sequence.
 */

import java.util.Scanner;
class Solution {
    public String countAndSay(int n) {
        String s1 = "1";
        String s2;
        char c;
        int j,k,count;
        for(int i=1;i<n;i++){
            j=0;
            s2 = "";
            while(j<s1.length()){
                c = s1.charAt(j);
                count = 1;
                for(k=j+1;k<s1.length();k++){
                    if(s1.charAt(k) == c){
                        count = count + 1;  
                    }
                    else{
                        break;
                    }
                }
                j = k;
                s2 = s2+count+c;
            }
            s1 = s2;
            s2 = "";
        }
        return s1;
    }
}



public class Problem1
{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();

        // Solution s1 = new Solution();
        // String s2 = s1.countAndSay(n);
        // System.out.println(s2);
        // int n = sc.nextInt();
        // int arr[] = new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i] = sc.nextInt();
        // }
    }
}