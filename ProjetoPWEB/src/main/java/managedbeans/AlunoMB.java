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
	private boolean disbleQuery = false;
	private boolean disbleEdit = true;
	private Aluno buscaAluno = new Aluno();
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
//			System.out.println("CPF não encontrado");
		}
	}

	public void habilitarEdicao() {
		disbleQuery = true;
		disbleEdit = false;
	}

	public void desabilitarEdicao() {
		disbleQuery = false;
		disbleEdit = true;
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
		return disbleQuery;
	}

	public void setDisbleQuery(boolean disbleQuery) {
		this.disbleQuery = disbleQuery;
	}

	public boolean isDisbleEdit() {
		return disbleEdit;
	}

	public void setDisbleEdit(boolean disbleEdit) {
		this.disbleEdit = disbleEdit;
	}

	public String getLabelBtn() {
		return labelBtn;
	}

	public void setLabelBtn(String labelBtn) {
		this.labelBtn = labelBtn;
	}

}
