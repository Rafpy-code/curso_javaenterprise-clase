package repositories;

import java.util.List;

import jakarta.persistence.EntityManager;
import model.Cliente;

public class ClienteRepository implements CrudRepository<Cliente> {

	private EntityManager em;

	public ClienteRepository(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public List<Cliente> listar() {
		return em.createQuery("select c from Cliente c", Cliente.class).getResultList();
	}

	@Override
	public Cliente porId(Long id) {
		return em.find(Cliente.class, id);
	}

	@Override
	public void guardar(Cliente cliente) {
		if(cliente.getIdCliente() != null && cliente.getIdCliente() > 0) {
			em.merge(cliente);
		} else {
			em.persist(cliente);
		}
	}

	@Override
	public void eliminar(Long id) {
		Cliente cliente = porId(id);
		em.remove(cliente);
	}

}
