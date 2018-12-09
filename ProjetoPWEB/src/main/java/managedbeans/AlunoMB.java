package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Aluno;
import service.AlunoService;

@ManagedBean
@SessionScoped
public class AlunoMB {
	private Aluno aluno = new Aluno(null,null);
	private AlunoService service = new AlunoService();
	
	public void salvar() {
		service.save(aluno);
		service.closeEntityManager();
		aluno = new Aluno(null,null);
	}
	
	public void consultar() {
		List<Aluno> lista = getAlunos();
		Aluno resultado = new Aluno(null,null);
		try {
			resultado = lista.stream().filter(pessoa -> pessoa.getCpf().equals(aluno.getCpf())).findFirst().get();
			System.out.println(resultado.getCpf());
			aluno = resultado;
			} catch (Exception  e) {
				System.out.println("CPF não encontrado");
			}
	}
	
	public List<Aluno> getAlunos() {
		List <Aluno> lista;
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

	
}
