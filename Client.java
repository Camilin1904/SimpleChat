import java.io.*;
import java.net.*;

public class Client{
    public static void main(String[] args) {
        BufferedReader brr = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input server direction:");
            String dir = brr.readLine();
            System.out.println("Input your nickname");
            String nickname = brr.readLine();
            InetAddress serverHost = InetAddress.getByName(dir);
            int serverPort = 5555;
            long startTime = System.currentTimeMillis();
            Socket clientSocket = new Socket(serverHost, serverPort);
            Receiver listener = new Receiver(clientSocket);
            listener.start();
            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            ps.println(nickname + " has entered the chat");
            while(true){
                String whisper = brr.readLine();
                ps.println(nickname + ": " + whisper);
            }
        }
        catch(Exception e) {
            e.printStackTrace() ;
        }
    }
}