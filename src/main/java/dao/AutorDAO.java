package dao;

import javax.persistence.EntityManager;

import model.pessoas.Autor;
import util.JPAUtil;

public class AutorDAO implements GenericDAO<Autor>{
	private EntityManager em;
	
	@Override
	public boolean insert(Autor obj) {
		// TODO Auto-generated method stub
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
			
			return true;
			
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		return false;
	}

	@Override
	public boolean update(Autor obj) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		return false;
	}

	@Override
	public boolean delete(Autor obj) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Autor autor = em.find(Autor.class, obj.getId());
			
			
			
			
			
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		return false;
	}

	@Override
	public Autor findByID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Autor autor = em.find(Autor.class, id);
			return autor;
			
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		return null;
	}
	
}
