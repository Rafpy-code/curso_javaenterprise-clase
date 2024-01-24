package services.interfaces;

import java.util.List;

import dtos.ClienteDto;

public interface ClientesServiceInterface {
	
	void altaCliente(ClienteDto clienteDto);
	
	ClienteDto autenticarCliente(String usuario, String password);
	
/*
	List<ClienteDto> getClientes();

	ClienteDto getClientePorUsuario(String usuario);

	ClienteDto getClienteDtoPorEmail(String email);
	
	ClienteDto getClienteDtoPorTelefono(int telefono);
*/
}
