package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.Aluno;
import entidades.Curso;
import service.CursoService;

@ManagedBean
@SessionScoped
public class CursoMB {
	private Curso curso = new Curso(null,null);
	private CursoService service = new CursoService();
	private boolean disableQuery = false;
	private boolean disableEdit = true;
	private Curso buscaCurso = new Curso(null, null);
	private String labelBtn = "Inserir";
	
	public void salvar() {
		service.save(curso);
		service.closeEntityManager();
		curso = new Curso(null,null);
		desabilitarEdicao();
	}
	
	public void consultar() {
		habilitarEdicao();
		buscaCurso = service.getById(Curso.class, curso.getSigla());
		if (buscaCurso != null) {
			curso = buscaCurso;
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
		disableQuery = false;
		disableEdit = true;
		labelBtn = "Inserir";
	}
	
	public void apagar() {
		service.remove(curso);
		service.closeEntityManager();
		curso = new Curso(null, null);
		desabilitarEdicao();
	}

	public void limpar() {
		curso = new Curso(null, null);
		desabilitarEdicao();
	}
	
	public List<Curso> getCursos() {
		List <Curso> lista;
		lista = service.getAll(Curso.class);
		service.closeEntityManager();
		return lista;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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

	public Curso getBuscaCurso() {
		return buscaCurso;
	}

	public void setBuscaCurso(Curso buscaCurso) {
		this.buscaCurso = buscaCurso;
	}

	public String getLabelBtn() {
		return labelBtn;
	}

	public void setLabelBtn(String labelBtn) {
		this.labelBtn = labelBtn;
	}
	
	
	
}
