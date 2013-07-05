package Network;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Network.Chat.IncomingReader;

import java.net.*;
import java.util.*;
import java.io.*;

public class ServerMain extends JFrame {
	
	/**
	 * Variablen für das Panel:
	 */
	
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private static JTextArea chatPane;
	private static JTextField chatInput;
	private static JTextArea usersList;
	private static String InputDialog;
	
	/**
	 * Variablen für das Netzwerk:
	 */
	
	String username, serverIP = "127.0.0.1 ";
    int Port = 5000;
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    ArrayList<String> userList = new ArrayList();
    Boolean isConnected = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerMain frame = new ServerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		});
		
		InputDialog = JOptionPane.showInputDialog( "Bitte gib deinen Usernamen ein:" );
		chatPane.setText(InputDialog+" ist dem Spiel beigetreten.");
		
		ServerMain sm = new ServerMain();
		sm.Connect();
		
		ServerWindow.main(null);
		
		
		//sm.Connect();
		
		
		
		
		

		
	}

	/**
	 * Create the frame.
	 */
	public ServerMain() {
		setResizable(false);
		setTitle("Neues Multiplayer-Spiel starten");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 798, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chatInput = new JTextField();
		chatInput.setBounds(18, 555, 354, 31);
		contentPane.add(chatInput);
		chatInput.setColumns(10);
		
		JButton chatInputSend = new JButton("Senden");
		chatInputSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Input = chatInput.getText();
				if (Input.length() == 0) {
					
				} else {
					chatPane.setText(chatPane.getText()+"\n"+InputDialog+": "+chatInput.getText());
					chatInput.setText(null);
					
					sendButtonActionPerformed(e);
					
				}
				
			}
		});
		
		
		chatInputSend.setForeground(new Color(255, 140, 0));
		chatInputSend.setFont(new Font("Arial", Font.PLAIN, 14));
		chatInputSend.setBounds(372, 555, 100, 31);
		contentPane.add(chatInputSend);
		
		JButton close = new JButton("Abbrechen");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sendDisconnect();
				Disconnect();
				dispose();
				
			}
		});
		close.setForeground(new Color(255, 140, 0));
		close.setFont(new Font("Arial", Font.PLAIN, 14));
		close.setBounds(480, 555, 120, 31);
		contentPane.add(close);
		
		chatPane = new JTextArea();
		chatPane.setWrapStyleWord(true);
		chatPane.setLineWrap(true);
		
		chatPane.setColumns(5);
		chatPane.setEditable(false);
		chatPane.setFont(new Font("Arial", Font.PLAIN, 14));
		chatPane.setBounds(18, 324, 438, 225);
		//contentPane.add(chatPane);
		
		JScrollPane ScrollPane = new JScrollPane(chatPane);
		ScrollPane.setBounds(18, 324, 454, 225);
		contentPane.add(ScrollPane);
		
		JTextArea usersList = new JTextArea();
		usersList.setWrapStyleWord(true);
		usersList.setLineWrap(true);
		usersList.setEditable(false);
		usersList.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane ScrollUserList = new JScrollPane(usersList);
		ScrollUserList.setBounds(18, 75, 767, 214);
		contentPane.add(ScrollUserList);
		
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ServerMain.class.getResource("/Resources/NetworkMainBackground.PNG")));
		lblBackground.setBounds(0, 0, 800, 600);
		contentPane.add(lblBackground);
	}
	
	public class IncomingReader implements Runnable{

        public void run() {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try {
                while ((stream = reader.readLine()) != null) {

                    data = stream.split(":");

                     if (data[2].equals(chat)) {

                        chatPane.append(data[0] + ": " + data[1] + "\n");
                        chatPane.setCaretPosition(chatPane.getDocument().getLength());

                    } else if (data[2].equals(connect)){

                        chatPane.removeAll();
                        userAdd(data[0]);

                    } else if (data[2].equals(disconnect)) {


                        userRemove(data[0]);

                    } else if (data[2].equals(done)) {


                        usersList.setText("");
                        writeUsers();
                        userList.clear();

                    }
                 
                }
           }catch(Exception ex) {
           }
        }
    }
	
	public void ListenThread() {
        Thread IncomingReader = new Thread(new IncomingReader());
        IncomingReader.start();
   }

   public void userAdd(String data) {
        userList.add(data);

    }

   public void userRemove(String data) {
        chatPane.append(data + " has disconnected.\n");

    }

   public void writeUsers() {
        String[] tempList = new String[(userList.size())];
        userList.toArray(tempList);
        for (String token:tempList) {

            usersList.append(token + "\n");

        }

    }

   public void sendDisconnect() {

      String bye = (username + ": :Disconnect");
       try{
           writer.println(bye); // Sends server the disconnect signal.
           writer.flush(); // flushes the buffer
       } catch (Exception e) {
           chatPane.append("Could not send Disconnect message.\n");
       }

     }

   public void Disconnect() {

       try {
              chatPane.append("Disconnected.\n");
              sock.close();
       } catch(Exception ex) {
              chatPane.append("Failed to disconnect. \n");
       }
       isConnected = false;
       //usernameField.setEditable(true);
       usersList.setText("");

     }
   
   public void BeforeConnect() {
	   username = InputDialog;
   }
   
   public void Connect() {
	 if (isConnected == false) {
         username = InputDialog;



         try {
             sock = new Socket(serverIP, Port);
             InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
             reader = new BufferedReader(streamreader);
             writer = new PrintWriter(sock.getOutputStream());
             writer.println(username + ":has connected.:Connect"); // Displays to everyone that user connected.
             writer.flush(); // flushes the buffer
             isConnected = true; // Used to see if the client is connected.
         } catch (Exception ex) {
             chatPane.append("Cannot Connect! Try Again. \n");
         }
         ListenThread();
     } else if (isConnected == true) {
         chatPane.append("You are already connected. \n");
     }
   }
   
   private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
       // TODO add your handling code here:
       String nothing = "";
       if ((chatInput.getText()).equals(nothing)) {
           chatInput.setText("");
           chatInput.requestFocus();
       } else {
           try {
              writer.println(username + ":" + chatInput.getText() + ":" + "Chat");
              writer.flush(); // flushes the buffer
           } catch (Exception ex) {
               chatPane.append("Message was not sent. \n");
           }
           chatInput.setText("");
           chatInput.requestFocus();
       }

       chatInput.setText("");
       chatInput.requestFocus();
   }                         
  
   
 

}
