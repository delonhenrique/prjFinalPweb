package entidades;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value="Instru")
public class Instrutor extends Pessoa implements Serializable {


	private String formacao;
	private String areaAtuacao;
	private static final long serialVersionUID = 1L;
	
	
	@OneToMany
	@JoinColumn(name="id_instrutor") // o Lador forte
	private ArrayList <Turma> turmas;
	
	
	public Instrutor() {
		super();
	}

	public Instrutor(String cpf, String nome) {
		super(cpf, nome);
		turmas = new ArrayList<Turma>();
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrutor other = (Instrutor) obj;
		if (getCpf() == null) {
			if (other.getCpf() != null)
				return false;
		} else if (!getCpf().equals(other.getCpf()))
			return false;
		return true;
	}
	
}
