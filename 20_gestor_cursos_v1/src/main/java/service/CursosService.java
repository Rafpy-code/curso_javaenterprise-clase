package service;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursosService {

	private List<Curso> cursos = new ArrayList<>();
	
	public List<Curso> obtenerCursos() {
        return cursos;
    }

	// modificar este método para que añada el curso si no hay otro
	// con el mismo nombre, si ya existe no se añade y se devuelve false
	public boolean nuevoCurso(String nombre, int duracion, double precio) {
		Curso curso = new Curso(nombre, duracion, precio);
		for (Curso c : cursos) {
			if (c.getNombre().equals(nombre)) {
				return false;
			}
		}
		cursos.add(curso);
		return true;
	}

	public void modificarDuracion(String nombre, int nuevaDuracion) {
		for (Curso c : cursos) {
			if (c.getNombre().equals(nombre)) {
				c.setDuracion(nuevaDuracion);
				break;
			}
		}
	}

	public List<Curso> preciosCursoMax(double precioMax) {
		// creamos arraylist auxiliar
		List<Curso> auxiliar = new ArrayList<>();
		// recorremos arraylist principal y cada curso con precio
		// igual o inferior al max será guardado en el auxiliar
		for (Curso c : cursos) {
			if (c.getPrecio() <= precioMax) {
				auxiliar.add(c);
			}
		}
		// devolvemos el arraylist auxiliar
		return auxiliar;
	}

	public void eliminarCurso(String nombre) {
		cursos.removeIf(c -> c.getNombre().equals(nombre));

	}
}