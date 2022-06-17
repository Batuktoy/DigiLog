package subFrame;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class pane_in_out extends JPanel {
	private JTable table;
	
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
	public pane_in_out() {
		setFont(new Font("Tahoma", Font.PLAIN, 26));
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				ShowData();
			}
		});
		
		setBackground(new Color(0, 51, 51));
		setBounds(220, 89, 932, 522);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 473, 376);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("REFRESH");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(163, 477, 172, 34);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LOG IN & LOG OUT DATABASE");
		lblNewLabel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.BLACK));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel.setBounds(27, 11, 427, 53);
		add(lblNewLabel);

	}
	private void ShowData() {
		Connection con = con();
		DefaultTableModel model = new DefaultTableModel();
		
		model.addColumn("ID");
		model.addColumn("ID Number");
		model.addColumn("In Time");
		model.addColumn("Out Time");
		model.addColumn("Logdate");
		model.addColumn("Status");
		
		
		try {
			String query = "Select * from visitors_pass ";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[] {
						rs.getString("id"),
						rs.getString("idnumber"),
						rs.getString("in_time"),
						rs.getString("out_time"),
						rs.getString("Logdate"),
						rs.getString("Status"),
						
				});
			}
			
			rs.close();
			st.close();
			con.close();
			
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(20);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(50);
			
			 
		} catch (Exception e) {
			System.out.println("Error"+ e);
		}
	}
}
