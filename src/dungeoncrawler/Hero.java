package dungeoncrawler;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

// Klasse für die Bewegung des Helden
public class Held {

    private String held = "held.png";

    //Variablen für Position und Bewegung
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;

    //fügt dem Helden ein Bild hinzu
    public Held() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(held));
        image = ii.getImage();
        x = 30;
        y = 30;
    }

    //Bewegung
    public void move() {
        x += dx;
        y += dy;
    }

    //Position abfragen
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    //setzt die Bewegungsvariablen bei Tastendruck
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
    }

    //setzt die Bewegungsvariablen wieder auf 0, wenn die Taste losgelassen wird
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
