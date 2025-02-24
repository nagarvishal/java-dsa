




public class LengthOfLastword {
    public static void main(String args[]){
        String s = "Hello   world   ";
        String s2 = "";
        int index=-1;

        
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i-1) == ' ' && s.charAt(i) != ' '){
                index = i;
                break;
            }
        }

        if(index!=-1){
            for(int j=index;j< s.length() && s.charAt(j) != ' ';j++){
                s2 = s2  + s.charAt(j);
            }
        }
        System.out.println(s2);
       
    }
}
