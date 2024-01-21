package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="libros")
public class Libro {
	@Id
	private String isbn;
	private String titulo;
	private String autor;
	private double precio;
	private int paginas;
	private int idTema;
	
}
