import java.io.File;
import java.io.IOException;

public class main3class {
    public static void main(String[]args){
        try{
            File myObj=new File("filename.txt");
            if(myObj.createNewFile()){
                System.out.println("File created:" + myObj.getName());


            }else{
                System.out.println("file already exists");
            }

        } catch(IOException e){
            System.out.println("error occured:");
            e.printStackTrace();

        }
    }
    
}
