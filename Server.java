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
            communicationHandler.start();
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
            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedInputStream = new BufferedReader(inputStream);
            String massage=" ";
            do{
                massage = bufferedInputStream.readLine();
                if(massage!=null){
                    System.out.println(massage);
                }
            }
            while (massage!=null);

        }
        catch (Exception e){

        }
    }
}
