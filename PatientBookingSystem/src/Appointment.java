import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Appointment {

	String appoinementID;
	Patient patient;
	Doctor doctor;
	Slot slot;
	String date;
	String bookedDate;
	String status, doctorFeedback;
	public Appointment(Patient patient, Doctor doctor, String date, Slot slot) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.slot = slot;
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		bookedDate=dtf.format(now);
		
		dtf = DateTimeFormatter.ofPattern("ddMMyyHHmmss");  
		appoinementID = "APPO-"+dtf.format(now);
		System.out.println("New Appointment ID: "+appoinementID);
		status = "Booked";
		doctorFeedback = "Not processed yet";
	}
	public String getAppoinementID() {
		return appoinementID;
	}
	public void setAppoinementID(String appoinementID) {
		this.appoinementID = appoinementID;
	}
	public String getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDoctorFeedback() {
		return doctorFeedback;
	}
	public void setDoctorFeedback(String doctorFeedback) {
		this.doctorFeedback = doctorFeedback;
	}	
}
