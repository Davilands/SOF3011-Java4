package com.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.model.Account;
import com.model.History;
import com.model.Video;
import com.utils.JpaUtils;

public class HistoryDAO extends DAO<History, String> {
	private EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		em.close();
		super.finalize();
	}

	private VideoDAO videoDao = new VideoDAO();
	//private HistoryDAO historyDao = new HistoryDAO();

	public boolean insert(Account account, Video video) {
		try {
			HistoryDAO historyDao = new HistoryDAO();
			History his = historyDao.findUsernameAndVideoId(account.getUsername(), video.getId());
			System.out.println("Tim thay user "+account.getFullname()+" trong hhisstory");
			return his.getIsLike();
		} catch (Exception e) {
			System.out.println("Khong tim thay user "+account.getFullname()+" trong hhisstory\"");
			History history = new History();
			history.setAccount(account);
			history.setVideo(video);
			history.setIsLike(Boolean.FALSE);
			history.setViewsDate(new Timestamp(System.currentTimeMillis()));
			history.setLikedDate(null);
			insert(history);
			// TODO: handle exception
			return false;
			/*
			 * Thêm thất bại: Đã tồn tại username và videoid đó trong db
			 */
		}
		
	}

	@Override
	public void insert(History entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}
	

	public List<History> findHistoryByUserAndIsLiked(String username){
		String jpsql = "SELECT h FROM History h WHERE h.account.username = :un AND h.isLike = 1"
				+"AND h.video.isActive = 1"
				+ "ORDER BY h.likedDate";
		TypedQuery<History> query = em.createQuery(jpsql, History.class);
		query.setParameter("un", username);
		return query.getResultList();
	}
	
	public List<History> findHistoryByUser(String username){
		String jpsql = "SELECT h FROM History h WHERE h.account.username = :un "
				+"AND h.video.isActive = 1 "
				+ "ORDER BY h.likedDate";
		TypedQuery<History> query = em.createQuery(jpsql, History.class);
		query.setParameter("un", username);
		return query.getResultList();
	}
	
	public History findUsernameAndVideoId(String username, Long videoId){
		String jpsql = "SELECT h FROM History h WHERE h.account.username = :un AND h.video.id = :vd";
		System.out.println(username+":"+videoId+":");
		TypedQuery<History> query = em.createQuery(jpsql, History.class);
		query.setParameter("un", username);
		query.setParameter("vd", videoId);
		return query.getSingleResult();
	}

	public boolean updateStatusIsLiked(Account account, String id) {
		Video video = videoDao.findById(Long.valueOf(id));
		HistoryDAO dao = new HistoryDAO();
		History history = dao.findUsernameAndVideoId(account.getUsername(), video.getId());
		System.out.println(history.getId()+": video ID from DAOHistory");
		
		try {
			if(!history.getIsLike()) {
				history.setIsLike(true);
				history.setLikedDate(new Timestamp(System.currentTimeMillis()));
			} else {
				history.setIsLike(false);
				history.setLikedDate(null);
			}
			dao.update(history);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public void update(History entity) {
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
		History entity = em.find(History.class, key);
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
		History entity = em.find(History.class, key);
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
	public List<History> findAll() {
		// TODO Auto-generated method stub
		String jpsql = "SELECT  a FROM History a";
		TypedQuery<History> query = em.createQuery(jpsql, History.class);
		System.out.println("get");
		return query.getResultList();
	}

	@Override
	public History findById(String key) {
		// TODO Auto-generated method stub
		History entity = em.find(History.class, key);
		return entity;
	}

}
