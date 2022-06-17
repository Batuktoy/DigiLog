package mainProgram;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class loadingScreen extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblLoad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{ 
				int x;
			
					loadingScreen frame = new loadingScreen();
					frame.setVisible(true);
					contenctMain c = new contenctMain();
					try {
					for(x=0; x<=100; x++) {
							loadingScreen.progressBar.setValue(x);
							Thread.sleep(50);
							loadingScreen.lblLoad.setText(Integer.toString(x)+"%");
							if(x==100) {
								frame.dispose();
								c.setVisible(true);
							}
						} 
						}catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
	}

	/**
	 * Create the frame.
	 */
	public loadingScreen() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 566, 498);
		setBackground(new Color(0, 0, 0, 0));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBounds(0, 478, 566, 9);
		contentPane.add(progressBar);
		
		lblLoad = new JLabel("");
		lblLoad.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoad.setForeground(new Color(255, 255, 255));
		lblLoad.setBounds(156, 358, 39, 28);
		contentPane.add(lblLoad);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(Color.BLACK, 1, true));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(loadingScreen.class.getResource("/images/QR.gif")));
		lblNewLabel.setBounds(105, 100, 355, 363);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("QR CODE GENERATOR");
		lblNewLabel_1.setFont(new Font("Niagara Engraved", Font.PLAIN, 92));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setBounds(10, 11, 546, 78);
		contentPane.add(lblNewLabel_1);
	}
}
