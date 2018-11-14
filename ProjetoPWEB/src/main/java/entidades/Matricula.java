package entidades;

import java.util.ArrayList;

public class Matricula {

	private String data;
	private int qtdeFaltas;
	private double nota;
	private ArrayList <Avista> avista;
	private ArrayList <Aprazo> aprazo;
	private Turma turma;
	
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

}
