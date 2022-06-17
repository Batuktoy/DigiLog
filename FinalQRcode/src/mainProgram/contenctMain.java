package mainProgram;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import subFrame.paneDatas;
import generateQRcode.InputProfile;
import subFrame.profile;
import subFrame.paneVisitorsDatabase;
import subFrame.paneVisitorsSlip;
import subFrame.pane_in_out;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.DropMode;

public class contenctMain {
	
	private Image img_ID = new ImageIcon(contenctMain.class.getResource("/images/qr.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	private Image img_data = new ImageIcon(contenctMain.class.getResource("/images/sql.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image img_VisitorsSlip = new ImageIcon(contenctMain.class.getResource("/images/vS.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image img_VisitorsData = new ImageIcon(contenctMain.class.getResource("/images/Vdb.png")).getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
	private Image img_Logout = new ImageIcon(contenctMain.class.getResource("/images/exit.png")).getImage().getScaledInstance(48, 45, Image.SCALE_SMOOTH);
	private Image img_inout = new ImageIcon(contenctMain.class.getResource("/images/inout.png")).getImage().getScaledInstance(50, 47, Image.SCALE_SMOOTH);
	private Image img_search = new ImageIcon(contenctMain.class.getResource("/images/search.png")).getImage().getScaledInstance(50, 47, Image.SCALE_SMOOTH);

	private JFrame frmQrCodeLogbook;
	
	private static profile profile;
	private static paneDatas DB;
	private static paneVisitorsSlip VS;
	private static paneVisitorsDatabase VDb;
	private static pane_in_out InOut;
	public static JPanel paneQRcode;
	private JLabel lblme;
	private JLabel lblClock; 
	private JLabel lbldate;
	private JLabel lblTime;
	private JLabel lblQRG;
	private JLabel lblDataBase;
	private JLabel lblVisitirsSlip;
	private JLabel lblVdataBase;
	private JLabel lblNewLabel_1;
	private JLabel lbltitleheader;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contenctMain window = new contenctMain();
					window.frmQrCodeLogbook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void dt ()
	{
		 Date d = new Date();
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("MMMM/dd/yyyy : EEEE");
		 String dd = sdf.format(d);
		 
		 lbldate.setText(dd);
	}
	
	Timer t ;
	SimpleDateFormat st;
	private JTextField txtSearchIdNumber;
	
	public void time() 
	{
		
		
		t = new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date dt = new Date();
				st = new SimpleDateFormat("hh:mm:ss a");
				
				String tt = st.format(dt); 
				
				lblTime.setText(tt);
			}
		});
		
		t.start();
	}

	/**
	 * Create the application.
	 */
	public contenctMain() {
		initialize();
		dt();
		time();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmQrCodeLogbook = new JFrame();
		frmQrCodeLogbook.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		frmQrCodeLogbook.setForeground(Color.BLACK);
		frmQrCodeLogbook.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\Pictures\\qr.png"));
		frmQrCodeLogbook.setTitle("QR CODE LOGBOOK SYSTEM");
		frmQrCodeLogbook.setBackground(Color.ORANGE);
		frmQrCodeLogbook.setResizable(false);
		frmQrCodeLogbook.getContentPane().setBackground(Color.GRAY);
		
		profile = new profile();
		DB = new paneDatas();
		VS = new paneVisitorsSlip();
		VDb = new paneVisitorsDatabase();
		InOut = new pane_in_out();
		
		JPanel paneHeader = new JPanel();
		paneHeader.setBounds(0, 0, 1846, 23);
		paneHeader.setBackground(new Color(0, 51, 51));
		
		JPanel paneTitlebar = new JPanel();
		paneTitlebar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		paneTitlebar.setBounds(0, 23, 1159, 61);
		paneTitlebar.setBackground(new Color(0, 102, 102));
		
		JPanel paneBottombar = new JPanel();
		paneBottombar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		paneBottombar.setBounds(0, 616, 1159, 45);
		paneBottombar.setBackground(new Color(0, 102, 102));
		
		JPanel paneSidebar = new JPanel();
		paneSidebar.setBounds(0, 84, 215, 532);
		paneSidebar.setBackground(new Color(0, 51, 51));
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(220, 89, 932, 522);
		paneMainContent.add(profile);
		paneMainContent.add(DB);
		paneMainContent.add(VS);
		paneMainContent.add(VDb);
		paneMainContent.add(InOut);
		
		
		menuClicked(profile);
		
		lblClock = new JLabel("   Time :");
		lblClock.setBounds(10, 11, 63, 23);
		lblClock.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lblClock.setForeground(new Color(0, 0, 0));
		lblClock.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		lblTime = new JLabel("0");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTime.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(255, 153, 0)));
		lblTime.setBounds(79, 11, 133, 23);
		lblTime.setForeground(Color.ORANGE);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(913, 11, 44, 23);
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		lbldate = new JLabel("0");
		lbldate.setBounds(963, 11, 186, 23);
		lbldate.setForeground(Color.ORANGE);
		lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lbltitleheader = new JLabel(" QR CODE GENERATOR");
		lbltitleheader.setBounds(10, 12, 565, 39);
		lbltitleheader.setForeground(new Color(255, 204, 0));
		lbltitleheader.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(0, 0, 1, 1, (Color) Color.WHITE));
		panel_1.setBounds(1088, 1, 71, 60);
		panel_1.addMouseListener(new  MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con =con();
				try {
					String query = "select * from aloy_aloy where id_number = ?";
					PreparedStatement ps = con.prepareStatement(query); 
					ps.setString(1, txtSearchIdNumber.getText());
					ResultSet rs = ps.executeQuery();
					
					if (rs.next() == false) 
					{
						JOptionPane.showMessageDialog(null,"Sorry Record Not Found");
						profile.txtIdNumber.requestFocus();
						profile.txtIdNumber.setText(" ID NUMBER");;
						profile.txtAcademicYear.setText(" ACADEMIC YEAR");
						profile.txtCoursedesignation.setText(" COURSE/DESIGNATION");
						profile.txtLastName.setText(" LAST NAME/SEFFIX");
						profile.txtFirstName.setText(" FIRST NAME");
						profile.txtMiddleName.setText(" MIDDLE NAME");
						profile.txtAge.setText(" AGE");
						profile.txtMonth.setText(" BIRTH DATE");
						profile.txtGender.setText(" GENDER");
						profile.txtContactNumber.setText(" CONTACT NUMBER");
						profile.txtEmailAddress.setText(" EMAIL ADDRESS");
						profile.txtPresentAddress.setText(" COMPLETE ADDRESS");
						txtSearchIdNumber.setText("Search ID Number");
						profile.lblcontrolnumber.setText("");
						profile.lblqrdisplay.setText("Get QR code");
						
						
						
					}
					else 
					{
						profile.txtIdNumber.setText(rs.getString("id_number"));
						profile.txtAcademicYear.setText(rs.getString("academic_year"));
						profile.txtCoursedesignation.setText(rs.getString("course"));
						profile.txtLastName.setText(rs.getString("surname"));
						profile.txtFirstName.setText(rs.getString("firstname"));
						profile.txtMiddleName.setText(rs.getString("middlename"));
						profile.txtAge.setText(rs.getString("age"));
						profile.txtMonth.setText(rs.getString("birthdate"));
						profile.txtGender.setText(rs.getString("gender"));
						profile.txtContactNumber.setText(rs.getString("ContactNumber"));
						profile.txtEmailAddress.setText(rs.getString("EmailAddress"));
						profile.txtPresentAddress.setText(rs.getString("CompleteAddress"));
						profile.lblcontrolnumber.setText(rs.getString("ImagePath"));
						byte[] img1 = rs.getBytes("ImageFile");
						
						ImageIcon image1 = new ImageIcon(img1);
		                Image im1 = image1.getImage();
		                Image myImg1 = im1.getScaledInstance(profile.lblqrdisplay.getWidth(), profile.lblqrdisplay.getHeight(),Image.SCALE_SMOOTH);
		                ImageIcon newImage1 = new ImageIcon(myImg1);
		                profile.lblqrdisplay.setIcon(newImage1);
		                profile.lblqrdisplay.setText("");
					}
				}catch (Exception r) {
					System.out.println("error" + r);
				}
				
			}
			
			
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(Color.GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(0, 102, 102));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				panel_1.setBackground(new Color (255, 255, 0));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				panel_1.setBackground(new Color (47, 79, 79));
			}
		});
		panel_1.setBackground(new Color(0, 102, 102));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.ORANGE));
		lblNewLabel_5.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_5.setIcon(new ImageIcon(img_search));
		
		lblNewLabel_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 5, 51, 50);
		panel_1.add(lblNewLabel_5);
		
		txtSearchIdNumber = new JTextField();
		txtSearchIdNumber.setForeground(Color.GRAY);
		txtSearchIdNumber.setBackground(Color.WHITE);
		txtSearchIdNumber.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 153, 0)));
		txtSearchIdNumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSearchIdNumber.getText().equals(" Search ID Number")) {
					txtSearchIdNumber.setText("");
				}
				else {
					txtSearchIdNumber.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtSearchIdNumber.getText().equals(""))
					txtSearchIdNumber.setText(" Search ID Number");
			}
		});
		txtSearchIdNumber.setText(" Search ID Number");
		txtSearchIdNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSearchIdNumber.setBounds(759, 12, 330, 39);
		
		txtSearchIdNumber.setColumns(10);
		
		
		GroupLayout gl_paneMainContent = new GroupLayout(paneMainContent);
		gl_paneMainContent.setHorizontalGroup(
			gl_paneMainContent.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_paneMainContent.createSequentialGroup()
					.addComponent(profile, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
					.addComponent(DB, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
					.addComponent(VS, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
					.addComponent(VDb, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
					.addComponent(InOut, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE))
		);
		gl_paneMainContent.setVerticalGroup(
			gl_paneMainContent.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_paneMainContent.createSequentialGroup()
					.addComponent(profile, GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
					.addComponent(DB, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addComponent(VS, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addComponent(VDb, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addComponent(InOut, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
		);
		paneMainContent.setLayout(gl_paneMainContent);
		
		paneQRcode = new JPanel();
		paneQRcode.setBounds(0, 161, 215, 54);
		paneQRcode.setBackground(new Color(0, 51, 51));
		paneQRcode.addMouseListener(new PanelButtonMouseAdapter(paneQRcode) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked (profile);
				lbltitleheader.setText("QR CODE GENERATOR");
				lblQRG.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.RED));
				lblQRG.setBackground(new Color (47, 79, 79));
				lblDataBase.setBorder(null);
				lblVisitirsSlip.setBorder(null);
				lblVdataBase.setBorder(null);
				lblNewLabel_1.setBorder(null);
				
			}
		});
		
		paneQRcode.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.ORANGE));
		
		JPanel paneData = new JPanel();
		paneData.setBounds(0, 215, 215, 54);
		paneData.setBackground(new Color(0, 51, 51));
		paneData.addMouseListener(new PanelButtonMouseAdapter(paneData) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(DB);
				lbltitleheader.setText("STUDENT/FACULTY DATABASE");
				lblQRG.setBorder(null);
				lblDataBase.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.RED));
				lblVisitirsSlip.setBorder(null);
				lblVdataBase.setBorder(null);
				lblNewLabel_1.setBorder(null);
			}
		});
		paneData.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.ORANGE));
		
		JPanel paneVisitorsPass = new JPanel();
		paneVisitorsPass.setBounds(0, 269, 215, 54);
		paneVisitorsPass.setBackground(new Color(0, 51, 51));
		paneVisitorsPass.addMouseListener(new PanelButtonMouseAdapter(paneVisitorsPass) {
				@Override
				public void mouseClicked(MouseEvent e) {
					menuClicked(VS);
					lbltitleheader.setText("VISITORS ENTRANCE SLIP");
					lblQRG.setBorder(null);
					lblDataBase.setBorder(null);
					lblVisitirsSlip.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.RED));
					lblVdataBase.setBorder(null);
					lblNewLabel_1.setBorder(null);
				}
			});
		paneVisitorsPass.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.ORANGE));
		
		JPanel paneVisitorData = new JPanel();
		paneVisitorData.setBounds(0, 323, 215, 54);
		paneVisitorData.setBackground(new Color(0, 51, 51));
		paneVisitorData.addMouseListener(new PanelButtonMouseAdapter(paneVisitorData){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(VDb);
				lbltitleheader.setText("VISITORS DATABASE");
				lblQRG.setBorder(null);
				lblDataBase.setBorder(null);
				lblVisitirsSlip.setBorder(null);
				lblVdataBase.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.RED));
				lblNewLabel_1.setBorder(null);
			}
		});
		paneVisitorData.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.ORANGE));
		
		lblme = new JLabel("");
		lblme.setBounds(10, 11, 195, 144);
		lblme.setIcon(new ImageIcon("C:\\Users\\user\\Pictures\\Saved Pictures\\ez.gif"));
		lblme.setHorizontalTextPosition(SwingConstants.CENTER);
		lblme.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel paneInOut = new JPanel();
		paneInOut.setBounds(0, 377, 215, 54);
		paneInOut.addMouseListener(new PanelButtonMouseAdapter(paneInOut) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(InOut);
				lbltitleheader.setText(" IN/OUT DATABASE");
				lblQRG.setBorder(null);
				lblDataBase.setBorder(null);
				lblVisitirsSlip.setBorder(null);
				lblVdataBase.setBorder(null);
				lblNewLabel_1.setBorder(new MatteBorder(0, 0, 0, 2, (Color) Color.RED));
				
			}
		});
		
		paneInOut.setBackground(new Color(0, 51, 51));
		paneInOut.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 55, 54);
		lblNewLabel.setIcon(new ImageIcon(img_inout));
		paneInOut.add(lblNewLabel);
		
		lblVdataBase = new JLabel("Visitors Data Base");
		lblVdataBase.setBounds(61, 12, 140, 31);
		lblVdataBase.setForeground(new Color(255, 204, 0));
		lblVdataBase.setFont(new Font("Book Antiqua", Font.PLAIN, 17));
		
		JLabel lblvisitorsData = new JLabel("");
		lblvisitorsData.setBounds(0, 1, 55, 53);
		lblvisitorsData.setHorizontalAlignment(SwingConstants.CENTER);
		lblvisitorsData.setIcon(new ImageIcon(img_VisitorsData));
		
		lblVisitirsSlip = new JLabel("Visitors Entrance Slip");
		lblVisitirsSlip.setBounds(61, 12, 140, 31);
		lblVisitirsSlip.setForeground(new Color(255, 204, 0));
		lblVisitirsSlip.setFont(new Font("Book Antiqua", Font.PLAIN, 14));
		
		JLabel lblVisitorsSlip = new JLabel("");
		lblVisitorsSlip.setBounds(0, 1, 55, 53);
		lblVisitorsSlip.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitorsSlip.setIcon(new ImageIcon(img_VisitorsSlip));
		
		lblDataBase = new JLabel("Data Base");
		lblDataBase.setBounds(61, 12, 140, 31);
		lblDataBase.setForeground(new Color(255, 204, 0));
		lblDataBase.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		
		JLabel lblData = new JLabel("");
		lblData.setBounds(2, 1, 53, 53);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setIcon(new ImageIcon(img_data));
		
		lblQRG = new JLabel("Generate QR code");
		lblQRG.setBounds(65, 12, 140, 31);
		lblQRG.setBackground(Color.WHITE);
		lblQRG.setForeground(new Color(255, 204, 0));
		lblQRG.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		
		JLabel lblID = new JLabel("");
		lblID.setBounds(2, 1, 53, 53);
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setIcon(new ImageIcon(img_ID));
		frmQrCodeLogbook.getContentPane().setLayout(null);
		frmQrCodeLogbook.getContentPane().add(paneHeader);
		paneHeader.setLayout(null);
		
		JLabel lblFile = new JLabel("File");
		lblFile.setForeground(Color.WHITE);
		lblFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblFile.setBounds(0, 0, 36, 25);

		paneHeader.add(lblFile);
		
		JLabel lblHelp = new JLabel("Help");
		lblHelp.setForeground(Color.WHITE);
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setBounds(37, 0, 36, 25);
		paneHeader.add(lblHelp);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setForeground(Color.WHITE);
		lblAboutUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAboutUs.setBounds(74, 0, 52, 25);
		paneHeader.add(lblAboutUs);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setBounds(134, 0, 54, 25);
		paneHeader.add(lblSettings);
		frmQrCodeLogbook.getContentPane().add(paneBottombar);
		paneBottombar.setLayout(null);
		paneBottombar.add(lblDate);
		paneBottombar.add(lbldate);
		paneBottombar.add(lblClock);
		paneBottombar.add(lblTime);
		frmQrCodeLogbook.getContentPane().add(paneSidebar);
		paneSidebar.setLayout(null);
		paneSidebar.add(paneInOut);
		
		lblNewLabel_1 = new JLabel("IN/OUT DATABASE");
		lblNewLabel_1.setForeground(new Color(255, 204, 0));
		lblNewLabel_1.setFont(new Font("Book Antiqua", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(58, 11, 147, 32);
		paneInOut.add(lblNewLabel_1);
		paneSidebar.add(lblme);
		paneSidebar.add(paneVisitorData);
		paneVisitorData.setLayout(null);
		paneVisitorData.add(lblvisitorsData);
		paneVisitorData.add(lblVdataBase);
		paneSidebar.add(paneVisitorsPass);
		paneVisitorsPass.setLayout(null);
		paneVisitorsPass.add(lblVisitorsSlip);
		paneVisitorsPass.add(lblVisitirsSlip);
		paneSidebar.add(paneQRcode);
		paneQRcode.setLayout(null);
		paneQRcode.add(lblID);
		paneQRcode.add(lblQRG);
		paneSidebar.add(paneData);
		paneData.setLayout(null);
		paneData.add(lblData);
		paneData.add(lblDataBase);
		
		JPanel paneLogout = new JPanel();
		paneLogout.setBounds(0, 431, 215, 54);
		paneSidebar.add(paneLogout);
		paneLogout.setBackground(new Color(0, 51, 51));
		paneLogout.addMouseListener(new PanelButtonMouseAdapter(paneLogout){
			@Override 
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?") == 0) {
					contenctMain.this.dispose();
				}
			}
		});
		paneLogout.setBorder(new MatteBorder(1, 0, 1, 0, (Color) Color.ORANGE));
		
		JLabel lblNewLabel_4 = new JLabel("Logout");
		lblNewLabel_4.setBounds(61, 12, 140, 31);
		lblNewLabel_4.setForeground(new Color(255, 204, 0));
		lblNewLabel_4.setFont(new Font("Book Antiqua", Font.PLAIN, 16));
		paneLogout.setLayout(null);
		
		JLabel lblLogout = new JLabel("");
		lblLogout.setBounds(0, 1, 55, 53);
		lblLogout.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setIcon(new ImageIcon(img_Logout));
		paneLogout.add(lblLogout);
		paneLogout.add(lblNewLabel_4);
		frmQrCodeLogbook.getContentPane().add(paneMainContent);
		frmQrCodeLogbook.getContentPane().add(paneTitlebar);
		paneTitlebar.setLayout(null);
		paneTitlebar.add(lbltitleheader);
		paneTitlebar.add(panel_1);
		paneTitlebar.add(txtSearchIdNumber);
		frmQrCodeLogbook.setBounds(100, 30, 1175, 700);
		frmQrCodeLogbook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void dispose() {
		frmQrCodeLogbook.dispose();
		
	}

	

	public static void menuClicked (JPanel panel) {
		profile.setVisible(false);
		DB.setVisible(false);
		VS.setVisible(false);
		VDb.setVisible(false);
		InOut.setVisible(false);
		
		panel.setVisible(true);
		
		
		
		
	}
	private class PanelButtonMouseAdapter extends MouseAdapter {
		JPanel panel;
		public PanelButtonMouseAdapter (JPanel panel) {
			this.panel = panel;
		}
		@Override 
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(Color.GRAY);
		}
		@Override 
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 51, 51));
		}
		@Override 
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color (255, 255, 0));
		}
		@Override 
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color (47, 79, 79));
		}
		
	}
	

	public void setVisible(boolean b) {
		frmQrCodeLogbook.setVisible(true);
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
}
