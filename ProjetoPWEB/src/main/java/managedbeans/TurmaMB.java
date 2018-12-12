package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import entidades.*;
import service.*;

@SessionScoped
@ManagedBean
public class TurmaMB {
	private Turma turma = new Turma(null,null);
	private Instrutor instrutor = null;
	private Curso curso;
	private TurmaService service = new TurmaService();
	private CursoService cursoService = new  CursoService();
	private boolean selected = false;
	private boolean disableQuery = true;
	private boolean disableEdit = true;
	private Turma buscaTurma = new Turma(null,null);
	private String labelBtn = "Inserir";
	
	public void salvar() {
		service.save(turma);
		service.closeEntityManager();
		turma = new Turma(null,null);
		desabilitarEdicao();
	}
	
	public List<Curso> getCursos() {
		List<Curso> lista;
		lista = cursoService.getAll(Curso.class);
		cursoService.closeEntityManager();
		return lista;
	}
	
	public void consultar() {
		habilitarEdicao();
		buscaTurma = service.getById(Turma.class, turma.getSiglaTurma());
		if (buscaTurma != null) {
			turma = buscaTurma;
			labelBtn = "Alterar";
		} else {
			labelBtn = "Inserir";
		}
	}
	
	public void habilitarEdicao() {
		disableQuery = true;
		disableEdit = false;
	}

	public void desabilitarEdicao() {
		disableQuery = true;
		disableEdit = true;
		selected = false;
		labelBtn = "Inserir";
		curso = null;
	}
	
	public void escolheCurso(ValueChangeEvent e){        
        if (e.getNewValue() == null) {
        	selected = false;
        	disableQuery = true;
        } else {
        	selected = true;
        	disableQuery = false;
        }
    }
	
	public void apagar() {
		service.remove(turma);
		service.closeEntityManager();
		turma = new Turma(null, null);
		desabilitarEdicao();
	}

	public void limpar() {
		turma = new Turma(null, null);
		desabilitarEdicao();
	}
	
	public List<Turma> getTurmas() {
		List<Turma> lista;
		lista = service.getAll(Turma.class);
		service.closeEntityManager();
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

	
	


	public boolean isDisableQuery() {
		return disableQuery;
	}

	public void setDisableQuery(boolean disableQuery) {
		this.disableQuery = disableQuery;
	}

	public boolean isDisableEdit() {
		return disableEdit;
	}

	public void setDisableEdit(boolean disableEdit) {
		this.disableEdit = disableEdit;
	}

	public String getLabelBtn() {
		return labelBtn;
	}


	public void setLabelBtn(String labelBtn) {
		this.labelBtn = labelBtn;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean isSelected) {
		this.selected = isSelected;
	}

	
}
