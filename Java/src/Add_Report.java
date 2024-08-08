package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Report extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lrn;
	private JTextField day;
	private JTextField month;
	private JTextField year;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Report frame = new Add_Report();
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
	public Add_Report() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lrn = new JTextField();
		lrn.setColumns(10);
		lrn.setBounds(446, 166, 269, 40);
		contentPane.add(lrn);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(162, 166, 165, 40);
		contentPane.add(panel);
		
		JLabel lr_name = new JLabel("Lab Report Name");
		lr_name.setHorizontalAlignment(SwingConstants.CENTER);
		lr_name.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lr_name.setBackground(new Color(0, 204, 204));
		lr_name.setBounds(0, 0, 165, 40);
		panel.add(lr_name);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 204, 204));
		panel_2.setBounds(162, 246, 165, 40);
		contentPane.add(panel_2);
		
		JLabel date = new JLabel("Date");
		date.setHorizontalAlignment(SwingConstants.CENTER);
		date.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		date.setBackground(new Color(0, 204, 204));
		date.setBounds(0, 0, 165, 40);
		panel_2.add(date);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 204, 204));
		panel_3.setBounds(162, 320, 165, 40);
		contentPane.add(panel_3);
		
		JLabel status = new JLabel("Status");
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		status.setBackground(new Color(0, 204, 204));
		status.setBounds(0, 0, 165, 40);
		panel_3.add(status);
		
		day = new JTextField();
		day.setText("dd");
		day.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		day.setColumns(10);
		day.setBounds(446, 246, 74, 40);
		contentPane.add(day);
		
		month = new JTextField();
		month.setText("mm");
		month.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		month.setColumns(10);
		month.setBounds(544, 246, 74, 40);
		contentPane.add(month);
		
		year = new JTextField();
		year.setText("yyyy");
		year.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		year.setColumns(10);
		year.setBounds(641, 246, 74, 40);
		contentPane.add(year);
		
		JRadioButton rdbtnTreatmentOver = new JRadioButton("Treatment Over");
		rdbtnTreatmentOver.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnTreatmentOver.setBackground(Color.WHITE);
		rdbtnTreatmentOver.setBounds(446, 320, 134, 40);
		contentPane.add(rdbtnTreatmentOver);
		
		JRadioButton rdbtnTreatmentOngoing = new JRadioButton("Treatment Ongoing");
		rdbtnTreatmentOngoing.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnTreatmentOngoing.setBackground(Color.WHITE);
		rdbtnTreatmentOngoing.setBounds(595, 320, 141, 40);
		contentPane.add(rdbtnTreatmentOngoing);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 102, 204));
		panel_2_1.setBounds(0, 0, 919, 89);
		contentPane.add(panel_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lab_Reports part = new Lab_Reports();
				part.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(21, 26, 137, 40);
		panel_2_1.add(btnNewButton_1_1);
		
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
		
		JLabel lblMedicines_1 = new JLabel("ADD REPORT");
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		lblMedicines_1.setBounds(349, 1, 252, 88);
		panel_2_1.add(lblMedicines_1);
		
		JRadioButton rdbtnBelowNormal = new JRadioButton("Below Normal\r\n");
		rdbtnBelowNormal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnBelowNormal.setBackground(Color.WHITE);
		rdbtnBelowNormal.setBounds(446, 398, 134, 40);
		contentPane.add(rdbtnBelowNormal);
		
		JRadioButton rdbtnNormal = new JRadioButton("Normal");
		rdbtnNormal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNormal.setBackground(Color.WHITE);
		rdbtnNormal.setBounds(595, 398, 141, 40);
		contentPane.add(rdbtnNormal);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(0, 204, 204));
		panel_3_1.setBounds(162, 398, 165, 40);
		contentPane.add(panel_3_1);
		
		JLabel levels = new JLabel("Levels");
		levels.setHorizontalAlignment(SwingConstants.CENTER);
		levels.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		levels.setBackground(new Color(0, 204, 204));
		levels.setBounds(0, 0, 165, 40);
		panel_3_1.add(levels);
		
		JRadioButton rdbtnAboveNormal = new JRadioButton("Above Normal");
		rdbtnAboveNormal.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnAboveNormal.setBackground(Color.WHITE);
		rdbtnAboveNormal.setBounds(759, 398, 134, 40);
		contentPane.add(rdbtnAboveNormal);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Integer no = Login.uid;
					String lname = lrn.getText();
					String lday = day.getText();
					String lmonth = month.getText();
					String lyear = year.getText();
					String date = lyear + lmonth + lday;
					String status;
					String levels; 
					if(rdbtnTreatmentOver.isSelected())
					{
						status = "TOv";
					}
					else if(rdbtnTreatmentOngoing.isSelected())
					{
						status = "TOn";
					}
					else 
					{
						status = "NULL";
						JOptionPane.showMessageDialog(null, "Added successfully");
					}
					
					if(rdbtnBelowNormal.isSelected())
					{
						levels = "BN";
					}
					else if(rdbtnNormal.isSelected())
					{
						levels = "N";
					}
					else if(rdbtnAboveNormal.isSelected())
					{
						levels = "AN";
					}
					else
					{
						levels = "NULL";
						JOptionPane.showMessageDialog(null, "Select levels");
					}
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
					Statement stmt = con.createStatement();
					PreparedStatement pst;
					pst = con.prepareStatement("Insert into lab_report(id, lr_name, lr_status, test_date, test_result) values(?,?,?,?,?)");
				    pst.setInt(1, no);
				    pst.setString(2, lname);
				    pst.setString(3, status);
				    pst.setString(4, date);
				    pst.setString(5, levels);
				    pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added successfully");
					
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(745, 458, 120, 49);
		contentPane.add(btnNewButton);
	}
}
