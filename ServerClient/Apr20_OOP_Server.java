package ServerClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Apr20_OOP_Server {

    public static void main(String[] args)
            throws IOException
    {
        // TODO Auto-generated method stub
        ServerSocket serverSocket =  new ServerSocket(12342);

        while(true) {
            Socket og = serverSocket.accept();
            Socket mu = serverSocket.accept();
            new Thread(new Connection(og,mu)).start();
            new Thread(new Connection(mu,og)).start();
        }
    }

}

class Connection implements Runnable{
    private Socket in, out;
    private DataInputStream dis;
    private DataOutputStream dos;
    Connection(Socket in, Socket out){
        this.in = in;
        this.out = out;
        try {
            dos = new DataOutputStream(out.getOutputStream());
            dis = new DataInputStream(in.getInputStream());
        }catch(IOException e) {}

    }
    public void run() {
        try {
            while(true) {
                String message = dis.readUTF();
                dos.writeUTF(message);
                dos.flush();
            }
        }catch(IOException e) {}

    }
}









