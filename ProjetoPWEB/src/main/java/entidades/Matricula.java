package entidades;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Matricula implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String data;
	private int qtdeFaltas;
	private double nota;
	//1
	@OneToMany
	@JoinColumn(name="id_avista")
	private ArrayList <Avista> avista;
	//2
	@OneToMany
	@JoinColumn(name="id_aprazo")
	private ArrayList <Aprazo> aprazo;
	//3
	@ManyToOne
	private Turma turma;
	//4
	@OneToOne
	@JoinColumn(name="id_aluno")
	private Aluno aluno;
	
	
	public Matricula() {
		super();
	}

	public Matricula(String data) {
		this.data = data;
		avista = new ArrayList<Avista>();
		aprazo = new ArrayList<Aprazo>();
	}
	
    public void addAvista(Avista av){
        avista.add(av);
        av.setMatricula(this);
    }
    
    public void addAprazo (Aprazo ap){
        aprazo.add(ap);
        ap.setMatricula(this);
    }

	public int getQtdeFaltas() {
		return qtdeFaltas;
	}

	public void setQtdeFaltas(int qtdeFaltas) {
		this.qtdeFaltas = qtdeFaltas;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
