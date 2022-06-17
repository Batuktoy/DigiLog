package subFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import mainProgram.contenctMain;

import java.awt.SystemColor;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class paneVisitorsDatabase extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblCnumber;
	private JLabel lblfilepath;
	private JLabel lblQRQR;
	
	static Connection con() {
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
	public paneVisitorsDatabase() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ShowDatabase();
			}
		});
		
		setFont(new Font("Tahoma", Font.PLAIN, 14));
		Image img_logo = new ImageIcon(contenctMain.class.getResource("/images/sjcsi.png")).getImage().getScaledInstance(109,95, Image.SCALE_SMOOTH);
		
		
		setBackground(new Color(0, 51, 51));
		setBounds(220, 89, 932, 522);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		scrollPane.setBounds(10, 11, 372, 500);
		
		JLabel lblNewLabel = new JLabel("VISITORS DATABASE");
		lblNewLabel.setBounds(429, 11, 463, 59);
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel.setForeground(new Color(255, 153, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id_number = table.getValueAt(table.getSelectedRow(), 0).toString();
				SetTextField(id_number);
			}
		});
		scrollPane.setViewportView(table);
		
		
		add(scrollPane);
		add(lblNewLabel);
		
		JPanel paneMAINpane = new JPanel();
		paneMAINpane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		paneMAINpane.setBackground(SystemColor.inactiveCaption);
		paneMAINpane.setAlignmentY(1.0f);
		paneMAINpane.setAlignmentX(1.0f);
		paneMAINpane.setBounds(392, 88, 530, 352);
		add(paneMAINpane);
		paneMAINpane.setLayout(null);
		
		JPanel paneENTRANCEs = new JPanel();
		paneENTRANCEs.setBounds(11, 12, 508, 328);
		paneENTRANCEs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		paneENTRANCEs.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 102, 51)));
		paneENTRANCEs.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2 = new JLabel("NAME:");
		lblNewLabel_5_2.setBounds(10, 157, 44, 21);
		
		textField = new JTextField();
		textField.setBounds(64, 158, 338, 20);
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("AGE:");
		lblNewLabel_5_1_1.setBounds(412, 157, 33, 21);
		
		textField_1 = new JTextField();
		textField_1.setBounds(455, 159, 43, 20);
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_1.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("COMPLETE ADDRESS:");
		lblNewLabel_5_2_1.setBounds(10, 189, 126, 21);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 188, 354, 20);
		textField_2.setColumns(10);
		textField_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_2.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("BIRTH DATE:");
		lblNewLabel_5_2_1_1.setBounds(10, 221, 76, 21);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 221, 105, 20);
		textField_3.setColumns(10);
		textField_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_3.setBackground(SystemColor.menu);
		
		textField_4 = new JTextField();
		textField_4.setBounds(244, 222, 55, 20);
		textField_4.setColumns(10);
		textField_4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_4.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1_1 = new JLabel("GENDER:");
		lblNewLabel_5_2_1_1_1.setBounds(195, 221, 50, 21);
		
		JLabel lblNewLabel_5_2_1_1_2 = new JLabel("CONTACT #:");
		lblNewLabel_5_2_1_1_2.setBounds(309, 219, 76, 21);
		
		textField_5 = new JTextField();
		textField_5.setBounds(374, 219, 126, 20);
		textField_5.setColumns(10);
		textField_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_5.setBackground(SystemColor.menu);
		
		textField_6 = new JTextField();
		textField_6.setBounds(309, 259, 187, 27);
		textField_6.setColumns(10);
		textField_6.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_6.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_5_2_1_1_3 = new JLabel("SIGNATURE");
		lblNewLabel_5_2_1_1_3.setBounds(356, 297, 89, 22);
		lblNewLabel_5_2_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(13, 11, 97, 95);
		lblNewLabel_1.setIcon(new ImageIcon(img_logo));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("CONTROL NUMBER:");
		lblNewLabel_5.setBounds(10, 125, 115, 21);
		
		lblCnumber = new JLabel("");
		lblCnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCnumber.setBounds(131, 125, 139, 21);
		lblCnumber.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		
		JLabel lblNewLabel_5_1 = new JLabel("DATE:");
		lblNewLabel_5_1.setBounds(345, 124, 38, 21);
		
		textField_7 = new JTextField();
		textField_7.setBounds(393, 126, 105, 20);
		textField_7.setColumns(10);
		textField_7.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		textField_7.setBackground(SystemColor.menu);
		
		JLabel lblNewLabel_2 = new JLabel("SAINT JOSEPH COLLEGE OF");
		lblNewLabel_2.setBounds(120, 11, 265, 37);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 102, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		JLabel lblNewLabel_2_1 = new JLabel("SINDANGAN INCORPORATED");
		lblNewLabel_2_1.setBounds(123, 43, 262, 21);
		lblNewLabel_2_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(new Color(0, 102, 0));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		
		JLabel lblNewLabel_4 = new JLabel("ENTRANCE SLIP");
		lblNewLabel_4.setBounds(142, 75, 240, 37);
		lblNewLabel_4.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		lblNewLabel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		
		lblQRQR = new JLabel("");
		lblQRQR.setBounds(401, 11, 97, 101);
		lblQRQR.setHorizontalTextPosition(SwingConstants.CENTER);
		lblQRQR.setHorizontalAlignment(SwingConstants.CENTER);
		lblQRQR.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		paneMAINpane.add(paneENTRANCEs);
		paneENTRANCEs.setLayout(null);
		paneENTRANCEs.add(lblNewLabel_5_2);
		paneENTRANCEs.add(textField);
		paneENTRANCEs.add(lblNewLabel_5_1_1);
		paneENTRANCEs.add(textField_1);
		paneENTRANCEs.add(lblNewLabel_5_2_1);
		paneENTRANCEs.add(textField_2);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1);
		paneENTRANCEs.add(textField_3);
		paneENTRANCEs.add(textField_4);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1_1);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1_2);
		paneENTRANCEs.add(textField_5);
		paneENTRANCEs.add(textField_6);
		paneENTRANCEs.add(lblNewLabel_5_2_1_1_3);
		paneENTRANCEs.add(lblNewLabel_5);
		paneENTRANCEs.add(lblNewLabel_1);
		paneENTRANCEs.add(lblCnumber);
		paneENTRANCEs.add(lblNewLabel_5_1);
		paneENTRANCEs.add(textField_7);
		paneENTRANCEs.add(lblNewLabel_2);
		paneENTRANCEs.add(lblNewLabel_2_1);
		paneENTRANCEs.add(lblNewLabel_4);
		paneENTRANCEs.add(lblQRQR);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton.setBounds(744, 459, 178, 41);
		add(btnNewButton);
		
		lblfilepath = new JLabel("");
		lblfilepath.setForeground(Color.WHITE);
		lblfilepath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblfilepath.setBounds(392, 459, 337, 41);
		add(lblfilepath);

	}
	private void ShowDatabase() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("Control Number");
		model.addColumn("QR code Path");
		model.addColumn("Qr code File");
		
		
		try {
			String query = "Select * from visitors_database ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("control_number"),
						rs.getString("qrcode_path"),
						rs.getString("qrcode_file"),
						
						
				});
			}
			
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(250);
			table.getColumnModel().getColumn(2).setPreferredWidth(250);
			
			 
		} catch (Exception e) {
			System.out.println("Error"+ e);
		}
	}
	private void SetTextField(String idnumber) {
		Connection con =con();
		try {
			String query = "select * from visitors_database where control_number = ?";
			PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, idnumber);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				lblCnumber.setText(rs.getString("control_number"));
				lblfilepath.setText(rs.getString("qrcode_path"));
				byte[] img1 = rs.getBytes("qrcode_file");
				
				ImageIcon image1 = new ImageIcon(img1);
                Image im1 = image1.getImage();
                Image myImg1 = im1.getScaledInstance(lblQRQR.getWidth(), lblQRQR.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage1 = new ImageIcon(myImg1);
                lblQRQR.setIcon(newImage1);
                lblQRQR.setText("");
				
			}
			ps.close();
			con.close();
		}catch (Exception e) {
			System.out.println("error" + e);
		}
	}
	
}
