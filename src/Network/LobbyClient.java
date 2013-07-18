package Network;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;

public class LobbyClient extends JFrame {

	/**
	 * Variablen Deklaration
	 * das gesamte Netzwerk Paket nutz die auf sich selbst referenzierende IP Adresse
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int Port = 5000;
	String bla = "jja", serverIP = "127.7.7.1 ";
	Socket sock;
	BufferedReader reader;
	PrintWriter writer;
	public boolean SelectedState1 = false;
	public boolean SelectedState2 = false;
	public boolean SelectedState3 = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LobbyClient frame = new LobbyClient();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public LobbyClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSchwierigkeitsgrad = new JLabel("Schwierigkeitsgrad:");
		lblSchwierigkeitsgrad.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblSchwierigkeitsgrad.setBounds(10, 77, 117, 22);
		contentPane.add(lblSchwierigkeitsgrad);
		
		JLabel lblNetzwerkLobby = new JLabel("Netzwerk Lobby - Client Interface");
		lblNetzwerkLobby.setFont(new Font("Bradley Hand ITC", Font.BOLD, 18));
		lblNetzwerkLobby.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetzwerkLobby.setBounds(10, 11, 414, 22);
		contentPane.add(lblNetzwerkLobby);
		
		JLabel lblEinstellungen = new JLabel("Einstellungen:");
		lblEinstellungen.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblEinstellungen.setBounds(10, 44, 117, 22);
		contentPane.add(lblEinstellungen);
	
		
		

		
		JLabel lblWhleDieZu = new JLabel("W\u00E4hle die zu spielende Karte:");
		lblWhleDieZu.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		lblWhleDieZu.setBounds(10, 110, 178, 21);
		contentPane.add(lblWhleDieZu);
		
		JButton btnJoinChat = new JButton("Join Chat");
		btnJoinChat.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnJoinChat.setBounds(289, 228, 117, 23);
		contentPane.add(btnJoinChat);
		
		btnJoinChat.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent Event) {
				// TODO Auto-generated method stub
				ServerChat.main(null);
				
			}
			
		});
		
		/**
		 * ermöglicht dem Admin das Starten des MultiPlayerGames
		 */
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		btnStartGame.setBounds(289, 196, 117, 22);
		contentPane.add(btnStartGame);
		
		btnStartGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent Event) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		/**
		 * 
		 * Methode zum Auswählen des Schwierigkeitsgrades und die Übergabe an den Server
		 */
		
		final JCheckBox chckbxLevel1 = new JCheckBox("1");
		chckbxLevel1.setBounds(133, 77, 39, 23);
		contentPane.add(chckbxLevel1);
		
		ItemListener itemListener = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					chckbxLevel1.setEnabled(false);
					SelectedState1 = true;
				}
			}
		};
		chckbxLevel1.addItemListener(itemListener);
		
		chckbxLevel1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				chckbxLevel1ActionPerformed(evt);
				}
			private void chckbxLevel1ActionPerformed(MouseEvent evt){
				if (SelectedState1 == true){
					System.out.println("SelectedState1");
					try {
		                sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
		                writer = new PrintWriter(sock.getOutputStream());  // sendet Daten an den Server
		                writer.println("Player" + ":hat Schwierigkeit 1 gewählt.:choosen"); // Displays to everyone that user connected.
		                writer.flush();
		                
		            } catch (Exception ex) {
		            }
		        } else if (SelectedState1 == false) {
		            System.out.println("You have to select a difficulty. \n");
		        
				}
			}
			
		});
		
		
		final JCheckBox chckbxLevel2 = new JCheckBox("2");
		chckbxLevel2.setBounds(177, 77, 39, 23);
		contentPane.add(chckbxLevel2);
		
		ItemListener itemListener2 = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					chckbxLevel2.setEnabled(false);
					SelectedState2 = true;
				}
			}
		};
		chckbxLevel2.addItemListener(itemListener2);
		
		chckbxLevel2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				chckbxLevel2ActionPerformed(evt);
				}
			private void chckbxLevel2ActionPerformed(MouseEvent evt){
				if (SelectedState2 == true){
					System.out.println("SelectedState2");
					try {
		                sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
		                writer = new PrintWriter(sock.getOutputStream());  // sendet Daten an den Server
		                writer.println("Player" + ":hat Schwierigkeit 2 gewählt.:choosen"); // Displays to everyone that user connected.
		                writer.flush();
		                
		            } catch (Exception ex) {
		            }
		        } else if (SelectedState2 == false) {
		            System.out.println("You have to select a difficulty. \n");
		        
				}
			}
			
		});

		
		final JCheckBox chckbxLevel3 = new JCheckBox("3");
		chckbxLevel3.setBounds(225, 77, 39, 23);
		contentPane.add(chckbxLevel3);

		ItemListener itemListener3 = new ItemListener(){
			public void itemStateChanged(ItemEvent itemEvent){
				int state = itemEvent.getStateChange();
				if(state == ItemEvent.SELECTED){
					chckbxLevel3.setEnabled(false);
					SelectedState2 = true;
				}
			}
		};
		chckbxLevel3.addItemListener(itemListener3);
		
		chckbxLevel3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt){
				chckbxLevel3ActionPerformed(evt);
				}
			private void chckbxLevel3ActionPerformed(MouseEvent evt){
				if (SelectedState3 == true){
					System.out.println("SelectedState3");
					try {
		                sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
		                writer = new PrintWriter(sock.getOutputStream());  // sendet Daten an den Server
		                writer.println("Player" + ":hat Schwierigkeit 2 gewählt.:choosen"); // Displays to everyone that user connected.
		                writer.flush();
		                
		            } catch (Exception ex) {
		            }
		        } else if (SelectedState3 == false) {
		            System.out.println("You have to select a difficulty. \n");
		        
				}
			}
			
		});
		
		
		/**
		 * Methode zum Wählen der Karte und Über der Information an den Server
		 */

		final JComboBox cBoxCard = new JComboBox();
		cBoxCard.setModel(new DefaultComboBoxModel(new String[] {"Haunted Desert", "Mystic Forest", "Stormy Sea"}));
		cBoxCard.setFont(new Font("Tw Cen MT", Font.PLAIN, 14));
		cBoxCard.setBounds(10, 142, 117, 52);
		contentPane.add(cBoxCard);
		
		cBoxCard.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(cBoxCard.getSelectedItem().equals("Haunted Desert")){
					 try {
		                	sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
							writer = new PrintWriter(sock.getOutputStream());// sendet Daten an den Server
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
					 writer.println("Player" + ":hat die Karte Haunted Desert gewählt.:card"); // Displays to everyone that user connected.
		                writer.flush();
				}else if(cBoxCard.getSelectedItem().equals("Mystic Forest")){
					 try {
		                	sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
							writer = new PrintWriter(sock.getOutputStream());// sendet Daten an den Server
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  
					writer.println("Player" +":"+ "hat die Karte Mystic Desert gewählt."+":card"); // Displays to everyone that user connected.
	                writer.flush();
				}else if(cBoxCard.getSelectedItem().equals("Stormy Sea")){
					
	                try {
	                	sock = new Socket(serverIP, Port);  //Socket stellt die Verbindung zum Server her
						writer = new PrintWriter(sock.getOutputStream());// sendet Daten an den Server
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
					writer.println("Player" + ":hat die Karte Stormy Sea gewählt.:card"); // Displays to everyone that user connected.
	                writer.flush();
				}
			}

	
			
		});
			
	}
}
