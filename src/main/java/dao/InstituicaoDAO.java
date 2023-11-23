package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.locais.Instituicao;
import util.JPAUtil;

public class InstituicaoDAO implements GenericDAO<Instituicao> {

	private EntityManager em;

	@Override
	public boolean insert(Instituicao obj) {
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
	public boolean update(Instituicao obj) {
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
	public boolean delete(Instituicao obj) {
		try {
			em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Instituicao instituicao = em.find(Instituicao.class, obj.getIdInstituicao());
			em.remove(instituicao);
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
	public Instituicao findByID(Long id) {
		try {
			em = JPAUtil.getEntityManager();
			Instituicao instituicao = em.find(Instituicao.class, id);
			return instituicao;
		} catch (NoResultException e) {
			System.out.println("Nenhum resultado encontrado para id: " + id);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Instituicao> listAll() {
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Instituicao> query = em.createQuery("SELECT obj FROM Autor obj", Instituicao.class);
			List<Instituicao> inst = query.getResultList();
			return inst;
		} catch (NoResultException e) {
			System.out.println("Nenhuma instituiçao encontrada");
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Instituicao> findByAttribute(String snomeInst) {
		// TODO 
		try {
			em = JPAUtil.getEntityManager();
			TypedQuery<Instituicao> query = em.createQuery("SELECT obj FROM Artigo obj "
					+ "WHERE obj.nome LIKE :nomeInst",
					Instituicao.class);
			query.setParameter("nomeInst", snomeInst).setMaxResults(10);
			List<Instituicao> inst = query.getResultList();
			return inst;
		} catch (NoResultException e) {
			System.out.println("Nenhuma instituição encontrada com esse nome: " + snomeInst);
		} catch (RuntimeException e) {
			System.out.println("Runtime exception: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
