package subFrame;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import mainProgram.contenctMain;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;


public class profile extends JPanel {
	public static JTextField txtIdNumber;
	public static JTextField txtAcademicYear;
	public static JTextField txtLastName;
	public static JTextField txtFirstName;
	public static JTextField txtMiddleName;
	public static JTextField txtCoursedesignation;
	public static JTextField txtMonth; 
	public static JTextField txtAge;
	private JLabel lblNewLabel_3;
	public static JTextField txtGender;
	public static JTextField txtContactNumber;
	public static JTextField txtEmailAddress;
	public static JTextField txtPresentAddress;
	private JLabel lblWarning;
	private JLabel lbladdphoto;
	public static JLabel lblcontrolnumber;
	public static JLabel lblqrdisplay;
	private JButton btngenerate;
	
	private static messageBox m;
	
	public static File f = null;
	public String path = null;
	
	

	
	public profile() {
		setBounds(220, 89, 932, 522);
		setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(51, 51, 51)));
		setBackground(new Color(0, 51, 51));
		
		Image img_logo = new ImageIcon(contenctMain.class.getResource("/images/sjcsi.png")).getImage().getScaledInstance(130,100, Image.SCALE_SMOOTH);
		
		JPanel paneProfile = new JPanel();
		paneProfile.setForeground(Color.GRAY);
		paneProfile.setBounds(12, 13, 670, 496);
		paneProfile.setBackground(new Color(0, 51, 51));
		paneProfile.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		
		JPanel paneQRslot = new JPanel();
		paneQRslot.setBounds(692, 13, 226, 266);
		paneQRslot.setBackground(new Color(0, 51, 51));
		paneQRslot.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		
		
		btngenerate = new JButton("GENERATE QR CODE");
		btngenerate.setBounds(692, 297, 226, 47);
		btngenerate.setForeground(Color.WHITE);
		btngenerate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btngenerate.setBackground(Color.DARK_GRAY);
		btngenerate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btngenerate.addActionListener(new action());
		paneQRslot.setLayout(null);
		
		lblqrdisplay = new JLabel("Get QR code");
		lblqrdisplay.addMouseListener(new MouseAdapter() {
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
					lblcontrolnumber.setText(path);
					lblqrdisplay.setIcon(image(path));
					lblqrdisplay.setText("");
				}
				
				else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Please Add Photo!!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblqrdisplay.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color (250, 0, 0)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblqrdisplay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
			}
		});
		lblqrdisplay.setForeground(Color.DARK_GRAY);
		lblqrdisplay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblqrdisplay.setHorizontalTextPosition(SwingConstants.CENTER);
		lblqrdisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblqrdisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblqrdisplay.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		lblqrdisplay.setBounds(10, 24, 206, 183);
		paneQRslot.add(lblqrdisplay);
		
		
		lblcontrolnumber = new JLabel("");
		lblcontrolnumber.setForeground(Color.WHITE);
		lblcontrolnumber.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		lblcontrolnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontrolnumber.setBounds(38, 218, 148, 37);
		paneQRslot.add(lblcontrolnumber);
		
		JLabel logo = new JLabel("");
		logo.setBounds(10, 11, 130, 113);
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setAlignmentX(Component.CENTER_ALIGNMENT);
		logo.setIcon(new ImageIcon(img_logo));
		
		JLabel lblNewLabel_1 = new JLabel("QR CODE GENERATOR");
		lblNewLabel_1.setBounds(153, 35, 488, 67);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 40));
		
		lbladdphoto = new JLabel("Click to Add Photo");
		lbladdphoto.setBounds(539, 113, 121, 140);
		lbladdphoto.setForeground(Color.DARK_GRAY);
		lbladdphoto.setHorizontalTextPosition(SwingConstants.CENTER);
		lbladdphoto.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbladdphoto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					String path = selectedFile.getAbsolutePath();
					lbladdphoto.setIcon(ResizeImage(path));
					lbladdphoto.setText("");
				}
				
				else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Please Add Photo!!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lbladdphoto.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbladdphoto.setBorder(new MatteBorder(1, 1, 1, 1, (Color)new Color(255, 153, 0)));
			}
		});
		lbladdphoto.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		lbladdphoto.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtIdNumber = new JTextField();
		txtIdNumber.setBounds(10, 140, 176, 29);
		txtIdNumber.setToolTipText("ID number");
		txtIdNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)) {
					txtIdNumber.setEditable(false);
					JOptionPane.showMessageDialog(null, "Plese fill ID Number correctly!!");
					txtIdNumber.setBackground(new Color(255, 255, 255));
				}
				else {
					txtIdNumber.setEditable(true);
					
				}
			}
		});
		txtIdNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtIdNumber.getText().equals(" ID NUMBER")) {
					txtIdNumber.setText("");
				}
				else {
					txtIdNumber.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtIdNumber.getText().equals(""))
					txtIdNumber.setText(" ID NUMBER");
			}
		});
		txtIdNumber.setForeground(Color.GRAY);
		txtIdNumber.setText(" ID NUMBER");
		txtIdNumber.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 51)));
		txtIdNumber.setColumns(10);
		
		txtAcademicYear = new JTextField();
		txtAcademicYear.setBounds(10, 186, 176, 29);
		txtAcademicYear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtAcademicYear.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		txtAcademicYear.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAcademicYear.getText().equals(" ACADEMIC YEAR")) {
					txtAcademicYear.setText("");
				}
				else {
					txtAcademicYear.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAcademicYear.getText().equals(""))
					txtAcademicYear.setText(" ACADEMIC YEAR");
			}
		});
		txtAcademicYear.setForeground(Color.GRAY);
		txtAcademicYear.setText(" ACADEMIC YEAR");
		txtAcademicYear.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtAcademicYear.setColumns(10);

		
		txtLastName = new JTextField();
		txtLastName.setBounds(10, 266, 227, 29);
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtLastName.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		
		txtLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtLastName.getText().equals(" LAST NAME/SUFFIX")) {
					txtLastName.setText("");
				}
				else {
					txtLastName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtLastName.getText().equals(""))
					txtLastName.setText(" LAST NAME/SUFFIX");
			}
		});
		txtLastName.setText(" LAST NAME/SUFFIX");
		txtLastName.setForeground(Color.GRAY);
		txtLastName.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setBounds(247, 266, 207, 29);
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtFirstName.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		txtFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtFirstName.getText().equals(" FIRST NAME")) {
					txtFirstName.setText("");
				}
				else {
					txtFirstName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtFirstName.getText().equals(""))
					txtFirstName.setText(" FIRST NAME");
			}
		});
		txtFirstName.setText(" FIRST NAME");
		txtFirstName.setForeground(Color.GRAY);
		txtFirstName.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtFirstName.setColumns(10);
		
		txtMiddleName = new JTextField();
		txtMiddleName.setBounds(464, 266, 196, 29);
		txtMiddleName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtMiddleName.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		txtMiddleName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMiddleName.getText().equals(" MIDDLE NAME")) {
					txtMiddleName.setText("");
				}
				else {
					txtMiddleName.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtMiddleName.getText().equals(""))
					txtMiddleName.setText(" MIDDLE NAME");
			}
		});
		txtMiddleName.setText(" MIDDLE NAME");
		txtMiddleName.setForeground(Color.GRAY);
		txtMiddleName.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtMiddleName.setColumns(10);
		
		txtCoursedesignation = new JTextField();
		txtCoursedesignation.setBounds(10, 226, 519, 29);
		txtCoursedesignation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int position = txtCoursedesignation.getCaretPosition();
				txtCoursedesignation.setText(txtCoursedesignation.getText().toUpperCase(getLocale()));
				txtCoursedesignation.setCaretPosition(position);
			}
		});
		txtCoursedesignation.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCoursedesignation.getText().equals(" COURSE/DESIGNATION")) {
					txtCoursedesignation.setText("");
				}
				else {
					txtCoursedesignation.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtCoursedesignation.getText().equals(""))
					txtCoursedesignation.setText(" COURSE/DESIGNATION");
			}
		});
		txtCoursedesignation.setText(" COURSE/DESIGNATION");
		txtCoursedesignation.setForeground(Color.GRAY);
		txtCoursedesignation.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtCoursedesignation.setColumns(10);
		
		txtMonth = new JTextField();
		txtMonth.setBounds(152, 306, 254, 29);
		txtMonth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtMonth.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		txtMonth.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMonth.getText().equals(" BIRTH DATE")) {
					txtMonth.setText("");
				}
				else {
					txtMonth.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtMonth.getText().equals(""))
					txtMonth.setText(" BIRTH DATE");
			}
		});
		txtMonth.setText(" BIRTH DATE");
		txtMonth.setForeground(Color.GRAY);
		txtMonth.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtMonth.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setBounds(10, 306, 54, 29);
		txtAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)) {
					txtAge.setEditable(false);
					JOptionPane.showMessageDialog(null, "Plese input Legal Age!!");
					txtAge.setBackground(new Color(255, 255, 255));
				}
				else {
					txtAge.setEditable(true);
				}
			}
		});
		txtAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAge.getText().equals(" AGE")) {
					txtAge.setText("");
				}
				else {
					txtAge.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtAge.getText().equals(""))
					txtAge.setText(" AGE");
			}
		});
		txtAge.setText(" AGE");
		txtAge.setForeground(Color.GRAY);
		txtAge.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtAge.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Birth Month:");
		lblNewLabel_3.setBounds(74, 313, 68, 14);
		lblNewLabel_3.setForeground(new Color(255, 204, 0));
		
		txtGender = new JTextField();
		txtGender.setBounds(412, 306, 82, 29);
		txtGender.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtGender.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		txtGender.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtGender.getText().equals(" GENDER")) 
				{
					txtGender.setText("");
				}
				else {
					txtGender.selectAll();
				}
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtGender.getText().equals(""))
					txtGender.setText(" GENDER");
			}
		});
		txtGender.setText(" GENDER");
		txtGender.setForeground(Color.GRAY);
		txtGender.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtGender.setColumns(10);
		
		txtContactNumber = new JTextField();
		txtContactNumber.setBounds(10, 346, 272, 29);
		txtContactNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(Character.isLetter(c)) {
					txtContactNumber.setEditable(false);
					JOptionPane.showMessageDialog(null, "Plese input 11 numbers only !!");
					txtContactNumber.setBackground(new Color(255, 255, 255));
				}
				else {
					txtContactNumber.setEditable(true);
					
				}
			}
		});
		txtContactNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtContactNumber.getText().equals(" CONTACT NUMBER")) {
					txtContactNumber.setText("");
				}
				else {
					txtContactNumber.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtContactNumber.getText().equals(""))
					txtContactNumber.setText(" CONTACT NUMBER");
			}
		});
		txtContactNumber.setText(" CONTACT NUMBER");
		txtContactNumber.setForeground(Color.GRAY);
		txtContactNumber.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtContactNumber.setColumns(10);
		
		txtEmailAddress = new JTextField();
		txtEmailAddress.setBounds(292, 346, 368, 29);
		txtEmailAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtEmailAddress.getText().equals(" EMAIL ADDRESS")) {
					txtEmailAddress.setText("");
				}
				else {
					txtEmailAddress.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtEmailAddress.getText().equals(""))
					txtEmailAddress.setText(" EMAIL ADDRESS");
			}
		});
		txtEmailAddress.setText(" EMAIL ADDRESS");
		txtEmailAddress.setForeground(Color.GRAY);
		txtEmailAddress.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtEmailAddress.setColumns(10);
		
		txtPresentAddress = new JTextField();
		txtPresentAddress.setBounds(10, 386, 650, 29);
		txtPresentAddress.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DocumentFilter f = new UppercaseJTextField();
				AbstractDocument doc = (AbstractDocument) txtPresentAddress.getDocument();
		        doc.setDocumentFilter(f);
			}
		});
		txtPresentAddress.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPresentAddress.getText().equals(" PRESENT ADDRESS")) {
					txtPresentAddress.setText("");
				}
				else {
					txtPresentAddress.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPresentAddress.getText().equals(""))
					txtPresentAddress.setText(" PRESENT ADDRESS");
			}
		});
		txtPresentAddress.setText(" PRESENT ADDRESS");
		txtPresentAddress.setForeground(Color.GRAY);
		txtPresentAddress.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 153, 0)));
		txtPresentAddress.setColumns(10);
		
		lblWarning = new JLabel("");
		lblWarning.setBounds(9, 426, 650, 3);
		lblWarning.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		JButton btnclear = new JButton("CLEAR");
		btnclear.setBounds(170, 447, 226, 29);
		btnclear.setForeground(Color.WHITE);
		btnclear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdNumber.setText(" ID NUMBER");
				txtAcademicYear.setText(" ACADEMIC YEAR");
				txtCoursedesignation.setText(" COURSE/DESIGNATION");
				txtLastName.setText(" LAST NAME/SUFFIX");
				txtFirstName.setText(" FIRST NAME");
				txtMiddleName.setText(" MIDDLE NAME");
				txtAge.setText(" AGE");
				txtMonth.setText(" BIRTH DATE");
				txtGender.setText(" GENDER");
				txtContactNumber.setText(" CONTACT NUMBER");
				txtEmailAddress.setText(" EMAIL ADDRESS");
				txtPresentAddress.setText(" PRESENT ADDRESS");
				lbladdphoto.setIcon(null);
				lblcontrolnumber.setText(" ");
				lblqrdisplay.setIcon(null);
				lblqrdisplay.setText("Get QR code");
			}
		});
		btnclear.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnclear.setBackground(Color.DARK_GRAY);
		
		JButton btnSave = new JButton("NEXT");
		btnSave.setBounds(433, 447, 227, 29);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtIdNumber.getText().equals(" ID NUMBER")) {
					JOptionPane.showMessageDialog(null, " Plese Add ID Number!!!");
				}else {
					SaveToDatabase();
				}
			}
		});
		setLayout(null);
		btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSave.setBackground(Color.DARK_GRAY);
		paneProfile.setLayout(null);
		paneProfile.add(txtCoursedesignation);
		paneProfile.add(txtIdNumber);
		paneProfile.add(logo);
		paneProfile.add(txtAcademicYear);
		paneProfile.add(lbladdphoto);
		paneProfile.add(lblNewLabel_1);
		paneProfile.add(txtLastName);
		paneProfile.add(txtFirstName);
		paneProfile.add(txtMiddleName);
		paneProfile.add(txtAge);
		paneProfile.add(lblNewLabel_3);
		paneProfile.add(txtMonth);
		paneProfile.add(txtGender);
		paneProfile.add(txtContactNumber);
		paneProfile.add(txtEmailAddress);
		paneProfile.add(txtPresentAddress);
		paneProfile.add(btnclear);
		paneProfile.add(btnSave);
		paneProfile.add(lblWarning);
		add(paneProfile);
		add(paneQRslot);
		add(btngenerate);

	}
	
	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/aloy";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","aloy");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Connection Failed! " + e);
		}
		
		return null;
	}
	private void SaveToDatabase() {
		
		m = new messageBox();
		m.show();
		
			
		m.lblID.setText(txtIdNumber.getText());
		m.lblCourse.setText(txtAcademicYear.getText());
		m.lblAcademicYear.setText(txtCoursedesignation.getText());
		m.lblFullName.setText(txtLastName.getText() + " " + txtFirstName.getText() + " " + txtMiddleName.getText());
		m.lblAgeee.setText(txtAge.getText());
		m.lblGM.setText(txtAge.getText());
		m.lblBD.setText(txtMonth.getText());
		m.lblCNMM.setText(txtContactNumber.getText());
		m.lblEaddd.setText(txtEmailAddress.getText());
		m.lblbl.setText(txtPresentAddress.getText());
		m.lblIDpcture.setIcon(lbladdphoto.getIcon());
		m.lblQRcode.setIcon(lblqrdisplay.getIcon());
		m.lblFilename.setText(lblcontrolnumber.getText());
		
		
		
		
		
	}
	class UppercaseJTextField extends DocumentFilter 
	    {
	        @Override
	        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
	           if (fb.getDocument().getLength() == 0) {
	               StringBuilder sb = new StringBuilder(text);
	               sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
	               text = sb.toString();
	           }
	           fb.insertString(offset, text, attr);
	        }

	        @Override
	        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	           if (fb.getDocument().getLength() == 0) {
	               StringBuilder sb = new StringBuilder(text);
	               sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
	               text = sb.toString();
	           }
	           fb.replace(offset, length, text, attrs);
	        }
	    }
	public ImageIcon ResizeImage (String ImagePath) 
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(lbladdphoto.getWidth(), lbladdphoto.getHeight(), Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
		 return image;
		 
		 
	 }
	public ImageIcon image (String ImagePath) 
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img = MyImage.getImage();
		 Image newImg = img.getScaledInstance(lblqrdisplay.getWidth(), lblqrdisplay.getHeight(), Image.SCALE_SMOOTH);
		 ImageIcon image = new ImageIcon(newImg);
		 return image;
		 
		 
	 }
	public class action implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
				try {
					String QRcodeData  = txtIdNumber.getText();
					String filepath = "D:\\QRcode\\" + txtIdNumber.getText() + ".png";
					String charset = "UTF-8";
					
					Map <EncodeHintType,ErrorCorrectionLevel> hintMap = new HashMap <EncodeHintType,ErrorCorrectionLevel>();
					hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
					
					BitMatrix matrix = new MultiFormatWriter().encode(new String (QRcodeData.getBytes(charset),charset),BarcodeFormat.QR_CODE, 250, 250,hintMap);
					
					MatrixToImageWriter.writeToFile(matrix, filepath.substring(filepath.lastIndexOf('.')+ 1),new File(filepath));
					
					
					lblcontrolnumber.setText(txtIdNumber.getText());
					JOptionPane.showMessageDialog(null, "QR code has been generated Successfully to " + filepath);
					
					
					
				}
				catch (Exception r) {
					JOptionPane.showMessageDialog(null,"error: " + r);
				}
			}
		
	}
	 
}
