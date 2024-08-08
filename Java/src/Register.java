package healthrec;

import java.text.SimpleDateFormat;  

import java.util.Date;  
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JTextField firstt;
	private JTextField lastt;
	private JTextField height;
	private JTextField weight;
	private JTextField dd;
	private JTextField mm;
	private JTextField yy;
	private JRadioButton man;
	private JRadioButton woman;
	private JRadioButton child;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register register_frame = new Register();
					register_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 544 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME");
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(90, 96, 101, 34);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(294, 96, 363, 34);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(90, 144, 101, 34);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_3);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(man);
		bg.add(woman);
		bg.add(child);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(715, 426, 93, 34);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Float he, we;
				String uname = user.getText();
				String pwd = pass.getText();
				String fname = firstt.getText();
				String lname = lastt.getText();
				String h = height.getText();
				String w = weight.getText();
				he = Float.parseFloat(h);
				we = Float.parseFloat(w);
				String day = dd.getText();
				String month = mm.getText();
				String year = yy.getText();
				String bdate = year+"/"+month+"/"+day;
				String gender = "M";
				if(Integer.parseInt(month)==01 || Integer.parseInt(month)== 03 || Integer.parseInt(month)== 05 || Integer.parseInt(month)==07 || Integer.parseInt(month)==8 || Integer.parseInt(month)==10 || Integer.parseInt(month)== 12)
				{
					if(Integer.parseInt(day)>31 || Integer.parseInt(day)<=0)
					{
						JOptionPane.showMessageDialog(null, "Not valid date. Kindly enter a valid date in dd!");
					}
				}
				else if(Integer.parseInt(month)==04 || Integer.parseInt(month)== 06 || Integer.parseInt(month)== 9 || Integer.parseInt(month)==11)
				{
					if(Integer.parseInt(day)>30 || Integer.parseInt(day)<=0)
					{
						JOptionPane.showMessageDialog(null, "Not valid date. Kindly enter a valid date in dd!");
					}
				}
				else if(Integer.parseInt(month)==02)
				{
					if(Integer.parseInt(year)%4==0)
					{
						if(Integer.parseInt(year)%100==0)
						{
							if(Integer.parseInt(year)%400==0)
							{
								if(Integer.parseInt(day)>29 && Integer.parseInt(day)<=0)
									JOptionPane.showMessageDialog(null, "Not valid date. Kindly enter a valid date in dd!");
							}
							else
							{
								if(Integer.parseInt(day)>28 && Integer.parseInt(day)<=0)
									JOptionPane.showMessageDialog(null, "Not valid date. Kindly enter a valid date in dd!");
							}
							
						}
						else
						{
							if(Integer.parseInt(day)>29 && Integer.parseInt(day)<=0)
								JOptionPane.showMessageDialog(null, "Not valid date. Kindly enter a valid date in dd!");
						}
					}
					else
					{
						if(Integer.parseInt(day)>28 || Integer.parseInt(day)<=0)
						{
							JOptionPane.showMessageDialog(null, "Not valid date. Kindly enter a valid date in dd!");
						}
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Not valid month. Kindly enter a valid date in mm!");
				}
				if(Integer.parseInt(year)<=0000 && Integer.parseInt(day)>=2024)
				{
					JOptionPane.showMessageDialog(null, "Not valid year. Kindly enter a valid date in yyyy!");
				}
				
					
				if(woman.isSelected())
				{
					gender = "F";
				}
				else if(man.isSelected())
				{
					gender = "M";
				}
				else if(child.isSelected())
				{
					gender = "Others";
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please enter all your details");
				}
				if(user.getText().equals("") || pass.getText().equals("") || firstt.getText().equals("") || lastt.getText().equals("") || height.getText().equals("") || weight.getText().equals("") || dd.getText().equals("") || mm.getText().equals("") || yy.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter all your details!");
				}
				else
				{
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
						Statement stmt = con.createStatement();
						PreparedStatement pst;
						String sql = "Select * from users where u_name = '"+user.getText()+"'";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "Account already exists");
						}
						else
						{
							pst = con.prepareStatement("Insert into users(u_name, pass, f_name, l_name, weight, height, dob, sex) values(?,?,?,?,?,?,?,? )");
						    pst.setString(1, uname);
						    pst.setString(2, pwd);
						    pst.setString(3, fname);
						    pst.setString(4, lname);
						    pst.setFloat(5, we);
						    pst.setFloat(6, he);
						    pst.setString(7, bdate);
						    pst.setString(8, gender);
						    pst.executeUpdate();
						    JOptionPane.showMessageDialog(null, "Registered successfully");
						    try {
						    	Login page = new Login();
							    page.setVisible(true);
							}catch(Exception ex) 
							{System.out.print(ex);}
						    
						    	
						}
						con.close();
					}catch(Exception ex) 
					{System.out.print(ex);}
				}
			}
		});
		contentPane.add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(294, 144, 363, 34);
		contentPane.add(pass);
		
		JLabel first = new JLabel("FIRST NAME");
		first.setBounds(90, 192, 101, 34);
		first.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		first.setBackground(new Color(255, 255, 255));
		contentPane.add(first);
		
		JLabel last = new JLabel("LAST NAME");
		last.setBackground(new Color(255, 255, 255));
		last.setBounds(90, 245, 101, 34);
		last.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(last);
		
		JLabel lblNewLabel_5 = new JLabel("HEIGHT");
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(90, 288, 65, 34);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("WEIGHT");
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setBounds(90, 332, 82, 34);
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DOB");
		lblNewLabel_7.setBackground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(90, 379, 49, 34);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SEX");
		lblNewLabel_8.setBackground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(90, 423, 65, 34);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_8);
		
		firstt = new JTextField();
		String username = user.getText();
		
		firstt.setEditable(true);
		
		
		firstt.setBounds(294, 192, 363, 34);
		contentPane.add(firstt);
		firstt.setColumns(10);
		
		lastt = new JTextField();
		lastt.setBounds(294, 240, 363, 34);
		contentPane.add(lastt);
		lastt.setColumns(10);
		
		height = new JTextField();
		height.setBounds(294, 284, 363, 34);
		contentPane.add(height);
		height.setColumns(10);
		
		weight = new JTextField();
		weight.setBounds(294, 329, 363, 34);
		contentPane.add(weight);
		weight.setColumns(10);
		
		man = new JRadioButton("Male");
		man.setBackground(new Color(255, 255, 255));
		man.setBounds(294, 426, 65, 34);
		man.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		man.setSelected(true);
		contentPane.add(man);
		
		woman = new JRadioButton("Female");
		woman.setBackground(new Color(255, 255, 255));
		woman.setBounds(413, 426, 101, 34);
		woman.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(woman);
		
		child = new JRadioButton("Others");
		child.setBackground(new Color(255, 255, 255));
		child.setBounds(536, 426, 111, 34);
		child.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		contentPane.add(child);
		
		dd = new JTextField();
		dd.setBounds(294, 379, 96, 34);
		dd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dd.setText("dd\r\n");
		contentPane.add(dd);
		dd.setColumns(10);
		
		mm = new JTextField();
		mm.setBounds(413, 379, 96, 34);
		mm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		mm.setText("mm");
		contentPane.add(mm);
		mm.setColumns(10);
		
		yy = new JTextField();
		yy.setBounds(536, 379, 96, 34);
		yy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		yy.setText("yyyy");
		contentPane.add(yy);
		yy.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 919, 71);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(323, 0, 275, 71);
		panel_1.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(61, 81, 798, 394);
		contentPane.add(panel);
	}
}
