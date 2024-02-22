package org.jsp.hibernatemapping.userapp.Controller;

import java.util.*;

import org.jsp.hibernatemapping.userapp.dao.UserDao;
import org.jsp.hibernatemapping.userapp.dto.User;

public class UserController {

	static UserDao dao = new UserDao();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("1.save User");
		System.out.println("2.update User");
		System.out.println("3.FindById");
		System.out.println("4.Delete");
		System.out.println("5.Verify Phone And Password");
		System.out.println("6.Verify Emil And Password");
		System.out.println("7.Verify Name And Password");
		System.out.println("8.Verify Id And Password");
		System.out.println("9.Fetch All the users Data");
		System.out.println("10.Fetch All The User Names");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			save();
			break;
		}
		case 2: {
			update();
			break;
		}
		case 3: {
			findById();
			break;
		}
		case 4: {
			delete();
			break;
		}
		case 5: {
			verifyPhone();
			break;
		}
		case 6: {
			verifyEmail();
			break;
		}
		case 7: {
			verifyName();
			break;
		}
		case 8: {
			verifyId();
			break;
		}
		case 9: {
			fetchUsers();
			break;
		}
		case 10: {
			fetchAllUserNames();
			break;
		}
		default:
			break;
		}
	}

	public static void save() {
		System.out.println("Enter the name , age,email,phone and password to save the record");
		User u = new User();
		u.setName(sc.next());
		u.setAge(sc.nextInt());
		u.setEmail(sc.next());
		u.setPhone(sc.nextLong());
		u.setPassword(sc.next());
		u = dao.saveUser(u);
		System.out.println("User saved with Id:" + u.getId());
	}

	public static void update() {
		System.out.println("enter the Id to Update the User Details");
		int id = sc.nextInt();
		System.out.println("Enter the name , age,email,phone and password ");
		User u = new User();
		u.setName(sc.next());
		u.setAge(sc.nextInt());
		u.setEmail(sc.next());
		u.setPhone(sc.nextLong());
		u.setPassword(sc.next());
		u = dao.updateUser(u);
		System.out.println("User Updated Successfully");
	}

	public static void findById() {
		System.out.println("enter the Id to Find the User Details");
		int id = sc.nextInt();
		User u = dao.findById(id);
		if (u != null) {
			System.out.println("Name:" + u.getName());
			System.out.println("Age:" + u.getAge());
			System.out.println("Phone:" + u.getPhone());
			System.out.println("Email" + u.getEmail());
			System.out.println("Password:" + u.getPassword());
		} else {
			System.out.println("you Entered Invalid Id");
		}
	}

	public static void delete() {
		System.out.println("enter the Id to Delete the User Details");
		int id = sc.nextInt();
		User u = dao.findById(id);
		boolean deleted = dao.deleteById(id);
		if (deleted) {
			System.out.println("User Deleted");
		} else {
			System.out.println("you Entered Invalid Id");
		}
	}

	public static void verifyPhone() {
		System.out.println("Enter the phone and password to fetch User Details");
		long phone = sc.nextLong();
		String password = sc.next();
		User u = dao.verifyPhoneAndPassword(phone, password);
		if (u != null) {
			System.out.println("Name:" + u.getName());
			System.out.println("Age:" + u.getAge());
			System.out.println("Phone:" + u.getPhone());
			System.out.println("Email" + u.getEmail());
			System.out.println("Password:" + u.getPassword());
		} else {
			System.out.println("Entered Invalid phone or Password");
		}
	}

	public static void verifyEmail() {
		System.out.println("Enter the Email and password to fetch User Details");
		String email = sc.next();
		String password = sc.next();
		User u = dao.verifyEmailAndPassword(email, password);
		if (u != null) {
			System.out.println("Name:" + u.getName());
			System.out.println("Age:" + u.getAge());
			System.out.println("Phone:" + u.getPhone());
			System.out.println("Email" + u.getEmail());
			System.out.println("Password:" + u.getPassword());
		} else {
			System.out.println("Entered Invalid Email or Password");
		}
	}

	public static void verifyName() {
		System.out.println("Enter the Name and password to fetch User Details");
		String name = sc.next();
		String password = sc.next();
		User u = dao.verifyNameAndPassword(name, password);
		if (u != null) {
			System.out.println("Name:" + u.getName());
			System.out.println("Age:" + u.getAge());
			System.out.println("Phone:" + u.getPhone());
			System.out.println("Email" + u.getEmail());
			System.out.println("Password:" + u.getPassword());
		} else {
			System.out.println("Entered Invalid Name or Password");
		}
	}

	public static void verifyId() {
		System.out.println("Enter the Id and password to fetch User Details");
		int id = sc.nextInt();
		String password = sc.next();
		User u = dao.verifyIdAndPassword(id, password);
		if (u != null) {
			System.out.println("Name:" + u.getName());
			System.out.println("Age:" + u.getAge());
			System.out.println("Phone:" + u.getPhone());
			System.out.println("Email" + u.getEmail());
			System.out.println("Password:" + u.getPassword());
		} else {
			System.out.println("Entered Invalid Id or Password");
		}
	}

	public static void fetchUsers() {
		List<User> users = dao.fetchAllTheUsersData();
		if (users != null) {
			for (User u : users) {
				System.out.println("Id:"+u.getId());
				System.out.println("Name:" + u.getName());
				System.out.println("Age:" + u.getAge());
				System.out.println("Phone:" + u.getPhone());
				System.out.println("Email:" + u.getEmail());
				System.out.println("Password:" + u.getPassword());
				System.out.println("=========================");
			}
		} 
	}
	public static void fetchAllUserNames() {
		List<String> names = dao.fetchAllTheUserNames();
		if(names!=null) {
			for(String name:names) {
				System.out.println("Names:"+name);
			}
		}
	}
}
