package healthrec;

import java.awt.EventQueue;
import healthrec.Login;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home1 frame = new Home1();
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
	public Home1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.inactiveCaption);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Medicines");
		btnNewButton.setBounds(349, 178, 236, 72);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Medicine part = new Medicine();
			    	part.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBackground(new Color(255, 255, 255));
		contentPane.add(btnNewButton);
		
		JButton btnAppointments = new JButton("Appointments");
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Appointments frame = new Appointments();
				frame.setVisible(true);
			}
		});
		btnAppointments.setForeground(new Color(0, 0, 0));
		btnAppointments.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAppointments.setBackground(new Color(255, 255, 255));
		btnAppointments.setBounds(66, 178, 236, 72);
		contentPane.add(btnAppointments);
		
		JButton btnVaccines = new JButton("Vaccines");
		btnVaccines.setForeground(new Color(0, 0, 0));
		btnVaccines.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnVaccines.setBackground(new Color(255, 255, 255));
		btnVaccines.setBounds(625, 178, 236, 72);
		btnVaccines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		    		Vaccine part = new Vaccine();
			    	part.setVisible(true);
				}catch(Exception ex) 
				{System.out.print(ex);}
			}
		});
		contentPane.add(btnVaccines);
		
		JButton btnMedicalHistory = new JButton("Lab Reports");
		btnMedicalHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lab_Reports part = new Lab_Reports();
				part.setVisible(true);
			}
		});
		btnMedicalHistory.setForeground(new Color(0, 0, 0));
		btnMedicalHistory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnMedicalHistory.setBackground(new Color(255, 255, 255));
		btnMedicalHistory.setBounds(210, 330, 236, 72);
		contentPane.add(btnMedicalHistory);
		
		
		JButton btnFamilyHistory = new JButton("Family History");
		btnFamilyHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Family_History frame = new Family_History();
				frame.setVisible(true);
			}
		});
		btnFamilyHistory.setForeground(new Color(0, 0, 0));
		btnFamilyHistory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnFamilyHistory.setBackground(new Color(255, 255, 255));
		btnFamilyHistory.setBounds(490, 330, 236, 72);
		contentPane.add(btnFamilyHistory);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 930, 89);
		contentPane.add(panel);
		
		JLabel lblMedicines = new JLabel("Welcome" + " " + Login.firstname);
		lblMedicines.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicines.setForeground(Color.WHITE);
		lblMedicines.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines.setBackground(new Color(0, 102, 102));
		lblMedicines.setBounds(305, 0, 343, 90);
		panel.add(lblMedicines);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(-41, 143, 1013, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Update Profile");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_Profile frame = new Update_Profile();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(727, 448, 134, 48);
		contentPane.add(btnNewButton_1);
	}
}