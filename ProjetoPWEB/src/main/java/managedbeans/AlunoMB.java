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
	private boolean flagConsultar = false;
	private boolean flagInserir = true;
	private boolean flagDeletar = true;
	private boolean flagAlterar = true;
	private boolean flagCancelar = true;
	private boolean flagText = true;
	
	/*public void salvar() {
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
			System.out.println(resultado.getNome());
			aluno = resultado;
			
			} catch (Exception  e) {
				System.out.println("CPF não encontrado");
			}
	}
	
	public Aluno popular() {
		List<Aluno> lista = getAlunos();
		Aluno resultado = new Aluno(null,null);
		try {
			resultado = lista.stream().filter(pessoa -> pessoa.getCpf().equals(aluno.getCpf())).findFirst().get();
		}catch (Exception e) {
			System.out.println("Nao tem aluno");
			return null;
		}
		return resultado;
	}*/
	
	public void consultar() {
		List<Aluno> lista = getAlunos();
		Aluno resultado = new Aluno(null,null);
		try {
			resultado = lista.stream().filter(pessoa -> pessoa.getCpf().equals(aluno.getCpf())).findFirst().get();
			System.out.println(resultado.getCpf());
			System.out.println(resultado.getNome());
			} catch (Exception  e) {
				System.out.println("CPF não encontrado");
			}
		
		if(resultado == null) {
			setFlagConsultar(true);
			setFlagText(false);
			setFlagInserir(false);
			setFlagDeletar(true);
			setFlagAlterar(true);
			setFlagCancelar(false);
			
		}else {
			aluno = resultado;
			setFlagText(false);
			setFlagConsultar(true);
			setFlagInserir(true);
			setFlagDeletar(false);
			setFlagAlterar(false);
			setFlagCancelar(false);
			
		}
	}

	public void salvar() {
	
		service.save(aluno);
		service.closeEntityManager();
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}
	
	public void alterar() {
		service.save(aluno);
		service.closeEntityManager();
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
	}
	
	public void deletar() {
		service.remove(aluno);
		aluno = new Aluno();
		setFlagConsultar(false);
		setFlagInserir(true);
		setFlagDeletar(true);
		setFlagAlterar(true);
		setFlagCancelar(true);
		setFlagText(true);
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

	public boolean isFlagConsultar() {
		return flagConsultar;
	}

	public void setFlagConsultar(boolean flagConsultar) {
		this.flagConsultar = flagConsultar;
	}

	public boolean isFlagInserir() {
		return flagInserir;
	}

	public void setFlagInserir(boolean flagInserir) {
		this.flagInserir = flagInserir;
	}

	public boolean isFlagDeletar() {
		return flagDeletar;
	}

	public void setFlagDeletar(boolean flagDeletar) {
		this.flagDeletar = flagDeletar;
	}

	public boolean isFlagAlterar() {
		return flagAlterar;
	}

	public void setFlagAlterar(boolean flagAlterar) {
		this.flagAlterar = flagAlterar;
	}

	public boolean isFlagCancelar() {
		return flagCancelar;
	}

	public void setFlagCancelar(boolean flagCancelar) {
		this.flagCancelar = flagCancelar;
	}

	public boolean isFlagText() {
		return flagText;
	}

	public void setFlagText(boolean flagText) {
		this.flagText = flagText;
	}

	
}
