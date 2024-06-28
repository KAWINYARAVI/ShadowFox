import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private static final int PORT = 8080;
    private static Set<PrintWriter> writers = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("Chat Server is running...");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.out.println("Error in the server: " + e.getMessage());
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;
        private PrintWriter writer;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writers.add(writer);

                String userName = reader.readLine();
                broadcast(userName + " has joined the chat.");

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    broadcast(userName + ": " + clientMessage);
                }
            } catch (IOException e) {
                System.out.println("Error handling client: " + e.getMessage());
            } finally {
                if (writer != null) {
                    writers.remove(writer);
                }
                broadcast(userName + " has left the chat.");
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }

    private static void broadcast(String message) {
        System.out.println(message);
        for (PrintWriter writer : writers) {
            writer.println(message);
        }
    }
}
