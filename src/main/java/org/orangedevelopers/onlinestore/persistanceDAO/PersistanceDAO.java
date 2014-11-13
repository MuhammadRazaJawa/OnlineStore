package org.orangedevelopers.onlinestore.persistanceDAO;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
@Repository
public interface PersistanceDAO {

	<T,PK extends Serializable> PK save(T entity) throws HibernateException;
	
	<T> boolean saveOrUpdate(T entity) throws HibernateException;
	
	<T> boolean remove(T entity) throws HibernateException;
	
	<T> T getById(int id) throws HibernateException;
	
	<T> boolean update(T entity) throws HibernateException;
	
	<T> boolean updateAll(List<T> list) throws HibernateException;
	
	<T> List<T> getAll(String entity) throws HibernateException;
	
	Model getClientDetailToUpdate(int id, Model model);
	
	void clearCommit();
	
	void closeSession();

	void commitAndClose();

}
