import java.io.FileWriter;
import java.io.IOException;
public class main4 {
    public static void main(String[] args){
        try{
            FileWriter fw=new FileWriter("filename.txt");
            fw.write("Files in java might be tricky.");
            fw.close();
            System.out.println("Succesfully wrote to the file.");
        }
        catch(IOException e){
            System.out.println("An error as occured:");
            e.printStackTrace();
        }
    }
}
    
