package bewegungsversuch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Spielfeld extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
    private Held held;

    public Spielfeld() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        held = new Held();

        timer = new Timer(5, this);
        timer.start();
    }

    //malt den Held aufs Spielfeld
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(held.getImage(), held.getX(), held.getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {
        held.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {
            held.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            held.keyPressed(e);
        }
    }

}