package entidades;

public class Aprazo {

	private double valor;
	private String dtVencimento;
	private double taxaJuros;
	private int qtdeMensalidade;
	private Matricula matricula;
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
