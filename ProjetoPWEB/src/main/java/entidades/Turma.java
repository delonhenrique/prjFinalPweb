package entidades;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Turma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String siglaTurma;
	private String descricao;
	private String dataInicio;
	private String dataTermino;
	private String periodo;
	private int qtdeVagas;
	private String observacoes;
  
	@OneToMany
	@JoinColumn(name="id_turma")
	private ArrayList<Matricula> matriculas;
        
    @ManyToOne
    private Curso curso;
    
	@OneToOne
    private Instrutor instrutor;
    
	
    public Turma() {
		super();
	}
    
	public Turma(String siglaTurma, String descricao) {
		this.siglaTurma = siglaTurma;
		this.descricao = descricao;
		matriculas = new ArrayList<Matricula>();
	}

	public String getSiglaTurma() {
		return siglaTurma;
	}

	public void setSiglaTurma(String siglaTurma) {
		this.siglaTurma = siglaTurma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public int getQtdeVagas() {
		return qtdeVagas;
	}



	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
    public void addMatricula(Matricula m){
        matriculas.add(m);
        m.setTurma(this);
    }

	public void setQtdeVagas(int qtdeVagas) {
		this.qtdeVagas = qtdeVagas;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (siglaTurma == null) {
			if (other.siglaTurma != null)
				return false;
		} else if (!siglaTurma.equals(other.siglaTurma))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((siglaTurma == null) ? 0 : siglaTurma.hashCode());
		return result;
	}
}
