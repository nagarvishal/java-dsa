package Genelization;

/** Important Rule - 
 *  Type Perameters can represent only reference types , not premitive types (like int , double and char) 
 */


class Example
{

    class myclass
    {

    }


    public <E1 , E2> E1 printArray(E1 arr[]){ /** E1 can replace only non-premitive type data - reference type not premitive type. */
        for( E1 values :arr ) System.out.print(values+" ");
        
        System.out.println("\n");
        return arr[0];
    }
}



public class GenericMethod {
    public static void main(String args[]){
        String arr[] = new String[]{"india","pakistahan","usa","nepal","shrilanka"};
        Example e1 = new Example();
        Integer numbers[] = {12, 34, 56 , 77};
        int integers[] = new int[]{1,2,3,4};

        e1.printArray(arr);
        e1.printArray(numbers);

        // e1.printArray(integers);  // Type Perameters can represent only reference types , not premitive types (like int , double and char) 





        return;
    }
}
