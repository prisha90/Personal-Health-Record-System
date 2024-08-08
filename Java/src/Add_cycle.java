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
import javax.swing.SwingConstants;

public class Add_cycle extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField stdate;
	private JTextField length;
	private JTextField gap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_cycle arbre = new Add_cycle();
					arbre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add_cycle() {
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
		
		length = new JTextField();
		length.setBounds(360, 126, 269, 65);
		panel_1.add(length);
		length.setColumns(10);
		
		stdate = new JTextField();
		stdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		stdate.setHorizontalAlignment(SwingConstants.CENTER);
		stdate.setText("yyyy/mm/dd");
		stdate.setBounds(360, 25, 269, 65);
		panel_1.add(stdate);
		stdate.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 255));
		panel_2.setBounds(77, 25, 192, 65);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDiseaseName = new JLabel("Start Date");
		lblDiseaseName.setBounds(37, 28, 114, 24);
		panel_2.add(lblDiseaseName);
		lblDiseaseName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(204, 255, 255));
		panel_2_1.setBounds(77, 126, 192, 65);
		panel_1.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		JLabel lblRelation = new JLabel("Length");
		lblRelation.setBounds(63, 27, 67, 24);
		panel_2_1.add(lblRelation);
		lblRelation.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2_1_2 = new JPanel();
		panel_2_1_2.setLayout(null);
		panel_2_1_2.setBackground(new Color(204, 255, 255));
		panel_2_1_2.setBounds(77, 220, 192, 65);
		panel_1.add(panel_2_1_2);
		
		JLabel lblRelation_1 = new JLabel("Gap");
		lblRelation_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRelation_1.setBounds(63, 27, 67, 24);
		panel_2_1_2.add(lblRelation_1);
		
		gap = new JTextField();
		gap.setColumns(10);
		gap.setBounds(360, 220, 269, 65);
		panel_1.add(gap);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBackground(new Color(0, 102, 204));
		panel_2_1_1.setBounds(0, 0, 930, 89);
		contentPane.add(panel_2_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Cycle_Reminder livre = new Cycle_Reminder();
			    	livre.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
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
		    		Home page = new Home();
			    	page.setVisible(true);
			    	System.out.print("Entered if");
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnHome_1_1_1.setForeground(Color.BLACK);
		btnHome_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1_1.setBackground(Color.WHITE);
		btnHome_1_1_1.setBounds(744, 29, 154, 35);
		panel_2_1_1.add(btnHome_1_1_1);
		
		JLabel lblMedicines_1 = new JLabel("ADD CYCLE PATTERN");
		lblMedicines_1.setBounds(286, 0, 352, 88);
		panel_2_1_1.add(lblMedicines_1);
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String frdate = stdate.getText();
				String lth = length.getText();
				Integer flth = Integer.parseInt(lth);
				String gp = gap.getText();
				Integer fgp = Integer.parseInt(gp);
				Integer id = Login.uid;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/healthrecord","root","Study*21");
					Statement stmt = con.createStatement();
					PreparedStatement pst;
					pst = con.prepareStatement("Insert into cycle_reminder(id, starting_date, cycle_length, cycle_gap) values(?,?,?,?)");
					pst.setInt(1, id);
					pst.setString(2, frdate);
					pst.setInt(3, flth);
					pst.setInt(4, fgp);
					pst.executeUpdate();
					con.close();
				}catch(Exception ex) 
				{System.out.print(ex);}
				JOptionPane.showMessageDialog(null, "Added successfully");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(323, 456, 197, 50);
		contentPane.add(btnNewButton);
	}
}