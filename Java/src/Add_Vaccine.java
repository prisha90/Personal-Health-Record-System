package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Add_Vaccine extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField vname;
	private JTextField dday;
	private JTextField dmonth;
	private JTextField dyear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Vaccine frame = new Add_Vaccine();
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
	public Add_Vaccine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(103, 125, 701, 294);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		vname = new JTextField();
		vname.setBounds(343, 41, 269, 40);
		panel_1.add(vname);
		vname.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(59, 41, 165, 40);
		panel.setBackground(new Color(0, 204, 204));
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblVaccineName = new JLabel("Vaccine Name");
		lblVaccineName.setBackground(new Color(0, 204, 204));
		lblVaccineName.setHorizontalAlignment(SwingConstants.CENTER);
		lblVaccineName.setBounds(0, 0, 165, 40);
		panel.add(lblVaccineName);
		lblVaccineName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(59, 121, 165, 40);
		panel_2.setBackground(new Color(0, 204, 204));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Due Date");
		lblNewLabel_1.setBackground(new Color(0, 204, 204));
		lblNewLabel_1.setBounds(0, 0, 165, 40);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(59, 195, 165, 40);
		panel_3.setBackground(new Color(0, 204, 204));
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Taken");
		lblNewLabel_2.setBackground(new Color(0, 204, 204));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 165, 40);
		panel_3.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		dday = new JTextField();
		dday.setBounds(343, 121, 74, 40);
		dday.setText("dd");
		dday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dday.setColumns(10);
		panel_1.add(dday);
		
		dmonth = new JTextField();
		dmonth.setBounds(441, 121, 74, 40);
		dmonth.setText("mm");
		dmonth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dmonth.setColumns(10);
		panel_1.add(dmonth);
		
		dyear = new JTextField();
		dyear.setBounds(538, 121, 74, 40);
		dyear.setText("yyyy");
		dyear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dyear.setColumns(10);
		panel_1.add(dyear);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		
		
		rdbtnYes.setBounds(343, 195, 74, 40);
		rdbtnYes.setBackground(new Color(255, 255, 255));
		rdbtnYes.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(441, 195, 74, 40);
		rdbtnNo.setBackground(new Color(255, 255, 255));
		rdbtnNo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(rdbtnNo);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 102, 204));
		panel_2_1.setBounds(0, 0, 919, 89);
		contentPane.add(panel_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Vaccine part = new Vaccine();
					part.setVisible(true);
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
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
		
		JLabel lblMedicines_1 = new JLabel("ADD VACCINE");
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		lblMedicines_1.setBounds(349, 1, 252, 80);
		panel_2_1.add(lblMedicines_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer no = Login.uid;
					String vaccinename = vname.getText();
					String dueday = dday.getText();
					String duemonth = dmonth.getText();
					String dueyear = dyear.getText();
					String duedate = dueyear + "/" + duemonth + "/" + dueday;
					String taken;
					if(rdbtnYes.isSelected())
					{
						taken = "Yes";
					}
					else if(rdbtnNo.isSelected())
					{
						taken = "No";
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Select Yes or No");
						taken = "NULL";
					}
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
					Statement stmt = con.createStatement();
					PreparedStatement pst;
					System.out.println(taken);
					pst = con.prepareStatement("Insert into vaccine(id, v_name, due_date, taken) values(?,?,?,?)");
					pst.setInt(1, no);
					pst.setString(2, vaccinename);
					pst.setString(3, duedate);
					pst.setString(4, taken);
					pst.executeUpdate();
					con.close();
					JOptionPane.showMessageDialog(null, "Added successfully");
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
			});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(737, 438, 120, 49);
		contentPane.add(btnNewButton);	
}
}
