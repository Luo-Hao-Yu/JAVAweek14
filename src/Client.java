import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String hostname = "localhost"; // 服务器地址，如果是本地测试，使用localhost
        int port = 8080;

        try (
                Socket socket = new Socket(hostname, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            System.out.println("Connected to server...");
            out.println("Hello from client!");

            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println("Server response: " + responseLine);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostname);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostname);
        }
    }
}