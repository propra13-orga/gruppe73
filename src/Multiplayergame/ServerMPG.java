package Multiplayergame;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ServerMPG extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Variablen fuer den Server
	 */
	private static ServerSocket serverSocket;
	private static Socket socket;
	private static DataOutputStream out;
	private static DataInputStream in;
	private static Users[] user = new Users[2];
	
	/**
	 * Variablen fuer das Panel
	 */
	public JPanel contentPanel;
	public static JTextArea serverInfo;
	
	public ServerMPG() {
		setResizable(false);
		setTitle("ServerMPG");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0,0, 800, 140);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		serverInfo = new JTextArea();
		serverInfo.setText("");
		serverInfo.setWrapStyleWord(true);
		serverInfo.setLineWrap(true);
		serverInfo.setColumns(5);
		serverInfo.setEditable(false);
		serverInfo.setFont(new Font("Arial", Font.PLAIN, 11));
		serverInfo.setBounds(18, 18, 768, 100);
		JScrollPane ScrollPane = new JScrollPane(serverInfo);
		ScrollPane.setBounds(18, 18, 768, 80);
		contentPanel.add(ScrollPane);

	}
	
	public static void main(String[] args){
		
		/**
		 *  Fenster wird erzeugt...
		 */
				try {
					ServerMPG frame = new ServerMPG();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
		/**
		 *  Server starten...
		 */
		try {
			ServerStarten(null);
		} catch (Exception e) {
			serverInfo.append("ERROR: Server konnte nicht gestartet werden!\n");
		}
		
	}
	
	public static void ServerStarten(String[] args) throws Exception {
		
		/**
		 *  SERVER:
		 *  =======
		 */
		
		/**
		 *  Server starten...
		 */
		serverInfo.setText(">>> \tStarting server.\n");
		serverSocket = new ServerSocket(7777);
		serverInfo.append(">>>\tYour IP-Address:\t"+InetAddress.getLocalHost()+"\n");
		serverInfo.append(">>> \tServer started.\n\twaiting for clients...\n");
		
		/**
		 *  auf Client warten...
		 */
		while(true){
			
			socket = serverSocket.accept();
			
			for (int i = 0; i < 2; i++) {
				
				serverInfo.append(">>> \tConnection from:" + socket.getInetAddress()+" (Client "+i+")\n");
				/**
				 *  Output-Stream senden...
				 */
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				
				Thread Users = new Thread(new Users());
				Users.start();
				break;
					
				
				
			}
			
		}
		
	}
	
}

class Users implements Runnable {
	
	
	DataInputStream in;
	DataOutputStream out;
	
	public void users(DataInputStream in, DataOutputStream out) {
		
		this.in = in;
		this.out = out;
		
	}
	
	public void run() {
		
		try {
			
			while(true){
				
				
				String message = in.readUTF();
				out.writeUTF(message);
				ServerMPG.serverInfo.append(">>>\tNachricht von Client ('"+message+")' erhalten und an die anderen Clients weitergeleitet.\n");
				
			}
			
		} catch (IOException e){
			
			ServerMPG.serverInfo.append("Kein run() moeglich.");
			
		}
		
		
	}
	
}

