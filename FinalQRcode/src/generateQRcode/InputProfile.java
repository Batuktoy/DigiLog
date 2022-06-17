package generateQRcode;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import mainProgram.contenctMain;
import qrGaller.MyQuery;
import qrGaller.QR_images;
import qrGaller.TheModel;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class InputProfile extends JPanel {
	private JTextField txtCname;
	private JTextField txtCadd;
	private JTextField txtID;
	private JTextField txtCN;
	
	private JComboBox cBoxAY = null;
	private JComboBox cBoxCourse = null;
	private JComboBox cBoxSY = null;
	
	
	private String path1 = null;
	private String path2 = null;
	
	
	Image img_logo = new ImageIcon(contenctMain.class.getResource("/images/ii.png")).getImage().getScaledInstance(165,95, Image.SCALE_SMOOTH);
	private JTable my_table;
	private JScrollPane scrollPane;
	
	
	
	public InputProfile() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				populateJTable();
				//ShowData();
			}
		});
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 415, 522);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		panel.setForeground(new Color(0, 51, 51));
		panel.setBackground(new Color(0, 51, 51));
		panel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SAINT JOSEPH COLLEGE ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setBounds(10, 11, 395, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OF SINDANGAN INCORPORATED");
		lblNewLabel_1.setForeground(new Color(153, 204, 153));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setBounds(68, 42, 279, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_2.setIcon(new ImageIcon(img_logo));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Image", "jpg","gif","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = file.getSelectedFile();
					path1 = selectedFile.getAbsolutePath();
					lblNewLabel_2.setIcon(ResizeImage(path1));
					
					
				}
	
				
				else if (result == JFileChooser.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Please Add Photo!!");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setBorder(new MatteBorder(2, 2, 2, 2, (Color) Color.ORANGE));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 51, 0)));
			}
		});
		lblNewLabel_2.setBackground(new Color(154, 205, 50));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 51, 0)));
		lblNewLabel_2.setBounds(251, 81, 139, 150);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID NUMBER");
		lblNewLabel_3.setForeground(new Color(153, 204, 153));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(49, 154, 112, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Course & Academic Year");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(153, 204, 153));
		lblNewLabel_3_1.setBounds(128, 284, 158, 22);
		panel.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Complete Name");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(new Color(153, 204, 153));
		lblNewLabel_3_1_1.setBounds(151, 345, 112, 14);
		panel.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Complete Address");
		lblNewLabel_3_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_2.setForeground(new Color(153, 204, 153));
		lblNewLabel_3_1_2.setBounds(151, 402, 112, 22);
		panel.add(lblNewLabel_3_1_2);
		
		txtCname = new JTextField();
		txtCname.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCname.setColumns(10);
		txtCname.setBounds(10, 314, 395, 28);
		panel.add(txtCname);
		
		txtCadd = new JTextField();
		txtCadd.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCadd.setColumns(10);
		txtCadd.setBounds(10, 373, 395, 28);
		panel.add(txtCadd);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtID.setColumns(10);
		txtID.setBounds(126, 121, 68, 22);
		panel.add(txtID);
		
		JLabel lblNewLabel_3_2 = new JLabel("-");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(new Color(0, 51, 0));
		lblNewLabel_3_2.setBounds(94, 121, 22, 22);
		panel.add(lblNewLabel_3_2);
		
		cBoxSY = new JComboBox();
		cBoxSY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cBoxSY.setSelectedItem(cBoxSY);
			}
		});
		cBoxSY.setModel(new DefaultComboBoxModel(new String[] {"S.Y.", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026"}));
		cBoxSY.setBounds(30, 121, 54, 22);
		panel.add(cBoxSY);
		
		
		
		cBoxCourse = new JComboBox();
		cBoxCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cBoxCourse.setSelectedItem(cBoxCourse);
			}
		});
		cBoxCourse.setModel(new DefaultComboBoxModel(new String[] {"Course", "Bachelor of Science in Information Technology", "BSBA major in Human Resource and Dev. Management", "BSBA major in Marketting Management", "Bachelor of Science Art", "Bachelor of Acounting Technology", "Bachelor of Schience in Crimenology", "BSED major in Math", "BSED major in English", "BSED major in Physical Education", "Bachelor in Elementaary Education", "Bachelor of Science in Social Work", "Junior High School", "SHS Academic ABM", "SHS Academic HUMSS", "SHS Academic STEM", "SHS Academic GAS", "SHS Tech. Voc. Caregiving", "SHS Tech. Voc. ICT ", "Tesda CSS", "Tesda VGD", "Tesda EIM", "Tesda HKP", "Tesda BKP"}));
		cBoxCourse.setBounds(10, 256, 290, 28);
		panel.add(cBoxCourse);
		
		cBoxAY = new JComboBox();
		cBoxAY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cBoxAY.setSelectedItem(cBoxAY);
			}
		});
		cBoxAY.setModel(new DefaultComboBoxModel(new String[] {"Acad. Year", "First Year", "Second Year", "Third Year", "Fourth Year", "Summer"}));
		cBoxAY.setBounds(309, 256, 96, 28);
		panel.add(cBoxAY);
		
		txtCN = new JTextField();
		txtCN.setToolTipText("");
		txtCN.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtCN.setColumns(10);
		txtCN.setBounds(75, 186, 139, 22);
		panel.add(txtCN);
		
		JLabel lblNewLabel_3_3 = new JLabel("Contact Number");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3.setForeground(new Color(153, 204, 153));
		lblNewLabel_3_3.setBounds(71, 217, 96, 14);
		panel.add(lblNewLabel_3_3);
		
		JButton btnNewButton = new JButton("GENERATE QR CODE");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String SY = cBoxSY.getSelectedItem().toString();
					String c = cBoxCourse.getSelectedItem().toString();
					String AY = cBoxAY.getSelectedItem().toString();
					JLabel lbl = new JLabel();
					JLabel lbl1 = new JLabel();
					JLabel lbl2 = new JLabel();
					lbl.setText(SY);
					lbl1.setText(c);
					lbl2.setText(AY);
							
					
					String QRcodeData  = lblNewLabel_2.getIcon() + "\n" +
					lbl.getText() + " - " +  txtID.getText() + "\n" + 
					"+63" + txtCN.getText() + "\n" + 
					lbl1.getText() + " - " + lbl2.getText() + "\n" +
					txtCname.getText() + "\n" + 
					txtCadd.getText();
					
					path2 = "D:\\myQR\\" + lbl.getText() + " - " +  txtID.getText() + ".png";
					String charset = "UTF-8";
					
					Map <EncodeHintType,ErrorCorrectionLevel> hintMap = new HashMap <EncodeHintType,ErrorCorrectionLevel>();
					hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
					
					
					
					BitMatrix matrix = new MultiFormatWriter().encode(new String (QRcodeData.getBytes(charset),charset),BarcodeFormat.QR_CODE, 250, 250,hintMap);
					MatrixToImageWriter.writeToFile(matrix, path2.substring(path2.lastIndexOf('.')+ 1),new File(path2));
					
					
					
					JFrame frame = new JFrame();
					ImageIcon icon = new ImageIcon("D:\\myQR\\" + lbl.getText() + " - " +  txtID.getText() + ".png");
					JLabel view = new JLabel(icon);
					
	
					
					
					frame.getContentPane().add(view);
					
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(550, 330, 100, 100);
					frame.pack();
					frame.setVisible(true);
					
					
					
					
					
				}
				catch (Exception e1) {
					System.out.println(e1);
				}
				
				SaveToData();
			}
			
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(69, 447, 262, 52);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("+63");
		lblNewLabel_3_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_3_1.setForeground(new Color(153, 204, 153));
		lblNewLabel_3_3_1.setBounds(41, 186, 32, 22);
		panel.add(lblNewLabel_3_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(425, 11, 497, 500);
		add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 477, 478);
		panel_1.add(scrollPane);
		
		my_table = new JTable();
		my_table.setGridColor(Color.BLACK);
		my_table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setViewportView(my_table);
		
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
	private void SaveToData() {
		Connection con = con();
		File f = new File(path1);
		File g = new File(path2);
		cBoxSY = new JComboBox();
		cBoxCourse = new JComboBox();
		cBoxAY = new JComboBox();
		
		
		try {
			InputStream is = new FileInputStream(f);
			InputStream iss = new FileInputStream(g);
			
			
			String query = " insert into qr_code (ID_NUMBER, NAME, IMAGE, PICTURE, C_NUMBER, COURSE, ADDRESS values (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			
			String value = cBoxSY.getSelectedItem().toString();
			ps.setString(1, value + txtID.getText());
			
			ps.setString(2, txtCname.getText());
			ps.setBlob(3, is);
			ps.setBlob(4, iss);
			ps.setString(5, txtCN.getText());
			
			String value1 = cBoxCourse.getSelectedItem().toString();
			String value2 = cBoxCourse.getSelectedItem().toString();
			
			ps.setString(6, value1 + value2);
			ps.setString(7, txtCadd.getText());
			
			
			int inserted = ps.executeUpdate();
			if(inserted > 0 ) {
				JOptionPane.showMessageDialog(null,"Saved Succesfully");
			}
		} catch (FileNotFoundException e) {
			System.out.print("Connection Failed! " + e );
		} catch (SQLException e) {
			System.out.print("Connection Failed! " + e );
		}
	}
	
	public void populateJTable() {
		MyQuery mq = new MyQuery();
		ArrayList<QR_images> list = mq.BindTable();
		Object [][] rows = new Object[list.size()][7];
		String[] columnName = {"ID Number","Name","QR code Image","Picture","Contact Number","Course","Address"};
		
		for (int i = 0; i < list.size(); i++) {
			rows [i] [0] = list.get(i).getID();
			rows [i] [1] = list.get(i).getName();
			rows [i] [2] = list.get(i).getMyImage();
			rows [i] [3] = list.get(i).getMyImage2();
			rows [i] [4] = list.get(i).getcNumber();
			rows [i] [5] = list.get(i).getCourse();
			rows [i] [6] = list.get(i).getAddress();
			
			 if(list.get(i).getMyImage() != null)
			 {
				 ImageIcon image = new ImageIcon(new ImageIcon(list.get(i).getMyImage()).getImage()
			             .getScaledInstance(150, 120, Image.SCALE_SMOOTH) );   
			                
			            rows[i][2 & 3] = image;
			            }
			            else{
			                rows[i][2] = null;
			            }
			       
			        }
		
					
			        
			        TheModel model = new TheModel(rows, columnName);
			        my_table.setModel(model);
			        my_table.setRowHeight(120);
			        my_table.getColumnModel().getColumn(0).setPreferredWidth(100);
			        my_table.getColumnModel().getColumn(1).setPreferredWidth(100);
			        my_table.getColumnModel().getColumn(2).setPreferredWidth(150);
			        my_table.getColumnModel().getColumn(3).setPreferredWidth(150);
			        my_table.getColumnModel().getColumn(4).setPreferredWidth(100);
			        my_table.getColumnModel().getColumn(5).setPreferredWidth(50);
			        my_table.getColumnModel().getColumn(6).setPreferredWidth(300);
			        

			 }

			 	
	
	public ImageIcon ResizeImage (String ImagePath) 
	 {
		 ImageIcon MyImage = new ImageIcon(ImagePath);
		 Image img1 = MyImage.getImage();
		 Image newImg1 = img1.getScaledInstance(139, 150, Image.SCALE_SMOOTH);
		 ImageIcon image1 = new ImageIcon(newImg1);
		 return image1;
	 }
}
