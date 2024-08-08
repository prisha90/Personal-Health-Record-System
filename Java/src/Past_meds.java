package healthrec;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Past_meds extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table2;

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
			String sql = "SELECT m.med_name, m.starting_date, m.end_date FROM medicine m "
					+ "WHERE id = '"+no+"'  ORDER BY starting_date ASC, end_date ASC;";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rss = rs.getMetaData();
			o = rss.getColumnCount();
			DefaultTableModel Df = (DefaultTableModel)table2.getModel();
			Df.setRowCount(0);
			Vector v1 = new Vector();
			v1.add("MEDICINE");
			v1.add("QUNATITY(g/ml)");
			v1.add("TIME");
			Df.addRow(v1);
			while(rs.next())
			{
				Vector v2 = new Vector();
				for(c=1; c<=o; c++)
				{
					v2.add(rs.getString("med_name"));
					v2.add(rs.getString("starting_date"));
					v2.add(rs.getString("end_date"));
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
					Past_meds frame = new Past_meds();
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
	public Past_meds() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 919, 89);
		contentPane.add(panel);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.addActionListener(new ActionListener() {
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
		btnHome_1.setForeground(Color.BLACK);
		btnHome_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1.setBackground(Color.WHITE);
		btnHome_1.setBounds(744, 29, 154, 35);
		panel.add(btnHome_1);
		
		JLabel lblMedicines = new JLabel("MEDICINES TAKEN");
		lblMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicines.setForeground(Color.WHITE);
		lblMedicines.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines.setBackground(new Color(0, 102, 102));
		lblMedicines.setBounds(259, 1, 367, 88);
		panel.add(lblMedicines);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Medicine part = new Medicine();
			    	part.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(23, 29, 137, 35);
		panel.add(btnNewButton_1_1);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{"Medicine", "Start Date", "End Date"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Name", "Start Date", "End Date"
			}
		));
		table2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table2.setBounds(156, 143, 575, 232);
		contentPane.add(table2);
		table_update();
	}
}
