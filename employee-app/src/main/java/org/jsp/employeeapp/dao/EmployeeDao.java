package org.jsp.employeeapp.dao;
import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.employeeapp.dto.Employee;

public class EmployeeDao {
	Session s = new Configuration().configure().buildSessionFactory().openSession();

	public Employee saveEmployee(Employee emp) {
		Transaction t = s.beginTransaction();
		s.save(emp);
		t.commit();
		return emp;

	}

	public Employee updateEmployee(Employee emp) {
		Transaction t = s.beginTransaction();
		s.save(emp);
		t.commit();
		return emp;

	}

	public Employee findById(int id) {
		return s.get(Employee.class, id);

	}

	public boolean deleteById(int id) {
		Employee e = findById(id);
		if (e != null) {
			Transaction t = s.beginTransaction();
			s.delete(e);
			t.commit();
			return true;
		}
		return false;

	}

	public Employee verfiyEmployee(long phone, String password) {
		String hql = "select e from Employee e where e.phone=?1 and e.password=?2";
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public Employee verfiyEmployee(int id, String password) {
		String hql = "select e from Employee e where e.id=?1 and e.password=?2";
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public Employee verfiyEmployee(String email, String password) {
		String hql = "select e from Employee e where e.email=?1 and e.password=?2";
		Query<Employee> q = s.createQuery(hql);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}


