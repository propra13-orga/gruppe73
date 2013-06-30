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
		
		try {
			
			String outdata;
			String Vergleich;
			Vergleich = "exit";
			ServerSocket ss = new ServerSocket(5556);
			Socket s = ss.accept();
			
			do {
				
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outdata = br.readLine();
				
				if (outdata == null) {
					
				} else {
					System.out.println("Incoming message: " + outdata);
				}
			} while (!Vergleich.equals( outdata));
			
			s.close();
			
		} catch(IOException e) {
			System.err.println(e.toString());
		}
	}

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


}
