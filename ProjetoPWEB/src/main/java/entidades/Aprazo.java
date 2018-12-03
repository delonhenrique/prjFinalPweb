package entidades;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Aprazo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private double valor;
	private String dtVencimento;
	private double taxaJuros;
	private int qtdeMensalidade;
	
	@ManyToOne
	@JoinColumn(name="id_matricula")
	private Matricula matricula;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(String dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public double getTaxaJuros() {
		return taxaJuros;
	}
	public void setTaxaJuros(double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	public int getQtdeMensalidade() {
		return qtdeMensalidade;
	}
	public void setQtdeMensalidade(int qtdeMensalidade) {
		this.qtdeMensalidade = qtdeMensalidade;
	}
	public Matricula getMatricula() {
		return matricula;
	}
	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	

	
}
