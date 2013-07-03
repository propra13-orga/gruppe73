package Network;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Sarah
 *
 */
public class ChatMain extends JFrame {
	
	String username, serverIP = "";
	int Port = 5000;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	ArrayList<String> userList = new ArrayList();
	Boolean isConnected = false;  
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UsernameInput;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatMain frame = new ChatMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 * UsernameInput - Eingabefeld für den Usernamen
	 * Connect Button - btnConnect
	 * Disconnect Button - btnDisconnect
	 * Send Button - btnNewButton
	 * OnlineUsersArea - Anzeige der User die Online sind. Aktualisiert über das Array
	 * ChatInput - Eingabefeld für den Chat Text
	 * ChatTextArea - Ausgabefeld für Chat Eingaben
	 */
	public ChatMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chat Client");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(15, 5, 55, 20);
		contentPane.add(lblUsername);
		
		UsernameInput = new JTextField();
		UsernameInput.setBounds(70, 5, 90, 20);
		contentPane.add(UsernameInput);
		UsernameInput.setColumns(10);
		
		UsernameInput.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				usernameInputActionPerformed(evt);
			}
		});
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBounds(172, 5, 73, 20);
		contentPane.add(btnConnect);
		
		btnConnect.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				btnConnectActionPerformed(evt);
			}
		});
		
		
		JButton btnDisconnect = new JButton("Disconnect");
		btnDisconnect.setBounds(250, 5, 85, 20);
		contentPane.add(btnDisconnect);
		
		btnDisconnect.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				btnDisconnectActionPerformed(evt);
			}
		});
		
		JLabel lblOnlineUsers = new JLabel("Online Users");
		lblOnlineUsers.setBounds(345, 5, 85, 20);
		lblOnlineUsers.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblOnlineUsers);
		
		JTextArea OnlineUsersArea = new JTextArea();
		OnlineUsersArea.setLineWrap(true);
		OnlineUsersArea.setEditable(false);
		OnlineUsersArea.setBounds(340, 35, 90, 218);
		contentPane.add(OnlineUsersArea);
		
		JTextArea ChatTextArea = new JTextArea();
		ChatTextArea.setEditable(false);
		ChatTextArea.setBounds(15, 35, 315, 136);
		contentPane.add(ChatTextArea);
		
		JTextArea ChatInput = new JTextArea();
		ChatInput.setColumns(20);
		ChatInput.setBounds(15, 182, 230, 71);
		contentPane.add(ChatInput);
		
		JButton btnNewButton = new JButton("Senden");
		btnNewButton.setBounds(255, 192, 73, 50);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent evt){
				btnNewButtonActionPerformed(evt);
			}
		});
	} 
	
	private javax.swing.JTextArea ChatTextArea;
	private javax.swing.JTextArea OnlineUsersArea;
	private javax.swing.JTextArea ChatInput;
	
	public class IncomingReader implements Runnable{
		public void run(){
			String [] data;
			String stream, done = "Done", connect = "Cnnect", disconnect ="Disconnect", chat = "Chat";
			
			try{
				while ((stream = reader.readLine()) != null) {
					data = stream.split(":");
					
					if (data[2].equals(chat)){
						ChatTextArea.append(data[0] + ": " + data[1] + "\n");
						ChatTextArea.setCaretPosition(ChatTextArea.getDocument().getLength());
					}else if (data[2].equals(connect)){
						ChatTextArea.removeAll();
						userAdd(data[0]);
					}else if (data[2].equals(disconnect)){
						userRemove(data[0]);
					}else if (data[2].equals(done)){
						OnlineUsersArea.setText("");
						writeUsers();
						userList.clear();
					}
					
				}
			}catch(Exception ex){
			}
		}
	}
	
	private void btnConnectActionPerformed(java.awt.event.ActionEvent evt){
		if (isConnected == false){
			username = UsernameInput.getText();
			UsernameInput.setEditable(false);
			
			try{
				sock = new Socket(serverIP, Port);
				InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
				reader = new BufferedReader(streamreader);
				writer = new PrintWriter(sock.getOutputStream());
				writer.println(username + ":has connected.:Connect"); // zeigt jedem User das sich ein weiterer eingeloggt hat
				writer.flush();
				isConnected = true; 
			}catch(Exception ex){
				ChatTextArea.append("Cannot cconnect. Try again.\n");
				UsernameInput.setEditable(true);
			}
			ListenThread();
		}else if (isConnected == true){
			ChatTextArea.append("You are already connectd.\n");
		}
	}
	
	private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt){
		sendDisconnect();
		Disconnect();		
	}
	
	
	public void ListenThread(){
		Thread IncomingReader = new Thread(new IncomingReader());
		IncomingReader.start();
	}
	
	public void userAdd(String data){
		userList.add(data);
	}
	
	public void userRemove(String data){
		ChatTextArea.append(data + "has disconnected.\n");
	}
	
	public void writeUsers(){
		String[] tempList = new String[(userList.size())];
		userList.toArray(tempList);
		for (String token:tempList){
			OnlineUsersArea.append(token + "\n");
		}
	}
	
	public void sendDisconnect(){
		String bye = (username + ": :Disconnect");
		try{
			writer.println(bye); //sendet das disconnect signal zum Server
			writer.flush();
		}catch(Exception e){
			ChatTextArea.append("Could not send Discconnect message.\n");
		}
	}
	
	public void Disconnect(){
		
		try{
			ChatTextArea.append("Disconnected.\n");
			sock.close();
		}catch(Exception ex){
			ChatTextArea.append("Failed to disconnect.\n");
		}
		isConnected = false;
		UsernameInput.setEditable(true);
		OnlineUsersArea.setText("");
	}
	

	private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt){
		String nothing ="";
		if ((ChatInput.getText().equals(nothing))){
			ChatInput.setText("");
			ChatInput.requestFocus();
		}else{
			try{
				writer.println(username + ":" +ChatInput.getText() +":"+"Chat");
				writer.flush();
			}catch(Exception ex){
				ChatTextArea.append("Die Nachricht wurde nicht gesendet.\n");
			}
			ChatInput.setText("");
			ChatInput.requestFocus();
		}
		ChatInput.setText("");
		ChatInput.requestFocus();
	}
	
	private void usernameInputActionPerformed(java.awt.event.ActionEvent evt){
		
	}
}
