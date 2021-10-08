import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server startup");

        int port = 8087;

        while (true) {
            try (
                    ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
                    Socket clientSocket = serverSocket.accept(); // ждем подключения
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())))
            {

                System.out.println("New connection accepted");
                out.println(String.format("Write your name", clientSocket.getPort()));
                String name = in.readLine();
                System.out.println(name);
                out.println(String.format("Are you child? (yes/no)", clientSocket.getPort()));
                String answer = in.readLine();
                System.out.println(answer);
                if (answer.equals("no")) {
                    out.println(String.format("Welcome to the adult zone, " + name + " Have a good rest, or a good working day!", clientSocket.getPort()));
                } else if (answer.equals("yes")) {
                    out.println(String.format("Welcome to the kids area, " + name +  " Let's play!", clientSocket.getPort()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

