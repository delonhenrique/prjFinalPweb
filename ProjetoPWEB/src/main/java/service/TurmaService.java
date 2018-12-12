package service;

import java.util.List;

import entidades.Turma;

public class TurmaService extends Service<Turma, String> {
	public List<Turma> getTurmas() {
		List <Turma> lista;
		lista = getAll(Turma.class);
		closeEntityManager();
		return lista;
	}
}