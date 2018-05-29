package ServerClient;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Apr20_OOP_Client extends JFrame{
    private JTextField message;
    private JTextArea history;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    Apr20_OOP_Client() throws IOException
    {
        socket = new Socket("127.0.0.1", 12345);
        dis = new DataInputStream(
                socket.getInputStream());
        dos = new DataOutputStream(
                socket.getOutputStream());

        message = new JTextField(20);
        history = new JTextArea(20,20);
        add(message, BorderLayout.NORTH);
        add(history, BorderLayout.CENTER);

        message.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                try
                {
                    dos.writeUTF(message.getText());
                    dos.flush();
                    history.append("Me: "+message.getText()+"\n");
                    message.setText("");
                }
                catch(IOException e) {}

            }

        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        while(true)
        {
            String inMessage = dis.readUTF();
            history.append("Other: "+inMessage+"\n");
        }

    }
    public static void main(String[] args) throws IOException
    {
        // TODO Auto-generated method stub
        new Apr20_OOP_Client();
    }

}

