package entidades;
import java.util.ArrayList;


public class Instrutor extends Pessoa {

	private ArrayList <Turma> turmas;
	private String formacao;
	private String areaAtuacao;
	
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
