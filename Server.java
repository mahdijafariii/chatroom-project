import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Wait for client !!! ");
        ServerSocket socket = new ServerSocket(6666);
        while (true){
            Socket clientSocket = socket.accept();
            System.out.println("Server accept new client !! ");
            CommunicationHandler communicationHandler = new CommunicationHandler(clientSocket);
        }





    }
}
class CommunicationHandler extends Thread{
    private Socket socket;
    public CommunicationHandler(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        try {


        }
        catch (Exception e){

        }
    }
}
