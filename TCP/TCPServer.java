package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                
                InputStream is = clientSocket.getInputStream();
                byte[] buffer = new byte[1024];
                int length = is.read(buffer);
                String message = new String(buffer, 0, length);
                System.out.println("Mensagem recebida: " + message);
                
                OutputStream os = clientSocket.getOutputStream();
                String response = "Olá, cliente!";
                os.write(response.getBytes());
                
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
