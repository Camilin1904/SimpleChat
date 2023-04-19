import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) {
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input the port");
            int port = Integer.parseInt(brr.readLine());
            ServerSocket comsCentral = new ServerSocket(port);
            ArrayList<Socket> clientSockets = new ArrayList<>();
            while (true){
                Socket senderSocket = comsCentral.accept();
                System.out.println("jijijija");
                if(clientSockets.size()<100){
                    if (!clientSockets.contains(senderSocket))clientSockets.add(senderSocket);
                }
                Handler handler = new Handler(senderSocket,clientSockets);
                handler.start();
            }
        } 
        catch (Exception e) {
            System.out.println("Pito");
        }
    }
}
