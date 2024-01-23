package services;

import java.util.Arrays;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;

public class LibrosService {
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	public List<Tema> getTemas() {
		String jpql = "select t from Tema t";
		TypedQuery<Tema> query = getEntityManager().createQuery(jpql, Tema.class);
		return query.getResultList();
	}
	
	public List<Libro> getAllLibros() {
		System.out.println("getAllLibros())");
		String jpql = "select l from Libro l";
		TypedQuery<Libro> query = getEntityManager().createQuery(jpql, Libro.class);
		return query.getResultList();
	}
	
	public List<Libro> getLibrosPorIdTema(int id) {
		System.out.println("getLibrosPorIdTema(Integer id)");
		String jpql = "select l from Libro l where l.idTema = :id";
		TypedQuery<Libro> query = getEntityManager().createQuery(jpql, Libro.class);
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public Libro getLibroPorIsbn(int isbn) {
		return getEntityManager().find(Libro.class, isbn);
	}
	
	public List<Libro> comprarLibros(int isbn){
		List<Libro> carrito = null; 
		carrito.add((Libro) getLibroPorIsbn(isbn));
		return carrito;
	}

}
