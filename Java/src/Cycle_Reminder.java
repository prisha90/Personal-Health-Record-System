package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Cycle_Reminder extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable cycletab;
	private JButton btnNewButton;
	private String message;
	private String messaged;
	private Integer days;

	/**
	 * Launch the application.
	 */
	private int check_diff() {
		String max_date;
		int no = Login.uid;
		int l=-1;
		int g=-1;
		int t=-1;
		int d=-1;
		int fd=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			String sql = "SELECT starting_date, cycle_length, cycle_gap, datediff( date(now()), MAX(starting_date)) as days FROM cycle_reminder WHERE starting_date = (SELECT MAX(starting_date) AS MAX_DATE FROM cycle_reminder WHERE id = '"+no+"' ); ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				l = rs.getInt("cycle_length");
				g = rs.getInt("cycle_gap");
				t = l+g;
				d = rs.getInt("days");
				String sql1 = "SELECT DATEDIFF('2017/08/25', '2016/09/03');";
			}
			con.close();
		}catch(Exception ex) 
		{System.out.print(ex);}
		if(d>t)
		{
			return -1;
		}
		else
		{
			fd = t-d;
			return fd;
		}
	}
	
	private void table_update(){
		int c, o;
		try {
			Integer no = Login.uid;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
			Statement stmt = con.createStatement();
			String sql = "SELECT starting_date, cycle_length, cycle_gap FROM cycle_reminder c WHERE id = '"+no+"'";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rss = rs.getMetaData();
			o = rss.getColumnCount();
			DefaultTableModel Df = (DefaultTableModel)cycletab.getModel();
			Df.setRowCount(0);
			Vector v1 = new Vector();
			v1.add("START DATE");
			v1.add("LENGTH");
			v1.add("GAP");
			Df.addRow(v1);
			while(rs.next())
			{
				Vector v2 = new Vector();
				for(c=1; c<=o; c++)
				{
					v2.add(rs.getString("starting_date"));
					v2.add(rs.getInt("cycle_length"));
					v2.add(rs.getInt("cycle_gap"));
				}
				Df.addRow(v2);
			}
			con.close();
		}catch(Exception ex) 
		{System.out.print(ex);}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cycle_Reminder frame = new Cycle_Reminder();
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
	public Cycle_Reminder() {
		days = check_diff();
		if(days==-1)
		{
			message = "Please update your latest pattern";
		}
		else
		{
			messaged = Integer.toString(days);
			message = messaged + " days left";
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cycletab = new JTable();
		cycletab.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cycletab.setColumnSelectionAllowed(true);
		cycletab.setCellSelectionEnabled(true);
		cycletab.setBorder(new LineBorder(new Color(0, 0, 0)));
		cycletab.setBounds(102, 172, 659, 277);
		cycletab.setRowHeight(35);
		cycletab.setModel(new DefaultTableModel(
			new Object[][] {
				{"Start Date", "Length", "Gap"},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		contentPane.add(cycletab);
		
		btnNewButton = new JButton("ADD NEW PATTERN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Add_cycle nag = new Add_cycle();
			    	nag.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton.setBounds(305, 460, 176, 46);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 919, 89);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Home page = new Home();
			    	page.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnHome_1.setBounds(744, 29, 154, 35);
		btnHome_1.setForeground(Color.BLACK);
		btnHome_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1.setBackground(Color.WHITE);
		panel.add(btnHome_1);
		
		JLabel lblDaysLeft = new JLabel(message);
		lblDaysLeft.setBounds(259, 1, 367, 88);
		lblDaysLeft.setHorizontalAlignment(SwingConstants.CENTER);
		lblDaysLeft.setForeground(Color.WHITE);
		lblDaysLeft.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblDaysLeft.setBackground(new Color(0, 102, 102));
		panel.add(lblDaysLeft);
		
		table_update();
	}
}
