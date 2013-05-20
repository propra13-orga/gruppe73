package dungeoncrawler;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import dungeoncrawler.LoadLevel;

// ###################################################
// Diese Klasse bildet ist die Mainmethode des Spiels!

public class BuildLevel extends JFrame {

	/**
	 * 
	 */
	
	public static final int			KEY_UP = KeyEvent.VK_W;
	public static final int			KEY_DOWN = KeyEvent.VK_S;
	public static final int			KEY_LEFT = KeyEvent.VK_LEFT;
	public static final int			KEY_RIGHT = KeyEvent.VK_D;
	public int Current_Level = 1;
	
	
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
		setResizable(false);
		
		//create Jframe and Grid
		
		setTitle("Dungeon Crawler - Level "+Current_Level);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 306, 240);
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setBorder(null);
		setContentPane(Content);
		Content.setLayout(null);
		
		//LEBENSANZEIGE
		
		JLabel lblLebensanzeige = new JLabel("1 ");
		lblLebensanzeige.setForeground(Color.BLACK);
		lblLebensanzeige.setBackground(Color.WHITE);
		lblLebensanzeige.setBounds(250, 0, 50, 15);
		lblLebensanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/heart.PNG")));
		lblLebensanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		Content.add(lblLebensanzeige);
		
		JLabel lblCurrentLevel = new JLabel("Level "+Current_Level);
		lblCurrentLevel.setBounds(3, 0, 46, 14);
		Content.add(lblCurrentLevel);

		
		final JLabel lblPlayer = new JLabel("");
		lblPlayer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int k = e.getKeyCode();
				if (k == KEY_DOWN)
				{
					int move_value = (15+lblPlayer.getY());
					lblPlayer.setBounds(lblPlayer.getX(), move_value, lblPlayer.getWidth(), lblPlayer.getHeight());
					Content.repaint();
				}
			}
		});
		lblPlayer.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		lblPlayer.setBounds(0, 15, 15, 15);
		Content.add(lblPlayer);
		
		// Einzelne Level Items
		// Hab's leider nicht geschafft das zu automatisieren :-(
		
		// A-Reihe (id 0-19)
		
		JLabel lvlA1 = new JLabel("");
		lvlA1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 0))));
		lvlA1.setBounds(0, 15, 15, 15);
		Content.add(lvlA1);
		
		JLabel lvlA2 = new JLabel("");
		lvlA2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 1))));
		lvlA2.setBounds(15, 15, 15, 15);
		Content.add(lvlA2);
		
		JLabel lvlA3 = new JLabel("");
		lvlA3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 2))));
		lvlA3.setBounds(30, 15, 15, 15);
		Content.add(lvlA3);
		
		JLabel lvlA4 = new JLabel("");
		lvlA4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 3))));
		lvlA4.setBounds(45, 15, 15, 15);
		Content.add(lvlA4);
		
		JLabel lvlA5 = new JLabel("");
		lvlA5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 4))));
		lvlA5.setBounds(60, 15, 15, 15);
		Content.add(lvlA5);
		
		JLabel lvlA6 = new JLabel("");
		lvlA6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 5))));
		lvlA6.setBounds(75, 15, 15, 15);
		Content.add(lvlA6);
		
		JLabel lvlA7 = new JLabel("");
		lvlA7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 6))));
		lvlA7.setBounds(90, 15, 15, 15);
		Content.add(lvlA7);
		
		JLabel lvlA8 = new JLabel("");
		lvlA8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 7))));
		lvlA8.setBounds(105, 15, 15, 15);
		Content.add(lvlA8);
		
		JLabel lvlA9 = new JLabel("");
		lvlA9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 8))));
		lvlA9.setBounds(120, 15, 15, 15);
		Content.add(lvlA9);
		
		JLabel lvlA10 = new JLabel("");
		lvlA10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 9))));
		lvlA10.setBounds(135, 15, 15, 15);
		Content.add(lvlA10);
		
		JLabel lvlA11 = new JLabel("");
		lvlA11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 10))));
		lvlA11.setBounds(150, 15, 15, 15);
		Content.add(lvlA11);
		
		JLabel lvlA12 = new JLabel("");
		lvlA12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 11))));
		lvlA12.setBounds(165, 15, 15, 15);
		Content.add(lvlA12);
		
		JLabel lvlA13 = new JLabel("");
		lvlA13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 12))));
		lvlA13.setBounds(180, 15, 15, 15);
		Content.add(lvlA13);
		
		JLabel lvlA14 = new JLabel("");
		lvlA14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 13))));
		lvlA14.setBounds(195, 15, 15, 15);
		Content.add(lvlA14);
		
		JLabel lvlA15 = new JLabel("");
		lvlA15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 14))));
		lvlA15.setBounds(210, 15, 15, 15);
		Content.add(lvlA15);
		
		JLabel lvlA16 = new JLabel("");
		lvlA16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 15))));
		lvlA16.setBounds(225, 15, 15, 15);
		Content.add(lvlA16);
		
		JLabel lvlA17 = new JLabel("");
		lvlA17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 16))));
		lvlA17.setBounds(240, 15, 15, 15);
		Content.add(lvlA17);
		
		JLabel lvlA18 = new JLabel("");
		lvlA18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 17))));
		lvlA18.setBounds(255, 15, 15, 15);
		Content.add(lvlA18);
		
		JLabel lvlA19 = new JLabel("");
		lvlA19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 18))));
		lvlA19.setBounds(270, 15, 15, 15);
		Content.add(lvlA19);
		
		JLabel lvlA20 = new JLabel("");
		lvlA20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 19))));
		lvlA20.setBounds(285, 15, 15, 15);
		Content.add(lvlA20);
		
		// B-Reihe (id 20-39)
		
		
		JLabel lvlB1 = new JLabel("");
		lvlB1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 20))));
		lvlB1.setBounds(0, 30, 15, 15);
		Content.add(lvlB1);
		
		JLabel lvlB2 = new JLabel("");
		lvlB2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 21))));
		lvlB2.setBounds(15, 30, 15, 15);
		Content.add(lvlB2);
		
		JLabel lvlB3 = new JLabel("");
		lvlB3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 22))));
		lvlB3.setBounds(30, 30, 15, 15);
		Content.add(lvlB3);
		
		JLabel lvlB4 = new JLabel("");
		lvlB4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 23))));
		lvlB4.setBounds(45, 30, 15, 15);
		Content.add(lvlB4);
		
		JLabel lvlB5 = new JLabel("");
		lvlB5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 24))));
		lvlB5.setBounds(60, 30, 15, 15);
		Content.add(lvlB5);
		
		JLabel lvlB6 = new JLabel("");
		lvlB6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 25))));
		lvlB6.setBounds(75, 30, 15, 15);
		Content.add(lvlB6);
		
		JLabel lvlB7 = new JLabel("");
		lvlB7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 26))));
		lvlB7.setBounds(90, 30, 15, 15);
		Content.add(lvlB7);
		
		JLabel lvlB8 = new JLabel("");
		lvlB8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 27))));
		lvlB8.setBounds(105, 30, 15, 15);
		Content.add(lvlB8);
		
		JLabel lvlB9 = new JLabel("");
		lvlB9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 28))));
		lvlB9.setBounds(120, 30, 15, 15);
		Content.add(lvlB9);
		
		JLabel lvlB10 = new JLabel("");
		lvlB10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 29))));
		lvlB10.setBounds(135, 30, 15, 15);
		Content.add(lvlB10);
		
		JLabel lvlB11 = new JLabel("");
		lvlB11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 30))));
		lvlB11.setBounds(150, 30, 15, 15);
		Content.add(lvlB11);
		
		JLabel lvlB12 = new JLabel("");
		lvlB12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 31))));
		lvlB12.setBounds(165, 30, 15, 15);
		Content.add(lvlB12);
		
		JLabel lvlB13 = new JLabel("");
		lvlB13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 32))));
		lvlB13.setBounds(180, 30, 15, 15);
		Content.add(lvlB13);
		
		JLabel lvlB14 = new JLabel("");
		lvlB14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 33))));
		lvlB14.setBounds(195, 30, 15, 15);
		Content.add(lvlB14);
		
		JLabel lvlB15 = new JLabel("");
		lvlB15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 34))));
		lvlB15.setBounds(210, 30, 15, 15);
		Content.add(lvlB15);
		
		JLabel lvlB16 = new JLabel("");
		lvlB16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 35))));
		lvlB16.setBounds(225, 30, 15, 15);
		Content.add(lvlB16);
		
		JLabel lvlB17 = new JLabel("");
		lvlB17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 36))));
		lvlB17.setBounds(240, 30, 15, 15);
		Content.add(lvlB17);
		
		JLabel lvlB18 = new JLabel("");
		lvlB18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 37))));
		lvlB18.setBounds(255, 30, 15, 15);
		Content.add(lvlB18);
		
		JLabel lvlB19 = new JLabel("");
		lvlB19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 38))));
		lvlB19.setBounds(270, 30, 15, 15);
		Content.add(lvlB19);
		
		JLabel lvlB20 = new JLabel("");
		lvlB20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 39))));
		lvlB20.setBounds(285, 30, 15, 15);
		Content.add(lvlB20);
		
		
		}
		

		

	}

