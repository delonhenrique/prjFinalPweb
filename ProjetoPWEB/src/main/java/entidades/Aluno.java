package entidades;

import java.io.Serializable;

import javax.persistence.*;


@DiscriminatorValue(value="Aluno")
@Entity
public class Aluno extends Pessoa implements Serializable {

	private String escolaridade;
	
	@OneToOne
	@JoinColumn(name="id_matricula")
	private Matricula matricula;
	
	
	private static final long serialVersionUID = 1L;
	
	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}


	public Aluno() {
		super();
	}


	public Aluno(String cpf, String nome) {
		super(cpf, nome);
	}


	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
}
