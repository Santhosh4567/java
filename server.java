import java.io.*;
import java.net.*;
public class server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server started... Waiting for client...");
            Socket socket = serverSocket.accept();
            System.out.println("Connected to: " + socket.getInetAddress());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in));
            while (true) {
                String data = in.readLine();
                if (data.equalsIgnoreCase("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.println("Client: " + data);

             
                System.out.print("You: ");
                String msg = userInput.readLine();
                out.write(msg);
                out.newLine();   
                out.flush();
            }
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}