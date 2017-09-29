package com.mvc.restaurant.model.repo;

import java.util.List;

import com.mvc.restaurant.model.domain.GenericEntity;

public interface GenericRepo<E extends GenericEntity> {

	public abstract boolean save(E entity);

	public abstract boolean delete(E entity);

	public abstract boolean update(E entity);

	public abstract E findById(Integer id);

	public abstract List<E> listAll();
}
