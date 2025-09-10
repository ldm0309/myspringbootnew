package myspring;

public class Emp {

	public int employeeId;
	public String lastName;
	public String firstName;
	public int salary;
	
	@Override
	public String toString() {
		return "Emp [id=" + employeeId + ", last_name=" + lastName + ", first_name=" + firstName + ", salary=" + salary + "]";
	}

}
