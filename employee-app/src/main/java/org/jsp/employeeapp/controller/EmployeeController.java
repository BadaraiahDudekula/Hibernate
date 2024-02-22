package org.jsp.employeeapp.controller;

import java.util.Scanner;

import org.jsp.employeeapp.dao.EmployeeDao;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeController {

	static EmployeeDao dao=new EmployeeDao();
	static Scanner s=new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1.Save Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Find Employee By Id");
		System.out.println("4.Delete Employee By Id");
		System.out.println("5.Verify Employee By Id and Password");
		System.out.println("6.Verify Employee By phone and Password");
		System.out.println("7.Verify Employee By email and Password");

		int choice =s.nextInt();
		switch(choice) {
		case 1:{
			save();
			break;
		}
		case 2:{
			update();
			break;
		}
		case 3:{
			findById();
			break;
		}
		case 4:{
			delete();
			break;
		}
		case 5:{
			verifyId();
			break;
		}
		case 6:{
			verifyPhone();
			break;
		}
		case 7:{
			verifyEmail();
			break;
		}
		default:{
			System.err.println("Invalid Choice");
		}
		}

	}
	public static void save(){
		System.out.println("Enter the name,phone,emial,designation,salary and password");
		Employee e=new Employee();
		e.setName(s.next());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setDesign(s.next());
		e.setSalary(s.nextDouble());
		e.setPassword(s.next());
		e=dao.saveEmployee(e);
		System.out.println("Employee saved with Id:"+e.getId());
	}
	public static void update() {
		System.out.println("Enter the Employee Id to update");
		int eid=s.nextInt();
		System.out.println("Enter the name,phone,emial,designation,salary and password");
		Employee e=new Employee();
		e.setId(eid);
		e.setName(s.next());
		e.setPhone(s.nextLong());
		e.setEmail(s.next());
		e.setDesign(s.next());
		e.setSalary(s.nextDouble());
		e.setPassword(s.next());
		e=dao.updateEmployee(e);
		System.out.println("Employee saved with Id:"+e.getId());
	}
	public static void findById() {
		System.out.println("Enter the Employee Id to display details");
		int eid=s.nextInt();
		Employee e=dao.findById(eid);
		if(e!=null) {
			System.out.println("EmployeeId:"+e.getId());
			System.out.println("EmployeeName:"+e.getName());
			System.out.println("Designation:"+e.getDesign());
			System.out.println("salary:"+e.getSalary());
			System.out.println("Email:"+e.getEmail());
			System.out.println("password:"+e.getPassword());
		}
		else {
			System.out.println("you have entered an invalid id");
		}

	}
	public static void delete() {
		System.out.println("Enter the Employee Id to delete record");
		int eid=s.nextInt();
		boolean deleted=dao.deleteById(eid);
		if(deleted) {
			System.out.println("Employee deleted");
		}else {
			System.out.println("cannot delete Employee...!!!As you entered invalid id");

		}

	}
	public static void verifyId() {
		System.out.println("Enter the Employee Id and password to display details");
		int eid=s.nextInt();
		String password=s.next();
		Employee e=dao.verfiyEmployee(eid, password);
		if(e!=null) {
			System.out.println("verification succesful");
			System.out.println("EmployeeId:"+e.getId());
			System.out.println("EmployeeName:"+e.getName());
			System.out.println("Designation:"+e.getDesign());
			System.out.println("salary:"+e.getSalary());
			System.out.println("Email:"+e.getEmail());
			System.out.println("password:"+e.getPassword());
		}
		else {
			System.err.println("you have entered an invalid id");
		}
	}
	public static void verifyEmail() {
		System.out.println("Enter the Employee email and password to display details");
		String email=s.next();
		String password=s.next();
		Employee e=dao.verfiyEmployee(email, password);
		if(e!=null) {
			System.out.println("verification succesful");
			System.out.println("EmployeeId:"+e.getId());
			System.out.println("EmployeeName:"+e.getName());
			System.out.println("Designation:"+e.getDesign());
			System.out.println("salary:"+e.getSalary());
			System.out.println("Email:"+e.getEmail());
			System.out.println("password:"+e.getPassword());
		}
		else {
			System.err.println("you have entered an invalid email or password");
		}
	}
	public static void verifyPhone() {
		System.out.println("Enter the Employee phone and password to display details");
		long phone=s.nextInt();
		String password=s.next();
		Employee e=dao.verfiyEmployee(phone, password);
		if(e!=null) {
			System.out.println("verification succesful");
			System.out.println("EmployeeId:"+e.getId());
			System.out.println("EmployeeName:"+e.getName());
			System.out.println("Designation:"+e.getDesign());
			System.out.println("salary:"+e.getSalary());
			System.out.println("Email:"+e.getEmail());
			System.out.println("password:"+e.getPassword());
		}
		else {
			System.err.println("you have entered an invalid phone or password");
		}
	}



}











