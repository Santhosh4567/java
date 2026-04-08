import java.io. BufferedWriter;
import java.io.FileWriter;
public class main1class {
    public static void main(String[]args){
        try{
            FileWriter fw=new FileWriter("output.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("hey Man");
            bw.newLine();
            bw.write("okay");
            bw.close();
            System.out.println("success");


        }catch(Exception e){
            System.out.println("error");       
         }
    }
    
}
