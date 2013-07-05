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

import java.net.*;
import java.io.*;

public class ClientMain extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private static javax.swing.JTextArea chatPane;
	private static javax.swing.JTextField chatInput;
	private static String InputDialog;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		});
		
		InputDialog = JOptionPane.showInputDialog( "Bitte gib deinen Usernamen ein:" );
		
		chatPane.setText(InputDialog);

		
	}

	/**
	 * Create the frame.
	 */
	public ClientMain() {
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
					chatPane.setText(chatPane.getText()+"\n"+InputDialog+": "+chatInput.getText());
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
		
		JTextArea usersList = new JTextArea();
		usersList.setWrapStyleWord(true);
		usersList.setLineWrap(true);
		JScrollPane ScrollUserList = new JScrollPane(usersList);
		ScrollUserList.setBounds(18, 75, 767, 214);
		contentPane.add(ScrollUserList);
		
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(ServerMain.class.getResource("/Resources/NetworkMainBackground.PNG")));
		lblBackground.setBounds(0, 0, 800, 600);
		contentPane.add(lblBackground);
		
	}

}
