import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;

public class PatientPortal extends JFrame {

	static PatientPortal frame;
	private JPanel contentPane;
	static String date="";
	static int doci=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PatientPortal();
					frame.setVisible(true);
					if(Storage.currentUser==null)
						logout();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PatientPortal() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Healthcare Patient System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(301, 12, 238, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
		btnNewButton_1.setBounds(669, 17, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 52, 748, 322);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Search Doctor Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 23, 137, 14);
		panel.add(lblNewLabel_1);
		
		JComboBox docT = new JComboBox();
		docT.setBounds(10, 48, 244, 43);
		panel.add(docT);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select Date");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(312, 23, 137, 14);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Search Available Slots");
		
		btnNewButton.setBounds(570, 47, 168, 44);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 130, 728, 181);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Doctor Details");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 11, 132, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel docDetails = new JLabel("...");
		docDetails.setVerticalAlignment(SwingConstants.TOP);
		docDetails.setBounds(10, 47, 233, 128);
		panel_1.add(docDetails);
		
		JLabel lblNewLabel_2_1 = new JLabel("Select Slot");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(304, 11, 132, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JComboBox slotsT = new JComboBox();
		slotsT.setBounds(304, 44, 132, 20);
		panel_1.add(slotsT);
		
		JButton btnProceedBooking = new JButton("Book Appointment");

		btnProceedBooking.setBounds(516, 32, 202, 44);
		panel_1.add(btnProceedBooking);
		
		JDateChooser dateT = new JDateChooser();
		dateT.setBounds(312, 48, 186, 43);
		panel.add(dateT);
		
		JButton btnNewButton_1_1 = new JButton("Book Appointments");
		btnNewButton_1_1.setBackground(new Color(153, 255, 204));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setEnabled(false);
		btnNewButton_1_1.setBounds(10, 17, 135, 23);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_3.setBounds(549, 21, 115, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Manage Appointments");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ManageBookings newFrame = new ManageBookings();
				newFrame.main(null);
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBounds(155, 17, 135, 23);
		contentPane.add(btnNewButton_1_1_1);

		
		try {
			lblNewLabel_3.setText("@"+Storage.currentUser.getName());
			for(Doctor d: Storage.doctors) {
				docT.addItem(d.getName()+" - "+d.getExpertise());
			}
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String pattern = "dd-MM-yyyy";
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
					try {
						date = simpleDateFormat.format(dateT.getDate());
						doci = docT.getSelectedIndex();
						docDetails.setText(Storage.doctors.get(doci)+"");
						
						ArrayList<Slot> unavSlots = new ArrayList<>();
						
						for(Slot s: Storage.slots) {
							
							for(Appointment apps: Storage.appointments) {
								if(apps.getDoctor().getId().equalsIgnoreCase(Storage.doctors.get(doci).getId())) {
									if(apps.getDate().equals(date)) {
										if(s.getSlotId()==apps.getSlot().getSlotId()) {
											unavSlots.add(s);
										}
									}
								}
							}
						}
						slotsT.removeAllItems();
						for(int j=1;j<=8;j++) {
							boolean flag=true;
							for(Slot s: unavSlots) {
								if(s.getSlotId()==j) {
									flag=false;
									break;
								}
							}
							if(flag) {
								slotsT.addItem("Slot-"+Storage.slots.get(j-1).getSlotId()+" | "+Storage.slots.get(j-1).getTime());								
							}
						}
						
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Please select a date to continue","Info", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
			});
			
			btnProceedBooking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Doctor dtemp = Storage.doctors.get(doci);
					int slotId = Integer.parseInt(slotsT.getSelectedItem().toString().substring(5,6));
					Slot slottemp=null;
					for(Slot s: Storage.slots) {
						if(s.getSlotId()==slotId) {
							slottemp=s;
							break;
						}
					}
					Storage.appointments.add(new Appointment(Storage.currentUser,dtemp,date,slottemp));
					JOptionPane.showMessageDialog(null, "Appointment Successfully booked","Info", JOptionPane.INFORMATION_MESSAGE); 
					
					frame.setVisible(false);
					ManageBookings newFrame = new ManageBookings();
					newFrame.main(null);
					
				}
			});
			
		}
		catch(Exception e) {
			
		}
		
	}
	
	static void logout() {
		frame.setVisible(false);
		SystemHome newFrame = new SystemHome();
		newFrame.main(null);
	}
}
