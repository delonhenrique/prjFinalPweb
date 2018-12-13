package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import entidades.Aluno;
import entidades.Curso;
import entidades.Matricula;
import entidades.Turma;
import service.CursoService;
import service.TurmaService;

@ManagedBean
@SessionScoped
public class MatriculaMB {

	private Matricula matricula = new Matricula();
	private Curso curso;
	private Turma turma;
	private Aluno aluno;
	private String pagamento;
	private CursoService cursoService = new CursoService();
	private TurmaService turmaService = new TurmaService();
	private boolean mostrar = true;
	private boolean mostrar2 = false;

	public List<Curso> getCursos() {
		List<Curso> lista;
		lista = cursoService.getAll(Curso.class);
		cursoService.closeEntityManager();
		return lista;
	}

	public List<Turma> getTurmas() {

		List<Turma> lista;
		lista = turmaService.getAll(Turma.class);
		turmaService.closeEntityManager();
		return lista;
	}
	
	public void escolheTurma(ValueChangeEvent e){        
        if (e.getNewValue() == null) {
        	
        } else {
        	
        }
    }

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public boolean isMostrar2() {
		return mostrar2;
	}

	public void setMostrar2(boolean mostrar2) {
		this.mostrar2 = mostrar2;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void show() {

		if (pagamento == "true") {
			mostrar = true;
			mostrar2 = false;
		} else {
			mostrar = false;
			mostrar2 = true;
		}
	}

	public void escolheCurso(ValueChangeEvent e) {
		if (e.getNewValue() == null) {

		} else {

		}
	}
}