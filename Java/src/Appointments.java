package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Appointments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointments frame = new Appointments();
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
	public Appointments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPreviousAppointments = new JButton("Previous Appointments ");
		btnPreviousAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Previous_appointments cravate = new Previous_appointments();
			    	cravate.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnPreviousAppointments.setForeground(new Color(0, 0, 0));
		btnPreviousAppointments.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPreviousAppointments.setBackground(new Color(153, 204, 204));
		btnPreviousAppointments.setBounds(61, 163, 231, 209);
		contentPane.add(btnPreviousAppointments);
		
		JButton btnAddNew_1_1 = new JButton("Add New Appointments");
		btnAddNew_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		New_app soleil = new New_app();
			    	soleil.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnAddNew_1_1.setForeground(new Color(0, 0, 0));
		btnAddNew_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAddNew_1_1.setBackground(new Color(153, 204, 204));
		btnAddNew_1_1.setBounds(342, 163, 231, 209);
		contentPane.add(btnAddNew_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 102, 204));
		panel_2_1.setBounds(0, 0, 919, 89);
		contentPane.add(panel_2_1);
		
		JButton btnHome_1_1_1 = new JButton("Home");
		btnHome_1_1_1.addActionListener(new ActionListener() {
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
		btnHome_1_1_1.setForeground(Color.BLACK);
		btnHome_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1_1.setBackground(Color.WHITE);
		btnHome_1_1_1.setBounds(744, 29, 154, 35);
		panel_2_1.add(btnHome_1_1_1);
		
		JLabel lblMedicines_1 = new JLabel("APPOINTMENTS");
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		lblMedicines_1.setBounds(349, 1, 252, 80);
		panel_2_1.add(lblMedicines_1);
		
		JButton btnAddNew_1_1_1 = new JButton("Future Appointments");
		btnAddNew_1_1_1.setForeground(Color.BLACK);
		btnAddNew_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAddNew_1_1_1.setBackground(new Color(153, 204, 204));
		btnAddNew_1_1_1.setBounds(633, 163, 231, 209);
		contentPane.add(btnAddNew_1_1_1);
	}

}

