package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

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
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Family_Records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	private void table_update(){
		int c, o;
		try {
			Integer no = Login.uid;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
			Statement stmt = con.createStatement();
			String sql = "SELECT disease, relation FROM family_history WHERE id = '"+no+"' ORDER BY disease ASC;";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rss = rs.getMetaData();
			o = rss.getColumnCount();
			DefaultTableModel Df = (DefaultTableModel)table.getModel();
			Df.setRowCount(0);
			Vector v1 = new Vector();
			v1.add("DISEASE");
			v1.add("RELATION");
			Df.addRow(v1);
			while(rs.next())
			{
				Vector v2 = new Vector();
				for(c=1; c<=o; c++)
				{
					v2.add(rs.getString("disease"));
					v2.add(rs.getString("relation"));
				}
				Df.addRow(v2);
			}
			con.close();
		}catch(Exception ex) 
		{System.out.print(ex);}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Family_Records frame = new Family_Records();
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
	public Family_Records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(0, 102, 204));
		panel_2_1_1.setBounds(0, 0, 919, 89);
		contentPane.add(panel_2_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Family_History frame = new Family_History();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(21, 26, 137, 40);
		panel_2_1_1.add(btnNewButton_1_1);
		
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
		panel_2_1_1.add(btnHome_1_1_1);
		
		JLabel lblMedicines_1 = new JLabel("FAMILY RECORDS");
		lblMedicines_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		lblMedicines_1.setBounds(286, 0, 352, 88);
		panel_2_1_1.add(lblMedicines_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBounds(91, 116, 733, 353);
		table.setRowHeight(35);
		contentPane.add(table);
		table_update();
	}

}
