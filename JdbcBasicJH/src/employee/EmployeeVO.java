package employee;

public class EmployeeVO {
	private int employeeId;
	private String lastName;
	private int salary;
	private int departmentId;
	private String eMail;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	@Override
	public String toString() {
		return "EmpoyeeVO [employeeId=" + employeeId + ", lastName=" + lastName + ", salary=" + salary
				+ ", departmentId=" + departmentId + ", eMail=" + eMail + "]";
	}
	
}
