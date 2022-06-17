package subFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class paneDatas extends JPanel {
	private JTable table;
	private JButton REFRESH;
	private JButton DELETE;
	private JScrollPane scrollPane;
	public profile qr;
	
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

	public paneDatas() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ShowData();
			}
		});
		
		setBackground(new Color(0, 51, 51));
		
		
		
	
		REFRESH = new JButton("REFRESH");
		REFRESH.setForeground(Color.WHITE);
		REFRESH.setBackground(Color.DARK_GRAY);
		REFRESH.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		REFRESH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowData();
			}
		});
		
		DELETE = new JButton("DELETE");
		DELETE.setForeground(Color.WHITE);
		DELETE.setBackground(Color.DARK_GRAY);
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectedRow() >= 0) {
					Deletedata(profile.txtIdNumber.getText());
				}
			}
		});
		
		DELETE.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id_number = table.getValueAt(table.getSelectedRow(), 0).toString();
				SetTextField(id_number);
			}
		});
		scrollPane.setViewportView(table);
		table.setGridColor(Color.BLACK);
		table.setForeground(Color.BLACK);
		table.setFont(new Font("Bookman Old Style", Font.PLAIN, 16));
		table.setBackground(Color.ORANGE);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(486)
							.addComponent(REFRESH, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(DELETE, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addGap(10))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(REFRESH, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(DELETE, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(16))
		);
		setLayout(groupLayout);

	}
	

	private void ShowData() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID Number");
		model.addColumn("Academic Year");
		model.addColumn("Course");
		model.addColumn("Last name & Suffix");
		model.addColumn("First Name");
		model.addColumn("Middle Name");
		model.addColumn("Age");
		model.addColumn("Birth Date");
		model.addColumn("Gender");
		model.addColumn("Contact Number");
		model.addColumn("Email Address");
		model.addColumn("Complete Address");
		model.addColumn("Image Path");
		model.addColumn("Image File");
		
		try {
			String query = "Select * from aloy_aloy ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id_number"),
						rs.getString("academic_year"),
						rs.getString("course"),
						rs.getString("surname"),
						rs.getString("firstname"),
						rs.getString("middlename"),
						rs.getString("age"),
						rs.getString("birthdate"),
						rs.getString("gender"),
						rs.getString("ContactNumber"),
						rs.getString("EmailAddress"),
						rs.getString("CompleteAddress"),
						rs.getString("ImagePath"),
						rs.getString("ImageFile"),
						
					
				});
			}
			
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(200);
			table.getColumnModel().getColumn(4).setPreferredWidth(200);
			table.getColumnModel().getColumn(5).setPreferredWidth(200);
			table.getColumnModel().getColumn(6).setPreferredWidth(80);
			table.getColumnModel().getColumn(7).setPreferredWidth(120);
			table.getColumnModel().getColumn(8).setPreferredWidth(70);
			table.getColumnModel().getColumn(9).setPreferredWidth(120);
			table.getColumnModel().getColumn(10).setPreferredWidth(200);
			table.getColumnModel().getColumn(11).setPreferredWidth(400);
			table.getColumnModel().getColumn(12).setPreferredWidth(200);
			table.getColumnModel().getColumn(13).setPreferredWidth(200);
			
			 
		} catch (Exception e) {
			System.out.println("Error"+ e);
		}
	}
	
	private void SetTextField(String idnumber) {
		Connection con =con();
		try {
			String query = "select * from aloy_aloy where id_number = ?";
			PreparedStatement ps = con.prepareStatement(query); 
			ps.setString(1, idnumber);
			ResultSet rs = ps.executeQuery();
			
			
			while (rs.next()) {
				qr.txtIdNumber.setText(rs.getString("id_number"));
				qr.txtAcademicYear.setText(rs.getString("academic_year"));
				qr.txtCoursedesignation.setText(rs.getString("course"));
				qr.txtLastName.setText(rs.getString("surname"));
				qr.txtFirstName.setText(rs.getString("firstname"));
				qr.txtMiddleName.setText(rs.getString("middlename"));
				qr.txtAge.setText(rs.getString("age"));
				qr.txtMonth.setText(rs.getString("birthdate"));
				qr.txtGender.setText(rs.getString("gender"));
				qr.txtContactNumber.setText(rs.getString("ContactNumber"));
				qr.txtEmailAddress.setText(rs.getString("EmailAddress"));
				qr.txtPresentAddress.setText(rs.getString("CompleteAddress"));
				qr.lblcontrolnumber.setText(rs.getString("ImagePath"));
				byte[] img1 = rs.getBytes("ImageFile");
				
				
				
				ImageIcon image1 = new ImageIcon(img1);
                Image im1 = image1.getImage();
                Image myImg1 = im1.getScaledInstance(qr.lblqrdisplay.getWidth(), qr.lblqrdisplay.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage1 = new ImageIcon(myImg1);
                qr.lblqrdisplay.setIcon(newImage1);
                qr.lblqrdisplay.setText("");
				
			}
			ps.close();
			con.close();
		}catch (Exception e) {
			System.out.println("error" + e);
		}
	}
	private void Deletedata(String idnumber) {
		Connection con = con();
	
		try {
			String query = "DELETE FROM `aloy_aloy` WHERE id_number = ?;";
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, idnumber);
			ps.execute();
			  
			ps.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Are You Sure You Want to Delete This?");
			ShowData();
		}catch (Exception e) {
			System.out.println("error" + e);
		}
	}
}
