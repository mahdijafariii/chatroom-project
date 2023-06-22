import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Wait for client !!! ");
        ServerSocket socket = new ServerSocket(6666);
        while (true)
        {
            Socket clientSocket = socket.accept();
            System.out.println("Server accept new client !! ");
            CommunicationHandler communicationHandler = new CommunicationHandler(clientSocket);
            communicationHandler.start();
        }
    }
}
class CommunicationHandler extends Thread
{
    private Socket socket;
    public CommunicationHandler(Socket socket)
    {
        this.socket=socket;
    }
    @Override
    public void run()
    {
        try
        {
            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedInputStream = new BufferedReader(inputStream);
            String massage=" ";
            do
            {
                massage = bufferedInputStream.readLine();
                if(massage!=null)
                {
                    System.out.println(massage);
                    String URL = "jdbc:mysql://localhost/Massage";
                    String name = "root";
                    String password = "123";
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection connection = DriverManager.getConnection(URL,name,password);
                    String command = String.format("INSERT INTO massage (Massage) VALUES ('%s');",massage);
                    Statement s = connection.prepareStatement(command);
                    s.execute(command);
                }
            }
            while (massage!=null);
        }
        catch (Exception e){
        }
    }
}