package Network;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ServerMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static javax.swing.JTextArea chatPane;
	private static javax.swing.JTextField chatInput;
	String username, serverIP = " ";
	int Port = 5000;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ArrayList<String> userList = new ArrayList();
	Boolean isConnected = false;
	

	

    
	/**
	 * Create the frame.
	 */
	public ServerMain() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Neues Multiplayer-Spiel starten");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		chatInput = new JTextField();
		chatInput.setBounds(18, 555, 354, 31);
		contentPane.add(chatInput);
		chatInput.setColumns(10);
		
		initComponents();
		
		
		JButton chatInputSend = new JButton("Senden");
		chatInputSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Input = chatInput.getText();
				if (Input.length() == 0) {
					
				} else {
					chatPane.setText(chatPane.getText()+"\nPlayer 1: "+chatInput.getText());
					chatInput.setText(null);
				}
				
			}
		});
		
          
	        
		chatInputSend.setForeground(new Color(255, 140, 0));
		chatInputSend.setFont(new Font("Arial", Font.PLAIN, 14));
		chatInputSend.setBounds(372, 555, 100, 31);
		contentPane.add(chatInputSend);
		
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
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ServerMain.class.getResource("/Resources/NetworkMainBackground.PNG")));
		lblBackground.setBounds(0, 0, 800, 600);
		contentPane.add(lblBackground);
		
		chatPane.setText("Host wurde eingerichtet...");
		}
	/**
	 * 	
	 * String zeigt welche Arten von Data vom Server empfangen werden können. 
	 *Berarbeitet das User Array in Abhängigkeit der vom Server ausgegebenen Strings
	 */
	
	public class IncomingReader implements Runnable{
		
		public void run(){
			String[] data;
			String stream, done ="Done", connect = "Connect", disconnect ="Disconnect", chat = "Chat";
			try{
				while ((stream = reader.readLine()) != null){
					data = stream.split(":");
					if(data[2].equals(chat)){
						chatTextArea.append(data[0] + ": " + data[1] + "\n");
						chatTextArea.setCaretPosition(chatInput.getDocument().getLength());
					}else if (data[2].equals(connect)){
						chatTextArea.removeAll();
						userAdd(data[0]);
					}else if (data[2].equals(disconnect)){
						userRemove(data[0]);
					}else if (data[2].equals(done)){
						usersList.setText("");
						writeUsers();
						userList.clear();
					}
				}
			}catch(Exception ex){
			}
			
		}
	}
	
	
	/**
	 * startet den IncomingReader
	 */
	public void ListenThread(){
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}
	
	public void userAdd(String data){
		userList.add(data);
	}
	
	public void userRemove(String data){
		chatTextArea.append(data +" has disconnected. \n");
	}
	/**
	 * generiert die UserList
	 */
	public void writeUsers(){
		String[] tempList = new String[(userList.size())];
		userList.toArray(tempList);
		for (String token:tempList) {
			usersList.append(token +"\n");
		}
	}
	
	public void sendDisconnect(){
		String bye = (username + ": :Disconnect");
		try{
			writer.println(bye); // Sendet dem Server das "Disconnect" signal
			writer.flush(); //flushes the Buffer
		}catch (Exception e) {
			chatTextArea.append("Could not send Disconnect message.\n");
		}
	}
	
	public void Disconnect(){
		try{
			chatTextArea.append("Disconnected.\n");
			sock.close();
		}catch (Exception ex){
			chatTextArea.append("Failed to disconnect.\n");			
		}
		isConnected=false;
		usernameField.setEditable(true);
		usersList.setText("");
	}
	
	
	private void initComponents(){
		usernameField = new JTextField();
		connectButton = new JButton();
		disconnectButton = new JButton();
		usersList = new JTextArea();
		jLabel1 = new JLabel();
		chatTextArea = new javax.swing.JTextArea();
		
		 chatTextArea.setColumns(20);
	        chatTextArea.setEditable(false);
	        chatTextArea.setFont(new java.awt.Font("Times New Roman", 0, 12)); 
	        chatTextArea.setLineWrap(true);
	        chatTextArea.setRows(5);
	        jScrollPane2.setViewportView(chatTextArea);
		
		
		/*usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });*/
		
		 connectButton.setText("Connect");
	        connectButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                connectButtonActionPerformed(evt);
	            }
	        });

	        disconnectButton.setText("Disconnect");
	        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                disconnectButtonActionPerformed(evt);
	            }
	        });}
	
	/**
	 * Wird ein Username eingegeben, wird die Try Schleife ausgeführt in der eine Socket Verbindung aufgebaut wird
	 * 
	 */
	        
	       public void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
	            // TODO add your handling code here:
	                if (isConnected == false) {
	                username = usernameField.getText();
	                usernameField.setEditable(false);
	                try {
	                    sock = new Socket(serverIP, Port);
	                    InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
	                    reader = new BufferedReader(streamreader);
	                    writer = new PrintWriter(sock.getOutputStream());
	                    writer.println(username + ":has connected.:Connect"); // Displays to everyone that user connected.
	                    writer.flush(); // flushes the buffer
	                    isConnected = true; // Used to see if the client is connected.
	                } catch (Exception ex) {
	                    chatTextArea.append("Cannot Connect! Try Again. \n");
	                    usernameField.setEditable(true);  // wenn die Eingabe nicht funktioniert hat, muss das Feld wieder editierbar sein 
	                }
	                ListenThread();
	            } else if (isConnected == true) {
	                chatTextArea.append("You are already connected. \n");
	            }
	        }                 
	                
	                
	        public void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
	           // TODO add your handling code here:
	               sendDisconnect();
	               Disconnect();
	               } 
	        

	        
	/*        private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
	                    chatTextArea.append("Message was not sent. \n");
	                }
	                chatInput.setText("");
	                chatInput.requestFocus();
	            }

	            chatInput.setText("");
	            chatInput.requestFocus();
	        }                      
		*/ /* Gibts schon */
	
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
	    		
	    		
	    			
	    		}

	

	
	//}
	
	private javax.swing.JButton connectButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextArea usersList;
    private javax.swing.JTextArea chatTextArea;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jLabel1;


}
