package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Previous_appointments extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	
	private void table_update(){
		int c, o;
		int no = Login.uid;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
			Statement stmt = con.createStatement();
			String sql = "SELECT doctor, adate, atime, diagnosis1, diagnosis2, diagnosis3 FROM makes INNER JOIN appointments ON makes.app_no = appointments.app_no WHERE ((adate < date(now()) or (adate = date(now()) and atime< time(now()))) and makes.id = '"+no+"');";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rss = rs.getMetaData();
			o = rss.getColumnCount();
			DefaultTableModel Df = (DefaultTableModel)table_1.getModel();
			Df.setRowCount(0);
			Vector v1 = new Vector();
			v1.add("DOCTOR");
			v1.add("DATE");
			v1.add("TIME");
			v1.add("DIAGNOSIS 1");
			v1.add("DIAGNOSIS 2");
			v1.add("DIAGNOSIS 3");
			Df.addRow(v1);
			while(rs.next())
			{
				
				Vector v2 = new Vector();
				for(c=1; c<=o+1; c++)
				{
					v2.add(rs.getString("doctor"));
					v2.add(rs.getString("adate"));
					v2.add(rs.getString("atime"));
					v2.add(rs.getString("diagnosis1"));
					v2.add(rs.getString("diagnosis2"));
					v2.add(rs.getString("diagnosis3"));
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
					Previous_appointments frame = new Previous_appointments();
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
	public Previous_appointments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 930, 89);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("Previous");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(21, 26, 137, 40);
		panel.add(btnNewButton_1);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.setForeground(Color.BLACK);
		btnHome_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1.setBackground(Color.WHITE);
		btnHome_1.setBounds(744, 29, 154, 35);
		panel.add(btnHome_1);
		
		table_1 = new JTable();
		table_1.setCellSelectionEnabled(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(24, 114, 781, 376);
		contentPane.add(table_1);
		table_update();
	}
}
