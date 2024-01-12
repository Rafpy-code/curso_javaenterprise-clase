package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Curso;
import model.Usuario;

public class UsuariosService {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}

	public boolean autenticar(String usuario, String password) {
																// ?1 ?2
		String jpql = "select u from Usuario u where u.usuario = :usuario and u.password = :password";
		EntityManager em = getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setParameter("usuario", usuario);
		query.setParameter("password", password);

		try {
			Usuario u = query.getSingleResult();
			return u != null; // Autenticación exitosa si se encuentra un usuario
		} catch (Exception e) {
			return false; // Usuario no encontrado
		}
	}
}
