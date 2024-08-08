package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import healthrec.Home;
import healthrec.Home1;
import healthrec.Login;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Vaccine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vaccine frame = new Vaccine();
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
	public Vaccine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(109, 169, 725, 252);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAddVaccine = new JButton("Add New Vaccine");
		btnAddVaccine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Vaccine part = new Add_Vaccine();
				part.setVisible(true);
			}
		});
		btnAddVaccine.setBounds(20, 58, 203, 121);
		panel_1.add(btnAddVaccine);
		btnAddVaccine.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnPastDiseases = new JButton("Vaccines Due");
		btnPastDiseases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vaccines_Due frame = new Vaccines_Due();
				frame.setVisible(true);
			}
		});
		btnPastDiseases.setBounds(249, 58, 218, 121);
		panel_1.add(btnPastDiseases);
		btnPastDiseases.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton btnVaccinesTaken = new JButton("Vaccines taken");
		btnVaccinesTaken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vaccines_Taken frame = new Vaccines_Taken();
				frame.setVisible(true);
			}
		});
		btnVaccinesTaken.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVaccinesTaken.setBounds(496, 58, 218, 121);
		panel_1.add(btnVaccinesTaken);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 102, 204));
		panel_2.setBounds(10, 0, 930, 89);
		contentPane.add(panel_2);
		
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
		
		JLabel lblMedicines = new JLabel("VACCINES");
		lblMedicines.setForeground(Color.WHITE);
		lblMedicines.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines.setBackground(new Color(0, 102, 102));
		lblMedicines.setBounds(349, 1, 191, 80);
		panel_2.add(lblMedicines);
	}

}