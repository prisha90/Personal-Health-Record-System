package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Family_History extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Disease;
	private JTextField Relation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Family_History frame = new Add_Family_History();
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
	public Add_Family_History() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(104, 123, 718, 314);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Relation = new JTextField();
		Relation.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Relation.setBounds(360, 200, 269, 40);
		panel_1.add(Relation);
		Relation.setColumns(10);
		
		Disease = new JTextField();
		Disease.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Disease.setBounds(360, 82, 269, 40);
		panel_1.add(Disease);
		Disease.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 255));
		panel_2.setBounds(77, 58, 192, 78);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDiseaseName = new JLabel("Disease Name");
		lblDiseaseName.setBounds(37, 28, 114, 24);
		panel_2.add(lblDiseaseName);
		lblDiseaseName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(204, 255, 255));
		panel_2_1.setBounds(77, 181, 192, 78);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblRelation = new JLabel("Relation");
		lblRelation.setBounds(63, 27, 67, 24);
		panel_2_1.add(lblRelation);
		lblRelation.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(0, 102, 204));
		panel_2_1_1.setBounds(0, 0, 930, 89);
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
		
		JLabel lblMedicines_1 = new JLabel("ADD FAMILY HISTORY");
		lblMedicines_1.setBounds(286, 0, 352, 88);
		panel_2_1_1.add(lblMedicines_1);
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		
		JButton btnNewButton_1_1_1 = new JButton("Add");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer id = Login.uid;
				String DiseaseName = Disease.getText();
				String Rel = Relation.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Hanuman1!");
//					Statement stmt = con.createStatement();
					PreparedStatement pst;
					pst = con.prepareStatement("Insert into family_history (id, disease, relation) values(?,?,?)");
					pst.setInt(1, id);
					pst.setString(2, DiseaseName);
					pst.setString(3, Rel);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Added successfully");
					con.close();
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton_1_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(737, 456, 128, 40);
		contentPane.add(btnNewButton_1_1_1);
	}

}
