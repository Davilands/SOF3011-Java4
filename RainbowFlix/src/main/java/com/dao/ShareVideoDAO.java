package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.model.*;
import com.utils.JpaUtils;
public class ShareVideoDAO extends DAO<ShareVideo, String> {
private EntityManager em = JpaUtils.getEntityManager();
	
	@Override
	protected void finalize() throws Throwable{
		em.close();
		super.finalize();
	}
	

	@Override
	public void insert(ShareVideo entity) {
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

	@Override
	public void update(ShareVideo entity) {
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
		ShareVideo entity = em.find(ShareVideo.class, key);
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
		}	
	}
	
	public void delete(Long key) {
		// TODO Auto-generated method stub
		ShareVideo entity = em.find(ShareVideo.class, key);
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
	public List<ShareVideo> findAll() {
		// TODO Auto-generated method stub
		String jpsql = "SELECT  a FROM ShareVideo a";
		TypedQuery<ShareVideo> query = em.createQuery(jpsql, ShareVideo.class);
		System.out.println("get");
		return query.getResultList();
	}

	@Override
	public ShareVideo findById(String key) {
		// TODO Auto-generated method stub
		ShareVideo entity = em.find(ShareVideo.class, key);
		return entity;
	}
	
	public List<ShareVideo> findByUsername(String username){
		String jpsql = "SELECT  a FROM ShareVideo a WHERE a.account.username = :un";
		TypedQuery<ShareVideo> query = em.createQuery(jpsql, ShareVideo.class);
		query.setParameter("un", username);
		return query.getResultList();
	}

}
