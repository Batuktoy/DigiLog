package generateQRcode;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class print extends JPanel {

	/**
	 * Create the panel.
	 */
	public print() {
		setLayout(null);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(29, 51, 180, 77);
		add(btnNewButton);
		

	}
}
