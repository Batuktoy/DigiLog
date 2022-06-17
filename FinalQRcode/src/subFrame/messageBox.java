package subFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import mainProgram.contenctMain;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

public class messageBox {
	
	Image img_logo = new ImageIcon(contenctMain.class.getResource("/images/Caution.png")).getImage().getScaledInstance(65,65, Image.SCALE_SMOOTH);


	private JFrame frmMe;
	public static JLabel lblID;
	public static JLabel lblCourse;
	public static JLabel lblAcademicYear;
	public static JLabel lblIDpcture;
	public static JLabel lblFullName;
	public static JLabel lblAgeee;
	public static JLabel lblGM;
	public static JLabel lblCNMM;
	public static JLabel lblEaddd;
	public static JLabel lblbl;
	public static JLabel lblQRcode;
	public static JLabel lblFilename;
	public profile QR;
	private JLabel lblNewLabel_2_1_1_1_1_1;
	public static JLabel lblBD;

	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					messageBox window = new messageBox();
					window.frmMe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public messageBox() {
		initialize();
	}
	
	//Connection con;
	//PreparedStatement pst;
	//ResultSet rs;
	private JScrollPane scrollPane;

	private void initialize() {

		frmMe = new JFrame();
		frmMe.getContentPane().setBackground(SystemColor.inactiveCaption);
		frmMe.setBackground(Color.WHITE);
		frmMe.setUndecorated(true);
		frmMe.setResizable(false);
		frmMe.setBounds(500, 150, 466, 451);
		frmMe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMe.getContentPane().setLayout(null);
		
		lblIDpcture = new JLabel("");
		lblIDpcture.setHorizontalTextPosition(SwingConstants.CENTER);
		lblIDpcture.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblIDpcture.setForeground(SystemColor.desktop);
		lblIDpcture.setHorizontalAlignment(SwingConstants.CENTER);
		lblIDpcture.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		lblIDpcture.setBackground(Color.WHITE);
		lblIDpcture.setBounds(330, 58, 126, 131);
		frmMe.getContentPane().add(lblIDpcture);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		panel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.BLACK));
		panel.setBounds(0, 0, 466, 451);
		frmMe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Check Details Before Saving");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(84, 11, 361, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		
		JLabel lblWarning = new JLabel("");
		lblWarning.setBounds(10, 11, 66, 63);
		lblWarning.setIcon(new ImageIcon(img_logo));
		panel.add(lblWarning);
		
		lblID = new JLabel("");
		lblID.setVerticalAlignment(SwingConstants.BOTTOM);
		lblID.setBounds(10, 85, 162, 45);
		panel.add(lblID);
		lblID.setForeground(new Color(204, 0, 0));
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 153, 0), new Color(255, 153, 0)), "ID number:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		
		lblCourse = new JLabel("");
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCourse.setBackground(Color.WHITE);
		lblCourse.setForeground(Color.BLACK);
		lblCourse.setBounds(10, 128, 89, 25);
		panel.add(lblCourse);
		
		lblAcademicYear = new JLabel("");
		lblAcademicYear.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAcademicYear.setForeground(Color.BLACK);
		lblAcademicYear.setBounds(109, 128, 211, 25);
		panel.add(lblAcademicYear);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.setBounds(328, 302, 128, 63);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMe.dispose();
			}
		});
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		JButton btnPkay = new JButton("SAVE");
		btnPkay.setBounds(328, 376, 128, 64);
		panel.add(btnPkay);
		btnPkay.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPkay.setBackground(new Color(255, 153, 0));
		btnPkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDataB();
				frmMe.dispose();
			}
		});
		btnPkay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		lblQRcode = new JLabel("");
		lblQRcode.setBounds(10, 302, 157, 138);
		panel.add(lblQRcode);
		lblQRcode.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQRcode.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblQRcode.setForeground(SystemColor.desktop);
		lblQRcode.setHorizontalAlignment(SwingConstants.CENTER);
		lblQRcode.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 51)));
		lblQRcode.setBackground(new Color(0, 153, 51));
		
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("COMPLETE ADDRESS:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1_1_1.setBounds(10, 266, 129, 25);
		panel.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_1_1_1);
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		
		lblbl = new JLabel("");
		lblbl.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblbl.setBounds(149, 266, 307, 25);
		panel.add(lblbl);
		lblbl.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1 = new JLabel("CONTACT NUMBER:");
		lblNewLabel_2_1_1_1_1_1_1_1_1.setBounds(233, 194, 110, 25);
		panel.add(lblNewLabel_2_1_1_1_1_1_1_1_1);
		lblNewLabel_2_1_1_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		
		lblCNMM = new JLabel("");
		lblCNMM.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCNMM.setBounds(356, 194, 89, 25);
		panel.add(lblCNMM);
		lblCNMM.setForeground(Color.BLACK);
		
		
		JLabel lblNewLabel_2_1_1_1_1_1_1_1_1_1_1 = new JLabel("EMAIL ADDRESS:");
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1.setBounds(191, 230, 98, 25);
		panel.add(lblNewLabel_2_1_1_1_1_1_1_1_1_1_1);
		lblNewLabel_2_1_1_1_1_1_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		
		lblEaddd = new JLabel("");
		lblEaddd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEaddd.setBounds(299, 230, 157, 25);
		panel.add(lblEaddd);
		lblEaddd.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("AGE:");
		lblNewLabel_2_1_1.setBounds(10, 194, 31, 25);
		panel.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setForeground(new Color(255, 255, 255));
		
		
		
		lblAgeee = new JLabel("");
		lblAgeee.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAgeee.setBounds(51, 194, 45, 25);
		panel.add(lblAgeee);
		lblAgeee.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Gender:");
		lblNewLabel_2_1_1_1_1.setBounds(133, 194, 45, 25);
		panel.add(lblNewLabel_2_1_1_1_1);
		lblNewLabel_2_1_1_1_1.setForeground(new Color(255, 255, 255));
		
		lblGM = new JLabel("");
		lblGM.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGM.setBounds(191, 194, 31, 25);
		panel.add(lblGM);
		lblGM.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_2_1 = new JLabel("COMPLETE NAME:");
		lblNewLabel_2_1.setBounds(10, 164, 103, 25);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		
		
		lblFullName = new JLabel("");
		lblFullName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblFullName.setBounds(123, 164, 197, 25);
		panel.add(lblFullName);
		lblFullName.setForeground(Color.BLACK);
		
		lblNewLabel_2_1_1_1_1_1 = new JLabel("BIRTH DATE:");
		lblNewLabel_2_1_1_1_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1_1_1_1_1.setBounds(10, 230, 70, 25);
		panel.add(lblNewLabel_2_1_1_1_1_1);
		
		lblBD = new JLabel("");
		lblBD.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBD.setForeground(Color.BLACK);
		lblBD.setBounds(90, 230, 97, 25);
		panel.add(lblBD);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(177, 302, 140, 39);
		panel.add(scrollPane);
		
		lblFilename = new JLabel("");
		lblFilename.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(lblFilename);
	}

	public void show() {
		frmMe.show();
		
	}
	static Connection con() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost/qr_generator";
			Class.forName(driver);
			return DriverManager.getConnection(url,"root","");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Connection Failed! " + e);
		}
		
		return null;
	}
	private void SaveToDataB() {
		Connection con = con();
		File f = new File(QR.path);
		
		try {
			InputStream is = new FileInputStream(f);
			
			
			String query = " insert into aloy_aloy (id_number, academic_year, course, surname, firstname, middlename, age, birthdate, gender, ContactNumber, EmailAddress, CompleteAddress, ImagePath, ImageFile)"
			        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, QR.txtIdNumber.getText());
			ps.setString(2, QR.txtAcademicYear.getText());
			ps.setString(3, QR.txtCoursedesignation.getText());
			ps.setString(4, QR.txtLastName.getText());
			ps.setString(5, QR.txtFirstName.getText());
			ps.setString(6, QR.txtMiddleName.getText());
			ps.setString(7, QR.txtAge.getText());
			ps.setString(8, QR.txtMonth.getText());
			ps.setString(9, QR.txtGender.getText());
			ps.setString(10, QR.txtContactNumber.getText());
			ps.setString(11, QR.txtEmailAddress.getText());
			ps.setString(12, QR.txtPresentAddress.getText());
			ps.setString(13, QR.path);
			ps.setBlob(14, is);
		
		
			
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
