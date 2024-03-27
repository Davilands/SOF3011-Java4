package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.jpautils.JPAUtils;
import com.poly.model.User;
import com.poly.model.UserLog;

public class UserLogDAO extends DAO<UserLog, Long> {
private EntityManager em = JPAUtils.getEntityManager();
	
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	
	@Override
	public void insert(UserLog entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}

	@Override
	public void delete(UserLog entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserLog entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public List<UserLog> findAll() {
		String jpql = "SELECT u FROM UserLog u";
		TypedQuery<UserLog> query = em.createQuery(jpql, UserLog.class);
		return query.getResultList();
	}

	@Override
	public UserLog findById(Long key) {
		UserLog entity = em.find(UserLog.class, key);
		return entity;
	}

}
