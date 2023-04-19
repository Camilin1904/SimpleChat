import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Handler extends Thread{
    Socket clientSocket;
    ArrayList<Socket> allOfThem;
    public Handler(Socket clientSocket, ArrayList<Socket> allOfThem){
        this.clientSocket = clientSocket;
        this.allOfThem = allOfThem;
    }

    @Override
    public void run() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while(true){
                String message = br.readLine();
                if(message!=null){
                    for(Socket cs : allOfThem){
                        if(cs!=clientSocket){
                            PrintStream ps = new PrintStream(cs.getOutputStream());
                            ps. println (message);
                            ps.flush ();
                        }
                    } 
                }
            }
        }
        catch(Exception e){}
    }
}
