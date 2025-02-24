import java.util.*;

class Student
{
    String name;
    int age;
    String rollno;
    public void setData(String name,int age,String rollno){
        this.name = name;
        this.age = age;
        this.rollno = rollno;
    }
    public void displayData(){
        System.out.println(this.name);
        System.out.println(this.age);
        System.out.println(this.rollno);
    }
}

class SortByAge implements Comparator<Student>
{
     // Compare by roll number in ascending order
     public int compare(Student a,Student b){
        return a.age - b.age;
     }
}
public class Practice
{
    public static void main(String args[]){

        ArrayList<List<Integer> > listOfLists = new ArrayList<List<Integer> >(); 
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(3);
        l1.add(6);
        l1.add(9);
        l1.add(9);
        l1.add(2);
        l1.add(9);
        listOfLists.add(l1);
        listOfLists.add(l1);
        listOfLists.add(l1);
        listOfLists.add(l1);
        listOfLists.add(l1);
        
        // List<Student> s1 = new ArrayList<>();
        // s1.add(new Student());s1.get(0).setData("vishal", 18, "191139");
        // s1.add(new Student());s1.get(1).setData("keshave", 19, "191130");
        // s1.add(new Student());s1.get(2).setData("mayank", 12, "191131");
        // s1.add(new Student());s1.get(3).setData("vishnu", 24, "191120");
        // s1.add(new Student());s1.get(4).setData("deepak", 30, "191156");
        // s1.add(new Student());s1.get(5).setData("rahul", 10, "191190");

        // Collections.sort(s1, new SortByAge());
        // for(int i=0;i<s1.size();i++){
        //     System.out.println(s1.get(i).age);
        // }


        // List<String> l1 = new ArrayList<>();
        // l1.add("vishal nagar");
        // l1.add("mayank agrawal");
        // l1.add("deepak nagar");
        // l1.add("manoj nagar");
        // l1.add("rahul nagar");
        // l1.add("khusi nagar");
        // for(String s : l1){
        //     System.out.println(s);
        // }
        // System.out.println(l1.size());
        // for(int i=0;i<l1.size();i++){
        //     System.out.println(l1.get(i));
        // }

        // System.out.println(l1.get(1));
        // System.out.println(l1.size());
        // l1.set(1,"Keshave Nagar");
        // System.out.println(l1.get(1));
        // System.out.println(l1.size());

        // System.out.println(l1.indexOf("manoj nagar"));
        // System.out.println(l1.indexOf("khusi nagar"));
        // System.out.println(l1.lastIndexOf("khusi nagar"));
        // System.out.println(l1.lastIndexOf("mayank agrawal"));
        // System.out.println(l1.indexOf("vishal nagar"));
        // System.out.println(l1.lastIndexOf("vishal nagar"));

        // System.out.println(l1.contains("rahul nagar"));
        // System.out.println(l1.contains("khusi meena"));
        // System.out.println(l1.contains("rahul kumar"));
        // System.out.println(l1.contains("khusi agrawal"));
        // l1.remove(0);
        // l1.remove(1);
        // for(int i=0;i<l1.size();i++){
        //     System.out.println(l1.get(i));
        // }
        // System.out.println(l1.hashCode());

    }
}