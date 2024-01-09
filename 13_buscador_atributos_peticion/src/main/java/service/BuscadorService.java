package service;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;

public class BuscadorService {
	List<Resultado> resultados = new ArrayList<>(List.of(new Resultado("http://www.fnac.es", "libros", "Libros y más"),
			new Resultado("http://www.mybook.com", "libros", "librería de temas varios"),
			new Resultado("http://www.game.es", "juegos", "Juegos variados"),
			new Resultado("http://www.music.es", "música", "La mejor música"),
			new Resultado("http://www.tech.com", "libros", "Libros técnicos"),
			new Resultado("http://www.eljuego.es", "juegos", "Juegos on-line")));

	public List<Resultado> buscar(String tematica) {
		/*
		 * List<Resultado> busquedas = new ArrayList<>(); for (int i = 0; i <
		 * resultados.size(); i++) { if
		 * (resultados.get(i).getTematica().equals(tematica)
		 * |resultados.get(i).getTematica().startsWith(tematica)) {
		 * busquedas.add(resultados.get(i)); } } ============= for(Resultado
		 * r:resultados){ if(r.getTematica().equals(tematica){
		 * busquedas.add(resultados.get(i)); } return busquedas; ====================
		 */
		return resultados.stream().filter(r -> r.getTematica().equals(tematica)).toList();
	}
}
