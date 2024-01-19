package service;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Producto;

public class ProductosService {

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("productosPU");
		return factory.createEntityManager();
	}

	public void agregarProducto(String nombre, String categoria, double precio) {
		Producto pr = new Producto(0, nombre, categoria, precio);
		EntityManager em = getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pr);
		tx.commit();
	}

	public Producto buscarProducto(int idProducto) {
		return getEntityManager().find(Producto.class, idProducto);
	}
	
	public List<Producto> buscarPorCategoria(String categoria) {
		String jpql ="select p from Producto p where p.categoria = ?1";
		TypedQuery<Producto> query = getEntityManager().createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}
	
	public void eliminarPorNombre(String nombre) {
		String jpql ="delete from Producto p where p.nombre=?1";
		EntityManager em = getEntityManager();		
		Query query = em.createQuery(jpql);
		query.setParameter(1, nombre);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		query.executeUpdate();
		tx.commit();
	}
	
	public void eliminarProducto(int idProducto) {
		Producto pr = buscarProducto(idProducto);
		if (pr != null) {
			EntityManager em = getEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.remove(pr);
			tx.commit();
		}
	}


}
