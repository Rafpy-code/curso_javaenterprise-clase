package service;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Curso;
import model.Usuario;

public class UsuariosService {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursosPU");
		return factory.createEntityManager();
	}

	private Usuario buscarPorUsuario(String usuario) {
		String jpql = "select u from Usuario u where u.usuario=:usuario";
		TypedQuery<Usuario> query = getEntityManager().createQuery(jpql, Usuario.class);
		query.setParameter("usuario", usuario);

		List<Usuario> usuarios = query.getResultList();
		if (!usuarios.isEmpty()) {
			System.out.println(usuarios.get(0) + "buscarPorUsuario()");
			return usuarios.get(0);
		}
		return null;
	}

	public boolean agregarUsuario(String usuario, String password, String password1) {
		if ((buscarPorUsuario(usuario) == null) && (password.equals(password1))) {
			Usuario c = new Usuario(usuario, password);
			EntityManager em = getEntityManager();
			EntityTransaction tx = em.getTransaction();
			try {
				tx.begin();
				em.persist(c);
				tx.commit();
				System.out.println("Registro Ok!  agregarUsuario()" + c.getUsuario());
				return true;
			} catch (Exception e) {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				e.printStackTrace();
			} finally {
				em.close();
			}
		}
		System.out.println("Las contraseñas son distintas o el usuario ya existe!");
		return false;
	}

	public boolean autenticar(String usuario, String password) {
		String jpql = "select u from Usuario u where u.usuario = :usuario and u.password = :password";
		EntityManager em = getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setParameter("usuario", usuario);
		query.setParameter("password", password);

		try {
			Usuario u = query.getSingleResult();
			return u != null; // Autenticación exitosa si se encuentra un usuario
		} catch (Exception e) {
			e.printStackTrace();
			return false; // Usuario no encontrado
		}
	}
}
