package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Lab_Reports extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab_Reports frame = new Lab_Reports();
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
	public Lab_Reports() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		btnHome_1_1_1.setForeground(Color.BLACK);
		btnHome_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1_1.setBackground(Color.WHITE);
		btnHome_1_1_1.setBounds(744, 29, 154, 35);
		panel_2_1.add(btnHome_1_1_1);
		
		JLabel lblMedicines_1 = new JLabel("Lab Reports");
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		lblMedicines_1.setBounds(349, 1, 252, 80);
		panel_2_1.add(lblMedicines_1);
		
		JButton btnAddReoprt = new JButton("Add Report");
		btnAddReoprt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Report part = new Add_Report();
				part.setVisible(true);
			}
		});
		btnAddReoprt.setForeground(Color.BLACK);
		btnAddReoprt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAddReoprt.setBackground(new Color(153, 204, 204));
		btnAddReoprt.setBounds(148, 185, 231, 209);
		contentPane.add(btnAddReoprt);
		
		JButton btnAddNew_1_1 = new JButton("Lab Records\r\n ");
		btnAddNew_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lab_Records part = new Lab_Records();
				part.setVisible(true);
			}
		});
		btnAddNew_1_1.setForeground(Color.BLACK);
		btnAddNew_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAddNew_1_1.setBackground(new Color(153, 204, 204));
		btnAddNew_1_1.setBounds(542, 185, 231, 209);
		contentPane.add(btnAddNew_1_1);
	}

}
