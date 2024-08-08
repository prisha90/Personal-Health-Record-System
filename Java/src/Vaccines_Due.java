package healthrec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Vaccines_Due extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	private void table_update(){
		int c, o;
		try {
			Integer no = Login.uid;
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
			Statement stmt = con.createStatement();
			String sql = "SELECT v.v_name, v.due_date FROM vaccine v where v.taken = 'No' and v.id = '"+no+"' ORDER BY due_date ASC;";
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rss = rs.getMetaData();
			o = rss.getColumnCount();
			DefaultTableModel Df = (DefaultTableModel)table.getModel();
			Df.setRowCount(0);
			Vector v1 = new Vector();
			v1.add("Vaccine Name");
			v1.add("Due Date");
			Df.addRow(v1);
			while(rs.next())
			{
				Vector v2 = new Vector();
				for(c=1; c<=o; c++)
				{
					v2.add(rs.getString("v_name"));
					v2.add(rs.getString("due_date"));
//					v2.add(rs.getString("end_date"));
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
					Vaccines_Due frame = new Vaccines_Due();
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
	public Vaccines_Due() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 204));
		panel_2.setBounds(0, 0, 930, 89);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try
			{
				Vaccine part = new Vaccine();
				part.setVisible(true);
			}
			catch(Exception exc)
			{
				System.out.println(exc);
			}
			}		
		});
		btnNewButton_1_1.setBounds(21, 26, 137, 40);
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnHome_1_1 = new JButton("Home");
		btnHome_1_1.addActionListener(new ActionListener() {
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
		btnHome_1_1.setBounds(744, 29, 154, 35);
		btnHome_1_1.setForeground(Color.BLACK);
		btnHome_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1.setBackground(Color.WHITE);
		panel_2.add(btnHome_1_1);
		
		JLabel lblNewLabel = new JLabel("Vaccines Due");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(250, 0, 434, 89);
		panel_2.add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column"
			}
		));
		table.setRowHeight(35);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(35, 122, 833, 344);
		contentPane.add(table);
		table_update();
	}
}
