package org.orangedevelopers.onlinestore.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.orangedevelopers.onlinestore.persistanceDAO.PersistanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
@Repository
public class PersistanceDAOImpl implements PersistanceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Transaction transaction = null;
	private Session session = null;
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public Session getSession(){
		try{
			if(session != null){
				this.session.clear();
				session = sessionFactory.getCurrentSession();
			}else{
				this.session = sessionFactory.openSession();
			}
		}catch(HibernateException ex){
			ex.getMessage();
		}
		return session;
	}
	public Session getSessionAndBeginTransaction(){
		try{
			if(session != null){
				session = sessionFactory.getCurrentSession();
				this.setTransaction(session.beginTransaction());
			}else{
				this.session = sessionFactory.openSession();
				this.setTransaction(session.beginTransaction());
			}
		}catch(HibernateException ex){
			ex.getMessage();
		}
		return session;
	}
	
	public <T,PK extends Serializable> PK save(T entity) throws HibernateException {
		PK pk = null;
		try{
			pk = (PK) this.getSessionAndBeginTransaction().save(entity);
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
		return pk;
	}

	@Override
	public <T> boolean remove(T entity) throws HibernateException {
		try{
			this.getSessionAndBeginTransaction().delete(entity);
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
		return false;
	}

	@Override
	public <T> T getById(int id)
			throws HibernateException {
		T t = null;
		try{
			//t =(T) this.getSessionAndBeginTransaction().get(ProgramOfStudy.class, id);
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
		return t;
	}

	@Override
	public <T> boolean update(T entity) throws HibernateException {
		try{
			this.getSessionAndBeginTransaction().update(entity);
		}catch(HibernateException ex){
			ex.getStackTrace();
		}finally{
			return true;
		}
	}

	@Override
	public <T> boolean updateAll(List<T> list) throws HibernateException {
		try{
			for(T t : list){
				this.getSessionAndBeginTransaction().saveOrUpdate(t);
				this.clearCommit();
			}
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
		return false;
	}

	@Override
	public void clearCommit() {
		try{
			this.getTransaction().commit();
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
	}

	@Override
	public void closeSession() {
		try{
			this.session.close();
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
	}

	@Override
	public void commitAndClose(){
		try{
			this.getTransaction().commit();
			this.getSession().close();
			this.getSession().flush();
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
	}

	@Override
	public <T> List<T> getAll(String entity) throws HibernateException {
		String query = "from " + entity;
		List<T> list = new ArrayList<T>();
		list = this.getSessionAndBeginTransaction().createQuery(query).list();
		try{
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
		return list;
	}

	@Override
	public Model getClientDetailToUpdate(int id, Model model) {
		try{
			this.session = this.getSessionAndBeginTransaction();
			Query currentStudyQuery = session.createQuery("from CurrentStudy where generalDetailId = :id ");
			currentStudyQuery.setInteger("id", id);

			Query educationalDetailQuery = session.createQuery("from EducationalDetail where generalDetailId = :id ");
			educationalDetailQuery.setInteger("id", id);

			Query languageQuery = session.createQuery("from Language where generalDetailId = :id ");
			languageQuery.setInteger("id", id);

			Query personalDetailQuery = session.createQuery("from PersonalDetail where generalDetailId = :id ");
			personalDetailQuery.setInteger("id", id);

			Query personalStatementQuery = session.createQuery("from PersonalStatement where generalDetailId = :id ");
			personalStatementQuery.setInteger("id", id);

			Query programOfStudyQuery = session.createQuery("from ProgramOfStudy where generalDetailId = :id ");
			programOfStudyQuery.setInteger("id", id);
			
			Query referenceQuery = session.createQuery("from Reference where generalDetailId = :id ");
			referenceQuery.setInteger("id", id);

			Query workExperienceQuery = session.createQuery("from WorkExperience where generalDetailId = :id ");
			workExperienceQuery.setInteger("id", id);
			
			Query countryQuery = session.createQuery("from Country");
			Query cityQuery = session.createQuery("from City");
			
			model.addAttribute("countryList", countryQuery.list());
			model.addAttribute("cityList", cityQuery.list());
			model.addAttribute("currentStudy", currentStudyQuery.uniqueResult());
			model.addAttribute("educationalDetailList", educationalDetailQuery.list());
			model.addAttribute("languageList", languageQuery.list());
			model.addAttribute("personalDetail", personalDetailQuery.uniqueResult());
			model.addAttribute("personalStatement", personalStatementQuery.uniqueResult());
			model.addAttribute("programOfStudyList", programOfStudyQuery.list());
			model.addAttribute("referenceList", referenceQuery.list());
			model.addAttribute("workExperienceList", workExperienceQuery.list());

		}catch(HibernateException ex){
			ex.getStackTrace();
		}		
		return model;
	}

	@Override
	public <T> boolean saveOrUpdate(T entity)
			throws HibernateException {
		try{
			this.getSessionAndBeginTransaction().saveOrUpdate(entity);
			this.commitAndClose();
		}catch(HibernateException ex){
			ex.getStackTrace();
		}
		return true;
	}

}
