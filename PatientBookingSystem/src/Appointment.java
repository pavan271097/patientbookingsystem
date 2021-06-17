import java.util.Date;

public class Appointment {

	Patient patient;
	Doctor doctor;
	Slot slot;
	Date date;
	String status, doctorFeedback;
	public Appointment(Patient patient, Doctor doctor, Date date, Slot slot) {
		this.patient = patient;
		this.doctor = doctor;
		this.date = date;
		this.slot = slot;
		status = "Booked";
		doctorFeedback = "Not processed yet";
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
