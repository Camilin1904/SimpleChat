import java.net.*;
import java.io.*;

public class Receiver extends Thread{
    Socket clientSocket;
    BufferedReader br;

    public Receiver(Socket sctk)throws Exception{
        clientSocket = sctk;
        br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
    @Override
    public void run() {
        while (true){
            //System.out.println("pito");
            try{
                String message = br.readLine();
                if(message!=null) System.out.println( "- "+ message);
            }
            catch (Exception e){System.out.println(e);}
        }
    }
}
