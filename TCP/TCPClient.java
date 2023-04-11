package TCP;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main (String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            
            OutputStream os = socket.getOutputStream();
            os.write("Olá, servidor!".getBytes());
            
            InputStream is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int length = is.read(buffer);
            System.out.println(new String(buffer, 0, length));
            
            // Fecha a conexão
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
