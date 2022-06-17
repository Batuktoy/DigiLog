package subFrame;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import mainProgram.contenctMain;
import subFrame.profile.action;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class paneVisitorsSlip extends JPanel {
	private JTextField txtVCnumber;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblQRQR;
	private JLabel lblpath;
	
	private JButton btnGQR;
	
	private JLabel lblQR;
	private JLabel lblCnumber;
	
	private File f = null;
	private String path = null;
	private ImageIcon format = null;
	String fname = null;
	
	static Connection conn() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/qr_generator";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			System.out.print("Connection Failed! " + e );
		}
		
		return null;
	}
	
	

	/**
	 * Create the panel.
	 */
	public paneVisitorsSlip() {
		
		
		
		Image img_logo = new ImageIcon(contenctMain.class.getResource("/images/sjcsi.png")).getImage().getScaledInstance(109,90, Image.SCALE_SMOOTH);
		
		setBackground(new Color(0, 51, 51));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane.setColumnHeaderView(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		tabbedPane.addTab("ENTRANCE SLIP", null, panel, null);
		tabbedPane.setBackgroundAt(0, new Color(0, 0, 0));
		tabbedPane.setForegroundAt(0, Color.BLACK);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		panel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.setBackground(new Color(0, 51, 51));
		
		txtVCnumber = new JTextField();
		txtVCnumber.setCaretColor(Color.WHITE);
		txtVCnumber.setDisabledTextColor(Color.DARK_GRAY);
		txtVCnumber.setText("Input Control Number...");
		txtVCnumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtVCnumber.getText().equals("Input Control Number...")) {
					txtVCnumber.setText("");
				}
				else {
					txtVCnumber.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtVCnumber.getText().equals(""))
					txtVCnumber.setText("Input Control Number...");
			}
		});
		txtVCnumber.setForeground(Color.DARK_GRAY);
		txtVCnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtVCnumber.setBackground(new Color(0, 51, 51));
		txtVCnumber.setBorder(new TitledBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 153, 0)), "Control Number:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.ORANGE));
		txtVCnumber.setColumns(10);
		
		lblQR = new JLabel("Click to Add Photo");
		lblQR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQR.setForeground(Color.DARK_GRAY);
		lblQR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					path = selectedFile.getAbsolutePath();
					lblpath.setText(path);
					lblQR.setIcon(image(path));
					lblQR.setText("");
				}
				
				else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Please Add Photo!!");
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				lblQR.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color (250, 0, 0)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblQR.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
			}
		});
		lblQR.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		lblQR.setHorizontalAlignment(SwingConstants.CENTER);
		lblQR.setHorizontalTextPosition(SwingConstants.LEADING);
		lblQR.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		btnGQR = new JButton("GENERATE QR CODE");
		btnGQR.setForeground(Color.WHITE);
		btnGQR.setBackground(Color.DARK_GRAY);
		btnGQR.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGQR.addActionListener(new action());
		
		JButton btnSaveToVisitors = new JButton("SAVE TO VISITOR'S SLIP");
		btnSaveToVisitors.setForeground(Color.WHITE);
		btnSaveToVisitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Image icon = new ImageIcon("D:\\QRcode\\2020-1174.png").getImage().getScaledInstance(130, 135, Image.SCALE_SMOOTH);;
				lblQRQR.setIcon(new ImageIcon (icon));
				SaveToDataB();
			}
		});
		btnSaveToVisitors.setBackground(Color.DARK_GRAY);
		btnSaveToVisitors.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 51, 51));
		panel_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		lblpath = new JLabel("");
		lblpath.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblpath.setHorizontalAlignment(SwingConstants.CENTER);
		lblpath.setForeground(Color.WHITE);
		lblpath.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(66)
					.addComponent(lblQR, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtVCnumber, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblpath, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnGQR, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
						.addComponent(btnSaveToVisitors, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
					.addGap(51))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtVCnumber, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(lblQR, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblpath, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGQR, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(btnSaveToVisitors, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
					.addGap(23))
		);
		panel_2.setLayout(gl_panel_2);
		
		JLabel lblheader = new JLabel("VISITORS ENTRANCE SLIP");
		lblheader.setForeground(Color.ORANGE);
		lblheader.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		lblheader.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblheader.setHorizontalAlignment(SwingConstants.CENTER);
		lblheader.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		
		JPanel paneMAINpane = new JPanel();
		paneMAINpane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		paneMAINpane.setBackground(SystemColor.inactiveCaption);
		paneMAINpane.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		paneMAINpane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		JButton btnNewButton = new JButton("PRINT");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(paneMAINpane, GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(22)
									.addComponent(lblheader, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
									.addGap(11)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(22))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblheader)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(paneMAINpane, GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		JPanel paneENTRANCEs = new JPanel();
		paneENTRANCEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		paneENTRANCEs.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 102, 51)));
		paneENTRANCEs.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 11, 97, 101);
		lblNewLabel_1.setIcon(new ImageIcon(img_logo));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("ENTRANCE SLIP");
		lblNewLabel_4.setBounds(142, 75, 246, 37);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		lblQRQR = new JLabel("");
		lblQRQR.setBounds(407, 11, 97, 101);
		lblQRQR.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQRQR.setHorizontalAlignment(SwingConstants.CENTER);
		lblQRQR.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_2 = new JLabel("SAINT JOSEPH COLLEGE OF");
		lblNewLabel_2.setBounds(115, 11, 276, 37);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2_1 = new JLabel("SINDANGAN INCORPORATED");
		lblNewLabel_2_1.setBounds(119, 43, 270, 25);
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblNewLabel_5 = new JLabel("CONTROL NUMBER:");
		lblNewLabel_5.setBounds(10, 125, 115, 21);
		
		JLabel lblNewLabel_5_1 = new JLabel("DATE:");
		lblNewLabel_5_1.setBounds(351, 124, 38, 21);
		
		textField_1 = new JTextField();
		textField_1.setBounds(399, 126, 105, 20);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2 = new JLabel("NAME:");
		lblNewLabel_5_2.setBounds(10, 157, 44, 21);
		
		textField_2 = new JTextField();
		textField_2.setBounds(64, 158, 344, 20);
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBackground(SystemColor.menu);
		
		textField_3 = new JTextField();
		textField_3.setBounds(461, 159, 43, 20);
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("AGE:");
		lblNewLabel_5_1_1.setBounds(418, 157, 33, 21);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("COMPLETE ADDRESS:");
		lblNewLabel_5_2_1.setBounds(10, 189, 126, 21);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 188, 360, 20);
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("BIRTH DATE:");
		lblNewLabel_5_2_1_1.setBounds(10, 221, 76, 21);
		
		textField_5 = new JTextField();
		textField_5.setBounds(96, 221, 91, 20);
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel("GENDER:");
		lblNewLabel_5_2_1_1_1.setBounds(197, 221, 50, 21);
		
		textField_6 = new JTextField();
		textField_6.setBounds(246, 222, 56, 20);
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_6.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1_2 = new JLabel("CONTACT #:");
		lblNewLabel_5_2_1_1_2.setBounds(313, 219, 76, 21);
		
		textField_7 = new JTextField();
		textField_7.setBounds(399, 219, 107, 20);
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_7.setBackground(SystemColor.menu);
		
		textField_8 = new JTextField();
		textField_8.setBounds(309, 259, 187, 27);
		textField_8.setColumns(10);
		textField_8.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_8.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1_3 = new JLabel("SIGNATURE");
		lblNewLabel_5_2_1_1_3.setBounds(356, 297, 89, 22);
		lblNewLabel_5_2_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_paneMAINpane = new GroupLayout(paneMAINpane);
		gl_paneMAINpane.setHorizontalGroup(
			gl_paneMAINpane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneMAINpane.createSequentialGroup()
					.addContainerGap()
					.addComponent(paneENTRANCEs, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_paneMAINpane.setVerticalGroup(
			gl_paneMAINpane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneMAINpane.createSequentialGroup()
					.addContainerGap()
					.addComponent(paneENTRANCEs, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lblCnumber = new JLabel("");
		lblCnumber.setBounds(131, 125, 139, 21);
		lblCnumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		paneENTRANCEs.setLayout(null);
		paneENTRANCEs.add(lblNewLabel_5_2);
		paneENTRANCEs.add(textField_2);
		paneENTRANCEs.add(lblNewLabel_5_1_1);
		paneENTRANCEs.add(textField_3);
		paneENTRANCEs.add(lblNewLabel_5_2_1);
		paneENTRANCEs.add(textField_4);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1);
		paneENTRANCEs.add(textField_5);
		paneENTRANCEs.add(textField_6);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1_1);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1_2);
		paneENTRANCEs.add(textField_7);
		paneENTRANCEs.add(textField_8);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1_3);
		paneENTRANCEs.add(lblNewLabel_1);
		paneENTRANCEs.add(lblNewLabel_5);
		paneENTRANCEs.add(lblCnumber);
		paneENTRANCEs.add(lblNewLabel_5_1);
		paneENTRANCEs.add(textField_1);
		paneENTRANCEs.add(lblNewLabel_2);
		paneENTRANCEs.add(lblNewLabel_4);
		paneENTRANCEs.add(lblNewLabel_2_1);
		paneENTRANCEs.add(lblQRQR);
		paneMAINpane.setLayout(gl_paneMAINpane);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13))
		);
		setLayout(groupLayout);
	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/aloy";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","aloy");
		} catch (Exception e) {
			System.out.print("Connection Failed! " + e );
		}
		
		return null;
	}
	
	
	
	public class action implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
				try {
					String QRcodeData  = txtVCnumber.getText();
					String filepath_1 = "D:\\QRcode" + txtVCnumber.getText() + ".png";
					String charset = "UTF-8";
					
					Map <EncodeHintType,ErrorCorrectionLevel> hintMap = new HashMap <EncodeHintType,ErrorCorrectionLevel>();
					hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
					
					BitMatrix matrix = new MultiFormatWriter().encode(
							new String (QRcodeData.getBytes(charset),charset),
							BarcodeFormat.QR_CODE, 250, 250,hintMap);
					
					MatrixToImageWriter.writeToFile(matrix, filepath_1.substring(filepath_1.lastIndexOf('.')+ 1),new File(filepath_1));
					
					Image icon = new ImageIcon("D:\\QRcode").getImage().getScaledInstance(250, 230, Image.SCALE_SMOOTH);
					lblQR.setIcon(new ImageIcon (icon));
					lblCnumber.setText(txtVCnumber.getText());
					JOptionPane.showMessageDialog(null, "QR code has been generated Successfully" + filepath_1);
					
					
				}
				catch (Exception r) {
					System.out.println("Error:" + r);
				}
			}
		
	}
	public ImageIcon image (String ImagePath) 
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(lblQR.getWidth(), lblQR.getHeight(), Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
		 return image;
		 
		 
	 }
	private void SaveToDataB() {
		Connection con = conn();
		File f = new File(path);
		
		try {
			InputStream is = new FileInputStream(f);
			
			String query = " insert into visitors_database ( control_number, qrcode_path, qrcode_file)"
			        + " values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, txtVCnumber.getText());
			ps.setString(2, path);
			ps.setBlob(3, is);
		
		
			
			int inserted = ps.executeUpdate();
			if(inserted > 0 ) {
				JOptionPane.showMessageDialog(null,"Saved Succesfully");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
