package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;

public class CursosService {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}
	
	public List<Curso> listarPorPrecioMax(double precioMax) {
		String jpql = "select c from Curso c where c.precio <= :precioMax";
		TypedQuery<Curso> query = getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter("precioMax", precioMax);
		return query.getResultList();
	}

	public List<Curso> listarPorDuracion(int duracinMin, int duracionMax) {
		String jpql = "select c from Curso c wher c.duracion >= :duracinMin and c.duracion <= :duracionMax";
		TypedQuery<Curso> query = getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter("duracinMin", duracinMin);
		query.setParameter("duracionMax", duracionMax);
		return query.getResultList();
	}

}
