package org.jsp.hibernatemapping.userapp.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.hibernatemapping.userapp.dto.User;

public class UserDao {

	Session s = new Configuration().configure().buildSessionFactory().openSession();
	Transaction t = s.beginTransaction();

	public User saveUser(User user) {

		s.save(user);
		t.commit();
		return user;
	}

	public User updateUser(User user) {

		s.save(user);
		t.commit();
		return user;
	}

	public User findById(int id) {
		return s.get(User.class, id);

	}

	public boolean deleteById(int id) {
		User u = findById(id);
		if (u != null) {
			s.delete(u);
			t.commit();
			return true;
		}
		return false;
	}

	public User verifyPhoneAndPassword(long phone, String password) {
		Query<User> qry = s.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		qry.setParameter(1, phone);
		qry.setParameter(2, password);
		try {
			return qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyEmailAndPassword(String email, String password) {
		Query<User> qry = s.createQuery("select u from User u where u.email=?1 and u.password=?2");
		qry.setParameter(1, email);
		qry.setParameter(2, password);
		try {
			return qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyNameAndPassword(String name, String password) {
		Query<User> qry = s.createQuery("select u from User u where u.name=?1 and u.password=?2");
		qry.setParameter(1, name);
		qry.setParameter(2, password);
		try {
			return qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public User verifyIdAndPassword(int id, String password) {
		Query<User> qry = s.createQuery("select u from User u where u.id=?1 and u.password=?2");
		qry.setParameter(1, id);
		qry.setParameter(2, password);
		try {
			return qry.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	public List<User> fetchAllTheUsersData() {
		Query<User> users = s.createQuery("select u from User u ");
		if(users!=null) {
			return users.getResultList();
		}else {
			return null;
		}
	}
	public List<String> fetchAllTheUserNames() {
		Query<String> names = s.createQuery("select u.name from User u ");
		if(names!=null) {
			return names.getResultList();
		}else {
			return null;
		}
	}

}
