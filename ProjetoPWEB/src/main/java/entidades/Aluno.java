package entidades;

public class Aluno extends Pessoa {

	private String escolaridade;
	private Matricula matricula;
	
	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


	public Aluno(String cpf, String nome) {
		super(cpf, nome);
		// TODO Auto-generated constructor stub
	}


	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
}
