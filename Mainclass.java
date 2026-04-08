import java.io.FileWriter;
public class Mainclass {
    public static void main(String[]args){
        try{
            FileWriter fw = new FileWriter("output.txt",true);
            fw.append("Mann");
            fw.close();
            System.out.println("Success");
        }catch(Exception e){
            System.out.println("Something has happened");
        }
    }
}
