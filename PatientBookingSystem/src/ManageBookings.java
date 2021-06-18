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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;

public class ManageBookings extends JFrame {

	static ManageBookings frame;
	private JPanel contentPane;
	static String date="";
	static int doci=0;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ManageBookings();
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
	public ManageBookings() {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ABC Healthcare Patient System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(379, 12, 238, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logout();
			}
		});
		btnNewButton_1.setBounds(823, 17, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_1_1 = new JButton("Book Appointments");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PatientPortal newFrame = new PatientPortal();
				newFrame.main(null);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(10, 17, 135, 23);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("@");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		lblNewLabel_3.setBounds(698, 21, 115, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1_1_1 = new JButton("Manage Appointments");
		btnNewButton_1_1_1.setEnabled(false);
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBounds(155, 17, 135, 23);
		contentPane.add(btnNewButton_1_1_1);
		btnNewButton_1_1_1.setBackground(new Color(153, 255, 204));

		
		try {
			lblNewLabel_3.setText("@"+Storage.currentUser.getName());			
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 54, 902, 223);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Appointment ID", "Booked On", "Doctor", "Booked Date", "Slot", "Status", "Feedback"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] canEdit = new boolean [] {
		                false, false, false, false, false, false, false
	            };
				public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
				
			});
			table.getColumnModel().getColumn(0).setPreferredWidth(110);
			scrollPane.setViewportView(table);
			
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.activeCaption);
			panel.setBounds(10, 288, 902, 184);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Search Appointment ID");
			lblNewLabel_1.setBounds(10, 11, 143, 14);
			panel.add(lblNewLabel_1);
			
			JComboBox appoT = new JComboBox();
			appoT.setBounds(10, 36, 214, 27);
			panel.add(appoT);
			
			JButton btnNewButton = new JButton("Change Booking");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String id = appoT.getSelectedItem().toString();
					for(Appointment app: Storage.appointments){
						if(app.getAppoinementID().equals(id)) {
							Storage.appointments.remove(app);
							JOptionPane.showMessageDialog(null, "Please make a new appointment to change","Info", JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
							PatientPortal newFrame = new PatientPortal();
							newFrame.main(null);
						}
					}
				}
			});
			btnNewButton.setBounds(294, 35, 200, 48);
			panel.add(btnNewButton);
			
			JButton btnCancelBooking = new JButton("Cancel Booking");
			btnCancelBooking.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = appoT.getSelectedItem().toString();
					for(Appointment app: Storage.appointments){
						if(app.getAppoinementID().equals(id)) {
							Storage.appointments.remove(app);
							JOptionPane.showMessageDialog(null, "Appointment Deleted","Info", JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
							ManageBookings newFrame = new ManageBookings();
							newFrame.main(null);
							
						}
					}
				}
			});
			btnCancelBooking.setBounds(294, 109, 200, 48);
			panel.add(btnCancelBooking);
			
			JTextArea feedbackT = new JTextArea();
			feedbackT.setBounds(571, 37, 321, 80);
			panel.add(feedbackT);
			
			JLabel lblNewLabel_1_1 = new JLabel("Enter Doctor's Feedback");
			lblNewLabel_1_1.setBounds(571, 11, 143, 14);
			panel.add(lblNewLabel_1_1);
			
			JButton btnMarkAttended = new JButton("Mark Attended");
			btnMarkAttended.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String feedback = feedbackT.getText();
					String id = appoT.getSelectedItem().toString();
					for(Appointment app: Storage.appointments){
						if(app.getAppoinementID().equals(id)) {
							app.setStatus("Attended");
							app.setDoctorFeedback(feedback);
							
							JOptionPane.showMessageDialog(null, "Appointment Updated","Info", JOptionPane.INFORMATION_MESSAGE);
							frame.setVisible(false);
							ManageBookings newFrame = new ManageBookings();
							newFrame.main(null);
							
						}
					}
				}
			});
			btnMarkAttended.setBounds(571, 130, 143, 27);
			panel.add(btnMarkAttended);
			
			
			
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
	        
	        for(Appointment app: Storage.appointments){
	        	if(app.getPatient()==Storage.currentUser) {
	        		model.addRow(new Object[]{app.getAppoinementID(),app.getBookedDate(),app.getDoctor().getName()+" - "+app.getDoctor().getExpertise(),app.getBookedDate(),app.getSlot().slotId,app.getStatus(),app.getDoctorFeedback()});
	        		appoT.addItem(app.getAppoinementID());
	        	}
	        }		
			
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
