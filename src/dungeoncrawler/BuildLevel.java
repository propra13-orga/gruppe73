package dungeoncrawler;



import java.awt.Color;
import java.io.IOException;

import dungeoncrawler.Player;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import dungeoncrawler.CollisionControl;
import dungeoncrawler.LoadLevel;
import dungeoncrawler.Treasure;


// ###################################################
// Diese Klasse bildet die Mainmethode des Spiels!
// ###################################################

public class BuildLevel extends JFrame {

	/**
	 * 
	 */
	
	
	
	// ZUSTAENDE:
	
	public static int Current_Level = 1;
	public static boolean game_over = false;
	public static boolean change_level_phase = false;
	public static int level_load = 1;
	public static boolean first_load = true;
	public static int dismatch = 300;
	public static boolean got_treasure = false;
	public static boolean stop_treasure = false;
	public static boolean change_level_exitX = false;
	public static boolean change_level_exitY = false;
	
	private static int counter = 0;
	
	
	private static final long serialVersionUID = 1L;
	private static JPanel Content;
	private static javax.swing.JLabel lblPlayer;
	private static MovementListener mListener;
	
	static javax.swing.JLabel lblPunkteanzeige;
	private static javax.swing.JLabel lblGegner1;
	private static javax.swing.JLabel lblGameOver;
	private static javax.swing.JLabel lblNeustart;
	public static javax.swing.JLabel lblTreasure;
	
	// Spielfeld Definitionen:
	
	private static javax.swing.JLabel lvlA1;
	private static javax.swing.JLabel lvlA2;
	private static javax.swing.JLabel lvlA3;
	private static javax.swing.JLabel lvlA4;
	private static javax.swing.JLabel lvlA5;
	private static javax.swing.JLabel lvlA6;
	private static javax.swing.JLabel lvlA7;
	private static javax.swing.JLabel lvlA8;
	private static javax.swing.JLabel lvlA9;
	private static javax.swing.JLabel lvlA10;
	private static javax.swing.JLabel lvlA11;
	private static javax.swing.JLabel lvlA12;
	private static javax.swing.JLabel lvlA13;
	private static javax.swing.JLabel lvlA14;
	private static javax.swing.JLabel lvlA15;
	private static javax.swing.JLabel lvlA16;
	private static javax.swing.JLabel lvlA17;
	private static javax.swing.JLabel lvlA18;
	private static javax.swing.JLabel lvlA19;
	private static javax.swing.JLabel lvlA20;
	
	private static javax.swing.JLabel lvlB1;
	private static javax.swing.JLabel lvlB2;
	private static javax.swing.JLabel lvlB3;
	private static javax.swing.JLabel lvlB4;
	private static javax.swing.JLabel lvlB5;
	private static javax.swing.JLabel lvlB6;
	private static javax.swing.JLabel lvlB7;
	private static javax.swing.JLabel lvlB8;
	private static javax.swing.JLabel lvlB9;
	private static javax.swing.JLabel lvlB10;
	private static javax.swing.JLabel lvlB11;
	private static javax.swing.JLabel lvlB12;
	private static javax.swing.JLabel lvlB13;
	private static javax.swing.JLabel lvlB14;
	private static javax.swing.JLabel lvlB15;
	private static javax.swing.JLabel lvlB16;
	private static javax.swing.JLabel lvlB17;
	private static javax.swing.JLabel lvlB18;
	private static javax.swing.JLabel lvlB19;
	private static javax.swing.JLabel lvlB20;
	
	private static javax.swing.JLabel lvlC1;
	private static javax.swing.JLabel lvlC2;
	private static javax.swing.JLabel lvlC3;
	private static javax.swing.JLabel lvlC4;
	private static javax.swing.JLabel lvlC5;
	private static javax.swing.JLabel lvlC6;
	private static javax.swing.JLabel lvlC7;
	private static javax.swing.JLabel lvlC8;
	private static javax.swing.JLabel lvlC9;
	private static javax.swing.JLabel lvlC10;
	private static javax.swing.JLabel lvlC11;
	private static javax.swing.JLabel lvlC12;
	private static javax.swing.JLabel lvlC13;
	private static javax.swing.JLabel lvlC14;
	private static javax.swing.JLabel lvlC15;
	private static javax.swing.JLabel lvlC16;
	private static javax.swing.JLabel lvlC17;
	private static javax.swing.JLabel lvlC18;
	private static javax.swing.JLabel lvlC19;
	private static javax.swing.JLabel lvlC20;
	
	private static javax.swing.JLabel lvlD1;
	private static javax.swing.JLabel lvlD2;
	private static javax.swing.JLabel lvlD3;
	private static javax.swing.JLabel lvlD4;
	private static javax.swing.JLabel lvlD5;
	private static javax.swing.JLabel lvlD6;
	private static javax.swing.JLabel lvlD7;
	private static javax.swing.JLabel lvlD8;
	private static javax.swing.JLabel lvlD9;
	private static javax.swing.JLabel lvlD10;
	private static javax.swing.JLabel lvlD11;
	private static javax.swing.JLabel lvlD12;
	private static javax.swing.JLabel lvlD13;
	private static javax.swing.JLabel lvlD14;
	private static javax.swing.JLabel lvlD15;
	private static javax.swing.JLabel lvlD16;
	private static javax.swing.JLabel lvlD17;
	private static javax.swing.JLabel lvlD18;
	private static javax.swing.JLabel lvlD19;
	private static javax.swing.JLabel lvlD20;
	
	private static javax.swing.JLabel lvlE1;
	private static javax.swing.JLabel lvlE2;
	private static javax.swing.JLabel lvlE3;
	private static javax.swing.JLabel lvlE4;
	private static javax.swing.JLabel lvlE5;
	private static javax.swing.JLabel lvlE6;
	private static javax.swing.JLabel lvlE7;
	private static javax.swing.JLabel lvlE8;
	private static javax.swing.JLabel lvlE9;
	private static javax.swing.JLabel lvlE10;
	private static javax.swing.JLabel lvlE11;
	private static javax.swing.JLabel lvlE12;
	private static javax.swing.JLabel lvlE13;
	private static javax.swing.JLabel lvlE14;
	private static javax.swing.JLabel lvlE15;
	private static javax.swing.JLabel lvlE16;
	private static javax.swing.JLabel lvlE17;
	private static javax.swing.JLabel lvlE18;
	private static javax.swing.JLabel lvlE19;
	private static javax.swing.JLabel lvlE20;
	
	private static javax.swing.JLabel lvlF1;
	private static javax.swing.JLabel lvlF2;
	private static javax.swing.JLabel lvlF3;
	private static javax.swing.JLabel lvlF4;
	private static javax.swing.JLabel lvlF5;
	private static javax.swing.JLabel lvlF6;
	private static javax.swing.JLabel lvlF7;
	private static javax.swing.JLabel lvlF8;
	private static javax.swing.JLabel lvlF9;
	private static javax.swing.JLabel lvlF10;
	private static javax.swing.JLabel lvlF11;
	private static javax.swing.JLabel lvlF12;
	private static javax.swing.JLabel lvlF13;
	private static javax.swing.JLabel lvlF14;
	private static javax.swing.JLabel lvlF15;
	private static javax.swing.JLabel lvlF16;
	private static javax.swing.JLabel lvlF17;
	private static javax.swing.JLabel lvlF18;
	private static javax.swing.JLabel lvlF19;
	private static javax.swing.JLabel lvlF20;
	
	private static javax.swing.JLabel lvlG1;
	private static javax.swing.JLabel lvlG2;
	private static javax.swing.JLabel lvlG3;
	private static javax.swing.JLabel lvlG4;
	private static javax.swing.JLabel lvlG5;
	private static javax.swing.JLabel lvlG6;
	private static javax.swing.JLabel lvlG7;
	private static javax.swing.JLabel lvlG8;
	private static javax.swing.JLabel lvlG9;
	private static javax.swing.JLabel lvlG10;
	private static javax.swing.JLabel lvlG11;
	private static javax.swing.JLabel lvlG12;
	private static javax.swing.JLabel lvlG13;
	private static javax.swing.JLabel lvlG14;
	private static javax.swing.JLabel lvlG15;
	private static javax.swing.JLabel lvlG16;
	private static javax.swing.JLabel lvlG17;
	private static javax.swing.JLabel lvlG18;
	private static javax.swing.JLabel lvlG19;
	private static javax.swing.JLabel lvlG20;
	
	private static javax.swing.JLabel lvlH1;
	private static javax.swing.JLabel lvlH2;
	private static javax.swing.JLabel lvlH3;
	private static javax.swing.JLabel lvlH4;
	private static javax.swing.JLabel lvlH5;
	private static javax.swing.JLabel lvlH6;
	private static javax.swing.JLabel lvlH7;
	private static javax.swing.JLabel lvlH8;
	private static javax.swing.JLabel lvlH9;
	private static javax.swing.JLabel lvlH10;
	private static javax.swing.JLabel lvlH11;
	private static javax.swing.JLabel lvlH12;
	private static javax.swing.JLabel lvlH13;
	private static javax.swing.JLabel lvlH14;
	private static javax.swing.JLabel lvlH15;
	private static javax.swing.JLabel lvlH16;
	private static javax.swing.JLabel lvlH17;
	private static javax.swing.JLabel lvlH18;
	private static javax.swing.JLabel lvlH19;
	private static javax.swing.JLabel lvlH20;
	
	private static javax.swing.JLabel lvlI1;
	private static javax.swing.JLabel lvlI2;
	private static javax.swing.JLabel lvlI3;
	private static javax.swing.JLabel lvlI4;
	private static javax.swing.JLabel lvlI5;
	private static javax.swing.JLabel lvlI6;
	private static javax.swing.JLabel lvlI7;
	private static javax.swing.JLabel lvlI8;
	private static javax.swing.JLabel lvlI9;
	private static javax.swing.JLabel lvlI10;
	private static javax.swing.JLabel lvlI11;
	private static javax.swing.JLabel lvlI12;
	private static javax.swing.JLabel lvlI13;
	private static javax.swing.JLabel lvlI14;
	private static javax.swing.JLabel lvlI15;
	private static javax.swing.JLabel lvlI16;
	private static javax.swing.JLabel lvlI17;
	private static javax.swing.JLabel lvlI18;
	private static javax.swing.JLabel lvlI19;
	private static javax.swing.JLabel lvlI20;
	
	
	private static javax.swing.JLabel lvlJ1;
	private static javax.swing.JLabel lvlJ2;
	private static javax.swing.JLabel lvlJ3;
	private static javax.swing.JLabel lvlJ4;
	private static javax.swing.JLabel lvlJ5;
	private static javax.swing.JLabel lvlJ6;
	private static javax.swing.JLabel lvlJ7;
	private static javax.swing.JLabel lvlJ8;
	private static javax.swing.JLabel lvlJ9;
	private static javax.swing.JLabel lvlJ10;
	private static javax.swing.JLabel lvlJ11;
	private static javax.swing.JLabel lvlJ12;
	private static javax.swing.JLabel lvlJ13;
	private static javax.swing.JLabel lvlJ14;
	private static javax.swing.JLabel lvlJ15;
	private static javax.swing.JLabel lvlJ16;
	private static javax.swing.JLabel lvlJ17;
	private static javax.swing.JLabel lvlJ18;
	private static javax.swing.JLabel lvlJ19;
	private static javax.swing.JLabel lvlJ20;
	
	private static javax.swing.JLabel lvlK1;
	private static javax.swing.JLabel lvlK2;
	private static javax.swing.JLabel lvlK3;
	private static javax.swing.JLabel lvlK4;
	private static javax.swing.JLabel lvlK5;
	private static javax.swing.JLabel lvlK6;
	private static javax.swing.JLabel lvlK7;
	private static javax.swing.JLabel lvlK8;
	private static javax.swing.JLabel lvlK9;
	private static javax.swing.JLabel lvlK10;
	private static javax.swing.JLabel lvlK11;
	private static javax.swing.JLabel lvlK12;
	private static javax.swing.JLabel lvlK13;
	private static javax.swing.JLabel lvlK14;
	private static javax.swing.JLabel lvlK15;
	private static javax.swing.JLabel lvlK16;
	private static javax.swing.JLabel lvlK17;
	private static javax.swing.JLabel lvlK18;
	private static javax.swing.JLabel lvlK19;
	private static javax.swing.JLabel lvlK20;
	
	private static javax.swing.JLabel lvlL1;
	private static javax.swing.JLabel lvlL2;
	private static javax.swing.JLabel lvlL3;
	private static javax.swing.JLabel lvlL4;
	private static javax.swing.JLabel lvlL5;
	private static javax.swing.JLabel lvlL6;
	private static javax.swing.JLabel lvlL7;
	private static javax.swing.JLabel lvlL8;
	private static javax.swing.JLabel lvlL9;
	private static javax.swing.JLabel lvlL10;
	private static javax.swing.JLabel lvlL11;
	private static javax.swing.JLabel lvlL12;
	private static javax.swing.JLabel lvlL13;
	private static javax.swing.JLabel lvlL14;
	private static javax.swing.JLabel lvlL15;
	private static javax.swing.JLabel lvlL16;
	private static javax.swing.JLabel lvlL17;
	private static javax.swing.JLabel lvlL18;
	private static javax.swing.JLabel lvlL19;
	private static javax.swing.JLabel lvlL20;
	
	private static javax.swing.JLabel lvlM1;
	private static javax.swing.JLabel lvlM2;
	private static javax.swing.JLabel lvlM3;
	private static javax.swing.JLabel lvlM4;
	private static javax.swing.JLabel lvlM5;
	private static javax.swing.JLabel lvlM6;
	private static javax.swing.JLabel lvlM7;
	private static javax.swing.JLabel lvlM8;
	private static javax.swing.JLabel lvlM9;
	private static javax.swing.JLabel lvlM10;
	private static javax.swing.JLabel lvlM11;
	private static javax.swing.JLabel lvlM12;
	private static javax.swing.JLabel lvlM13;
	private static javax.swing.JLabel lvlM14;
	private static javax.swing.JLabel lvlM15;
	private static javax.swing.JLabel lvlM16;
	private static javax.swing.JLabel lvlM17;
	private static javax.swing.JLabel lvlM18;
	private static javax.swing.JLabel lvlM19;
	private static javax.swing.JLabel lvlM20;
	
	private static javax.swing.JLabel lvlN1;
	private static javax.swing.JLabel lvlN2;
	private static javax.swing.JLabel lvlN3;
	private static javax.swing.JLabel lvlN4;
	private static javax.swing.JLabel lvlN5;
	private static javax.swing.JLabel lvlN6;
	private static javax.swing.JLabel lvlN7;
	private static javax.swing.JLabel lvlN8;
	private static javax.swing.JLabel lvlN9;
	private static javax.swing.JLabel lvlN10;
	private static javax.swing.JLabel lvlN11;
	private static javax.swing.JLabel lvlN12;
	private static javax.swing.JLabel lvlN13;
	private static javax.swing.JLabel lvlN14;
	private static javax.swing.JLabel lvlN15;
	private static javax.swing.JLabel lvlN16;
	private static javax.swing.JLabel lvlN17;
	private static javax.swing.JLabel lvlN18;
	private static javax.swing.JLabel lvlN19;
	private static javax.swing.JLabel lvlN20;
	
	private static javax.swing.JLabel lvlO1;
	private static javax.swing.JLabel lvlO2;
	private static javax.swing.JLabel lvlO3;
	private static javax.swing.JLabel lvlO4;
	private static javax.swing.JLabel lvlO5;
	private static javax.swing.JLabel lvlO6;
	private static javax.swing.JLabel lvlO7;
	private static javax.swing.JLabel lvlO8;
	private static javax.swing.JLabel lvlO9;
	private static javax.swing.JLabel lvlO10;
	private static javax.swing.JLabel lvlO11;
	private static javax.swing.JLabel lvlO12;
	private static javax.swing.JLabel lvlO13;
	private static javax.swing.JLabel lvlO14;
	private static javax.swing.JLabel lvlO15;
	private static javax.swing.JLabel lvlO16;
	private static javax.swing.JLabel lvlO17;
	private static javax.swing.JLabel lvlO18;
	private static javax.swing.JLabel lvlO19;
	private static javax.swing.JLabel lvlO20;
	
	// Player-Startposition
	public static int newY = 225;
    public static int newX = 30;
    
    // Trasury-Starposition
    
    public static int treasureX = 300;
    public static int treasureY = 15;
    

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
	
	public static void PlayerPosition(String args[]) {
		lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
		
	}

	public static int getCurrentPlayerPos(int XY) {
		int Pos = 0;
		if (XY == 0) {
			Pos = lblPlayer.getX();
		} else if (XY == 1) {
			Pos = lblPlayer.getY();
		}
		return Pos;
	} 
	
	public BuildLevel() {
		setResizable(false);
		

		
		//create Jframe and Grid
		
		setTitle("Dungeon Crawler - Level "+Current_Level);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 306, 272);
		Content = new JPanel();
		Content.setBackground(Color.WHITE);
		Content.setBorder(null);
		setContentPane(Content);
		Content.setLayout(null);
		change_level_phase = false;
		
		
		
		
		mListener = new MovementListener() {
			@Override
			public void doMovement(int left, int right, int up, int down) {
				
				if ((Current_Level != level_load)|(first_load = true)) {
					
					
					if (first_load = true) {
						
						first_load = false;
						
					}
					
					
						
						
						
						lvlA1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 0))));
						lvlA2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 1))));
						lvlA3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 2))));
						lvlA4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 3))));
						lvlA5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 4))));
						lvlA6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 5))));
						lvlA7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 6))));
						lvlA8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 7))));
						lvlA9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 8))));
						lvlA10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 9))));
						lvlA11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 10))));
						lvlA12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 11))));
						lvlA13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 12))));
						lvlA14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 13))));
						lvlA15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 14))));
						lvlA16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 15))));
						lvlA17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 16))));
						lvlA18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 17))));
						lvlA19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 18))));
						lvlA20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 19))));
						
						lvlB1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 20))));
						lvlB2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 21))));
						lvlB3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 22))));
						lvlB4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 23))));
						lvlB5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 24))));
						lvlB6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 25))));
						lvlB7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 26))));
						lvlB8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 27))));
						lvlB9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 28))));
						lvlB10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 29))));
						lvlB11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 30))));
						lvlB12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 31))));
						lvlB13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 32))));
						lvlB14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 33))));
						lvlB15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 34))));
						lvlB16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 35))));
						lvlB17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 36))));
						lvlB18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 37))));
						lvlB19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 38))));
						lvlB20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 39))));
	
						lvlC1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 40))));
						lvlC2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 41))));
						lvlC3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 42))));
						lvlC4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 43))));
						lvlC5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 44))));
						lvlC6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 45))));
						lvlC7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 46))));
						lvlC8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 47))));
						lvlC9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 48))));
						lvlC10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 49))));
						lvlC11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 50))));
						lvlC12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 51))));
						lvlC13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 52))));
						lvlC14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 53))));
						lvlC15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 54))));
						lvlC16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 55))));
						lvlC17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 56))));
						lvlC18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 57))));
						lvlC19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 58))));
						lvlC20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 59))));
	
						lvlD1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 60))));
						lvlD2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 61))));
						lvlD3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 62))));
						lvlD4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 63))));
						lvlD5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 64))));
						lvlD6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 65))));
						lvlD7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 66))));
						lvlD8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 67))));
						lvlD9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 68))));
						lvlD10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 69))));
						lvlD11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 70))));
						lvlD12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 71))));
						lvlD13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 72))));
						lvlD14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 73))));
						lvlD15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 74))));
						lvlD16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 75))));
						lvlD17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 76))));
						lvlD18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 77))));
						lvlD19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 78))));
						lvlD20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 79))));
	
						lvlE1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 80))));
						lvlE2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 81))));
						lvlE3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 82))));
						lvlE4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 83))));
						lvlE5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 84))));
						lvlE6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 85))));
						lvlE7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 86))));
						lvlE8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 87))));
						lvlE9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 88))));
						lvlE10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 89))));
						lvlE11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 90))));
						lvlE12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 91))));
						lvlE13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 92))));
						lvlE14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 93))));
						lvlE15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 94))));
						lvlE16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 95))));
						lvlE17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 96))));
						lvlE18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 97))));
						lvlE19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 98))));
						lvlE20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 99))));
	
						lvlF1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 100))));
						lvlF2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 101))));
						lvlF3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 102))));
						lvlF4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 103))));
						lvlF5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 104))));
						lvlF6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 105))));
						lvlF7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 106))));
						lvlF8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 107))));
						lvlF9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 108))));
						lvlF10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 109))));
						lvlF11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 110))));
						lvlF12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 111))));
						lvlF13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 112))));
						lvlF14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 113))));
						lvlF15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 114))));
						lvlF16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 115))));
						lvlF17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 116))));
						lvlF18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 117))));
						lvlF19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 118))));
						lvlF20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 119))));
	
						lvlG1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 120))));
						lvlG2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 121))));
						lvlG3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 122))));
						lvlG4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 123))));
						lvlG5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 124))));
						lvlG6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 125))));
						lvlG7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 126))));
						lvlG8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 127))));
						lvlG9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 128))));
						lvlG10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 129))));
						lvlG11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 130))));
						lvlG12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 131))));
						lvlG13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 132))));
						lvlG14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 133))));
						lvlG15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 134))));
						lvlG16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 135))));
						lvlG17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 136))));
						lvlG18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 137))));
						lvlG19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 138))));
						lvlG20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 139))));
	
						lvlH1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 140))));
						lvlH2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 141))));
						lvlH3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 142))));
						lvlH4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 143))));
						lvlH5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 144))));
						lvlH6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 145))));
						lvlH7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 146))));
						lvlH8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 147))));
						lvlH9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 148))));
						lvlH10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 149))));
						lvlH11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 150))));
						lvlH12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 151))));
						lvlH13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 152))));
						lvlH14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 153))));
						lvlH15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 154))));
						lvlH16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 155))));
						lvlH17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 156))));
						lvlH18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 157))));
						lvlH19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 158))));
						lvlH20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 159))));
	
						lvlI1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 160))));
						lvlI2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 161))));
						lvlI3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 162))));
						lvlI4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 163))));
						lvlI5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 164))));
						lvlI6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 165))));
						lvlI7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 166))));
						lvlI8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 167))));
						lvlI9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 168))));
						lvlI10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 169))));
						lvlI11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 170))));
						lvlI12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 171))));
						lvlI13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 172))));
						lvlI14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 173))));
						lvlI15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 174))));
						lvlI16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 175))));
						lvlI17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 176))));
						lvlI18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 177))));
						lvlI19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 178))));
						lvlI20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 179))));
	
						lvlJ1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 180))));
						lvlJ2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 181))));
						lvlJ3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 182))));
						lvlJ4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 183))));
						lvlJ5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 184))));
						lvlJ6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 185))));
						lvlJ7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 186))));
						lvlJ8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 187))));
						lvlJ9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 188))));
						lvlJ10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 189))));
						lvlJ11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 190))));
						lvlJ12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 191))));
						lvlJ13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 192))));
						lvlJ14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 193))));
						lvlJ15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 194))));
						lvlJ16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 195))));
						lvlJ17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 196))));
						lvlJ18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 197))));
						lvlJ19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 198))));
						lvlJ20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 199))));
	
						lvlK1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 200))));
						lvlK2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 201))));
						lvlK3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 202))));
						lvlK4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 203))));
						lvlK5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 204))));
						lvlK6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 205))));
						lvlK7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 206))));
						lvlK8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 207))));
						lvlK9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 208))));
						lvlK10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 209))));
						lvlK11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 210))));
						lvlK12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 211))));
						lvlK13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 212))));
						lvlK14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 213))));
						lvlK15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 214))));
						lvlK16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 215))));
						lvlK17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 216))));
						lvlK18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 217))));
						lvlK19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 218))));
						lvlK20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 219))));
	
						lvlL1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 220))));
						lvlL2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 221))));
						lvlL3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 222))));
						lvlL4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 223))));
						lvlL5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 224))));
						lvlL6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 225))));
						lvlL7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 226))));
						lvlL8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 227))));
						lvlL9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 228))));
						lvlL10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 229))));
						lvlL11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 230))));
						lvlL12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 231))));
						lvlL13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 232))));
						lvlL14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 233))));
						lvlL15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 234))));
						lvlL16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 235))));
						lvlL17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 236))));
						lvlL18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 237))));
						lvlL19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 238))));
						lvlL20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 239))));
	
						lvlM1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 240))));
						lvlM2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 241))));
						lvlM3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 242))));
						lvlM4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 243))));
						lvlM5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 244))));
						lvlM6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 245))));
						lvlM7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 246))));
						lvlM8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 247))));
						lvlM9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 248))));
						lvlM10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 249))));
						lvlM11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 250))));
						lvlM12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 251))));
						lvlM13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 252))));
						lvlM14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 253))));
						lvlM15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 254))));
						lvlM16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 255))));
						lvlM17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 256))));
						lvlM18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 257))));
						lvlM19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 258))));
						lvlM20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 259))));
	
						lvlN1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 260))));
						lvlN2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 261))));
						lvlN3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 262))));
						lvlN4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 263))));
						lvlN5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 264))));
						lvlN6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 265))));
						lvlN7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 266))));
						lvlN8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 267))));
						lvlN9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 268))));
						lvlN10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 269))));
						lvlN11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 270))));
						lvlN12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 271))));
						lvlN13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 272))));
						lvlN14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 273))));
						lvlN15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 274))));
						lvlN16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 275))));
						lvlN17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 276))));
						lvlN18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 277))));
						lvlN19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 278))));
						lvlN20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 279))));
	
						lvlO1.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 280))));
						lvlO2.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 281))));
						lvlO3.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 282))));
						lvlO4.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 283))));
						lvlO5.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 284))));
						lvlO6.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 285))));
						lvlO7.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 286))));
						lvlO8.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 287))));
						lvlO9.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 288))));
						lvlO10.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 289))));
						lvlO11.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 290))));
						lvlO12.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 291))));
						lvlO13.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 292))));
						lvlO14.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 293))));
						lvlO15.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 294))));
						lvlO16.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 295))));
						lvlO17.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 296))));
						lvlO18.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 297))));
						lvlO19.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 298))));
						lvlO20.setIcon(new ImageIcon(BuildLevel.class.getResource(LoadLevel.main(Current_Level, 299))));
					
						
					
					
					
			
				}
				
				/*
				 *  PLAYER BEWEGUNGSKOORDINATEN
				 *  ===========================
				 */
				
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
                
                CollisionControl.permit_movement = false;
                
                /*
                 *  
                 */
                
                // Bewegt den Player waehrend des Level-Wechsels an die mittlere Position
                
                if (BuildLevel.change_level_phase == true){
					newX = LoadLevel.getPlayerPosStartX(Current_Level);
					newY = LoadLevel.getPlayerPosStartY(Current_Level);
					level_load = level_load+1;
					counter = 2;
				}
                
                if ((BuildLevel.change_level_phase == true)&(counter == 2)) {
                	counter = 4;
                	change_level_phase = false;
                	newX = LoadLevel.getPlayerPosStartX(Current_Level);
					newY = LoadLevel.getPlayerPosStartY(Current_Level);
					change_level_exitX = true;
					
                }
                
                
                if ((change_level_exitX == true)&(counter == 6)) {
                	
                	newY = LoadLevel.getPlayerPosStartY(Current_Level);
                	
                	newX = LoadLevel.getPlayerPosStartX(Current_Level);
                	
					counter = 0;
					change_level_exitX = false;
                }
               
                
                if (change_level_exitX == true) {
                	
                	newY = LoadLevel.getPlayerPosStartY(Current_Level);
                	
                	newX = LoadLevel.getPlayerPosStartX(Current_Level);
                	
					counter = 6;
					
                }
                
               
                
                
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        lblPlayer.setBounds(newX,newY,lblPlayer.getWidth(), lblPlayer.getHeight());
                        lblTreasure.setBounds(Treasure.buildTreasureX(), Treasure.buildTreasureY(), 15, 15);
                        
                        /*  while (player.lives !=0)
                        {
                        	
                        }*/
                     //   if ((lblPlayer.getX() == LoadLevel.getDoorX(Current_Level))&(lblPlayer.getY() == LoadLevel.getDoorY(Current_Level))) {
                     //       Current_Level = (2);
                     //   }
                    }
                });
                
                
                // FALLEN-Abfrage
                
                
                if (Treasure.check_treasure() == true) {
                	Player.CurrentPoints = Player.CurrentPoints+100;
                	got_treasure = true;
                	
                	stop_treasure = true;
                	if (stop_treasure = true) {
                    	lblTreasure.setBounds(300, 15, 15, 15);
                    	stop_treasure = false;
                    	Treasure.check_treasure();
                    }
                }
                
                
                
                if (CollisionControl.check_Xborder(lblPlayer.getX()) == true) {
                	if (CollisionControl.check_trap(lblPlayer.getX(), lblPlayer.getY()) == true) {
                		lblGameOver.setVisible(true);
                		MovementListener.stopFlag = true;
                		
                	}
                	if (CollisionControl.check_Yborder(lblPlayer.getY()) == true) {
                    	if (CollisionControl.check_trap(lblPlayer.getX(), lblPlayer.getY()) == true) {
                    		lblGameOver.setVisible(true);
                    		lblNeustart.setVisible(true);
                    		lblNeustart.setEnabled(true);
                    		MovementListener.stopFlag = true;
                    		game_over = true;
                    		
                    	}	            	
                    }
                	
                }
                
                


                
                
                Content.repaint();
			}
			
		};
		mListener.setPriority(Thread.NORM_PRIORITY);
		

		
		
		
		
		// NEUSTART-Button
		
		
		
		
		//LEBENSANZEIGE
		
		JLabel lblLebensanzeige = new JLabel("1 ");
		lblLebensanzeige.setForeground(Color.BLACK);
		lblLebensanzeige.setBackground(Color.WHITE);
		lblLebensanzeige.setBounds(250, 0, 50, 15);
		lblLebensanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/heart.PNG")));
		lblLebensanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		Content.add(lblLebensanzeige);
		
		//Punkteanzeige
		
		lblPunkteanzeige = new JLabel(Player.CurrentPoints+" ");
		lblPunkteanzeige.setForeground(Color.BLACK);
		lblPunkteanzeige.setBackground(Color.WHITE);
		lblPunkteanzeige.setBounds(210, 0, 90, 15);
		lblPunkteanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/points.PNG")));
		//lblPunkteanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		Content.add(lblPunkteanzeige);
		
		// Treasure
		
		lblTreasure = new JLabel("");
		lblTreasure.setBounds(treasureX, treasureY, 15, 15);
		lblTreasure.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/points.PNG")));
		lblTreasure.setVisible(true);
		Content.add(lblTreasure);
		
		//Current_Level
		
		JLabel lblCurrentLevel = new JLabel("Level "+Current_Level);
		lblCurrentLevel.setBounds(3, 0, 46, 14);
		Content.add(lblCurrentLevel);
		
		lblGameOver = new JLabel("");
		lblGameOver.setBounds(50, 90, 200, 50);
		lblGameOver.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/gameover.PNG")));
		lblGameOver.setVisible(false);
		Content.add(lblGameOver);

		lblNeustart = new JLabel ("");
		lblNeustart.setBounds(50, 150, 200, 50);
		lblNeustart.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/restart.PNG")));
		lblNeustart.setEnabled(false);
		lblNeustart.setVisible(false);
		Content.add(lblNeustart);
		
		
		lblPlayer = new JLabel("");
		lblPlayer.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/player.PNG")));
		
		lblPlayer.setBounds(newX, newY, 15, 15);
		Content.add(lblPlayer);
		
		lblGegner1 = new JLabel("");
		lblGegner1.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/boooo.PNG")));
		lblGegner1.setBounds(30, 30, 15, 15);
		Content.add(lblGegner1);
		
		// Einzelne Level Items
		// Hab's leider nicht geschafft das zu automatisieren :-(
		
		// A-Reihe (id 0-19)
		
		lvlA1 = new JLabel("");
		lvlA1.setBounds(0, 15, 15, 15);
		Content.add(lvlA1);
		
		lvlA2 = new JLabel("");
		lvlA2.setBounds(15, 15, 15, 15);
		Content.add(lvlA2);
		
		lvlA3 = new JLabel("");
		lvlA3.setBounds(30, 15, 15, 15);
		Content.add(lvlA3);
		
		lvlA4 = new JLabel("");
		lvlA4.setBounds(45, 15, 15, 15);
		Content.add(lvlA4);
		
		lvlA5 = new JLabel("");
		lvlA5.setBounds(60, 15, 15, 15);
		Content.add(lvlA5);
		
		lvlA6 = new JLabel("");
		lvlA6.setBounds(75, 15, 15, 15);
		Content.add(lvlA6);
		
		lvlA7 = new JLabel("");
		lvlA7.setBounds(90, 15, 15, 15);
		Content.add(lvlA7);
		
		lvlA8 = new JLabel("");
		lvlA8.setBounds(105, 15, 15, 15);
		Content.add(lvlA8);
		
		lvlA9 = new JLabel("");
		lvlA9.setBounds(120, 15, 15, 15);
		Content.add(lvlA9);
		
		lvlA10 = new JLabel("");
		lvlA10.setBounds(135, 15, 15, 15);
		Content.add(lvlA10);
		
		lvlA11 = new JLabel("");
		lvlA11.setBounds(150, 15, 15, 15);
		Content.add(lvlA11);
		
		lvlA12 = new JLabel("");
		lvlA12.setBounds(165, 15, 15, 15);
		Content.add(lvlA12);
		
		lvlA13 = new JLabel("");
		lvlA13.setBounds(180, 15, 15, 15);
		Content.add(lvlA13);
		
		lvlA14 = new JLabel("");
		lvlA14.setBounds(195, 15, 15, 15);
		Content.add(lvlA14);
		
		lvlA15 = new JLabel("");
		lvlA15.setBounds(210, 15, 15, 15);
		Content.add(lvlA15);
		
		lvlA16 = new JLabel("");
		lvlA16.setBounds(225, 15, 15, 15);
		Content.add(lvlA16);
		
		lvlA17 = new JLabel("");
		lvlA17.setBounds(240, 15, 15, 15);
		Content.add(lvlA17);
		
		lvlA18 = new JLabel("");
		lvlA18.setBounds(255, 15, 15, 15);
		Content.add(lvlA18);
		
		lvlA19 = new JLabel("");
		lvlA19.setBounds(270, 15, 15, 15);
		Content.add(lvlA19);
		
		lvlA20 = new JLabel("");
		lvlA20.setBounds(285, 15, 15, 15);
		Content.add(lvlA20);
		
		// B-Reihe (id 20-39)
		
		
		lvlB1 = new JLabel("");
		lvlB1.setBounds(0, 30, 15, 15);
		Content.add(lvlB1);
		
		lvlB2 = new JLabel("");
		lvlB2.setBounds(15, 30, 15, 15);
		Content.add(lvlB2);
		
		lvlB3 = new JLabel("");
		lvlB3.setBounds(30, 30, 15, 15);
		Content.add(lvlB3);
		
		lvlB4 = new JLabel("");
		lvlB4.setBounds(45, 30, 15, 15);
		Content.add(lvlB4);
		
		lvlB5 = new JLabel("");
		lvlB5.setBounds(60, 30, 15, 15);
		Content.add(lvlB5);
		
		lvlB6 = new JLabel("");
		lvlB6.setBounds(75, 30, 15, 15);
		Content.add(lvlB6);
		
		lvlB7 = new JLabel("");
		lvlB7.setBounds(90, 30, 15, 15);
		Content.add(lvlB7);
		
		lvlB8 = new JLabel("");
		lvlB8.setBounds(105, 30, 15, 15);
		Content.add(lvlB8);
		
		lvlB9 = new JLabel("");
		lvlB9.setBounds(120, 30, 15, 15);
		Content.add(lvlB9);
		
		lvlB10 = new JLabel("");
		lvlB10.setBounds(135, 30, 15, 15);
		Content.add(lvlB10);
		
		lvlB11 = new JLabel("");
		lvlB11.setBounds(150, 30, 15, 15);
		Content.add(lvlB11);
		
		lvlB12 = new JLabel("");
		lvlB12.setBounds(165, 30, 15, 15);
		Content.add(lvlB12);
		
		lvlB13 = new JLabel("");
		lvlB13.setBounds(180, 30, 15, 15);
		Content.add(lvlB13);
		
		lvlB14 = new JLabel("");
		lvlB14.setBounds(195, 30, 15, 15);
		Content.add(lvlB14);
		
		lvlB15 = new JLabel("");
		lvlB15.setBounds(210, 30, 15, 15);
		Content.add(lvlB15);
		
		lvlB16 = new JLabel("");
		
		lvlB16.setBounds(225, 30, 15, 15);
		Content.add(lvlB16);
		
		lvlB17 = new JLabel("");
		lvlB17.setBounds(240, 30, 15, 15);
		Content.add(lvlB17);
		
		lvlB18 = new JLabel("");
		lvlB18.setBounds(255, 30, 15, 15);
		Content.add(lvlB18);
		
		lvlB19 = new JLabel("");
		lvlB19.setBounds(270, 30, 15, 15);
		Content.add(lvlB19);
		
		lvlB20 = new JLabel("");
		lvlB20.setBounds(285, 30, 15, 15);
		Content.add(lvlB20);
		
		// C-Reihe (id 40-59)
		
		lvlC1 = new JLabel("");
		lvlC1.setBounds(0, 45, 15, 15);
		Content.add(lvlC1);
		
		lvlC2 = new JLabel("");
		lvlC2.setBounds(15, 45, 15, 15);
		Content.add(lvlC2);
		
		lvlC3 = new JLabel("");
		lvlC3.setBounds(30, 45, 15, 15);
		Content.add(lvlC3);
		
		lvlC4 = new JLabel("");
		lvlC4.setBounds(45, 45, 15, 15);
		Content.add(lvlC4);
		
		lvlC5 = new JLabel("");
		lvlC5.setBounds(60, 45, 15, 15);
		Content.add(lvlC5);
		
		lvlC6 = new JLabel("");
		lvlC6.setBounds(75, 45, 15, 15);
		Content.add(lvlC6);
		
		lvlC7 = new JLabel("");
		lvlC7.setBounds(90, 45, 15, 15);
		Content.add(lvlC7);
		
		lvlC8 = new JLabel("");
		lvlC8.setBounds(105, 45, 15, 15);
		Content.add(lvlC8);
		
		lvlC9 = new JLabel("");
		lvlC9.setBounds(120, 45, 15, 15);
		Content.add(lvlC9);
		
		lvlC10 = new JLabel("");
		lvlC10.setBounds(135, 45, 15, 15);
		Content.add(lvlC10);
		
		lvlC11 = new JLabel("");
		lvlC11.setBounds(150, 45, 15, 15);
		Content.add(lvlC11);
		
		lvlC12 = new JLabel("");
		lvlC12.setBounds(165, 45, 15, 15);
		Content.add(lvlC12);
		
		lvlC13 = new JLabel("");
		lvlC13.setBounds(180, 45, 15, 15);
		Content.add(lvlC13);
		
		lvlC14 = new JLabel("");
		lvlC14.setBounds(195, 45, 15, 15);
		Content.add(lvlC14);
		
		lvlC15 = new JLabel("");
		lvlC15.setBounds(210, 45, 15, 15);
		Content.add(lvlC15);
		
		lvlC16 = new JLabel("");
		lvlC16.setBounds(225, 45, 15, 15);
		Content.add(lvlC16);
		
		lvlC17 = new JLabel("");
		lvlC17.setBounds(240, 45, 15, 15);
		Content.add(lvlC17);
		
		lvlC18 = new JLabel("");
		lvlC18.setBounds(255, 45, 15, 15);
		Content.add(lvlC18);
		
		lvlC19 = new JLabel("");
		lvlC19.setBounds(270, 45, 15, 15);
		Content.add(lvlC19);
		
		lvlC20 = new JLabel("");
		lvlC20.setBounds(285, 45, 15, 15);
		Content.add(lvlC20);
		
		// D-Reihe (id 60-79)
		
		lvlD1 = new JLabel("");
		lvlD1.setBounds(0, 60, 15, 15);
		Content.add(lvlD1);
		
		lvlD2 = new JLabel("");
		lvlD2.setBounds(15, 60, 15, 15);
		Content.add(lvlD2);
		
		lvlD3 = new JLabel("");
		lvlD3.setBounds(30, 60, 15, 15);
		Content.add(lvlD3);
		
		lvlD4 = new JLabel("");
		lvlD4.setBounds(45, 60, 15, 15);
		Content.add(lvlD4);
		
		lvlD5 = new JLabel("");
		lvlD5.setBounds(60, 60, 15, 15);
		Content.add(lvlD5);
		
		lvlD6 = new JLabel("");
		lvlD6.setBounds(75, 60, 15, 15);
		Content.add(lvlD6);
		
		lvlD7 = new JLabel("");
		lvlD7.setBounds(90, 60, 15, 15);
		Content.add(lvlD7);
		
		lvlD8 = new JLabel("");
		lvlD8.setBounds(105, 60, 15, 15);
		Content.add(lvlD8);
		
		lvlD9 = new JLabel("");
		lvlD9.setBounds(120, 60, 15, 15);
		Content.add(lvlD9);
		
		lvlD10 = new JLabel("");
		lvlD10.setBounds(135, 60, 15, 15);
		Content.add(lvlD10);
		
		lvlD11 = new JLabel("");
		lvlD11.setBounds(150, 60, 15, 15);
		Content.add(lvlD11);
		
		lvlD12 = new JLabel("");
		lvlD12.setBounds(165, 60, 15, 15);
		Content.add(lvlD12);
		
		lvlD13 = new JLabel("");
		lvlD13.setBounds(180, 60, 15, 15);
		Content.add(lvlD13);
		
		lvlD14 = new JLabel("");
		lvlD14.setBounds(195, 60, 15, 15);
		Content.add(lvlD14);
		
		lvlD15 = new JLabel("");
		lvlD15.setBounds(210, 60, 15, 15);
		Content.add(lvlD15);
		
		lvlD16 = new JLabel("");
		lvlD16.setBounds(225, 60, 15, 15);
		Content.add(lvlD16);
		
		lvlD17 = new JLabel("");
		lvlD17.setBounds(240, 60, 15, 15);
		Content.add(lvlD17);
		
		lvlD18 = new JLabel("");
		lvlD18.setBounds(255, 60, 15, 15);
		Content.add(lvlD18);
		
		lvlD19 = new JLabel("");
		lvlD19.setBounds(270, 60, 15, 15);
		Content.add(lvlD19);
		
		lvlD20 = new JLabel("");
		lvlD20.setBounds(285, 60, 15, 15);
		Content.add(lvlD20);
		
		// E-Reihe (id 80-99)
		
		lvlE1 = new JLabel("");
		lvlE1.setBounds(0, 75, 15, 15);
		Content.add(lvlE1);
		
		lvlE2 = new JLabel("");
		lvlE2.setBounds(15, 75, 15, 15);
		Content.add(lvlE2);
		
		lvlE3 = new JLabel("");
		lvlE3.setBounds(30, 75, 15, 15);
		Content.add(lvlE3);
		
		lvlE4 = new JLabel("");
		lvlE4.setBounds(45, 75, 15, 15);
		Content.add(lvlE4);
		
		lvlE5 = new JLabel("");
		lvlE5.setBounds(60, 75, 15, 15);
		Content.add(lvlE5);
		
		lvlE6 = new JLabel("");
		lvlE6.setBounds(75, 75, 15, 15);
		Content.add(lvlE6);
		
		lvlE7 = new JLabel("");
		lvlE7.setBounds(90, 75, 15, 15);
		Content.add(lvlE7);
		
		lvlE8 = new JLabel("");
		lvlE8.setBounds(105, 75, 15, 15);
		Content.add(lvlE8);
		
		lvlE9 = new JLabel("");
		lvlE9.setBounds(120, 75, 15, 15);
		Content.add(lvlE9);
		
		lvlE10 = new JLabel("");
		lvlE10.setBounds(135, 75, 15, 15);
		Content.add(lvlE10);
		
		lvlE11 = new JLabel("");
		lvlE11.setBounds(150, 75, 15, 15);
		Content.add(lvlE11);
		
		lvlE12 = new JLabel("");
		lvlE12.setBounds(165, 75, 15, 15);
		Content.add(lvlE12);
		
		lvlE13 = new JLabel("");
		lvlE13.setBounds(180, 75, 15, 15);
		Content.add(lvlE13);
		
		lvlE14 = new JLabel("");
		lvlE14.setBounds(195, 75, 15, 15);
		Content.add(lvlE14);
		
		lvlE15 = new JLabel("");
		lvlE15.setBounds(210, 75, 15, 15);
		Content.add(lvlE15);
		
		lvlE16 = new JLabel("");
		lvlE16.setBounds(225, 75, 15, 15);
		Content.add(lvlE16);
		
		lvlE17 = new JLabel("");
		lvlE17.setBounds(240, 75, 15, 15);
		Content.add(lvlE17);
		
		lvlE18 = new JLabel("");
		lvlE18.setBounds(255, 75, 15, 15);
		Content.add(lvlE18);
		
		lvlE19 = new JLabel("");
		lvlE19.setBounds(270, 75, 15, 15);
		Content.add(lvlE19);
		
		lvlE20 = new JLabel("");
		lvlE20.setBounds(285, 75, 15, 15);
		Content.add(lvlE20);
		
		// F-Reihe (id 100-119)
		
		lvlF1 = new JLabel("");
		lvlF1.setBounds(0, 90, 15, 15);
		Content.add(lvlF1);
		
		lvlF2 = new JLabel("");
		lvlF2.setBounds(15, 90, 15, 15);
		Content.add(lvlF2);
		
		lvlF3 = new JLabel("");
		lvlF3.setBounds(30, 90, 15, 15);
		Content.add(lvlF3);
		
		lvlF4 = new JLabel("");
		lvlF4.setBounds(45, 90, 15, 15);
		Content.add(lvlF4);
		
		lvlF5 = new JLabel("");
		lvlF5.setBounds(60, 90, 15, 15);
		Content.add(lvlF5);
		
		lvlF6 = new JLabel("");
		lvlF6.setBounds(75, 90, 15, 15);
		Content.add(lvlF6);
		
		lvlF7 = new JLabel("");
		lvlF7.setBounds(90, 90, 15, 15);
		Content.add(lvlF7);
		
		lvlF8 = new JLabel("");
		lvlF8.setBounds(105, 90, 15, 15);
		Content.add(lvlF8);
		
		lvlF9 = new JLabel("");
		lvlF9.setBounds(120, 90, 15, 15);
		Content.add(lvlF9);
		
		lvlF10 = new JLabel("");
		lvlF10.setBounds(135, 90, 15, 15);
		Content.add(lvlF10);
		
		lvlF11 = new JLabel("");
		lvlF11.setBounds(150, 90, 15, 15);
		Content.add(lvlF11);
		
		lvlF12 = new JLabel("");
		lvlF12.setBounds(165, 90, 15, 15);
		Content.add(lvlF12);
		
		lvlF13 = new JLabel("");
		lvlF13.setBounds(180, 90, 15, 15);
		Content.add(lvlF13);
		
		lvlF14 = new JLabel("");
		lvlF14.setBounds(195, 90, 15, 15);
		Content.add(lvlF14);
		
		lvlF15 = new JLabel("");
		lvlF15.setBounds(210, 90, 15, 15);
		Content.add(lvlF15);
		
		lvlF16 = new JLabel("");
		lvlF16.setBounds(225, 90, 15, 15);
		Content.add(lvlF16);
		
		lvlF17 = new JLabel("");
		lvlF17.setBounds(240, 90, 15, 15);
		Content.add(lvlF17);
		
		lvlF18 = new JLabel("");
		lvlF18.setBounds(255, 90, 15, 15);
		Content.add(lvlF18);
		
		lvlF19 = new JLabel("");
		lvlF19.setBounds(270, 90, 15, 15);
		Content.add(lvlF19);
		
		lvlF20 = new JLabel("");
		lvlF20.setBounds(285, 90, 15, 15);
		Content.add(lvlF20);
		
		// G-Reihe (id: 120-139)
		
		lvlG1 = new JLabel("");
		lvlG1.setBounds(0, 105, 15, 15);
		Content.add(lvlG1);
		
		lvlG2 = new JLabel("");
		lvlG2.setBounds(15, 105, 15, 15);
		Content.add(lvlG2);
		
		lvlG3 = new JLabel("");
		lvlG3.setBounds(30, 105, 15, 15);
		Content.add(lvlG3);
		
		lvlG4 = new JLabel("");
		lvlG4.setBounds(45, 105, 15, 15);
		Content.add(lvlG4);
		
		lvlG5 = new JLabel("");
		lvlG5.setBounds(60, 105, 15, 15);
		Content.add(lvlG5);
		
		lvlG6 = new JLabel("");
		lvlG6.setBounds(75, 105, 15, 15);
		Content.add(lvlG6);
		
		lvlG7 = new JLabel("");
		lvlG7.setBounds(90, 105, 15, 15);
		Content.add(lvlG7);
		
		lvlG8 = new JLabel("");
		lvlG8.setBounds(105, 105, 15, 15);
		Content.add(lvlG8);
		
		lvlG9 = new JLabel("");
		lvlG9.setBounds(120, 105, 15, 15);
		Content.add(lvlG9);
		
		lvlG10 = new JLabel("");
		lvlG10.setBounds(135, 105, 15, 15);
		Content.add(lvlG10);
		
		lvlG11 = new JLabel("");
		lvlG11.setBounds(150, 105, 15, 15);
		Content.add(lvlG11);
		
		lvlG12 = new JLabel("");
		lvlG12.setBounds(165, 105, 15, 15);
		Content.add(lvlG12);
		
		lvlG13 = new JLabel("");
		lvlG13.setBounds(180, 105, 15, 15);
		Content.add(lvlG13);
		
		lvlG14 = new JLabel("");
		lvlG14.setBounds(195, 105, 15, 15);
		Content.add(lvlG14);
		
		lvlG15 = new JLabel("");
		lvlG15.setBounds(210, 105, 15, 15);
		Content.add(lvlG15);
		
		lvlG16 = new JLabel("");
		lvlG16.setBounds(225, 105, 15, 15);
		Content.add(lvlG16);
		
		lvlG17 = new JLabel("");
		lvlG17.setBounds(240, 105, 15, 15);
		Content.add(lvlG17);
		
		lvlG18 = new JLabel("");
		lvlG18.setBounds(255, 105, 15, 15);
		Content.add(lvlG18);
		
		lvlG19 = new JLabel("");
		lvlG19.setBounds(270, 105, 15, 15);
		Content.add(lvlG19);
		
		lvlG20 = new JLabel("");
		lvlG20.setBounds(285, 105, 15, 15);
		Content.add(lvlG20);
		
		// H-Reihe (id: 140-159)
		
		lvlH1 = new JLabel("");
		lvlH1.setBounds(0, 120, 15, 15);
		Content.add(lvlH1);
		
		lvlH2 = new JLabel("");
		lvlH2.setBounds(15, 120, 15, 15);
		Content.add(lvlH2);
		
		lvlH3 = new JLabel("");
		lvlH3.setBounds(30, 120, 15, 15);
		Content.add(lvlH3);
		
		lvlH4 = new JLabel("");
		lvlH4.setBounds(45, 120, 15, 15);
		Content.add(lvlH4);
		
		lvlH5 = new JLabel("");
		lvlH5.setBounds(60, 120, 15, 15);
		Content.add(lvlH5);
		
		lvlH6 = new JLabel("");
		lvlH6.setBounds(75, 120, 15, 15);
		Content.add(lvlH6);
		
		lvlH7 = new JLabel("");
		lvlH7.setBounds(90, 120, 15, 15);
		Content.add(lvlH7);
		
		lvlH8 = new JLabel("");
		lvlH8.setBounds(105, 120, 15, 15);
		Content.add(lvlH8);
		
		lvlH9 = new JLabel("");
		lvlH9.setBounds(120, 120, 15, 15);
		Content.add(lvlH9);
		
		lvlH10 = new JLabel("");
		lvlH10.setBounds(135, 120, 15, 15);
		Content.add(lvlH10);
		
		lvlH11 = new JLabel("");
		lvlH11.setBounds(150, 120, 15, 15);
		Content.add(lvlH11);
		
		lvlH12 = new JLabel("");
		lvlH12.setBounds(165, 120, 15, 15);
		Content.add(lvlH12);
		
		lvlH13 = new JLabel("");
		lvlH13.setBounds(180, 120, 15, 15);
		Content.add(lvlH13);
		
		lvlH14 = new JLabel("");
		lvlH14.setBounds(195, 120, 15, 15);
		Content.add(lvlH14);
		
		lvlH15 = new JLabel("");
		lvlH15.setBounds(210, 120, 15, 15);
		Content.add(lvlH15);
		
		lvlH16 = new JLabel("");
		lvlH16.setBounds(225, 120, 15, 15);
		Content.add(lvlH16);
		
		lvlH17 = new JLabel("");
		
		lvlH17.setBounds(240, 120, 15, 15);
		Content.add(lvlH17);
		
		lvlH18 = new JLabel("");
		lvlH18.setBounds(255, 120, 15, 15);
		Content.add(lvlH18);
		
		lvlH19 = new JLabel("");
		lvlH19.setBounds(270, 120, 15, 15);
		Content.add(lvlH19);
		
		lvlH20 = new JLabel("");
		lvlH20.setBounds(285, 120, 15, 15);
		Content.add(lvlH20);
		
		// I-Reihe (id: 160-179)
		
		lvlI1 = new JLabel("");
		lvlI1.setBounds(0, 135, 15, 15);
		Content.add(lvlI1);
		
		lvlI2 = new JLabel("");
		lvlI2.setBounds(15, 135, 15, 15);
		Content.add(lvlI2);
		
		lvlI3 = new JLabel("");
		lvlI3.setBounds(30, 135, 15, 15);
		Content.add(lvlI3);
		
		lvlI4 = new JLabel("");
		lvlI4.setBounds(45, 135, 15, 15);
		Content.add(lvlI4);
		
		lvlI5 = new JLabel("");
		lvlI5.setBounds(60, 135, 15, 15);
		Content.add(lvlI5);
		
		lvlI6 = new JLabel("");
		lvlI6.setBounds(75, 135, 15, 15);
		Content.add(lvlI6);
		
		lvlI7 = new JLabel("");
		lvlI7.setBounds(90, 135, 15, 15);
		Content.add(lvlI7);
		
		lvlI8 = new JLabel("");
		
		lvlI8.setBounds(105, 135, 15, 15);
		Content.add(lvlI8);
		
		lvlI9 = new JLabel("");
		lvlI9.setBounds(120, 135, 15, 15);
		Content.add(lvlI9);
		
		lvlI10 = new JLabel("");
		lvlI10.setBounds(135, 135, 15, 15);
		Content.add(lvlI10);
		
		lvlI11 = new JLabel("");
		lvlI11.setBounds(150, 135, 15, 15);
		Content.add(lvlI11);
		
		lvlI12 = new JLabel("");
		lvlI12.setBounds(165, 135, 15, 15);
		Content.add(lvlI12);
		
		lvlI13 = new JLabel("");
		lvlI13.setBounds(180, 135, 15, 15);
		Content.add(lvlI13);
		
		lvlI14 = new JLabel("");
		lvlI14.setBounds(195, 135, 15, 15);
		Content.add(lvlI14);
		
		lvlI15 = new JLabel("");
		lvlI15.setBounds(210, 135, 15, 15);
		Content.add(lvlI15);
		
		lvlI16 = new JLabel("");
		lvlI16.setBounds(225, 135, 15, 15);
		Content.add(lvlI16);
		
		lvlI17 = new JLabel("");
		lvlI17.setBounds(240, 135, 15, 15);
		Content.add(lvlI17);
		
		lvlI18 = new JLabel("");
		lvlI18.setBounds(255, 135, 15, 15);
		Content.add(lvlI18);
		
		lvlI19 = new JLabel("");
		lvlI19.setBounds(270, 135, 15, 15);
		Content.add(lvlI19);
		
		lvlI20 = new JLabel("");
		lvlI20.setBounds(285, 135, 15, 15);
		Content.add(lvlI20);
		
		// J-Reihe (id:180-199)
		
		lvlJ1 = new JLabel("");
		lvlJ1.setBounds(0, 150, 15, 15);
		Content.add(lvlJ1);
		
		lvlJ2 = new JLabel("");
		lvlJ2.setBounds(15, 150, 15, 15);
		Content.add(lvlJ2);
		
		lvlJ3 = new JLabel("");
		lvlJ3.setBounds(30, 150, 15, 15);
		Content.add(lvlJ3);
		
		lvlJ4 = new JLabel("");
		lvlJ4.setBounds(45, 150, 15, 15);
		Content.add(lvlJ4);
		
		lvlJ5 = new JLabel("");
		lvlJ5.setBounds(60, 150, 15, 15);
		Content.add(lvlJ5);
		
		lvlJ6 = new JLabel("");
		lvlJ6.setBounds(75, 150, 15, 15);
		Content.add(lvlJ6);
		
		lvlJ7 = new JLabel("");
		lvlJ7.setBounds(90, 150, 15, 15);
		Content.add(lvlJ7);
		
		lvlJ8 = new JLabel("");
		lvlJ8.setBounds(105, 150, 15, 15);
		Content.add(lvlJ8);
		
		lvlJ9 = new JLabel("");
		lvlJ9.setBounds(120, 150, 15, 15);
		Content.add(lvlJ9);
		
		lvlJ10 = new JLabel("");
		lvlJ10.setBounds(135, 150, 15, 15);
		Content.add(lvlJ10);
		
		lvlJ11 = new JLabel("");
		lvlJ11.setBounds(150, 150, 15, 15);
		Content.add(lvlJ11);
		
		lvlJ12 = new JLabel("");
		lvlJ12.setBounds(165, 150, 15, 15);
		Content.add(lvlJ12);
		
		lvlJ13 = new JLabel("");
		lvlJ13.setBounds(180, 150, 15, 15);
		Content.add(lvlJ13);
		
		lvlJ14 = new JLabel("");
		lvlJ14.setBounds(195, 150, 15, 15);
		Content.add(lvlJ14);
		
		lvlJ15 = new JLabel("");
		lvlJ15.setBounds(210, 150, 15, 15);
		Content.add(lvlJ15);
		
		lvlJ16 = new JLabel("");
		lvlJ16.setBounds(225, 150, 15, 15);
		Content.add(lvlJ16);
		
		lvlJ17 = new JLabel("");
		lvlJ17.setBounds(240, 150, 15, 15);
		Content.add(lvlJ17);
		
		lvlJ18 = new JLabel("");
		lvlJ18.setBounds(255, 150, 15, 15);
		Content.add(lvlJ18);
		
		lvlJ19 = new JLabel("");
		lvlJ19.setBounds(270, 150, 15, 15);
		Content.add(lvlJ19);
		
		lvlJ20 = new JLabel("");
		lvlJ20.setBounds(285, 150, 15, 15);
		Content.add(lvlJ20);
		
		// K-Reihe (id: 200-219)
		
		lvlK1 = new JLabel("");
		lvlK1.setBounds(0, 165, 15, 15);
		Content.add(lvlK1);
		
		lvlK2 = new JLabel("");
		lvlK2.setBounds(15, 165, 15, 15);
		Content.add(lvlK2);
		
		lvlK3 = new JLabel("");
		lvlK3.setBounds(30, 165, 15, 15);
		Content.add(lvlK3);
		
		lvlK4 = new JLabel("");
		lvlK4.setBounds(45, 165, 15, 15);
		Content.add(lvlK4);
		
		lvlK5 = new JLabel("");
		lvlK5.setBounds(60, 165, 15, 15);
		Content.add(lvlK5);
		
		lvlK6 = new JLabel("");
		lvlK6.setBounds(75, 165, 15, 15);
		Content.add(lvlK6);
		
		lvlK7 = new JLabel("");
		lvlK7.setBounds(90, 165, 15, 15);
		Content.add(lvlK7);
		
		lvlK8 = new JLabel("");
		lvlK8.setBounds(105, 165, 15, 15);
		Content.add(lvlK8);
		
		lvlK9 = new JLabel("");
		lvlK9.setBounds(120, 165, 15, 15);
		Content.add(lvlK9);
		
		lvlK10 = new JLabel("");
		lvlK10.setBounds(135, 165, 15, 15);
		Content.add(lvlK10);
		
		lvlK11 = new JLabel("");
		lvlK11.setBounds(150, 165, 15, 15);
		Content.add(lvlK11);
		
		lvlK12 = new JLabel("");
		lvlK12.setBounds(165, 165, 15, 15);
		Content.add(lvlK12);
		
		lvlK13 = new JLabel("");
		lvlK13.setBounds(180, 165, 15, 15);
		Content.add(lvlK13);
		
		lvlK14 = new JLabel("");
		lvlK14.setBounds(195, 165, 15, 15);
		Content.add(lvlK14);
		
		lvlK15 = new JLabel("");
		lvlK15.setBounds(210, 165, 15, 15);
		Content.add(lvlK15);
		
		lvlK16 = new JLabel("");
		lvlK16.setBounds(225, 165, 15, 15);
		Content.add(lvlK16);
		
		lvlK17 = new JLabel("");
		lvlK17.setBounds(240, 165, 15, 15);
		Content.add(lvlK17);
		
		lvlK18 = new JLabel("");
		lvlK18.setBounds(255, 165, 15, 15);
		Content.add(lvlK18);
		
		lvlK19 = new JLabel("");
		lvlK19.setBounds(270, 165, 15, 15);
		Content.add(lvlK19);
		
		lvlK20 = new JLabel("");
		lvlK20.setBounds(285, 165, 15, 15);
		Content.add(lvlK20);
		
		// L-Reihe (id: 220-239)
		
		lvlL1 = new JLabel("");
		lvlL1.setBounds(0, 180, 15, 15);
		Content.add(lvlL1);
		
		lvlL2 = new JLabel("");
		lvlL2.setBounds(15, 180, 15, 15);
		Content.add(lvlL2);
		
		lvlL3 = new JLabel("");
		lvlL3.setBounds(30, 180, 15, 15);
		Content.add(lvlL3);
		
		lvlL4 = new JLabel("");
		lvlL4.setBounds(45, 180, 15, 15);
		Content.add(lvlL4);
		
		lvlL5 = new JLabel("");
		lvlL5.setBounds(60, 180, 15, 15);
		Content.add(lvlL5);
		
		lvlL6 = new JLabel("");
		lvlL6.setBounds(75, 180, 15, 15);
		Content.add(lvlL6);
		
		lvlL7 = new JLabel("");
		lvlL7.setBounds(90, 180, 15, 15);
		Content.add(lvlL7);
		
		lvlL8 = new JLabel("");
		lvlL8.setBounds(105, 180, 15, 15);
		Content.add(lvlL8);
		
		lvlL9 = new JLabel("");
		lvlL9.setBounds(120, 180, 15, 15);
		Content.add(lvlL9);
		
		lvlL10 = new JLabel("");
		lvlL10.setBounds(135, 180, 15, 15);
		Content.add(lvlL10);
		
		lvlL11 = new JLabel("");
		lvlL11.setBounds(150, 180, 15, 15);
		Content.add(lvlL11);
		
		lvlL12 = new JLabel("");
		lvlL12.setBounds(165, 180, 15, 15);
		Content.add(lvlL12);
		
		lvlL13 = new JLabel("");
		lvlL13.setBounds(180, 180, 15, 15);
		Content.add(lvlL13);
		
		lvlL14 = new JLabel("");
		lvlL14.setBounds(195, 180, 15, 15);
		Content.add(lvlL14);
		
		lvlL15 = new JLabel("");
		lvlL15.setBounds(210, 180, 15, 15);
		Content.add(lvlL15);
		
		lvlL16 = new JLabel("");
		lvlL16.setBounds(225, 180, 15, 15);
		Content.add(lvlL16);
		
		lvlL17 = new JLabel("");
		lvlL17.setBounds(240, 180, 15, 15);
		Content.add(lvlL17);
		
		lvlL18 = new JLabel("");
		lvlL18.setBounds(255, 180, 15, 15);
		Content.add(lvlL18);
		
		lvlL19 = new JLabel("");
		lvlL19.setBounds(270, 180, 15, 15);
		Content.add(lvlL19);
		
		lvlL20 = new JLabel("");
		lvlL20.setBounds(285, 180, 15, 15);
		Content.add(lvlL20);
		
		// M-Reihe (id: 240-259)
		
		lvlM1 = new JLabel("");
		lvlM1.setBounds(0, 195, 15, 15);
		Content.add(lvlM1);
		
		lvlM2 = new JLabel("");
		lvlM2.setBounds(15, 195, 15, 15);
		Content.add(lvlM2);
		
		lvlM3 = new JLabel("");
		lvlM3.setBounds(30, 195, 15, 15);
		Content.add(lvlM3);
		
		lvlM4 = new JLabel("");
		lvlM4.setBounds(45, 195, 15, 15);
		Content.add(lvlM4);
		
		lvlM5 = new JLabel("");
		lvlM5.setBounds(60, 195, 15, 15);
		Content.add(lvlM5);
		
		lvlM6 = new JLabel("");
		lvlM6.setBounds(75, 195, 15, 15);
		Content.add(lvlM6);
		
		lvlM7 = new JLabel("");
		lvlM7.setBounds(90, 195, 15, 15);
		Content.add(lvlM7);
		
		lvlM8 = new JLabel("");
		lvlM8.setBounds(105, 195, 15, 15);
		Content.add(lvlM8);
		
		lvlM9 = new JLabel("");
		lvlM9.setBounds(120, 195, 15, 15);
		Content.add(lvlM9);
		
		lvlM10 = new JLabel("");
		lvlM10.setBounds(135, 195, 15, 15);
		Content.add(lvlM10);
		
		lvlM11 = new JLabel("");
		lvlM11.setBounds(150, 195, 15, 15);
		Content.add(lvlM11);
		
		lvlM12 = new JLabel("");
		lvlM12.setBounds(165, 195, 15, 15);
		Content.add(lvlM12);
		
		lvlM13 = new JLabel("");
		lvlM13.setBounds(180, 195, 15, 15);
		Content.add(lvlM13);
		
		lvlM14 = new JLabel("");
		lvlM14.setBounds(195, 195, 15, 15);
		Content.add(lvlM14);
		
		lvlM15 = new JLabel("");
		lvlM15.setBounds(210, 195, 15, 15);
		Content.add(lvlM15);
		
		lvlM16 = new JLabel("");
		lvlM16.setBounds(225, 195, 15, 15);
		Content.add(lvlM16);
		
		lvlM17 = new JLabel("");
		lvlM17.setBounds(240, 195, 15, 15);
		Content.add(lvlM17);
		
		lvlM18 = new JLabel("");
		lvlM18.setBounds(255, 195, 15, 15);
		Content.add(lvlM18);
		
		lvlM19 = new JLabel("");
		lvlM19.setBounds(270, 195, 15, 15);
		Content.add(lvlM19);
		
		lvlM20 = new JLabel("");
		lvlM20.setBounds(285, 195, 15, 15);
		Content.add(lvlM20);
		
		// N-Reihe (id: 260-279)
		
		lvlN1 = new JLabel("");
		lvlN1.setBounds(0, 210, 15, 15);
		Content.add(lvlN1);
		
		lvlN2 = new JLabel("");
		lvlN2.setBounds(15, 210, 15, 15);
		Content.add(lvlN2);
		
		lvlN3 = new JLabel("");
		lvlN3.setBounds(30, 210, 15, 15);
		Content.add(lvlN3);
		
		lvlN4 = new JLabel("");
		lvlN4.setBounds(45, 210, 15, 15);
		Content.add(lvlN4);
		
		lvlN5 = new JLabel("");
		lvlN5.setBounds(60, 210, 15, 15);
		Content.add(lvlN5);
		
		lvlN6 = new JLabel("");
		lvlN6.setBounds(75, 210, 15, 15);
		Content.add(lvlN6);
		
		lvlN7 = new JLabel("");
		lvlN7.setBounds(90, 210, 15, 15);
		Content.add(lvlN7);
		
		lvlN8 = new JLabel("");
		lvlN8.setBounds(105, 210, 15, 15);
		Content.add(lvlN8);
		
		lvlN9 = new JLabel("");
		lvlN9.setBounds(120, 210, 15, 15);
		Content.add(lvlN9);
		
		lvlN10 = new JLabel("");
		lvlN10.setBounds(135, 210, 15, 15);
		Content.add(lvlN10);
		
		lvlN11 = new JLabel("");
		lvlN11.setBounds(150, 210, 15, 15);
		Content.add(lvlN11);
		
		lvlN12 = new JLabel("");
		lvlN12.setBounds(165, 210, 15, 15);
		Content.add(lvlN12);
		
		lvlN13 = new JLabel("");
		lvlN13.setBounds(180, 210, 15, 15);
		Content.add(lvlN13);
		
		lvlN14 = new JLabel("");
		lvlN14.setBounds(195, 210, 15, 15);
		Content.add(lvlN14);
		
		lvlN15 = new JLabel("");
		lvlN15.setBounds(210, 210, 15, 15);
		Content.add(lvlN15);
		
		lvlN16 = new JLabel("");
		lvlN16.setBounds(225, 210, 15, 15);
		Content.add(lvlN16);
		
		lvlN17 = new JLabel("");
		lvlN17.setBounds(240, 210, 15, 15);
		Content.add(lvlN17);
		
		lvlN18 = new JLabel("");
		lvlN18.setBounds(255, 210, 15, 15);
		Content.add(lvlN18);
		
		lvlN19 = new JLabel("");
		lvlN19.setBounds(270, 210, 15, 15);
		Content.add(lvlN19);
		
		lvlN20 = new JLabel("");
		lvlN20.setBounds(285, 210, 15, 15);
		Content.add(lvlN20);
		
		// O-Reihe (id: 280-299)
		
		lvlO1 = new JLabel("");
		lvlO1.setBounds(0, 225, 15, 15);
		Content.add(lvlO1);
		
		lvlO2 = new JLabel("");
		lvlO2.setBounds(15, 225, 15, 15);
		Content.add(lvlO2);
		
		lvlO3 = new JLabel("");
		lvlO3.setBounds(30, 225, 15, 15);
		Content.add(lvlO3);
		
		lvlO4 = new JLabel("");
		lvlO4.setBounds(45, 225, 15, 15);
		Content.add(lvlO4);
		
		lvlO5 = new JLabel("");
		lvlO5.setBounds(60, 225, 15, 15);
		Content.add(lvlO5);
		
		lvlO6 = new JLabel("");
		lvlO6.setBounds(75, 225, 15, 15);
		Content.add(lvlO6);
		
		lvlO7 = new JLabel("");
		lvlO7.setBounds(90, 225, 15, 15);
		Content.add(lvlO7);
		
		lvlO8 = new JLabel("");
		lvlO8.setBounds(105, 225, 15, 15);
		Content.add(lvlO8);
		
		lvlO9 = new JLabel("");
		lvlO9.setBounds(120, 225, 15, 15);
		Content.add(lvlO9);
		
		lvlO10 = new JLabel("");
		lvlO10.setBounds(135, 225, 15, 15);
		Content.add(lvlO10);
		
		lvlO11 = new JLabel("");
		lvlO11.setBounds(150, 225, 15, 15);
		Content.add(lvlO11);
		
		lvlO12 = new JLabel("");
		lvlO12.setBounds(165, 225, 15, 15);
		Content.add(lvlO12);
		
		lvlO13 = new JLabel("");
		lvlO13.setBounds(180, 225, 15, 15);
		Content.add(lvlO13);
		
		lvlO14 = new JLabel("");
		lvlO14.setBounds(195, 225, 15, 15);
		Content.add(lvlO14);
		
		lvlO15 = new JLabel("");
		lvlO15.setBounds(210, 225, 15, 15);
		Content.add(lvlO15);
		
		lvlO16 = new JLabel("");
		lvlO16.setBounds(225, 225, 15, 15);
		Content.add(lvlO16);
		
		lvlO17 = new JLabel("");
		lvlO17.setBounds(240, 225, 15, 15);
		Content.add(lvlO17);
		
		lvlO18 = new JLabel("");
		lvlO18.setBounds(255, 225, 15, 15);
		Content.add(lvlO18);
		
		lvlO19 = new JLabel("");
		lvlO19.setBounds(270, 225, 15, 15);
		Content.add(lvlO19);
		
		lvlO20 = new JLabel("");
		lvlO20.setBounds(285, 225, 15, 15);
		Content.add(lvlO20);
		}


	
		
	
		

	}

