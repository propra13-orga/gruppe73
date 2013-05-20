package dungeoncrawler;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class BuildLevel extends JFrame {

	/**
	 * 
	 */
	
	public static final int			KEY_UP = KeyEvent.VK_KP_UP;
	public static final int			KEY_DOWN = KeyEvent.VK_KP_DOWN;
	public static final int			KEY_LEFT = KeyEvent.VK_KP_LEFT;
	public static final int			KEY_RIGHT = KeyEvent.VK_D;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel Content;

	/**
	 * Main-Methode
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildLevel frame = new BuildLevel();
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
	public BuildLevel() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int k = e.getKeyCode();
				if (k == KEY_RIGHT)
				{
					int move_value = (lblPlayer.getX()+15);
					lblPlayer.setLocation(move_value, lblPlayer.getY());
					Content.repaint();
					
				}
			}
		});
		setResizable(false);
		
		//create Jframe and Grid
		
		setTitle("Dungeon Crawler - Level 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 304, 240);
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setForeground(Color.BLACK);
		Content.setBorder(null);
		setContentPane(Content);
		Content.setLayout(null);
		
		JLabel lblDoor = new JLabel("");
		lblDoor.setBounds(0, -1, 292, -1);
		lblDoor.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoor.setVerticalAlignment(SwingConstants.TOP);
		lblDoor.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/door.PNG")));
		Content.add(lblDoor);
		
		//LEBENSANZEIGE
		
		JLabel lblLebensanzeige = new JLabel("1 ");
		lblLebensanzeige.setForeground(Color.BLACK);
		lblLebensanzeige.setBackground(Color.WHITE);
		lblLebensanzeige.setBounds(0, 0, 300, 15);
		lblLebensanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/heart.PNG")));
		lblLebensanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		Content.add(lblLebensanzeige);
		
		final JLabel lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		lblPlayer.setBounds(0, 15, 15, 15);
		Content.add(lblPlayer);
	}
}
