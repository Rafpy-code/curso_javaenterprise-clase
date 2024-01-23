package services.mappers;

import dtos.LibroDto;
import dtos.TemaDto;
import model.Libro;
import model.Tema;
import services.LibrosService;

public class Mapeador {

	public static TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}

	public static LibroDto libroEntityToDto(Libro libro) {
		LibrosService service = new LibrosService();
		return new LibroDto(
				libro.getIsbn(), 
				libro.getTitulo(), 
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(), 
				service.getTema(libro.getIdTema()));
	}

}
