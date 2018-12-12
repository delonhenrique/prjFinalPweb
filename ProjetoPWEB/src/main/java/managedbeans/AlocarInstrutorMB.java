package managedbeans;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import entidades.*;
import service.*;

@SessionScoped
@ManagedBean
public class AlocarInstrutorMB {
	private Turma turma;
	private Instrutor instrutor = null;
	private Curso curso = null;
	private TurmaService service = new TurmaService();
	private CursoService cursoService = new  CursoService();
	private InstrutorService instrutorService = new InstrutorService();
	private boolean cursoSelected = false;
	private boolean turmaSelected = true;
	private boolean instrutorSelected = true;
	private boolean disableClean = true;
	private String labelBtn = "Inserir";
	
	public void salvar() {
		service.save(turma);
		service.closeEntityManager();
//		desabilitarEdicao();
	}
	
	public List<Curso> getCursos() {
		List<Curso> lista;
		lista = cursoService.getAll(Curso.class);
		cursoService.closeEntityManager();
		return lista;
	}
	
	public List<Instrutor> getInstrutores() {
		List<Instrutor> lista;
		lista = instrutorService.getAll(Instrutor.class);
		cursoService.closeEntityManager();
		return lista;
	}
	
	public void escolheCurso(ValueChangeEvent e){        
        if (e.getNewValue() == null) {
        	cursoSelected = false;
        	turmaSelected = true;
        	instrutorSelected = true;
        } else {
        	cursoSelected = true;
        	turmaSelected = false;
        }
        getTurmas();
    }
	
	public void escolheTurma(ValueChangeEvent e){        
        if (e.getNewValue() == null) {
        	cursoSelected = true;
        	turmaSelected = false;
        	instrutorSelected = true;
        } else {
        	turmaSelected = true;
        	instrutorSelected = false;
        }
    }
	
	public void escolheInstrutor(ValueChangeEvent e){        
        if (e.getNewValue() == null) {
        	System.out.println("Sem Instrutor");
        } else {
        	System.out.println(e.getNewValue());
        }
    }

	public void limpar() {
		curso = null;
		turma = null;
		instrutor = null;
		cursoSelected = false;
		turmaSelected = true;
		instrutorSelected = true;
	}
	
	public List<Turma> getTurmas() {
		List<Turma> lista;
		lista = service.getAll(Turma.class);
		service.closeEntityManager();
//		lista = lista.stream().filter(turmaF -> turmaF.getSiglaTurma().equals(turma.getSiglaTurma())).;
		if (curso != null)
		{
		System.out.println("Com Curso");
		/*return lista.stream()
				.filter(turmaF -> turmaF.getCurso().equals(turma.getCurso()))
				.collect(Collectors.toList());*/
		} else {
			System.out.println("Sem Curso");
		}
		return lista;
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


	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public String getLabelBtn() {
		return labelBtn;
	}

	public void setLabelBtn(String labelBtn) {
		this.labelBtn = labelBtn;
	}

	public boolean isCursoSelected() {
		return cursoSelected;
	}

	public void setCursoSelected(boolean cursoSelected) {
		this.cursoSelected = cursoSelected;
	}

	public boolean isTurmaSelected() {
		return turmaSelected;
	}

	public void setTurmaSelected(boolean turmaSelected) {
		this.turmaSelected = turmaSelected;
	}

	public boolean isInstrutorSelected() {
		return instrutorSelected;
	}

	public void setInstrutorSelected(boolean instrutorSelected) {
		this.instrutorSelected = instrutorSelected;
	}

	public boolean isDisableClean() {
		return disableClean;
	}

	public void setDisableClean(boolean disableClean) {
		this.disableClean = disableClean;
	}
	
	
}
