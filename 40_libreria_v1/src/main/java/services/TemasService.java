package services;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Tema;

public class TemasService {
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}
	
	public List<Tema> listarTemas() {
		String jpql = "select t from Tema t";
		TypedQuery<Tema> query = getEntityManager().createQuery(jpql, Tema.class);
		return query.getResultList();
	}
	public List<Tema> listarPorTema(String tema) {
		String jpql = "select t from Tema t where t.tema <= :tema";
		TypedQuery<Tema> query = getEntityManager().createQuery(jpql, Tema.class);
		query.setParameter("tema", tema);
		return query.getResultList();
	}

}
