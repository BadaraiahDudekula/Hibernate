package org.jsp.merchantproduct.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.merchantproduct.dto.Merchant;

public class MerchantDao {
	EntityManager manager=Persistence.createEntityManagerFactory("jpa").createEntityManager();
	
	public Merchant saveMerchant(Merchant merchant) {
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(merchant);
		transaction.begin();
		transaction.commit();
		return merchant;
	}
	public Merchant updateMerchant(Merchant merchant) {
		EntityTransaction transaction=manager.getTransaction();
		manager.merge(merchant);
		transaction.begin();
		transaction.commit();
		return merchant;
	}
	public Merchant verifyMerchant(long phone , String password) {
		EntityTransaction transaction=manager.getTransaction();
		Query q=manager.createQuery("select m from Merchant m where m.phone=?1 and m.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return(Merchant)q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	
	public Merchant verifyMerchant(String email , String password) {
		EntityTransaction transaction=manager.getTransaction();
		Query q=manager.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return(Merchant)q.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
	}
	public boolean deleteMerchant(int id) {
		Merchant m=manager.find(Merchant.class, id);
		if(m!=null) {
			manager.remove(m);
			EntityTransaction entityTransaction=manager.getTransaction();
			entityTransaction.begin();
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
