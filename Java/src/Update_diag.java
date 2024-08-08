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

public class Update_diag extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField doctor;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_diag frame = new Update_diag();
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
	public Update_diag() {
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
		
		JLabel lblNewLabel = new JLabel("Diagnosis 1");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 204, 204));
		panel_3.setBounds(22, 170, 165, 40);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Diagnosis 2");
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 204, 204));
		panel_4.setBounds(22, 323, 165, 40);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Diagnosis 3");
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
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
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
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String aday = day.getText();
				String amonth = month.getText();
				String ayear = year.getText();
				String adate = ayear + "/" + amonth + "/" + aday;
				String ahour = hour.getText();
				String amin = min.getText();
				String atime = ahour + ":" + amin;
				String doc = doctor.getText();
				Integer l = 0;
				Integer no = Login.uid;*/
				/*try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
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
				{System.out.print(ex);}*/
			}
		});
		btnNewButton.setBounds(788, 448, 121, 40);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(473, 284, 269, 40);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(473, 119, 269, 40);
		contentPane.add(textField_1);
	}
}