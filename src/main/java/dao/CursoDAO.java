package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.submissoes.Curso;
import util.JPAUtil;

public class CursoDAO implements GenericDAO<Curso> {
	private EntityManager em;

	@Override
	public boolean insert(Curso obj) {
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
	public boolean update(Curso obj) {
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
	public boolean delete(Curso obj) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Curso curso = em.find(Curso.class, obj.getIdSubmissao());
			em.remove(curso);
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
	public Curso findByID(int id) {
		try {
			em = JPAUtil.getEntityManager();
			Curso curso = em.find(Curso.class, id);
			return curso;
		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para id: " + id);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Curso> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Curso> query = em.createQuery("SELECT obj FROM Artigo obj",
				Curso.class);
			List<Curso> curso= query.getResultList();
			return curso;
		} catch (NoResultException e) {
			System.out.println("Nenhum curso encontrado");
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Curso> findByAttribute(String stitulo) {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Curso> query = em.createQuery("SELECT obj FROM Artigo obj "
					+ "WHERE obj.titulo LIKE :stitulo",
					Curso.class);
			query.setParameter("stitulo", stitulo).setMaxResults(10);
			List<Curso> cursos = query.getResultList();
			return cursos;
		} catch (NoResultException e) {
			System.out.println("Nenhum curso encontrado com esse titulo: " + stitulo);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
}
