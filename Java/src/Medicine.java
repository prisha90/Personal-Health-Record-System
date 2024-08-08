package healthrec;

import java.awt.EventQueue;
import healthrec.Login;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Medicine extends JFrame {

private static final long serialVersionUID = 1L;
private JPanel contentPane;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
	public void run() {
		try {
			Medicine frame = new Medicine();
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
public Medicine() {
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
	btnHome_1.setForeground(new Color(0, 0, 0));
	btnHome_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	btnHome_1.setBackground(new Color(255, 255, 255));
	btnHome_1.setBounds(744, 29, 154, 35);
	panel.add(btnHome_1);

	JLabel lblMedicines = new JLabel("MEDICINES");
	lblMedicines.setBounds(349, 1, 191, 80);
	panel.add(lblMedicines);
	lblMedicines.setForeground(new Color(255, 255, 255));
	lblMedicines.setFont(new Font("Times New Roman", Font.BOLD, 30));
	lblMedicines.setBackground(new Color(0, 102, 102));

	JPanel panel_1 = new JPanel();
	panel_1.setBackground(new Color(153, 204, 255));
	panel_1.setBounds(39, 170, 840, 221);
	contentPane.add(panel_1);
	panel_1.setLayout(null);

	JButton btnAddMedicine = new JButton("Add Medicine");
	btnAddMedicine.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
	    		Addmeds form = new Addmeds();
		    	form.setVisible(true);
			}catch(Exception ex) 
			{System.out.print(ex);}
		}
	});
	btnAddMedicine.setBounds(59, 65, 162, 96);
	panel_1.add(btnAddMedicine);
	btnAddMedicine.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	JButton btnCurrentMedicines = new JButton("Current Medicines");
	btnCurrentMedicines.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
	    		Medicine_Records record = new Medicine_Records();
		    	record.setVisible(true);
			}catch(Exception ex) 
			{System.out.print(ex);}
		}
	});
	btnCurrentMedicines.setBounds(324, 65, 193, 96);
	panel_1.add(btnCurrentMedicines);
	btnCurrentMedicines.setFont(new Font("Times New Roman", Font.PLAIN, 20));

	JButton btnPastRecord = new JButton("Past Record\r\n");
	btnPastRecord.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
	    		Past_meds tableu = new Past_meds();
		    	tableu.setVisible(true);
			}catch(Exception ex) 
			{System.out.print(ex);}
		}
	});
	btnPastRecord.setBounds(605, 65, 162, 96);
	panel_1.add(btnPastRecord);
	btnPastRecord.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
}

