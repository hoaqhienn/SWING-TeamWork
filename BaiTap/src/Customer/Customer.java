package Customer;

public class Customer {
	private String ID;
	private String lastName;
	private String firstName;
	private String faction;
	private int age;
	private double salary;
	
	

	public Customer(String ID, String lastName, String firstName, String faction, int age, double salary) {
		super();
		this.ID = ID;
		setAge(age);
		setFaction(faction);
		setFirstName(firstName);
		setLastName(lastName);
		setSalary(salary);
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(!lastName.equals(""))this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(!firstName.equals(""))
			this.firstName = firstName;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		if(!faction.equals(""))this.faction = faction;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0)this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if(salary>0) this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", lastName=" + lastName + ", firstName=" + firstName + ", faction=" + faction
				+ ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(((Customer) obj).getID().equals(this.getID())) return false;
		return true;
	}
	
	
	
}
