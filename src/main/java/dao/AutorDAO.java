package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.pessoas.Autor;
import util.JPAUtil;

public class AutorDAO implements GenericDAO<Autor>{
	private EntityManager em;
	
	@Override
	public boolean insert(Autor obj) {
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
		} catch (RuntimeException e) {
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
			Autor autor = em.find(Autor.class, obj.getIdAutor());
			em.remove(autor);
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
	public Autor findByID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Autor autor = em.find(Autor.class, id);
			return autor;
		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para id: " + id);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Autor> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Autor> query = em.createQuery("SELECT obj FROM Autor obj", Autor.class);
			List<Autor> autores = query.getResultList();
			return autores;
		} catch (NoResultException e) {
			System.out.println("Nenhum Autor encontrado");
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Autor> findByAttribute(String snome) {
		// TODO funciona ?
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Autor> query = em.createQuery("SELECT obj FROM Autor obj "
					+ "WHERE obj.nome LIKE :snome",
					Autor.class);
			query.setParameter("snome", snome).setMaxResults(10);
			List<Autor> autores = query.getResultList();
			return autores;
		} catch (NoResultException e) {
			System.out.println("Nenhum autor encontrado com esse nome: " + snome);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
}
