package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.model.Video;
import com.utils.JpaUtils;

public class VideoDAO extends DAO<Video, String> {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	@Override
	public void insert(Video entity) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void update(Video entity) {
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
		Video entity = em.find(Video.class, key);
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
	public List<Video> findAll() {
		// TODO Auto-generated method stub
		String jsqp = "SELECT v FROM Video v";
		TypedQuery<Video> query = em.createQuery(jsqp, Video.class);
		return query.getResultList();
	}

	@Override
	public Video findById(String key) {
		// TODO Auto-generated method stub
		Video entity = em.find(Video.class, key);
		return entity;
	}
	
	public Video findById(Long key) {
		// TODO Auto-generated method stub
		Video entity = em.find(Video.class, key);
		return entity;
	}
	
	public Video findByHref(String href) {
		String jsqp = "SELECT v FROM Video v WHERE v.href = :link";
		
		TypedQuery<Video> query = em.createQuery(jsqp, Video.class);
		query.setParameter("link", href);
		return query.getSingleResult();
	}
	
	public void updateView() {
		
	}
	
	public List<Video> top4Video(){
		String jsqp = "SELECT v "
				+ "FROM Video v "
				+ "ORDER BY v.views DESC";
		
		TypedQuery<Video> query = em.createQuery(jsqp, Video.class);
		return query.setMaxResults(4).getResultList();
	}

}
