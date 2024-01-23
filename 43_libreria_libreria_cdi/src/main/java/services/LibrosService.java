package services;

import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;
import services.mappers.Mapeador;

public class LibrosService {
	
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	// desde que iniciamos con los dtos
	public List<TemaDto> getTemas() {
		String jpql = "select t from Tema t";
		TypedQuery<Tema> query = getEntityManager().createQuery(jpql, Tema.class);
		return query.getResultList()
				.stream()
				.map(t -> Mapeador.temaEntityToDto(t))
				.toList();
	}
	
	public List<LibroDto> getAllLibros() {
		System.out.println("getAllLibros())");
		String jpql = "select l from Libro l";
		TypedQuery<Libro> query = getEntityManager().createQuery(jpql, Libro.class);
		return query.getResultList()
				.stream()
				.map(l -> Mapeador.libroEntityToDto(l))
				.toList();
	}
	
	public List<LibroDto> getLibrosPorIdTema(int id) {
		System.out.println("getLibrosPorIdTema(Integer id)");
		String jpql = "select l from Libro l where l.idTema = :id";
		TypedQuery<Libro> query = getEntityManager().createQuery(jpql, Libro.class);
		query.setParameter("id", id);
		return query.getResultList()
				.stream()
				.map(l -> Mapeador.libroEntityToDto(l))
				.toList();
	}
	
	public LibroDto getLibroPorIsbn(int isbn) {
		return Mapeador.libroEntityToDto(getEntityManager().find(Libro.class, isbn));
	}

	public TemaDto getTema(int idTema) {
		return Mapeador.temaEntityToDto(getEntityManager().find(Tema.class, idTema));
	}

}
