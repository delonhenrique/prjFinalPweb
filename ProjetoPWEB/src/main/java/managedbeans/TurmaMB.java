package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.*;
import service.*;

@SessionScoped
@ManagedBean
public class TurmaMB {
	private Turma turma = new Turma(null,null);
	private TurmaService service = new TurmaService();
	private Curso curso = new Curso();
	private CursoService cursoService = new  CursoService();
	private List<Curso> cursos = new ArrayList<>();
	
	public void salvar() {
		service.save(turma);
		service.closeEntityManager();
		turma = new Turma(null,null);
	}
	
	
	public void consultar(){
		List<Turma> lista = getTurmas();
		Turma resultado = new Turma(null,null);
		try {
			resultado = lista.stream().filter(turma -> turma.getSiglaTurma().equals(turma.getSiglaTurma())).findFirst().get();
			System.out.println(resultado.getSiglaTurma());
			turma = resultado;
		}catch (Exception e) {
			System.out.println("SIGLA não encontrado");
		}
	}
	
	public List<Turma> getTurmas() {
		List <Turma> lista;
		lista = service.getAll(Turma.class);
		service.closeEntityManager();
		return lista;
	}
	
	public List <String> getCursos() {
		List<String> lista = new ArrayList<>();
		cursos = cursoService.getAll(Curso.class);
		cursoService.closeEntityManager();
		for (int i = 0; i<cursos.size(); i++) {
			curso = cursos.get(i);
			lista.add(curso.getSigla());
		}
		return lista;
	}
	
	public TurmaService getService() {
		return service;
	}

	public void setService(TurmaService service) {
		this.service = service;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}
