package healthrec;
import java.util.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Color;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	public static String firstname;
	public static Integer uid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login_frame = new Login();
					login_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	// Login class starts
	
	
	public Login() {
		int a = 5;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 919, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN PAGE");
		lblNewLabel.setBounds(346, 28, 218, 35);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(116, 162, 679, 293);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.setBounds(453, 219, 135, 48);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Register form = new Register();
					form.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(21, 219, 151, 48);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
					Statement stmt = con.createStatement();
					String sql = "Select * from users where u_name = '"+user.getText()+"' and pass = '"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next())
					{
						firstname = rs.getString("f_name");
						uid = rs.getInt("id");
						String a = rs.getString("sex");
						System.out.println(a);
						if(a.equals("F"))
						{
							JOptionPane.showMessageDialog(null, "Login successfully");
							
							try {
					    		Home page = new Home();
						    	page.setVisible(true);
						    	System.out.print("Entered if");
							}catch(Exception ex) 
							{System.out.print(ex);}
						}
						else
						{	
							JOptionPane.showMessageDialog(null, "Login successfully");
							
							try {
					    		Home1 page1 = new Home1();
						    	page1.setVisible(true);
							}catch(Exception ex) 
							{System.out.print(ex);}
						}
						
					}
					else
						JOptionPane.showMessageDialog(null, "Incorrect username or password");
					con.close();
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		user = new JTextField();
		user.setBounds(21, 44, 418, 40);
		panel_1.add(user);
		user.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		user.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(21, 10, 100, 34);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		pass = new JPasswordField();
		pass.setBounds(21, 138, 418, 40);
		panel_1.add(pass);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(21, 94, 100, 34);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		
	}

}


