package tech.csm.domain;

public class StudentVO {
	private String rollNo;
	private String name;
	private String cgpa;
	private AddressVO address;
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public AddressVO getAddress() {
		return address;
	}
	public void setAddress(AddressVO address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentVO [rollNo=" + rollNo + ", name=" + name + ", cgpa=" + cgpa + "]";
	}
	
	
}
