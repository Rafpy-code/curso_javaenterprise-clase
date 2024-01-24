package services.implementations;

import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import model.Libro;
import model.Tema;
import services.interfaces.LibrosService;
import services.mappers.Mapeador;

public class LibrosServiceImpl implements LibrosService {
	
	@Named(value = "impl1")
	@RequestScoped
	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("libreriaPU");
		return factory.createEntityManager();
	}
	
	// desde que iniciamos con los dtos
	@Override
	public List<TemaDto> getTemas() {
		String jpql = "select t from Tema t";
		TypedQuery<Tema> query = getEntityManager().createQuery(jpql, Tema.class);
		return query.getResultList()
				.stream()
				.map(t -> Mapeador.temaEntityToDto(t))
				.toList();
	}
	
	@Override
	public List<LibroDto> getAllLibros() {
		System.out.println("getAllLibros())");
		String jpql = "select l from Libro l";
		TypedQuery<Libro> query = getEntityManager().createQuery(jpql, Libro.class);
		return query.getResultList()
				.stream()
				.map(l -> Mapeador.libroEntityToDto(l))
				.toList();
	}
	
	@Override
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
	
	@Override
	public LibroDto getLibroPorIsbn(int isbn) {
		return Mapeador.libroEntityToDto(getEntityManager().find(Libro.class, isbn));
	}

	@Override
	public TemaDto getTema(int idTema) {
		return Mapeador.temaEntityToDto(getEntityManager().find(Tema.class, idTema));
	}

}
