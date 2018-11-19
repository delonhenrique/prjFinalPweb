package entidades;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value="Instru")
public class Instrutor extends Pessoa implements Serializable {

	private ArrayList <Turma> turmas;
	private String formacao;
	private String areaAtuacao;
	private static final long serialVersionUID = 1L;
	
	public Instrutor(String cpf, String nome) {
		super(cpf, nome);
		turmas = new ArrayList<Turma>();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Turma> getTurmas() {
		return turmas;
	}

	public void addTurma(Turma t) {
		turmas.add(t);
		t.setInstrutor(this);
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	
	
}
