package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Update_Profile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField height;
	private JTextField weight;
	private JTextField dobday;
	private JTextField dobm;
	private JTextField doby;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Profile frame = new Update_Profile();
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
	public Update_Profile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 919, 71);
		contentPane.add(panel_1);
		
		JLabel lblUpdateProfile = new JLabel("UPDATE PROFILE");
		lblUpdateProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateProfile.setForeground(Color.WHITE);
		lblUpdateProfile.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUpdateProfile.setBackground(Color.BLACK);
		lblUpdateProfile.setBounds(323, 0, 304, 71);
		panel_1.add(lblUpdateProfile);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(20, 16, 118, 37);
		panel_1.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(64, 83, 757, 394);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel first = new JLabel("FIRST NAME");
		first.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		first.setBackground(Color.WHITE);
		first.setBounds(46, 29, 101, 34);
		panel.add(first);
		
		fname = new JTextField();
		fname.setEditable(true);
		fname.setColumns(10);
		fname.setBounds(250, 29, 363, 34);
		panel.add(fname);
		
		JLabel last = new JLabel("LAST NAME");
		last.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		last.setBackground(Color.WHITE);
		last.setBounds(46, 90, 101, 34);
		panel.add(last);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(250, 92, 363, 34);
		panel.add(lname);
		
		height = new JTextField();
		height.setColumns(10);
		height.setBounds(250, 153, 363, 34);
		panel.add(height);
		
		JLabel lblNewLabel_5 = new JLabel("HEIGHT");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_5.setBackground(Color.WHITE);
		lblNewLabel_5.setBounds(46, 157, 65, 34);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("WEIGHT");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setBounds(46, 222, 82, 34);
		panel.add(lblNewLabel_6);
		
		weight = new JTextField();
		weight.setColumns(10);
		weight.setBounds(250, 219, 363, 34);
		panel.add(weight);
		
		JLabel lblNewLabel_7 = new JLabel("DOB");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setBounds(46, 279, 49, 34);
		panel.add(lblNewLabel_7);
		
		dobday = new JTextField();
		dobday.setText("dd\r\n");
		dobday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dobday.setColumns(10);
		dobday.setBounds(250, 279, 96, 34);
		panel.add(dobday);
		
		dobm = new JTextField();
		dobm.setText("mm");
		dobm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		dobm.setColumns(10);
		dobm.setBounds(369, 279, 96, 34);
		panel.add(dobm);
		
		doby = new JTextField();
		doby.setText("yyyy");
		doby.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		doby.setColumns(10);
		doby.setBounds(492, 279, 96, 34);
		panel.add(doby);
		
		JLabel lblNewLabel_8 = new JLabel("SEX");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setBounds(46, 323, 65, 34);
		panel.add(lblNewLabel_8);
		
		JRadioButton man = new JRadioButton("Male");
		man.setSelected(true);
		man.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		man.setBackground(Color.WHITE);
		man.setBounds(250, 326, 65, 34);
		panel.add(man);
		
		JRadioButton woman = new JRadioButton("Female");
		woman.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		woman.setBackground(Color.WHITE);
		woman.setBounds(369, 326, 101, 34);
		panel.add(woman);
		
		JRadioButton child = new JRadioButton("Others");
		child.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		child.setBackground(Color.WHITE);
		child.setBounds(492, 326, 111, 34);
		panel.add(child);
		
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Integer no = 1;
					String firstName = fname.getText();
					String lastName = lname.getText();
					String Height = height.getText();
					String Weight = weight.getText();
					String day = dobday.getText();
					String month = dobm.getText();
					String year = doby.getText();
					String dob = year + month + day;
					String sex;
					if(man.isSelected())
					{
						sex ="M";
					}
					else if(woman.isSelected())
					{
						sex = "F";
					}
					else if(child.isSelected())
					{
						sex = "Others";
					}
					else
					{
						sex = "NULL";
						JOptionPane.showMessageDialog(null, "Select a valid sex");
					}
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
					Statement stmt = con.createStatement();
					PreparedStatement pst;
					pst = con.prepareStatement("UPDATE users SET f_name = ?, l_name = ?, weight = ?, height = ?, dob = ?, sex = ? WHERE id = ?");
					pst.setString(1, firstName);
					pst.setString(2, lastName);
					pst.setString(3, Weight);
					pst.setString(4, Height);
					pst.setString(5, dob); 
					pst.setString(6, sex);
					pst.setInt(7, no);
				    pst.executeUpdate();
				    JOptionPane.showMessageDialog(null, "Profile updated successfully");
				}
				catch(Exception ae)
				{
					System.out.println(ae);
				}
			}
		});
		submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		submit.setBounds(648, 350, 85, 34);
		panel.add(submit);
	}
}
