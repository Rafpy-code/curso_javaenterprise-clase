package services.mappers;

import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;
import services.LibrosService;
import services.LibrosServiceImpl;

public class Mapeador {

	public static TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}

	public static LibroDto libroEntityToDto(Libro libro) {
		LibrosService service = new LibrosServiceImpl();
		return new LibroDto(
				libro.getIsbn(), 
				libro.getTitulo(), 
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(), 
				service.getTema(libro.getIdTema()));
	}

}
