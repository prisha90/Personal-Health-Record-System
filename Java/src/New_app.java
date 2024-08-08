package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class New_app extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField day;
	private JTextField hour;
	private JTextField doctor;
	private JTextField month;
	private JTextField year;
	private JTextField min;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					New_app frame = new New_app();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public New_app() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewAppointment = new JLabel("ADD NEW APPOINTMENT");
		lblAddNewAppointment.setForeground(new Color(255, 255, 255));
		lblAddNewAppointment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddNewAppointment.setBackground(new Color(0, 102, 102));
		lblAddNewAppointment.setBounds(273, 10, 448, 76);
		contentPane.add(lblAddNewAppointment);
		
		day = new JTextField();
		day.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		day.setText("dd");
		day.setBounds(476, 118, 74, 40);
		contentPane.add(day);
		day.setColumns(10);
		
		hour = new JTextField();
		hour.setText("hour");
		hour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hour.setColumns(10);
		hour.setBounds(476, 272, 74, 40);
		contentPane.add(hour);
		
		doctor = new JTextField();
		doctor.setColumns(10);
		doctor.setBounds(473, 433, 269, 40);
		contentPane.add(doctor);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setForeground(new Color(255, 204, 102));
		panel_1.setBounds(140, 104, 210, 392);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(22, 10, 165, 40);
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("Date");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 204, 204));
		panel_3.setBounds(22, 170, 165, 40);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 204, 204));
		panel_4.setBounds(22, 323, 165, 40);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor");
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 102, 204));
		panel_2.setBounds(0, 0, 930, 89);
		contentPane.add(panel_2);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Appointments fleur = new Appointments();
			    	fleur.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(21, 26, 137, 40);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnHome_1_1 = new JButton("Home");
		btnHome_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer no = Login.uid;
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
					Statement stmt = con.createStatement();
					String sql = "Select sex from users where id = '"+no+"'";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next())
					{
						String a = rs.getString("sex");
						if(a.equals("F"))
						{
							try {
					    		Home page = new Home();
						    	page.setVisible(true);
						    	System.out.print("Entered if");
							}catch(Exception ex) 
							{System.out.print(ex);}
						}
						else
						{
							try {
								System.out.print("Entered else");
					    		Home1 page1 = new Home1();
						    	page1.setVisible(true);
							}catch(Exception ex) 
							{System.out.print(ex);}
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnHome_1_1.setForeground(Color.BLACK);
		btnHome_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1.setBackground(new Color(255, 255, 255));
		btnHome_1_1.setBounds(744, 29, 154, 35);
		panel_2.add(btnHome_1_1);
		
		month = new JTextField();
		month.setText("mm");
		month.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		month.setColumns(10);
		month.setBounds(615, 118, 74, 40);
		contentPane.add(month);
		
		year = new JTextField();
		year.setText("yyyy");
		year.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		year.setColumns(10);
		year.setBounds(732, 118, 74, 40);
		contentPane.add(year);
		
		min = new JTextField();
		min.setText("min");
		min.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		min.setColumns(10);
		min.setBounds(615, 272, 74, 40);
		contentPane.add(min);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aday = day.getText();
				String amonth = month.getText();
				String ayear = year.getText();
				String adate = ayear + "/" + amonth + "/" + aday;
				String ahour = hour.getText();
				String amin = min.getText();
				String atime = ahour + ":" + amin;
				String doc = doctor.getText();
				Integer l = 0;
				Integer no = Login.uid;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
					Statement stmt = con.createStatement();
					PreparedStatement pst, pst1;
					pst = con.prepareStatement("Insert into appointments(adate, atime, doctor, diagnosis1, diagnosis2, diagnosis3) values(?,?,?,?,?,?)");
					pst.setString(1, adate);
					pst.setString(2, atime);
					pst.setString(3, doc);
					pst.setString(4, "pending");
					pst.setString(5, "pending");
					pst.setString(6, "pending");
					pst.executeUpdate();
					String sql = "SELECT MAX(app_no) AS MAX_APP FROM appointments;";
					ResultSet rs = stmt.executeQuery(sql);
					while(rs.next())
					{
						l = rs.getInt("MAX_APP");
					}
					pst1 = con.prepareStatement("Insert into makes(app_no, id) values(?,?)");
					pst1.setInt(1, l);
					pst1.setInt(2, no);
					pst1.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(null, "Added successfully");
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton.setBounds(788, 448, 121, 40);
		contentPane.add(btnNewButton);
	}
}

