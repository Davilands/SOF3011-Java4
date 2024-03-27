package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.model.*;
import com.utils.JpaUtils;

public class AccountDAO extends DAO<Account, String> {
private EntityManager em = JpaUtils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	@Override
	public void insert(Account entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		}
		catch(Exception ex) {
			em.getTransaction().rollback();	
		}
	}
	
	public void insert(String username, String email,String fullname, String password) {
		// TODO Auto-generated method stub
		Account acc = new Account();
		acc.setEmail(email);
		acc.setFullname(fullname);
		acc.setHistories(null);
		acc.setImage(null);
		acc.setIsActive(true);
		acc.setLiked(0);
		acc.setPassword(password);
		acc.setRole(false);
		acc.setShares(0);
		acc.setShareVideo(null);
		acc.setUsername(username);
		try {
			em.getTransaction().begin();
			em.persist(acc);
			em.getTransaction().commit();
		}
		catch(Exception ex) {
			em.getTransaction().rollback();	
		}
	}

	@Override
	public void update(Account entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		Account entity = em.find(Account.class, key);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}		
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		String jpsql = "SELECT  a FROM Account a";
		TypedQuery<Account> query = em.createQuery(jpsql, Account.class);
		System.out.println("get");
		return query.getResultList();
	}
	
	public List<Account> findUser(){
		String jpsql = "SELECT  a FROM Account a WHERE a.role = 0";
		TypedQuery<Account> query = em.createQuery(jpsql, Account.class);
		return query.getResultList();
	}

	@Override
	public Account findById(String key) {
		// TODO Auto-generated method stub
		Account entity = em.find(Account.class, key);
		return entity;
	}
	
	public Account findByUsername(String key) {
		// TODO Auto-generated method stub
		String jpsql = "SELECT  a FROM Account a WHERE a.username = :un";
		TypedQuery<Account> query = em.createQuery(jpsql, Account.class);
		query.setParameter("un", key);
		return query.getSingleResult();
	}
	
	/*
	 * return a String upperCase when account is ADMIN
	 * return a String lowerCase when account is user
	 * return a String is empty when account do not exits
	 */
	public String login(String username, String password) {
		String jpsql = "SELECT  u FROM Account u WHERE u.username = :un AND u.password = :pw";
		TypedQuery<Account> query = em.createQuery(jpsql, Account.class);
		query.setParameter("un", username);
		query.setParameter("pw",password);
		Account acc = new Account();
		try {
			acc = query.getSingleResult();
		} catch (Exception e) {
			// TODO: Không tìm thấy user
			return "";
		}

		String fullname = acc.getFullname();
		if(acc.getRole()) {
			return fullname.substring(fullname.lastIndexOf(" ")).trim().toUpperCase();
		}
		return fullname.substring(fullname.lastIndexOf(" ")).trim().toLowerCase();
	}
	
	

}
