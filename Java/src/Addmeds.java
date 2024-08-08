package healthrec;

import java.awt.EventQueue;
import healthrec.Login;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Addmeds extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField mname;
	private JTextField strength;
	private JTextField sday;
	private JTextField smonth;
	private JTextField syear;
	private JTextField eday;
	private JTextField emonth;
	private JTextField eyear;
	private JTextField ohour;
	private JTextField thour;
	private JTextField thhour;
	private JTextField omin;
	private JTextField tmin;
	private JTextField thmin;
	private JPanel panel_1;
	private JButton btnPrevious;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Addmeds frame = new Addmeds();
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
	public Addmeds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(147, 135, 74, 34);
		contentPane.add(lblNewLabel_1);
		
		mname = new JTextField();
		mname.setBounds(285, 138, 128, 34);
		contentPane.add(mname);
		mname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Strength");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(147, 179, 74, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Start");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(147, 223, 74, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("End");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(147, 280, 74, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel l = new JLabel("Time1");
		l.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l.setBounds(147, 335, 74, 34);
		contentPane.add(l);
		
		strength = new JTextField();
		strength.setBounds(285, 182, 128, 34);
		contentPane.add(strength);
		strength.setColumns(10);
		
		sday = new JTextField();
		sday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sday.setText("dd");
		sday.setBounds(285, 233, 96, 34);
		contentPane.add(sday);
		sday.setColumns(10);
		
		smonth = new JTextField();
		smonth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		smonth.setText("mm");
		smonth.setBounds(425, 233, 96, 34);
		contentPane.add(smonth);
		smonth.setColumns(10);
		
		syear = new JTextField();
		syear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		syear.setText("yyyy");
		syear.setBounds(577, 233, 96, 34);
		contentPane.add(syear);
		syear.setColumns(10);
		eday = new JTextField();
		eday.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eday.setText("dd");
		eday.setBounds(285, 281, 96, 34);
		contentPane.add(eday);
		eday.setColumns(10);
		
		emonth = new JTextField();
		emonth.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		emonth.setText("mm");
		emonth.setBounds(425, 281, 96, 34);
		contentPane.add(emonth);
		emonth.setColumns(10);
		
		eyear = new JTextField();
		eyear.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		eyear.setText("yyyy");
		eyear.setBounds(577, 281, 96, 34);
		contentPane.add(eyear);
		eyear.setColumns(10);
		
		ohour = new JTextField();
		ohour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ohour.setText("hour");
		ohour.setBounds(285, 336, 96, 34);
		contentPane.add(ohour);
		ohour.setColumns(10);
		
		JLabel lt = new JLabel("Time2");
		lt.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lt.setBounds(147, 392, 74, 34);
		contentPane.add(lt);
		
		thour = new JTextField();
		thour.setBackground(new Color(255, 255, 255));
		thour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		thour.setText("hour");
		thour.setBounds(285, 393, 94, 34);
		contentPane.add(thour);
		thour.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Time3");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(147, 443, 74, 34);
		contentPane.add(lblNewLabel_9);
		
		thhour = new JTextField();
		thhour.setBackground(new Color(255, 255, 255));
		thhour.setForeground(new Color(0, 0, 0));
		thhour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		thhour.setText("hour");
		thhour.setBounds(285, 444, 94, 34);
		contentPane.add(thhour);
		thhour.setColumns(10);
		
		omin = new JTextField();
		omin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		omin.setText("min");
		omin.setBounds(425, 335, 96, 34);
		contentPane.add(omin);
		omin.setColumns(10);
		
		tmin = new JTextField();
		tmin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tmin.setText("min");
		tmin.setBounds(425, 393, 96, 34);
		contentPane.add(tmin);
		tmin.setColumns(10);
		
		thmin = new JTextField();
		thmin.setBackground(new Color(255, 255, 255));
		thmin.setForeground(new Color(0, 0, 0));
		thmin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		thmin.setText("min");
		thmin.setBounds(425, 444, 94, 34);
		contentPane.add(thmin);
		thmin.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = Login.uid;
				String medname = mname.getText();
				String dstrength = strength.getText();
				Float fstrength = Float.parseFloat(dstrength);
				String ssdate = sday.getText();
				String ssmonth = smonth.getText();
				String ssyear = syear.getText();
				String sdate = ssyear + "/" + ssmonth + "/" + ssdate;
				String edate = eday.getText();
				String efmonth = emonth.getText();
				String efyear = eyear.getText();
				String efdate = efyear + "/" + efmonth + "/" + edate;
				String fhour = ohour.getText();
				String fmin = omin.getText();
				String shour = thour.getText();
				String smin = tmin.getText();
				String nhour = thhour.getText();
				String nmin = thmin.getText();
				String ftime = fhour + ":" + fmin;
				String ttime = shour + ":" + smin;
				String ntime = nhour + ":" + nmin;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
					Statement stmt = con.createStatement();
					PreparedStatement pst;
					pst = con.prepareStatement("Insert into medicine(id, med_name, strength, starting_date, "
							+ "end_date, mtime) values(?,?,?,?,?,?)");
					pst.setInt(1, id);
					pst.setString(2, medname);
					pst.setFloat(3, fstrength);
					pst.setString(4, sdate);
					pst.setString(5, efdate);
					pst.setString(6, ftime);
					pst.executeUpdate();
					con.close();
				}catch(Exception ex) 
				{System.out.print(ex);}
			    if(shour.equals("hour") && smin.equals("min"))
			    {
			    	System.out.println("No time2");
			    }
			    else
			    {
			    	try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
						Statement stmt = con.createStatement();
						PreparedStatement pst;
						pst = con.prepareStatement("Insert into medicine(id, med_name, strength, starting_date, end_date, mtime) values(?,?,?,?,?,?)");
						pst.setInt(1, id);
						pst.setString(2, medname);
						pst.setFloat(3, fstrength);
						pst.setString(4, sdate);
						pst.setString(5, efdate);
						pst.setString(6, ttime);
						pst.executeUpdate();
						con.close();
					}catch(Exception ex) 
					{System.out.print(ex);}
			    }
			    if(nhour.equals("hour") && nmin.equals("min"))
			    {
			    	System.out.println("No time3");
			    }
			    else
			    {
			    	try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
						Statement stmt = con.createStatement();
						PreparedStatement pst;
						pst = con.prepareStatement("Insert into medicine(id, med_name, strength, starting_date, end_date, mtime) values(?,?,?,?,?,?)");
						pst.setInt(1, id);
						pst.setString(2, medname);
						pst.setFloat(3, fstrength);
						pst.setString(4, sdate);
						pst.setString(5, efdate);
						pst.setString(6, ntime);
						pst.executeUpdate();
						con.close();
					}catch(Exception ex) 
					{System.out.print(ex);}
			    }
			    JOptionPane.showMessageDialog(null, "Added successfully");
			}
		});
		btnNewButton_1.setBounds(598, 445, 89, 34);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(10, 10, 909, 98);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("ADD NEW MEDICINE");
		lblNewLabel.setBounds(303, 24, 367, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(770, 27, 106, 45);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Medicine part = new Medicine();
			    	part.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnPrevious.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnPrevious.setBounds(30, 27, 106, 45);
		panel.add(btnPrevious);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(120, 118, 629, 389);
		contentPane.add(panel_1);
	}
}


