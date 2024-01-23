package services;

import java.util.List;

import dtos.LibroDto;
import dtos.TemaDto;

public interface LibrosService {

	// desde que iniciamos con los dtos
	List<TemaDto> getTemas();

	List<LibroDto> getAllLibros();

	List<LibroDto> getLibrosPorIdTema(int id);

	LibroDto getLibroPorIsbn(int isbn);

	TemaDto getTema(int idTema);

}