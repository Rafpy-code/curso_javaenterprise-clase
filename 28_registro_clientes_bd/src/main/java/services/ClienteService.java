package services;

import java.util.List;
import java.util.Optional;

import model.Cliente;

public interface ClienteService {

	List<Cliente> listar();

	Optional<Cliente> porId(Long id);

	void guardar(Cliente cliente);

	void eliminar(Long id);
	
}
