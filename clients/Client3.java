package clients;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Client3
{
    public static void main(String[] args) throws IOException
    {
        Socket clientSocket = new Socket("127.0.0.1",6666);
        System.out.println("client connected !!! ");
        PrintWriter printWriter= new PrintWriter(clientSocket.getOutputStream(),true);
        Scanner in = new Scanner(System.in);
        String test = "";
        do
        {
            test = in.nextLine();
            printWriter.println("Client 3: "+test);
        }
        while (!test.equals("END"));

        System.out.println("Disconnected!!");
        printWriter.close();
        clientSocket.close();
    }
}
class getMassageHandler3 extends Thread
{
    @Override
    public void run()
    {
        try
        {
            String URL = "jdbc:mysql://localhost/Massage";
            String name = "root";
            String password = "123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, name, password);
            String command = String.format("SELECT * FROM massage");
            Statement statement = connection.prepareStatement(command);
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next())
            {
                System.out.println(resultSet.getString(1));
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}