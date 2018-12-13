package service;

import java.util.List;

import javax.persistence.Query;

import entidades.Turma;

public class TurmaService extends Service<Turma, String> {
	public List<Turma> getTurmas() {
		List <Turma> lista;
		lista = getAll(Turma.class);
		closeEntityManager();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	public List<Turma> getTurmaByCurso(String sigla) {
		Query query = getEntityManager().createQuery("select o from TURMA o where o.curso.sigla = :curso");
		query.setParameter("curso", sigla);
		
		return (List<Turma>) query.getResultList();
	}
}