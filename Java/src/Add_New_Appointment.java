package healthrec;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Add_New_Appointment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDd;
	private JTextField txtHour;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtMm;
	private JTextField txtYyyy;
	private JTextField txtMin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_New_Appointment frame = new Add_New_Appointment();
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
	public Add_New_Appointment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 554);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddNewAppointment = new JLabel("ADD NEW APPOINTMENT");
		lblAddNewAppointment.setForeground(new Color(255, 255, 255));
		lblAddNewAppointment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddNewAppointment.setBackground(new Color(0, 102, 102));
		lblAddNewAppointment.setBounds(273, 10, 448, 76);
		contentPane.add(lblAddNewAppointment);
		
		txtDd = new JTextField();
		txtDd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDd.setText("dd");
		txtDd.setBounds(492, 118, 74, 40);
		contentPane.add(txtDd);
		txtDd.setColumns(10);
		
		txtHour = new JTextField();
		txtHour.setText("hour");
		txtHour.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtHour.setColumns(10);
		txtHour.setBounds(492, 179, 74, 40);
		contentPane.add(txtHour);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(492, 249, 269, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(492, 320, 269, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(492, 384, 269, 40);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(492, 448, 269, 40);
		contentPane.add(textField_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		panel_1.setForeground(new Color(255, 204, 102));
		panel_1.setBounds(140, 104, 210, 392);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 204, 204));
		panel.setBounds(22, 10, 165, 40);
		panel_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("Date");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 204, 204));
		panel_3.setBounds(22, 73, 165, 40);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Time");
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 204, 204));
		panel_4.setBounds(22, 147, 165, 40);
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor");
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 204, 204));
		panel_5.setBounds(22, 218, 165, 40);
		panel_1.add(panel_5);
		
		JLabel lblNewLabel_3 = new JLabel("Diagnosis1");
		panel_5.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 204, 204));
		panel_6.setBounds(22, 279, 165, 40);
		panel_1.add(panel_6);
		
		JLabel lblNewLabel_3_1 = new JLabel("Diagnosis2");
		panel_6.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(0, 204, 204));
		panel_7.setBounds(22, 342, 165, 40);
		panel_1.add(panel_7);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Diagnosis3");
		panel_7.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(0, 102, 204));
		panel_2.setBounds(0, 0, 930, 89);
		contentPane.add(panel_2);
		
		JButton btnNewButton_1_1 = new JButton("Previous");
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(21, 26, 137, 40);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnHome_1_1 = new JButton("Home");
		btnHome_1_1.setForeground(Color.BLACK);
		btnHome_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnHome_1_1.setBackground(new Color(255, 255, 255));
		btnHome_1_1.setBounds(744, 29, 154, 35);
		panel_2.add(btnHome_1_1);
		
		txtMm = new JTextField();
		txtMm.setText("mm");
		txtMm.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMm.setColumns(10);
		txtMm.setBounds(590, 118, 74, 40);
		contentPane.add(txtMm);
		
		txtYyyy = new JTextField();
		txtYyyy.setText("yyyy");
		txtYyyy.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtYyyy.setColumns(10);
		txtYyyy.setBounds(687, 118, 74, 40);
		contentPane.add(txtYyyy);
		
		txtMin = new JTextField();
		txtMin.setText("min");
		txtMin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMin.setColumns(10);
		txtMin.setBounds(590, 179, 74, 40);
		contentPane.add(txtMin);
	}
}
