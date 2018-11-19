package entidades;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value="Alun")
public class Aluno extends Pessoa implements Serializable {

	private String escolaridade;
	private Matricula matricula;
	private static final long serialVersionUID = 1L;
	
	public Matricula getMatricula() {
		return matricula;
	}


	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
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
