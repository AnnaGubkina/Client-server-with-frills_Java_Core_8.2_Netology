import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        String host = "netology.homework";
        int port = 8087;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            out.println("Владимир Путин");
            String resp = in.readLine();
            System.out.println(resp);
            out.println("no");
            String question1 = in.readLine();
            System.out.println(question1);

            String welcome = in.readLine();
            System.out.println(welcome);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

