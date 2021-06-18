import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class SystemHome extends JFrame {

	private JPanel contentPane;
	private JTextField emailLog;
	private JPasswordField passLog;
	private JTextField emailT;
	private JTextField nameT;
	private JPasswordField passT;
	static SystemHome frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Storage.initiateData();
					frame = new SystemHome();
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
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
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
		lblNewLabel_1.setBounds(103, 0, 100, 100);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = emailLog.getText().toString();
				String password = passLog.getText().toString();
				boolean flag=false;
				for(Patient p: Storage.patients) {
					if(email.equalsIgnoreCase(p.getEmail()) && password.equalsIgnoreCase(p.getPassword())){
						JOptionPane.showMessageDialog(null, "Login Successful","Info", JOptionPane.INFORMATION_MESSAGE);
						Storage.currentUser=p;
						frame.setVisible(false);
						PatientPortal newFrame = new PatientPortal();
						newFrame.main(null);
						flag=true;
						break;
					}
				}
				if(!flag)	
					JOptionPane.showMessageDialog(null, "Invalid Credentials","Info", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(396, 230, 124, 35);
		panel.add(btnNewButton);
		
		JButton btnPatientSignUp = new JButton("Patient Sign Up");
		
		btnPatientSignUp.setBounds(90, 281, 124, 35);
		panel.add(btnPatientSignUp);
		
		emailLog = new JTextField();
		
		//testing
//		emailLog.setText("sx1@mail.com"); 
		
		emailLog.setBounds(355, 120, 198, 20);
		panel.add(emailLog);
		emailLog.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Email ID");
		lblNewLabel_2.setBounds(355, 95, 152, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Password");
		lblNewLabel_2_1.setBounds(355, 159, 134, 14);
		panel.add(lblNewLabel_2_1);
		
		passLog = new JPasswordField();
		passLog.setBounds(355, 184, 198, 20);
		panel.add(passLog);
		
		JLabel lblNewLabel_3 = new JLabel("Patient Login");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(399, 42, 108, 29);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(304, 11, 292, 316);
		panel.add(panel_1);
		
		emailT = new JTextField();
		emailT.setColumns(10);
		emailT.setBounds(51, 111, 198, 20);
		panel.add(emailT);
		
		JLabel lblNewLabel_2_2 = new JLabel("Enter Email ID");
		lblNewLabel_2_2.setBounds(51, 95, 152, 14);
		panel.add(lblNewLabel_2_2);
		
		nameT = new JTextField();
		nameT.setColumns(10);
		nameT.setBounds(51, 153, 198, 20);
		panel.add(nameT);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Enter Full Name");
		lblNewLabel_2_2_1.setBounds(51, 137, 152, 14);
		panel.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Enter Age");
		lblNewLabel_2_2_2.setBounds(51, 184, 86, 14);
		panel.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("Enter Password");
		lblNewLabel_2_2_3.setBounds(51, 230, 152, 14);
		panel.add(lblNewLabel_2_2_3);
		
		JSpinner ageT = new JSpinner();
		ageT.setModel(new SpinnerNumberModel(1, 1, 120, 1));
		ageT.setBounds(51, 199, 86, 20);
		panel.add(ageT);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Enter Gender");
		lblNewLabel_2_2_2_1.setBounds(163, 184, 86, 14);
		panel.add(lblNewLabel_2_2_2_1);
		
		JComboBox genderT = new JComboBox();
		genderT.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		genderT.setBounds(163, 199, 86, 20);
		panel.add(genderT);
		
		passT = new JPasswordField();
		passT.setBounds(51, 245, 198, 20);
		panel.add(passT);
		
		
		btnPatientSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailT.getText();
				String name = nameT.getText();
				String gender = genderT.getSelectedItem().toString();
				String password = passT.getText();
				int age = Integer.parseInt(ageT.getValue().toString());
				
				Storage.patients.add(new Patient(email,name,gender,age,password));
				
				JOptionPane.showMessageDialog(null, "Account Succesfully Created","Info", JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				SystemHome newFrame = new SystemHome();
				newFrame.main(null);
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Quit");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		
		btnNewButton_1.setBounds(527, 17, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
