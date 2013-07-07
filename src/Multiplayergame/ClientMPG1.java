package Multiplayergame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientMPG1 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Socket socket;
	static DataInputStream in;
	static DataOutputStream out;
	

	public JPanel contentPanel;
	public static JTextArea clientInfo;
	public static JTextField chatInput;
	

	
	public ClientMPG1() {
		setResizable(false);
		setTitle("ClientMPG");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(600, 100, 800, 600);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		clientInfo = new JTextArea();
		clientInfo.setText("");
		clientInfo.setWrapStyleWord(true);
		clientInfo.setLineWrap(true);
		clientInfo.setColumns(5);
		clientInfo.setEditable(false);
		clientInfo.setFont(new Font("Arial", Font.PLAIN, 11));
		clientInfo.setBounds(18, 480, 768, 100);
		JScrollPane ScrollPane = new JScrollPane(clientInfo);
		ScrollPane.setBounds(18, 480, 768, 80);
		contentPanel.add(ScrollPane);
		
		JButton chatSendButton = new JButton("Senden");
		chatSendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Senden();
				
			}
		});
		chatSendButton.setForeground(new Color(255, 140, 0));
		chatSendButton.setFont(new Font("Arial", Font.PLAIN, 14));
		chatSendButton.setBounds(686, 450, 100, 30);
		contentPanel.add(chatSendButton);
		
		chatInput = new JTextField();
		chatInput.setBounds(18, 450, 668, 30);
		chatInput.setColumns(10);
		contentPanel.add(chatInput);
		
	}
	
	public static void main(String[] args){
		
		
			
			/**
			 *  Fenster wird erzeugt...
			 */
		
					try {
						ClientMPG1 frame = new ClientMPG1();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
			
			/**
			 *  Server starten...
			 */
			try {
				ClientStarten(null);
			} catch (Exception e) {
				clientInfo.append("ERROR: Verbindung konnte nicht hergestellt werden!\n");
			}
			
			
		}
		
	
	
	public static void ClientInfoRefresher(String clientInfoMessage){
		clientInfo.append(">>>\t"+clientInfoMessage+"\n");
	}
	
	public void Senden() {
		
		String sendMessage = chatInput.getText();
		try {
			out.writeUTF(sendMessage);
			ClientInfoRefresher("Nachricht ('"+sendMessage+"') an alle Clients gesendet.");
			chatInput.setText("");
		} catch (IOException e) {
			ClientInfoRefresher("Nachricht konnte nicht gesendet werden.");
		}
		
		
	}
	
	public static void ClientStarten(String[] args) throws Exception {
		
		
		
		clientInfo.setText(">>> \tConnecting...\n");
		socket = new Socket("localhost", 7777);
		clientInfo.append("\tConnection successful\n");
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		
		Thread input = new Thread(new Input());
		input.start();
		
		ClientInfoRefresher("ClientInfoRefresher getestet.");
		
			
	}

}

class Input implements Runnable{
	
	DataInputStream in;

	public void input(DataInputStream in) {
		
		this.in = in;
		
	}
	
	public void run() {
		
		ClientMPG1.ClientInfoRefresher("run() wird vorbereitet...");
		
		while (true) {
			
			String message;
			ClientMPG1.ClientInfoRefresher("run() wird gestartet...");
			try {
				
				message = in.readUTF();
				ClientMPG1.clientInfo.append(message);
				System.out.println(message);
				
			} catch (IOException e) {
				
				ClientMPG1.clientInfo.append("run() nicht moeglich");
				
			}
			
			
		}
		
		
	}
	
}