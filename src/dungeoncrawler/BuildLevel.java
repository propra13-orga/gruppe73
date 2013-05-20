package dungeoncrawler;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class BuildLevel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 300, 225);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(15, 20, 0, 0));
		
		JLabel lblLebensanzeige = new JLabel("1 ");
		lblLebensanzeige.setIcon(new ImageIcon(BuildLevel.class.getResource("/dungeoncrawler/heart.PNG")));
		lblLebensanzeige.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblLebensanzeige);
	}

}
