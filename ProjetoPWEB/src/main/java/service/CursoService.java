package service;

import java.util.List;

import entidades.Curso;

public class CursoService extends Service <Curso, String > {

	public List<Curso> getCursos() {
		List <Curso> lista;
		lista = getAll(Curso.class);
		closeEntityManager();
		return lista;
	}
}
