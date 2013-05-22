package bewegungsversuch;

import javax.swing.JFrame;

public class Hauptspiel extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Generiert das leere Spielfeld
	public Hauptspiel() {

        add(new Spielfeld());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocation(300, 50);
        setTitle("Doofen Crawler");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Hauptspiel();
    }
}