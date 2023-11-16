package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.submissoes.Artigo;
import util.JPAUtil;

public class ArtigoDAO implements GenericDAO<Artigo> {
	private EntityManager em;

	@Override
	public boolean insert(Artigo obj) {
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
	public boolean update(Artigo obj) {
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
	public boolean delete(Artigo obj) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Artigo submissao = em.find(Artigo.class, obj.getIdSubmissao());
			em.remove(submissao);
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
	public Artigo findByID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Artigo submissao = em.find(Artigo.class, id);
			return submissao;
			
		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		return null;
	}

	@Override
	public List<Artigo> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Artigo> query = em.createQuery("SELECT obj FROM Artigo obj",
				Artigo.class);
			List<Artigo> artigos = query.getResultList();
			return artigos;
		} catch (RuntimeException e) {
			return null;
		}
	}


}
