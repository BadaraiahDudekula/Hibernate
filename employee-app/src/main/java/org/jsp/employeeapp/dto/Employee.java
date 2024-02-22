package org.jsp.employeeapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  @Table(name="Employee")
public class Employee {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
  @Column(nullable=false)
	private String name;
  @Column(nullable=false , unique=true)
	private long phone;
  @Column(nullable=false , unique=true)
	private String email;
  @Column(nullable=false)
	private String design;
  @Column(nullable=false)
	private double salary;
  @Column(nullable=false)
	private String password;
  @Column(nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesign() {
		return design;
	}
	public void setDesign(String design) {
		this.design = design;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
