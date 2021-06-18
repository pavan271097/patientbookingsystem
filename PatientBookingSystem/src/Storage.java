import java.util.ArrayList;

public class Storage {

	public static ArrayList<Patient> patients = new ArrayList<>();
	public static ArrayList<Doctor> doctors = new ArrayList<>();
	public static ArrayList<Slot> slots = new ArrayList<>();
	public static ArrayList<Appointment> appointments = new ArrayList<>();
	public static Patient currentUser = null;

	public static void initiateData() {
		if(slots.size()==0) {	
			
			slots.add(new Slot(1,"10:00"));
			slots.add(new Slot(2,"11:00"));
			slots.add(new Slot(3,"12:00"));
			slots.add(new Slot(4,"13:00"));
			slots.add(new Slot(5,"14:00"));
			slots.add(new Slot(6,"15:00"));
			slots.add(new Slot(7,"16:00"));
			slots.add(new Slot(8,"17:00"));
			
			patients.add(new Patient("sx1@mail.com","Brandon Castee","Male",26,"asdasd"));
			patients.add(new Patient("aceer3@mail.com","Acie Miller","Female",21,"zxczxc"));
			
			doctors.add(new Doctor("doc-101","John Doe","Skin Specialist","Male",12.5));
			doctors.add(new Doctor("doc-112","Arron Doh","Skin Specialist","Male",15.0));
			doctors.add(new Doctor("doc-143","Jane Dundy","Skin Specialist","Female",10.15));
			doctors.add(new Doctor("doc-211","Elton Drake","ENT Specialist","Male",12.5));
			doctors.add(new Doctor("doc-312","Corbin Gross","Heart Specialist","Male",22.5));
			doctors.add(new Doctor("doc-263","Corey Sherer","General Phycisian","Male",8.15));
			doctors.add(new Doctor("doc-151","Gingerane Doe","General Phycisian","Female",10.5));
			
		}
	}
}
