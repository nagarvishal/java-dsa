import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileOutputStream(File file)
 * Creates a file output stream to write to the file represented by the specified file object.
 * 
 * FileOutputStream(File file , boolean append)
 * Creates a file output stream to wirte to the file represent by the specified File object.
 * 
 * FileOutputStream(String name)
 * Creates a file output stream to write to the file with the specified name.
 * 
 * FileOutputStream(String name , boolean append)
 * Creates a file output stream to wirte to the file with the specified name.
 * 
 * 
 */

public class FileHandling {
    public static void main(String args[]) throws IOException
    {
        // File f1 = new File("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt");
        // System.out.println("Can file Read "+f1.canWrite());
        // System.out.println("Is File Exist "+f1.exists());
        // System.out.println("File name "+f1.getName());
        // System.out.println("Length of file "+f1.length());

        // File f1 = new File("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt");
        // f1.createNewFile();
        // f1.delete();

        // f1.

        // try{
            // FileWriter writer = new FileWriter("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt");
            // writer.write("console log is very common for now i am flee");
            // writer.close();

            // FileReader reader = new FileReader("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt");
            // int ch;
            // while ((ch = reader.read()) != -1) {
            //     System.out.print((char) ch);
            // }
            // reader.close();
            // return;

            // String data = "Hello, this is a FileOutputStream example in Java.";
            // FileOutputStream fos = new FileOutputStream("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile_1.txt");
            
            // byte[] byteData = data.getBytes();

            // fos.write(byteData);
            // fos.close();

            // System.out.println("Data successfully written to the file.");

            // BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

            // String data = "Hello , this is a buffer wirter example in java";
            // BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile_1.txt"));

            // writer.write(data);
            // writer.newLine();
            // writer.write("This is a new line added \n\n using BufferedWriter.");
            // writer.close();

            // System.out.println("Data successfully written to the file.");

            // String sourceFile = "/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt";   // Source file
            // String destinationFile = "/Users/nagarvishal19/Desktop/JAVA_DSA/myfile_1.txt";  // Destination file

             // Step 1: Open FileInputStream to read the source file
            // FileInputStream fis = new FileInputStream(sourceFile);

            // Step 2: Open FileOutputStream to write to the destination file
            // FileOutputStream fos = new FileOutputStream(destinationFile);

            // Step 3: Create a buffer to store read data
            // byte[] buffer = new byte[1024]; // 1KB buffer
            // int bytesRead;

            // while((bytesRead = fis.read(buffer)) == -1){
            //     fos.write(buffer);
            // }

            // fis.close();
            // fos.close();


            // System.out.println("mayank agrawal");

            // FileOutputStream fout = new FileOutputStream("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt",true);
            // String s = "\nRatan Tata is a good person";
            // char ch[] = s.toCharArray();
            // for(int i=0;i<s.length();i++){
            //     fout.write(ch[i]);
            // }
            // fout.close();
            

            // int i;
            // String s1 = "";

            // FileInputStream fin = new FileInputStream("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt");
            // do{
            //     i = fin.read();
            //     if(i!=-1){
            //         s1 = s1 + (char)i;
            //     }
            // }while(i!=-1);
            // System.out.println(s1);
            // fin.close();
        // }catch(IOException e){
        //     System.out.println("An error occurred while writing to the file.");
        //     e.printStackTrace();
        // }


        /** Buffered Writer */
        /** Writes text to a character-output stream , buffering charactors so as to provide for the efficient writing of single charactors , arrays , and strings.
         * The buffer size may be specified , or the default size may be accepeted. The default is large enough for most purpose.
         * 
         * BufferedWriter(Writer out)
         * Creates a buffered character - output stream that uses a default - sized output buffer.
         * 
         * BufferedWriter(Writer out , int sz)
         * Creates a new buffered character - output stream that uses an output buffer of the given size.
         */

        //  BufferedWriter bf = new BufferedWriter(new FileWriter("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile_1.txt" , true));
        //  bf.write("computer\n");
        //  bf.close();

        /** BufferedReader (Reader in) */
        /** Creates a buffering charactor - input stream that uses a default size input buffer.  */

        // BufferedReader bf = new BufferedReader(new FileReader("/Users/nagarvishal19/Desktop/JAVA_DSA/myfile.txt"));
        // int ch;
        // String s1 = "";
        // while((ch=bf.read())!=-1){
        //     // System.out.print((char)ch);
        //     s1 = s1 + (char)ch;
        // }
        // bf.close();
        // System.out.println(s1);

        // String s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);
        // s2 = bf.readLine();
        // System.out.println(s2);



        /** BufferedReader (Reader in, int sz) */
        /** Creates a buffering charactors-input stream that uses an input buffer of the specified size. */

        
    }


}
