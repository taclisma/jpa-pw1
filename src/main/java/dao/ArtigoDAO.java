package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		} catch (RuntimeException e) {
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
		} catch (RuntimeException e) {
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
		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para id: " + id);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
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
		} catch (NoResultException e) {
			System.out.println("Nenhum artigo encontrado");
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Artigo> findByAttribute(String stitulo) {
		// TODO sera q funciona?
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Artigo> query = em.createQuery("SELECT obj FROM Artigo obj "
					+ "WHERE obj.titulo LIKE :stitulo",
					Artigo.class);
			query.setParameter("stitulo", stitulo).setMaxResults(10);
			List<Artigo> artigos = query.getResultList();
			return artigos;
		} catch (NoResultException e) {
			System.out.println("Nenhum artigo encontrado com esse titulo: " + stitulo);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
