import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SystemHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemHome frame = new SystemHome();
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
	public SystemHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 642, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Healthcare Patient System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 606, 30);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 52, 606, 338);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(123, 0, 100, 100);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(396, 230, 124, 35);
		panel.add(btnNewButton);
		
		JButton btnPatientSignUp = new JButton("Patient Sign Up");
		btnPatientSignUp.setBounds(110, 281, 124, 35);
		panel.add(btnPatientSignUp);
		
		textField = new JTextField();
		textField.setBounds(355, 120, 198, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Email ID");
		lblNewLabel_2.setBounds(355, 95, 152, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Password");
		lblNewLabel_2_1.setBounds(355, 159, 134, 14);
		panel.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(355, 184, 198, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Patient Login");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(399, 42, 108, 20);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(304, 11, 292, 316);
		panel.add(panel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(71, 111, 198, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter Email ID");
		lblNewLabel_2_2.setBounds(71, 95, 152, 14);
		panel.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(71, 153, 198, 20);
		panel.add(textField_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Enter Full Name");
		lblNewLabel_2_2_1.setBounds(71, 137, 152, 14);
		panel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Enter Age");
		lblNewLabel_2_2_2.setBounds(71, 184, 86, 14);
		panel.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Enter Password");
		lblNewLabel_2_2_3.setBounds(71, 230, 152, 14);
		panel.add(lblNewLabel_2_2_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(71, 199, 86, 20);
		panel.add(spinner);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Enter Gender");
		lblNewLabel_2_2_2_1.setBounds(183, 184, 86, 14);
		panel.add(lblNewLabel_2_2_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboBox.setBounds(183, 199, 86, 20);
		panel.add(comboBox);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(71, 245, 198, 20);
		panel.add(passwordField_1);
		
		JButton btnNewButton_1 = new JButton("Quit");
		btnNewButton_1.setBounds(527, 17, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
