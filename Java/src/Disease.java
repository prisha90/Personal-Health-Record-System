package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class Disease extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disease frame = new Disease();
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
	public Disease() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddDisease = new JButton("Add Disease");
		btnAddDisease.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnAddDisease.setBounds(54, 213, 203, 121);
		contentPane.add(btnAddDisease);
		
		JButton btnPastDiseases = new JButton("Past Record");
		btnPastDiseases.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnPastDiseases.setBounds(686, 213, 185, 121);
		contentPane.add(btnPastDiseases);
		
		JButton btnCurrentDiseases = new JButton("Current Diseases");
		btnCurrentDiseases.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCurrentDiseases.setBounds(381, 213, 185, 121);
		contentPane.add(btnCurrentDiseases);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setBounds(10, 170, 899, 222);
		contentPane.add(panel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 102, 204));
		panel_2_1.setBounds(0, 0, 930, 89);
		contentPane.add(panel_2_1);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(21, 26, 137, 40);
		panel_2_1.add(btnNewButton_1_1);
		
		JButton btnHome_1_1_1 = new JButton("Home");
		btnHome_1_1_1.setForeground(Color.BLACK);
		btnHome_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1_1.setBackground(Color.WHITE);
		btnHome_1_1_1.setBounds(744, 29, 154, 35);
		panel_2_1.add(btnHome_1_1_1);
		
		JLabel lblMedicines_1 = new JLabel("DISEASES");
		lblMedicines_1.setForeground(Color.WHITE);
		lblMedicines_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblMedicines_1.setBackground(new Color(0, 102, 102));
		lblMedicines_1.setBounds(349, 1, 252, 80);
		panel_2_1.add(lblMedicines_1);
	}

}
