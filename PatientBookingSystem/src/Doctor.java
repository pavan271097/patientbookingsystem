
public class Doctor {

	String id, name, expertise, gender;
	double rate;
	public Doctor(String id, String name, String expertise, String gender, double rate) {
		this.id = id;
		this.name = name;
		this.expertise = expertise;
		this.gender = gender;
		this.rate = rate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "<html><p>Doctor ID: " + id + "<br>Name: " + name + "<br>Expertise: " + expertise + "<br>Gender: " + gender + "<br>Rate: $"
				+ rate + "</p>";
	}
	
	
	
	
}
