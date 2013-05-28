package dungeoncrawler;



import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import dungeoncrawler.CollisionControl;
import dungeoncrawler.LoadLevel;

// ###################################################
// Diese Klasse bildet die Mainmethode des Spiels!
// ###################################################

public class BuildLevel extends JFrame {

	/**
	 * 
	 */
	
	public static int Current_Level = 1;
	public static int Current_Points = 0;
	public static boolean game_over = false;
	
	
	private static final long serialVersionUID = 1L;
	private static JPanel Content;
	private static javax.swing.JLabel lblPlayer;
	private static MovementListener mListener;
	private static javax.swing.JLabel lblPunkteanzeige;
	private static javax.swing.JLabel lblGegner1;
	private int newY;
    private int newX;

	/**
	 * Main-Methode
	 */
	public static void main(String[] args) {
		final BuildLevel m = new BuildLevel();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	public void run() {
        		m.setVisible(true);
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	@Override
    public void setVisible(boolean value) {
        if (value == true) {
            this.addKeyListener(mListener);
            mListener.start();
        } else {
            mListener.end();
            this.removeKeyListener(mListener);
        }
        super.setVisible(value);
	}
	
	public BuildLevel() {
		setResizable(false);
		
		//create Jframe and Grid
		
		setTitle("Dungeon Crawler - Level "+Current_Level);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 306, 272);
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setBorder(null);
		setContentPane(Content);
		Content.setLayout(null);
		
		mListener = new MovementListener() {
			@Override
			public void doMovement(int left, int right, int up, int down) {
                
				java.awt.Rectangle pos = lblPlayer.getBounds();
                if (CollisionControl.check_Xborder(lblPlayer.getX()) == true) {
                	if (CollisionControl.check_wall(lblPlayer.getX(), lblPlayer.getY()) == true) {
                		newX = pos.x + left + right;
                	}
                	
                }
                if (CollisionControl.check_Yborder(lblPlayer.getY()) == true) {
                	if (CollisionControl.check_wall(lblPlayer.getX(), lblPlayer.getY()) == true) {
                		newY = pos.y + up + down;   
                	}
                	            	
                }
                
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());   
                    }
                });
                Content.repaint();
                
			}
			
		};
		mListener.setPriority(Thread.NORM_PRIORITY);
		
		
		
		//LEBENSANZEIGE
		
		JLabel lblLebensanzeige = new JLabel("1 ");
		lblLebensanzeige.setForeground(Color.BLACK);
		lblLebensanzeige.setBackground(Color.WHITE);
		lblLebensanzeige.setBounds(250, 0, 50, 15);
		lblLebensanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/heart.PNG")));
		lblLebensanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		Content.add(lblLebensanzeige);
		
		//Punkteanzeige
		
		lblPunkteanzeige = new JLabel(Current_Points+" ");
		lblPunkteanzeige.setForeground(Color.BLACK);
		lblPunkteanzeige.setBackground(Color.WHITE);
		lblPunkteanzeige.setBounds(215, 0, 50, 15);
		lblPunkteanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/points.PNG")));
		lblPunkteanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		Content.add(lblPunkteanzeige);
		
		//Current_Level
		
		JLabel lblCurrentLevel = new JLabel("Level "+Current_Level);
		lblCurrentLevel.setBounds(3, 0, 46, 14);
		Content.add(lblCurrentLevel);

		
		lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		newX = LoadLevel.getPlayerPosStartX(Current_Level);
		newY = LoadLevel.getPlayerPosStartY(Current_Level);
		lblPlayer.setBounds(newX, newY, 15, 15);
		Content.add(lblPlayer);
		
		lblGegner1 = new JLabel("");
		lblGegner1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/boooo.PNG")));
		lblGegner1.setBounds(30, 30, 15, 15);
		Content.add(lblGegner1);
		
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
		
		// C-Reihe (id 40-59)
		
		JLabel lvlC1 = new JLabel("");
		lvlC1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 40))));
		lvlC1.setBounds(0, 45, 15, 15);
		Content.add(lvlC1);
		
		JLabel lvlC2 = new JLabel("");
		lvlC2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 41))));
		lvlC2.setBounds(15, 45, 15, 15);
		Content.add(lvlC2);
		
		JLabel lvlC3 = new JLabel("");
		lvlC3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 42))));
		lvlC3.setBounds(30, 45, 15, 15);
		Content.add(lvlC3);
		
		JLabel lvlC4 = new JLabel("");
		lvlC4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 43))));
		lvlC4.setBounds(45, 45, 15, 15);
		Content.add(lvlC4);
		
		JLabel lvlC5 = new JLabel("");
		lvlC5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 44))));
		lvlC5.setBounds(60, 45, 15, 15);
		Content.add(lvlC5);
		
		JLabel lvlC6 = new JLabel("");
		lvlC6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 45))));
		lvlC6.setBounds(75, 45, 15, 15);
		Content.add(lvlC6);
		
		JLabel lvlC7 = new JLabel("");
		lvlC7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 46))));
		lvlC7.setBounds(90, 45, 15, 15);
		Content.add(lvlC7);
		
		JLabel lvlC8 = new JLabel("");
		lvlC8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 47))));
		lvlC8.setBounds(105, 45, 15, 15);
		Content.add(lvlC8);
		
		JLabel lvlC9 = new JLabel("");
		lvlC9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 48))));
		lvlC9.setBounds(120, 45, 15, 15);
		Content.add(lvlC9);
		
		JLabel lvlC10 = new JLabel("");
		lvlC10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 49))));
		lvlC10.setBounds(135, 45, 15, 15);
		Content.add(lvlC10);
		
		JLabel lvlC11 = new JLabel("");
		lvlC11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 50))));
		lvlC11.setBounds(150, 45, 15, 15);
		Content.add(lvlC11);
		
		JLabel lvlC12 = new JLabel("");
		lvlC12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 51))));
		lvlC12.setBounds(165, 45, 15, 15);
		Content.add(lvlC12);
		
		JLabel lvlC13 = new JLabel("");
		lvlC13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 52))));
		lvlC13.setBounds(180, 45, 15, 15);
		Content.add(lvlC13);
		
		JLabel lvlC14 = new JLabel("");
		lvlC14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 53))));
		lvlC14.setBounds(195, 45, 15, 15);
		Content.add(lvlC14);
		
		JLabel lvlC15 = new JLabel("");
		lvlC15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 54))));
		lvlC15.setBounds(210, 45, 15, 15);
		Content.add(lvlC15);
		
		JLabel lvlC16 = new JLabel("");
		lvlC16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 55))));
		lvlC16.setBounds(225, 45, 15, 15);
		Content.add(lvlC16);
		
		JLabel lvlC17 = new JLabel("");
		lvlC17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 56))));
		lvlC17.setBounds(240, 45, 15, 15);
		Content.add(lvlC17);
		
		JLabel lvlC18 = new JLabel("");
		lvlC18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 57))));
		lvlC18.setBounds(255, 45, 15, 15);
		Content.add(lvlC18);
		
		JLabel lvlC19 = new JLabel("");
		lvlC19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 58))));
		lvlC19.setBounds(270, 45, 15, 15);
		Content.add(lvlC19);
		
		JLabel lvlC20 = new JLabel("");
		lvlC20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 59))));
		lvlC20.setBounds(285, 45, 15, 15);
		Content.add(lvlC20);
		
		// D-Reihe (id 60-79)
		
		JLabel lvlD1 = new JLabel("");
		lvlD1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 60))));
		lvlD1.setBounds(0, 60, 15, 15);
		Content.add(lvlD1);
		
		JLabel lvlD2 = new JLabel("");
		lvlD2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 61))));
		lvlD2.setBounds(15, 60, 15, 15);
		Content.add(lvlD2);
		
		JLabel lvlD3 = new JLabel("");
		lvlD3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 62))));
		lvlD3.setBounds(30, 60, 15, 15);
		Content.add(lvlD3);
		
		JLabel lvlD4 = new JLabel("");
		lvlD4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 63))));
		lvlD4.setBounds(45, 60, 15, 15);
		Content.add(lvlD4);
		
		JLabel lvlD5 = new JLabel("");
		lvlD5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 64))));
		lvlD5.setBounds(60, 60, 15, 15);
		Content.add(lvlD5);
		
		JLabel lvlD6 = new JLabel("");
		lvlD6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 65))));
		lvlD6.setBounds(75, 60, 15, 15);
		Content.add(lvlD6);
		
		JLabel lvlD7 = new JLabel("");
		lvlD7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 66))));
		lvlD7.setBounds(90, 60, 15, 15);
		Content.add(lvlD7);
		
		JLabel lvlD8 = new JLabel("");
		lvlD8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 67))));
		lvlD8.setBounds(105, 60, 15, 15);
		Content.add(lvlD8);
		
		JLabel lvlD9 = new JLabel("");
		lvlD9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 68))));
		lvlD9.setBounds(120, 60, 15, 15);
		Content.add(lvlD9);
		
		JLabel lvlD10 = new JLabel("");
		lvlD10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 69))));
		lvlD10.setBounds(135, 60, 15, 15);
		Content.add(lvlD10);
		
		JLabel lvlD11 = new JLabel("");
		lvlD11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 70))));
		lvlD11.setBounds(150, 60, 15, 15);
		Content.add(lvlD11);
		
		JLabel lvlD12 = new JLabel("");
		lvlD12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 71))));
		lvlD12.setBounds(165, 60, 15, 15);
		Content.add(lvlD12);
		
		JLabel lvlD13 = new JLabel("");
		lvlD13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 72))));
		lvlD13.setBounds(180, 60, 15, 15);
		Content.add(lvlD13);
		
		JLabel lvlD14 = new JLabel("");
		lvlD14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 73))));
		lvlD14.setBounds(195, 60, 15, 15);
		Content.add(lvlD14);
		
		JLabel lvlD15 = new JLabel("");
		lvlD15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 74))));
		lvlD15.setBounds(210, 60, 15, 15);
		Content.add(lvlD15);
		
		JLabel lvlD16 = new JLabel("");
		lvlD16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 75))));
		lvlD16.setBounds(225, 60, 15, 15);
		Content.add(lvlD16);
		
		JLabel lvlD17 = new JLabel("");
		lvlD17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 76))));
		lvlD17.setBounds(240, 60, 15, 15);
		Content.add(lvlD17);
		
		JLabel lvlD18 = new JLabel("");
		lvlD18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 77))));
		lvlD18.setBounds(255, 60, 15, 15);
		Content.add(lvlD18);
		
		JLabel lvlD19 = new JLabel("");
		lvlD19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 78))));
		lvlD19.setBounds(270, 60, 15, 15);
		Content.add(lvlD19);
		
		JLabel lvlD20 = new JLabel("");
		lvlD20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 79))));
		lvlD20.setBounds(285, 60, 15, 15);
		Content.add(lvlD20);
		
		// E-Reihe (id 80-99)
		
		JLabel lvlE1 = new JLabel("");
		lvlE1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 80))));
		lvlE1.setBounds(0, 75, 15, 15);
		Content.add(lvlE1);
		
		JLabel lvlE2 = new JLabel("");
		lvlE2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 81))));
		lvlE2.setBounds(15, 75, 15, 15);
		Content.add(lvlE2);
		
		JLabel lvlE3 = new JLabel("");
		lvlE3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 82))));
		lvlE3.setBounds(30, 75, 15, 15);
		Content.add(lvlE3);
		
		JLabel lvlE4 = new JLabel("");
		lvlE4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 83))));
		lvlE4.setBounds(45, 75, 15, 15);
		Content.add(lvlE4);
		
		JLabel lvlE5 = new JLabel("");
		lvlE5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 84))));
		lvlE5.setBounds(60, 75, 15, 15);
		Content.add(lvlE5);
		
		JLabel lvlE6 = new JLabel("");
		lvlE6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 85))));
		lvlE6.setBounds(75, 75, 15, 15);
		Content.add(lvlE6);
		
		JLabel lvlE7 = new JLabel("");
		lvlE7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 86))));
		lvlE7.setBounds(90, 75, 15, 15);
		Content.add(lvlE7);
		
		JLabel lvlE8 = new JLabel("");
		lvlE8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 87))));
		lvlE8.setBounds(105, 75, 15, 15);
		Content.add(lvlE8);
		
		JLabel lvlE9 = new JLabel("");
		lvlE9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 88))));
		lvlE9.setBounds(120, 75, 15, 15);
		Content.add(lvlE9);
		
		JLabel lvlE10 = new JLabel("");
		lvlE10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 89))));
		lvlE10.setBounds(135, 75, 15, 15);
		Content.add(lvlE10);
		
		JLabel lvlE11 = new JLabel("");
		lvlE11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 90))));
		lvlE11.setBounds(150, 75, 15, 15);
		Content.add(lvlE11);
		
		JLabel lvlE12 = new JLabel("");
		lvlE12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 91))));
		lvlE12.setBounds(165, 75, 15, 15);
		Content.add(lvlE12);
		
		JLabel lvlE13 = new JLabel("");
		lvlE13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 92))));
		lvlE13.setBounds(180, 75, 15, 15);
		Content.add(lvlE13);
		
		JLabel lvlE14 = new JLabel("");
		lvlE14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 93))));
		lvlE14.setBounds(195, 75, 15, 15);
		Content.add(lvlE14);
		
		JLabel lvlE15 = new JLabel("");
		lvlE15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 94))));
		lvlE15.setBounds(210, 75, 15, 15);
		Content.add(lvlE15);
		
		JLabel lvlE16 = new JLabel("");
		lvlE16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 95))));
		lvlE16.setBounds(225, 75, 15, 15);
		Content.add(lvlE16);
		
		JLabel lvlE17 = new JLabel("");
		lvlE17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 96))));
		lvlE17.setBounds(240, 75, 15, 15);
		Content.add(lvlE17);
		
		JLabel lvlE18 = new JLabel("");
		lvlE18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 97))));
		lvlE18.setBounds(255, 75, 15, 15);
		Content.add(lvlE18);
		
		JLabel lvlE19 = new JLabel("");
		lvlE19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 98))));
		lvlE19.setBounds(270, 75, 15, 15);
		Content.add(lvlE19);
		
		JLabel lvlE20 = new JLabel("");
		lvlE20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 99))));
		lvlE20.setBounds(285, 75, 15, 15);
		Content.add(lvlE20);
		
		// F-Reihe (id 100-119)
		
		JLabel lvlF1 = new JLabel("");
		lvlF1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 100))));
		lvlF1.setBounds(0, 90, 15, 15);
		Content.add(lvlF1);
		
		JLabel lvlF2 = new JLabel("");
		lvlF2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 101))));
		lvlF2.setBounds(15, 90, 15, 15);
		Content.add(lvlF2);
		
		JLabel lvlF3 = new JLabel("");
		lvlF3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 102))));
		lvlF3.setBounds(30, 90, 15, 15);
		Content.add(lvlF3);
		
		JLabel lvlF4 = new JLabel("");
		lvlF4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 103))));
		lvlF4.setBounds(45, 90, 15, 15);
		Content.add(lvlF4);
		
		JLabel lvlF5 = new JLabel("");
		lvlF5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 104))));
		lvlF5.setBounds(60, 90, 15, 15);
		Content.add(lvlF5);
		
		JLabel lvlF6 = new JLabel("");
		lvlF6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 105))));
		lvlF6.setBounds(75, 90, 15, 15);
		Content.add(lvlF6);
		
		JLabel lvlF7 = new JLabel("");
		lvlF7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 106))));
		lvlF7.setBounds(90, 90, 15, 15);
		Content.add(lvlF7);
		
		JLabel lvlF8 = new JLabel("");
		lvlF8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 107))));
		lvlF8.setBounds(105, 90, 15, 15);
		Content.add(lvlF8);
		
		JLabel lvlF9 = new JLabel("");
		lvlF9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 108))));
		lvlF9.setBounds(120, 90, 15, 15);
		Content.add(lvlF9);
		
		JLabel lvlF10 = new JLabel("");
		lvlF10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 109))));
		lvlF10.setBounds(135, 90, 15, 15);
		Content.add(lvlF10);
		
		JLabel lvlF11 = new JLabel("");
		lvlF11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 110))));
		lvlF11.setBounds(150, 90, 15, 15);
		Content.add(lvlF11);
		
		JLabel lvlF12 = new JLabel("");
		lvlF12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 111))));
		lvlF12.setBounds(165, 90, 15, 15);
		Content.add(lvlF12);
		
		JLabel lvlF13 = new JLabel("");
		lvlF13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 112))));
		lvlF13.setBounds(180, 90, 15, 15);
		Content.add(lvlF13);
		
		JLabel lvlF14 = new JLabel("");
		lvlF14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 113))));
		lvlF14.setBounds(195, 90, 15, 15);
		Content.add(lvlF14);
		
		JLabel lvlF15 = new JLabel("");
		lvlF15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 114))));
		lvlF15.setBounds(210, 90, 15, 15);
		Content.add(lvlF15);
		
		JLabel lvlF16 = new JLabel("");
		lvlF16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 115))));
		lvlF16.setBounds(225, 90, 15, 15);
		Content.add(lvlF16);
		
		JLabel lvlF17 = new JLabel("");
		lvlF17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 116))));
		lvlF17.setBounds(240, 90, 15, 15);
		Content.add(lvlF17);
		
		JLabel lvlF18 = new JLabel("");
		lvlF18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 117))));
		lvlF18.setBounds(255, 90, 15, 15);
		Content.add(lvlF18);
		
		JLabel lvlF19 = new JLabel("");
		lvlF19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 118))));
		lvlF19.setBounds(270, 90, 15, 15);
		Content.add(lvlF19);
		
		JLabel lvlF20 = new JLabel("");
		lvlF20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 119))));
		lvlF20.setBounds(285, 90, 15, 15);
		Content.add(lvlF20);
		
		// G-Reihe (id: 120-139)
		
		JLabel lvlG1 = new JLabel("");
		lvlG1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 120))));
		lvlG1.setBounds(0, 105, 15, 15);
		Content.add(lvlG1);
		
		JLabel lvlG2 = new JLabel("");
		lvlG2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 121))));
		lvlG2.setBounds(15, 105, 15, 15);
		Content.add(lvlG2);
		
		JLabel lvlG3 = new JLabel("");
		lvlG3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 122))));
		lvlG3.setBounds(30, 105, 15, 15);
		Content.add(lvlG3);
		
		JLabel lvlG4 = new JLabel("");
		lvlG4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 123))));
		lvlG4.setBounds(45, 105, 15, 15);
		Content.add(lvlG4);
		
		JLabel lvlG5 = new JLabel("");
		lvlG5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 124))));
		lvlG5.setBounds(60, 105, 15, 15);
		Content.add(lvlG5);
		
		JLabel lvlG6 = new JLabel("");
		lvlG6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 125))));
		lvlG6.setBounds(75, 105, 15, 15);
		Content.add(lvlG6);
		
		JLabel lvlG7 = new JLabel("");
		lvlG7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 126))));
		lvlG7.setBounds(90, 105, 15, 15);
		Content.add(lvlG7);
		
		JLabel lvlG8 = new JLabel("");
		lvlG8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 127))));
		lvlG8.setBounds(105, 105, 15, 15);
		Content.add(lvlG8);
		
		JLabel lvlG9 = new JLabel("");
		lvlG9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 128))));
		lvlG9.setBounds(120, 105, 15, 15);
		Content.add(lvlG9);
		
		JLabel lvlG10 = new JLabel("");
		lvlG10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 129))));
		lvlG10.setBounds(135, 105, 15, 15);
		Content.add(lvlG10);
		
		JLabel lvlG11 = new JLabel("");
		lvlG11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 130))));
		lvlG11.setBounds(150, 105, 15, 15);
		Content.add(lvlG11);
		
		JLabel lvlG12 = new JLabel("");
		lvlG12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 131))));
		lvlG12.setBounds(165, 105, 15, 15);
		Content.add(lvlG12);
		
		JLabel lvlG13 = new JLabel("");
		lvlG13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 132))));
		lvlG13.setBounds(180, 105, 15, 15);
		Content.add(lvlG13);
		
		JLabel lvlG14 = new JLabel("");
		lvlG14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 133))));
		lvlG14.setBounds(195, 105, 15, 15);
		Content.add(lvlG14);
		
		JLabel lvlG15 = new JLabel("");
		lvlG15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 134))));
		lvlG15.setBounds(210, 105, 15, 15);
		Content.add(lvlG15);
		
		JLabel lvlG16 = new JLabel("");
		lvlG16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 135))));
		lvlG16.setBounds(225, 105, 15, 15);
		Content.add(lvlG16);
		
		JLabel lvlG17 = new JLabel("");
		lvlG17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 136))));
		lvlG17.setBounds(240, 105, 15, 15);
		Content.add(lvlG17);
		
		JLabel lvlG18 = new JLabel("");
		lvlG18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 137))));
		lvlG18.setBounds(255, 105, 15, 15);
		Content.add(lvlG18);
		
		JLabel lvlG19 = new JLabel("");
		lvlG19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 138))));
		lvlG19.setBounds(270, 105, 15, 15);
		Content.add(lvlG19);
		
		JLabel lvlG20 = new JLabel("");
		lvlG20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 139))));
		lvlG20.setBounds(285, 105, 15, 15);
		Content.add(lvlG20);
		
		// H-Reihe (id: 140-159)
		
		JLabel lvlH1 = new JLabel("");
		lvlH1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 140))));
		lvlH1.setBounds(0, 120, 15, 15);
		Content.add(lvlH1);
		
		JLabel lvlH2 = new JLabel("");
		lvlH2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 141))));
		lvlH2.setBounds(15, 120, 15, 15);
		Content.add(lvlH2);
		
		JLabel lvlH3 = new JLabel("");
		lvlH3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 142))));
		lvlH3.setBounds(30, 120, 15, 15);
		Content.add(lvlH3);
		
		JLabel lvlH4 = new JLabel("");
		lvlH4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 143))));
		lvlH4.setBounds(45, 120, 15, 15);
		Content.add(lvlH4);
		
		JLabel lvlH5 = new JLabel("");
		lvlH5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 144))));
		lvlH5.setBounds(60, 120, 15, 15);
		Content.add(lvlH5);
		
		JLabel lvlH6 = new JLabel("");
		lvlH6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 145))));
		lvlH6.setBounds(75, 120, 15, 15);
		Content.add(lvlH6);
		
		JLabel lvlH7 = new JLabel("");
		lvlH7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 146))));
		lvlH7.setBounds(90, 120, 15, 15);
		Content.add(lvlH7);
		
		JLabel lvlH8 = new JLabel("");
		lvlH8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 147))));
		lvlH8.setBounds(105, 120, 15, 15);
		Content.add(lvlH8);
		
		JLabel lvlH9 = new JLabel("");
		lvlH9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 148))));
		lvlH9.setBounds(120, 120, 15, 15);
		Content.add(lvlH9);
		
		JLabel lvlH10 = new JLabel("");
		lvlH10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 149))));
		lvlH10.setBounds(135, 120, 15, 15);
		Content.add(lvlH10);
		
		JLabel lvlH11 = new JLabel("");
		lvlH11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 150))));
		lvlH11.setBounds(150, 120, 15, 15);
		Content.add(lvlH11);
		
		JLabel lvlH12 = new JLabel("");
		lvlH12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 151))));
		lvlH12.setBounds(165, 120, 15, 15);
		Content.add(lvlH12);
		
		JLabel lvlH13 = new JLabel("");
		lvlH13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 152))));
		lvlH13.setBounds(180, 120, 15, 15);
		Content.add(lvlH13);
		
		JLabel lvlH14 = new JLabel("");
		lvlH14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 153))));
		lvlH14.setBounds(195, 120, 15, 15);
		Content.add(lvlH14);
		
		JLabel lvlH15 = new JLabel("");
		lvlH15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 154))));
		lvlH15.setBounds(210, 120, 15, 15);
		Content.add(lvlH15);
		
		JLabel lvlH16 = new JLabel("");
		lvlH16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 155))));
		lvlH16.setBounds(225, 120, 15, 15);
		Content.add(lvlH16);
		
		JLabel lvlH17 = new JLabel("");
		lvlH17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 156))));
		lvlH17.setBounds(240, 120, 15, 15);
		Content.add(lvlH17);
		
		JLabel lvlH18 = new JLabel("");
		lvlH18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 157))));
		lvlH18.setBounds(255, 120, 15, 15);
		Content.add(lvlH18);
		
		JLabel lvlH19 = new JLabel("");
		lvlH19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 158))));
		lvlH19.setBounds(270, 120, 15, 15);
		Content.add(lvlH19);
		
		JLabel lvlH20 = new JLabel("");
		lvlH20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 159))));
		lvlH20.setBounds(285, 120, 15, 15);
		Content.add(lvlH20);
		
		// I-Reihe (id: 160-179)
		
		JLabel lvlI1 = new JLabel("");
		lvlI1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 160))));
		lvlI1.setBounds(0, 135, 15, 15);
		Content.add(lvlI1);
		
		JLabel lvlI2 = new JLabel("");
		lvlI2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 161))));
		lvlI2.setBounds(15, 135, 15, 15);
		Content.add(lvlI2);
		
		JLabel lvlI3 = new JLabel("");
		lvlI3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 162))));
		lvlI3.setBounds(30, 135, 15, 15);
		Content.add(lvlI3);
		
		JLabel lvlI4 = new JLabel("");
		lvlI4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 163))));
		lvlI4.setBounds(45, 135, 15, 15);
		Content.add(lvlI4);
		
		JLabel lvlI5 = new JLabel("");
		lvlI5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 164))));
		lvlI5.setBounds(60, 135, 15, 15);
		Content.add(lvlI5);
		
		JLabel lvlI6 = new JLabel("");
		lvlI6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 165))));
		lvlI6.setBounds(75, 135, 15, 15);
		Content.add(lvlI6);
		
		JLabel lvlI7 = new JLabel("");
		lvlI7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 166))));
		lvlI7.setBounds(90, 135, 15, 15);
		Content.add(lvlI7);
		
		JLabel lvlI8 = new JLabel("");
		lvlI8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 167))));
		lvlI8.setBounds(105, 135, 15, 15);
		Content.add(lvlI8);
		
		JLabel lvlI9 = new JLabel("");
		lvlI9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 168))));
		lvlI9.setBounds(120, 135, 15, 15);
		Content.add(lvlI9);
		
		JLabel lvlI10 = new JLabel("");
		lvlI10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 169))));
		lvlI10.setBounds(135, 135, 15, 15);
		Content.add(lvlI10);
		
		JLabel lvlI11 = new JLabel("");
		lvlI11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 170))));
		lvlI11.setBounds(150, 135, 15, 15);
		Content.add(lvlI11);
		
		JLabel lvlI12 = new JLabel("");
		lvlI12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 171))));
		lvlI12.setBounds(165, 135, 15, 15);
		Content.add(lvlI12);
		
		JLabel lvlI13 = new JLabel("");
		lvlI13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 172))));
		lvlI13.setBounds(180, 135, 15, 15);
		Content.add(lvlI13);
		
		JLabel lvlI14 = new JLabel("");
		lvlI14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 173))));
		lvlI14.setBounds(195, 135, 15, 15);
		Content.add(lvlI14);
		
		JLabel lvlI15 = new JLabel("");
		lvlI15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 174))));
		lvlI15.setBounds(210, 135, 15, 15);
		Content.add(lvlI15);
		
		JLabel lvlI16 = new JLabel("");
		lvlI16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 175))));
		lvlI16.setBounds(225, 135, 15, 15);
		Content.add(lvlI16);
		
		JLabel lvlI17 = new JLabel("");
		lvlI17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 176))));
		lvlI17.setBounds(240, 135, 15, 15);
		Content.add(lvlI17);
		
		JLabel lvlI18 = new JLabel("");
		lvlI18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 177))));
		lvlI18.setBounds(255, 135, 15, 15);
		Content.add(lvlI18);
		
		JLabel lvlI19 = new JLabel("");
		lvlI19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 178))));
		lvlI19.setBounds(270, 135, 15, 15);
		Content.add(lvlI19);
		
		JLabel lvlI20 = new JLabel("");
		lvlI20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 179))));
		lvlI20.setBounds(285, 135, 15, 15);
		Content.add(lvlI20);
		
		// J-Reihe (id:180-199)
		
		JLabel lvlJ1 = new JLabel("");
		lvlJ1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 180))));
		lvlJ1.setBounds(0, 150, 15, 15);
		Content.add(lvlJ1);
		
		JLabel lvlJ2 = new JLabel("");
		lvlJ2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 181))));
		lvlJ2.setBounds(15, 150, 15, 15);
		Content.add(lvlJ2);
		
		JLabel lvlJ3 = new JLabel("");
		lvlJ3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 182))));
		lvlJ3.setBounds(30, 150, 15, 15);
		Content.add(lvlJ3);
		
		JLabel lvlJ4 = new JLabel("");
		lvlJ4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 183))));
		lvlJ4.setBounds(45, 150, 15, 15);
		Content.add(lvlJ4);
		
		JLabel lvlJ5 = new JLabel("");
		lvlJ5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 184))));
		lvlJ5.setBounds(60, 150, 15, 15);
		Content.add(lvlJ5);
		
		JLabel lvlJ6 = new JLabel("");
		lvlJ6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 185))));
		lvlJ6.setBounds(75, 150, 15, 15);
		Content.add(lvlJ6);
		
		JLabel lvlJ7 = new JLabel("");
		lvlJ7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 186))));
		lvlJ7.setBounds(90, 150, 15, 15);
		Content.add(lvlJ7);
		
		JLabel lvlJ8 = new JLabel("");
		lvlJ8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 187))));
		lvlJ8.setBounds(105, 150, 15, 15);
		Content.add(lvlJ8);
		
		JLabel lvlJ9 = new JLabel("");
		lvlJ9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 188))));
		lvlJ9.setBounds(120, 150, 15, 15);
		Content.add(lvlJ9);
		
		JLabel lvlJ10 = new JLabel("");
		lvlJ10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 189))));
		lvlJ10.setBounds(135, 150, 15, 15);
		Content.add(lvlJ10);
		
		JLabel lvlJ11 = new JLabel("");
		lvlJ11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 190))));
		lvlJ11.setBounds(150, 150, 15, 15);
		Content.add(lvlJ11);
		
		JLabel lvlJ12 = new JLabel("");
		lvlJ12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 191))));
		lvlJ12.setBounds(165, 150, 15, 15);
		Content.add(lvlJ12);
		
		JLabel lvlJ13 = new JLabel("");
		lvlJ13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 192))));
		lvlJ13.setBounds(180, 150, 15, 15);
		Content.add(lvlJ13);
		
		JLabel lvlJ14 = new JLabel("");
		lvlJ14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 193))));
		lvlJ14.setBounds(195, 150, 15, 15);
		Content.add(lvlJ14);
		
		JLabel lvlJ15 = new JLabel("");
		lvlJ15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 194))));
		lvlJ15.setBounds(210, 150, 15, 15);
		Content.add(lvlJ15);
		
		JLabel lvlJ16 = new JLabel("");
		lvlJ16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 195))));
		lvlJ16.setBounds(225, 150, 15, 15);
		Content.add(lvlJ16);
		
		JLabel lvlJ17 = new JLabel("");
		lvlJ17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 196))));
		lvlJ17.setBounds(240, 150, 15, 15);
		Content.add(lvlJ17);
		
		JLabel lvlJ18 = new JLabel("");
		lvlJ18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 197))));
		lvlJ18.setBounds(255, 150, 15, 15);
		Content.add(lvlJ18);
		
		JLabel lvlJ19 = new JLabel("");
		lvlJ19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 198))));
		lvlJ19.setBounds(270, 150, 15, 15);
		Content.add(lvlJ19);
		
		JLabel lvlJ20 = new JLabel("");
		lvlJ20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 199))));
		lvlJ20.setBounds(285, 150, 15, 15);
		Content.add(lvlJ20);
		
		// K-Reihe (id: 200-219)
		
		JLabel lvlK1 = new JLabel("");
		lvlK1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 200))));
		lvlK1.setBounds(0, 165, 15, 15);
		Content.add(lvlK1);
		
		JLabel lvlK2 = new JLabel("");
		lvlK2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 201))));
		lvlK2.setBounds(15, 165, 15, 15);
		Content.add(lvlK2);
		
		JLabel lvlK3 = new JLabel("");
		lvlK3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 202))));
		lvlK3.setBounds(30, 165, 15, 15);
		Content.add(lvlK3);
		
		JLabel lvlK4 = new JLabel("");
		lvlK4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 203))));
		lvlK4.setBounds(45, 165, 15, 15);
		Content.add(lvlK4);
		
		JLabel lvlK5 = new JLabel("");
		lvlK5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 204))));
		lvlK5.setBounds(60, 165, 15, 15);
		Content.add(lvlK5);
		
		JLabel lvlK6 = new JLabel("");
		lvlK6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 205))));
		lvlK6.setBounds(75, 165, 15, 15);
		Content.add(lvlK6);
		
		JLabel lvlK7 = new JLabel("");
		lvlK7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 206))));
		lvlK7.setBounds(90, 165, 15, 15);
		Content.add(lvlK7);
		
		JLabel lvlK8 = new JLabel("");
		lvlK8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 207))));
		lvlK8.setBounds(105, 165, 15, 15);
		Content.add(lvlK8);
		
		JLabel lvlK9 = new JLabel("");
		lvlK9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 208))));
		lvlK9.setBounds(120, 165, 15, 15);
		Content.add(lvlK9);
		
		JLabel lvlK10 = new JLabel("");
		lvlK10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 209))));
		lvlK10.setBounds(135, 165, 15, 15);
		Content.add(lvlK10);
		
		JLabel lvlK11 = new JLabel("");
		lvlK11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 210))));
		lvlK11.setBounds(150, 165, 15, 15);
		Content.add(lvlK11);
		
		JLabel lvlK12 = new JLabel("");
		lvlK12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 211))));
		lvlK12.setBounds(165, 165, 15, 15);
		Content.add(lvlK12);
		
		JLabel lvlK13 = new JLabel("");
		lvlK13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 212))));
		lvlK13.setBounds(180, 165, 15, 15);
		Content.add(lvlK13);
		
		JLabel lvlK14 = new JLabel("");
		lvlK14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 213))));
		lvlK14.setBounds(195, 165, 15, 15);
		Content.add(lvlK14);
		
		JLabel lvlK15 = new JLabel("");
		lvlK15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 214))));
		lvlK15.setBounds(210, 165, 15, 15);
		Content.add(lvlK15);
		
		JLabel lvlK16 = new JLabel("");
		lvlK16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 215))));
		lvlK16.setBounds(225, 165, 15, 15);
		Content.add(lvlK16);
		
		JLabel lvlK17 = new JLabel("");
		lvlK17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 216))));
		lvlK17.setBounds(240, 165, 15, 15);
		Content.add(lvlK17);
		
		JLabel lvlK18 = new JLabel("");
		lvlK18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 217))));
		lvlK18.setBounds(255, 165, 15, 15);
		Content.add(lvlK18);
		
		JLabel lvlK19 = new JLabel("");
		lvlK19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 218))));
		lvlK19.setBounds(270, 165, 15, 15);
		Content.add(lvlK19);
		
		JLabel lvlK20 = new JLabel("");
		lvlK20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 219))));
		lvlK20.setBounds(285, 165, 15, 15);
		Content.add(lvlK20);
		
		// L-Reihe (id: 220-239)
		
		JLabel lvlL1 = new JLabel("");
		lvlL1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 220))));
		lvlL1.setBounds(0, 180, 15, 15);
		Content.add(lvlL1);
		
		JLabel lvlL2 = new JLabel("");
		lvlL2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 221))));
		lvlL2.setBounds(15, 180, 15, 15);
		Content.add(lvlL2);
		
		JLabel lvlL3 = new JLabel("");
		lvlL3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 222))));
		lvlL3.setBounds(30, 180, 15, 15);
		Content.add(lvlL3);
		
		JLabel lvlL4 = new JLabel("");
		lvlL4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 223))));
		lvlL4.setBounds(45, 180, 15, 15);
		Content.add(lvlL4);
		
		JLabel lvlL5 = new JLabel("");
		lvlL5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 224))));
		lvlL5.setBounds(60, 180, 15, 15);
		Content.add(lvlL5);
		
		JLabel lvlL6 = new JLabel("");
		lvlL6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 225))));
		lvlL6.setBounds(75, 180, 15, 15);
		Content.add(lvlL6);
		
		JLabel lvlL7 = new JLabel("");
		lvlL7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 226))));
		lvlL7.setBounds(90, 180, 15, 15);
		Content.add(lvlL7);
		
		JLabel lvlL8 = new JLabel("");
		lvlL8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 227))));
		lvlL8.setBounds(105, 180, 15, 15);
		Content.add(lvlL8);
		
		JLabel lvlL9 = new JLabel("");
		lvlL9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 228))));
		lvlL9.setBounds(120, 180, 15, 15);
		Content.add(lvlL9);
		
		JLabel lvlL10 = new JLabel("");
		lvlL10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 229))));
		lvlL10.setBounds(135, 180, 15, 15);
		Content.add(lvlL10);
		
		JLabel lvlL11 = new JLabel("");
		lvlL11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 230))));
		lvlL11.setBounds(150, 180, 15, 15);
		Content.add(lvlL11);
		
		JLabel lvlL12 = new JLabel("");
		lvlL12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 231))));
		lvlL12.setBounds(165, 180, 15, 15);
		Content.add(lvlL12);
		
		JLabel lvlL13 = new JLabel("");
		lvlL13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 232))));
		lvlL13.setBounds(180, 180, 15, 15);
		Content.add(lvlL13);
		
		JLabel lvlL14 = new JLabel("");
		lvlL14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 233))));
		lvlL14.setBounds(195, 180, 15, 15);
		Content.add(lvlL14);
		
		JLabel lvlL15 = new JLabel("");
		lvlL15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 234))));
		lvlL15.setBounds(210, 180, 15, 15);
		Content.add(lvlL15);
		
		JLabel lvlL16 = new JLabel("");
		lvlL16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 235))));
		lvlL16.setBounds(225, 180, 15, 15);
		Content.add(lvlL16);
		
		JLabel lvlL17 = new JLabel("");
		lvlL17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 236))));
		lvlL17.setBounds(240, 180, 15, 15);
		Content.add(lvlL17);
		
		JLabel lvlL18 = new JLabel("");
		lvlL18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 237))));
		lvlL18.setBounds(255, 180, 15, 15);
		Content.add(lvlL18);
		
		JLabel lvlL19 = new JLabel("");
		lvlL19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 238))));
		lvlL19.setBounds(270, 180, 15, 15);
		Content.add(lvlL19);
		
		JLabel lvlL20 = new JLabel("");
		lvlL20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 239))));
		lvlL20.setBounds(285, 180, 15, 15);
		Content.add(lvlL20);
		
		// M-Reihe (id: 240-259)
		
		JLabel lvlM1 = new JLabel("");
		lvlM1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 240))));
		lvlM1.setBounds(0, 195, 15, 15);
		Content.add(lvlM1);
		
		JLabel lvlM2 = new JLabel("");
		lvlM2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 241))));
		lvlM2.setBounds(15, 195, 15, 15);
		Content.add(lvlM2);
		
		JLabel lvlM3 = new JLabel("");
		lvlM3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 242))));
		lvlM3.setBounds(30, 195, 15, 15);
		Content.add(lvlM3);
		
		JLabel lvlM4 = new JLabel("");
		lvlM4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 243))));
		lvlM4.setBounds(45, 195, 15, 15);
		Content.add(lvlM4);
		
		JLabel lvlM5 = new JLabel("");
		lvlM5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 244))));
		lvlM5.setBounds(60, 195, 15, 15);
		Content.add(lvlM5);
		
		JLabel lvlM6 = new JLabel("");
		lvlM6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 245))));
		lvlM6.setBounds(75, 195, 15, 15);
		Content.add(lvlM6);
		
		JLabel lvlM7 = new JLabel("");
		lvlM7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 246))));
		lvlM7.setBounds(90, 195, 15, 15);
		Content.add(lvlM7);
		
		JLabel lvlM8 = new JLabel("");
		lvlM8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 247))));
		lvlM8.setBounds(105, 195, 15, 15);
		Content.add(lvlM8);
		
		JLabel lvlM9 = new JLabel("");
		lvlM9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 248))));
		lvlM9.setBounds(120, 195, 15, 15);
		Content.add(lvlM9);
		
		JLabel lvlM10 = new JLabel("");
		lvlM10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 249))));
		lvlM10.setBounds(135, 195, 15, 15);
		Content.add(lvlM10);
		
		JLabel lvlM11 = new JLabel("");
		lvlM11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 250))));
		lvlM11.setBounds(150, 195, 15, 15);
		Content.add(lvlM11);
		
		JLabel lvlM12 = new JLabel("");
		lvlM12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 251))));
		lvlM12.setBounds(165, 195, 15, 15);
		Content.add(lvlM12);
		
		JLabel lvlM13 = new JLabel("");
		lvlM13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 252))));
		lvlM13.setBounds(180, 195, 15, 15);
		Content.add(lvlM13);
		
		JLabel lvlM14 = new JLabel("");
		lvlM14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 253))));
		lvlM14.setBounds(195, 195, 15, 15);
		Content.add(lvlM14);
		
		JLabel lvlM15 = new JLabel("");
		lvlM15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 254))));
		lvlM15.setBounds(210, 195, 15, 15);
		Content.add(lvlM15);
		
		JLabel lvlM16 = new JLabel("");
		lvlM16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 255))));
		lvlM16.setBounds(225, 195, 15, 15);
		Content.add(lvlM16);
		
		JLabel lvlM17 = new JLabel("");
		lvlM17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 256))));
		lvlM17.setBounds(240, 195, 15, 15);
		Content.add(lvlM17);
		
		JLabel lvlM18 = new JLabel("");
		lvlM18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 257))));
		lvlM18.setBounds(255, 195, 15, 15);
		Content.add(lvlM18);
		
		JLabel lvlM19 = new JLabel("");
		lvlM19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 258))));
		lvlM19.setBounds(270, 195, 15, 15);
		Content.add(lvlM19);
		
		JLabel lvlM20 = new JLabel("");
		lvlM20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 259))));
		lvlM20.setBounds(285, 195, 15, 15);
		Content.add(lvlM20);
		
		// N-Reihe (id: 260-279)
		
		JLabel lvlN1 = new JLabel("");
		lvlN1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 260))));
		lvlN1.setBounds(0, 210, 15, 15);
		Content.add(lvlN1);
		
		JLabel lvlN2 = new JLabel("");
		lvlN2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 261))));
		lvlN2.setBounds(15, 210, 15, 15);
		Content.add(lvlN2);
		
		JLabel lvlN3 = new JLabel("");
		lvlN3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 262))));
		lvlN3.setBounds(30, 210, 15, 15);
		Content.add(lvlN3);
		
		JLabel lvlN4 = new JLabel("");
		lvlN4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 263))));
		lvlN4.setBounds(45, 210, 15, 15);
		Content.add(lvlN4);
		
		JLabel lvlN5 = new JLabel("");
		lvlN5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 264))));
		lvlN5.setBounds(60, 210, 15, 15);
		Content.add(lvlN5);
		
		JLabel lvlN6 = new JLabel("");
		lvlN6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 265))));
		lvlN6.setBounds(75, 210, 15, 15);
		Content.add(lvlN6);
		
		JLabel lvlN7 = new JLabel("");
		lvlN7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 266))));
		lvlN7.setBounds(90, 210, 15, 15);
		Content.add(lvlN7);
		
		JLabel lvlN8 = new JLabel("");
		lvlN8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 267))));
		lvlN8.setBounds(105, 210, 15, 15);
		Content.add(lvlN8);
		
		JLabel lvlN9 = new JLabel("");
		lvlN9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 268))));
		lvlN9.setBounds(120, 210, 15, 15);
		Content.add(lvlN9);
		
		JLabel lvlN10 = new JLabel("");
		lvlN10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 269))));
		lvlN10.setBounds(135, 210, 15, 15);
		Content.add(lvlN10);
		
		JLabel lvlN11 = new JLabel("");
		lvlN11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 270))));
		lvlN11.setBounds(150, 210, 15, 15);
		Content.add(lvlN11);
		
		JLabel lvlN12 = new JLabel("");
		lvlN12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 271))));
		lvlN12.setBounds(165, 210, 15, 15);
		Content.add(lvlN12);
		
		JLabel lvlN13 = new JLabel("");
		lvlN13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 272))));
		lvlN13.setBounds(180, 210, 15, 15);
		Content.add(lvlN13);
		
		JLabel lvlN14 = new JLabel("");
		lvlN14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 273))));
		lvlN14.setBounds(195, 210, 15, 15);
		Content.add(lvlN14);
		
		JLabel lvlN15 = new JLabel("");
		lvlN15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 274))));
		lvlN15.setBounds(210, 210, 15, 15);
		Content.add(lvlN15);
		
		JLabel lvlN16 = new JLabel("");
		lvlN16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 275))));
		lvlN16.setBounds(225, 210, 15, 15);
		Content.add(lvlN16);
		
		JLabel lvlN17 = new JLabel("");
		lvlN17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 276))));
		lvlN17.setBounds(240, 210, 15, 15);
		Content.add(lvlN17);
		
		JLabel lvlN18 = new JLabel("");
		lvlN18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 277))));
		lvlN18.setBounds(255, 210, 15, 15);
		Content.add(lvlN18);
		
		JLabel lvlN19 = new JLabel("");
		lvlN19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 278))));
		lvlN19.setBounds(270, 210, 15, 15);
		Content.add(lvlN19);
		
		JLabel lvlN20 = new JLabel("");
		lvlN20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 279))));
		lvlN20.setBounds(285, 210, 15, 15);
		Content.add(lvlN20);
		
		// O-Reihe (id: 280-299)
		
		JLabel lvlO1 = new JLabel("");
		lvlO1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 280))));
		lvlO1.setBounds(0, 225, 15, 15);
		Content.add(lvlO1);
		
		JLabel lvlO2 = new JLabel("");
		lvlO2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 281))));
		lvlO2.setBounds(15, 225, 15, 15);
		Content.add(lvlO2);
		
		JLabel lvlO3 = new JLabel("");
		lvlO3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 282))));
		lvlO3.setBounds(30, 225, 15, 15);
		Content.add(lvlO3);
		
		JLabel lvlO4 = new JLabel("");
		lvlO4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 283))));
		lvlO4.setBounds(45, 225, 15, 15);
		Content.add(lvlO4);
		
		JLabel lvlO5 = new JLabel("");
		lvlO5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 284))));
		lvlO5.setBounds(60, 225, 15, 15);
		Content.add(lvlO5);
		
		JLabel lvlO6 = new JLabel("");
		lvlO6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 285))));
		lvlO6.setBounds(75, 225, 15, 15);
		Content.add(lvlO6);
		
		JLabel lvlO7 = new JLabel("");
		lvlO7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 286))));
		lvlO7.setBounds(90, 225, 15, 15);
		Content.add(lvlO7);
		
		JLabel lvlO8 = new JLabel("");
		lvlO8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 287))));
		lvlO8.setBounds(105, 225, 15, 15);
		Content.add(lvlO8);
		
		JLabel lvlO9 = new JLabel("");
		lvlO9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 288))));
		lvlO9.setBounds(120, 225, 15, 15);
		Content.add(lvlO9);
		
		JLabel lvlO10 = new JLabel("");
		lvlO10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 289))));
		lvlO10.setBounds(135, 225, 15, 15);
		Content.add(lvlO10);
		
		JLabel lvlO11 = new JLabel("");
		lvlO11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 290))));
		lvlO11.setBounds(150, 225, 15, 15);
		Content.add(lvlO11);
		
		JLabel lvlO12 = new JLabel("");
		lvlO12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 291))));
		lvlO12.setBounds(165, 225, 15, 15);
		Content.add(lvlO12);
		
		JLabel lvlO13 = new JLabel("");
		lvlO13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 292))));
		lvlO13.setBounds(180, 225, 15, 15);
		Content.add(lvlO13);
		
		JLabel lvlO14 = new JLabel("");
		lvlO14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 293))));
		lvlO14.setBounds(195, 225, 15, 15);
		Content.add(lvlO14);
		
		JLabel lvlO15 = new JLabel("");
		lvlO15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 294))));
		lvlO15.setBounds(210, 225, 15, 15);
		Content.add(lvlO15);
		
		JLabel lvlO16 = new JLabel("");
		lvlO16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 295))));
		lvlO16.setBounds(225, 225, 15, 15);
		Content.add(lvlO16);
		
		JLabel lvlO17 = new JLabel("");
		lvlO17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 296))));
		lvlO17.setBounds(240, 225, 15, 15);
		Content.add(lvlO17);
		
		JLabel lvlO18 = new JLabel("");
		lvlO18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 297))));
		lvlO18.setBounds(255, 225, 15, 15);
		Content.add(lvlO18);
		
		JLabel lvlO19 = new JLabel("");
		lvlO19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 298))));
		lvlO19.setBounds(270, 225, 15, 15);
		Content.add(lvlO19);
		
		JLabel lvlO20 = new JLabel("");
		lvlO20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 299))));
		lvlO20.setBounds(285, 225, 15, 15);
		Content.add(lvlO20);
		}
	
		
	
		

	}

