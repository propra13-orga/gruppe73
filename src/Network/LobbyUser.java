package Network;


import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

import Network.Chat.IncomingReader;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class LobbyUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int Port = 5000;
	String bla = "jja", serverIP = "127.7.7.1 ";
	private JPanel contentPane;
	public boolean chckbxState = true;
	Boolean isConnected = false;
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	TextArea textAreaEinstellungen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LobbyUser frame = new LobbyUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	/**
	 * Create the frame.
	 */
	public LobbyUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNetzwerkLobby = new JLabel("Netzwerk Lobby - User Interface");
		lblNetzwerkLobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetzwerkLobby.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18));
		lblNetzwerkLobby.setBounds(10, 11, 414, 24);
		contentPane.add(lblNetzwerkLobby);
		
		final JCheckBox chckbxReadyToPlay = new JCheckBox("Ready to Play!");
		
		chckbxReadyToPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				chckbxReadyToPlayActionPerformed(evt);
			}

			private void chckbxReadyToPlayActionPerformed(MouseEvent evt) {
				// TODO Auto-generated method stub
				if(chckbxState == false){
					System.out.println("chckbxState");
					try {
		                sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
		                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
		                reader = new BufferedReader(streamreader);
		                writer = new PrintWriter(sock.getOutputStream());  // sendet Daten an den Server
		                writer.println("Player" + ":is ready to play.:ready"); // Displays to everyone that user connected.
		                writer.flush();
		                isConnected = true; // Used to see if the client is connected.
		            } catch (Exception ex) {
		            }
		        } else if (chckbxState == true) {
		            System.out.println("You have to push the Ready to Pay Button. \n");
		        
		    }   
			}
			
		});
		
		chckbxReadyToPlay.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		chckbxReadyToPlay.setBounds(297, 232, 127, 23);
		contentPane.add(chckbxReadyToPlay);
		
		//Ändert den Status der Checkbox nach Eingabe
		ItemListener itemListener = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					chckbxReadyToPlay.setEnabled(false);
					chckbxState = false;
				}
			}
		};
		chckbxReadyToPlay.addItemListener(itemListener);
		
		
	
			
		JTextArea textAreaEinstellungen = new JTextArea();
		textAreaEinstellungen.setEditable(false);
		textAreaEinstellungen.setBounds(20, 98, 386, 112);
		contentPane.add(textAreaEinstellungen);
		
		JLabel lblAusgewhlteEinstellungen = new JLabel("Ausgew\u00E4hlte Einstellungen:");
		lblAusgewhlteEinstellungen.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
		lblAusgewhlteEinstellungen.setBounds(20, 65, 172, 22);
		contentPane.add(lblAusgewhlteEinstellungen);
	}

	public class IncomingReader implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			String[] data;
			String stream, choosen = "choosen", card = "card";
			
			try{
				while ((stream = reader.readLine())!= null){
					data = stream.split(":");
					
					if(data[2].equals(choosen)){
						
						textAreaEinstellungen.append("Admin hat"+data[1]+"ausgewählt.\n");
					}else if(data[2].equals(card)){
						textAreaEinstellungen.append("Admin hat"+data[1]+"ausgewählt.\n");
					}
				}
					
			}catch(Exception ex){
				
			}
		}
		
	}
	
}
