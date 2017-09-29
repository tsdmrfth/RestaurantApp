package com.mvc.restaurant.model.repo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.mvc.restaurant.model.domain.GenericEntity;
import com.mvc.restaurant.model.util.HibernateUtil;

public abstract class AbstractRepo<E extends GenericEntity> implements GenericRepo<E> {

	private final Class<E> entityClass;

	public AbstractRepo(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public boolean save(E entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(E entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean update(E entity) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public E findById(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		E entity = (E) session.get(entityClass, id);
		session.close();
		return entity;
	}

	@Override
	public List<E> listAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("FROM " + entityClass.getName());
		@SuppressWarnings("unchecked")
		List<E> list = query.list();
		session.close();
		return list;
	}
	
	public String findID(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		E entity = (E) session.get(entityClass, id);
		session.close();
		return entity.getClass().getName();
	}	
	
	public String getClassName(Integer id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		E entity = (E) session.get(entityClass, id);
		return entity.getClass().getName();
	}

}
