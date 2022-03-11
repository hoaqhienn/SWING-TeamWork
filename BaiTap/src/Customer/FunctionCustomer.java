package Customer;

import java.util.Vector;

public class FunctionCustomer {
	private Vector<Customer> customer;

	public FunctionCustomer() {
		super();
		customer = new Vector<>();
	}

	public Vector<Customer> getCustomer() {
		return customer;
	}

	public boolean addCustomer(Customer c) {
		for(Customer cm : customer) {
			if(cm.getID().equals(c.getID())) return false;
		}
		customer.add(c);
		return true;
	}

	public boolean deleteCustomer(String id){
		for(Customer cm : customer) {
			if(cm.getID().equals(id)) {
				customer.remove(cm);
				return true;
			}
		}
		return false;
	}

	public boolean editCustomer(Customer c) {
		for(Customer cm : customer) {
			if(cm.getID().equals(c.getID())) {
				cm.setFaction(c.getFaction());
				cm.setAge(c.getAge());
				cm.setFirstName(c.getFirstName());
				cm.setLastName(c.getLastName());
				cm.setSalary(c.getSalary());
				return true;
			}
		}
		return false;
	}
	
}
