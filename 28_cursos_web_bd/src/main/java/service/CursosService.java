package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Curso;

public class CursosService {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}

	public void agregarCurso(String nombre, int duracion, double precio) {
		Curso curso = new Curso(0, nombre, duracion, precio);
		EntityManager em = getEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(curso);
		tx.commit();
	}

	public Curso buscarCurso(int idCurso) {
		return getEntityManager().find(Curso.class, idCurso);
	}

	public List<Curso> preciosCursoMax(double precioMax) {
		String jpql = "select c from Curso c where c.precio <= ?1";
		TypedQuery<Curso> query = getEntityManager().createQuery(jpql, Curso.class);
		query.setParameter(1, precioMax);
		return query.getResultList();
	}

	public void eliminarCurso(String nombre) {
		String jpql = "delete from Curso c where c.nombre=?1";
		EntityManager em = getEntityManager();
		Query query = em.createQuery(jpql);
		query.setParameter(1, nombre);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}

	public void modificarDuracion(String nombre, int nuevaDuracion) {
		String jpql = "UPDATE Curso c SET duracion = ?2 WHERE (c.idCurso = ?1)";
		EntityManager em = getEntityManager();
		Query query = em.createQuery(jpql);
		query.setParameter(1, nombre);
		query.setParameter(2, nuevaDuracion);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}
}
