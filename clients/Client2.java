package clients;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket("127.0.0.1",6666);
        System.out.println("client connected !!! ");
        PrintWriter printWriter= new PrintWriter(clientSocket.getOutputStream(),true);
        Scanner in = new Scanner(System.in);
        String test = "";
        do{
            test = in.nextLine();
            printWriter.println(test);
        }while (!test.equals("END"));
        System.out.println("Disconnected!!");
        printWriter.close();
        clientSocket.close();
    }
}
