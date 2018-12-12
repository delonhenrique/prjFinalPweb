package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Aluno;
import service.AlunoService;

@ManagedBean
@SessionScoped
public class AlunoMB {
	private Aluno aluno = new Aluno(null, null);
	private AlunoService service = new AlunoService();
	private boolean disableQuery = false;
	private boolean disableEdit = true;
	private Aluno buscaAluno = new Aluno(null,null);
	private String labelBtn = "Inserir";

	public void salvar() {
		service.save(aluno);
		service.closeEntityManager();
		aluno = new Aluno(null, null);
		desabilitarEdicao();
	}

	public void consultar() {
		habilitarEdicao();
		buscaAluno = service.getById(Aluno.class, aluno.getCpf());
		if (buscaAluno != null) {
			aluno = buscaAluno;
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
		service.remove(aluno);
		service.closeEntityManager();
		aluno = new Aluno(null, null);
		desabilitarEdicao();
	}

	public void limpar() {
		aluno = new Aluno(null, null);
		desabilitarEdicao();
	}

	public List<Aluno> getAlunos() {
		List<Aluno> lista;
		lista = service.getAll(Aluno.class);
		service.closeEntityManager();
		return lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public boolean isDisbleQuery() {
		return disableQuery;
	}

	public void setDisbleQuery(boolean disableQuery) {
		this.disableQuery = disableQuery;
	}

	public boolean isDisbleEdit() {
		return disableEdit;
	}

	public void setDisbleEdit(boolean disableEdit) {
		this.disableEdit = disableEdit;
	}

	public String getLabelBtn() {
		return labelBtn;
	}

	public void setLabelBtn(String labelBtn) {
		this.labelBtn = labelBtn;
	}

}
