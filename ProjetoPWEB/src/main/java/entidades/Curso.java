package entidades;
import javax.persistence.Entity;
import javax.persistence.Id;

public class Curso {
	@Id
	private String sigla;
	private String nome;
	private int cargaHoraria;
	private double valor;
	private String dataVigencia;
	private double valorHoraInstrutor;
	private String programa;
	
	
	public Curso(String sigla, String nome) {
		super();
		this.sigla = sigla;
		this.nome = nome;
	}
	//gets and setters
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDataVigencia() {
		return dataVigencia;
	}
	public void setDataVigencia(String dataVigencia) {
		this.dataVigencia = dataVigencia;
	}
	public double getValorHoraInstrutor() {
		return valorHoraInstrutor;
	}
	public void setValorHoraInstrutor(double valorHoraInstrutor) {
		this.valorHoraInstrutor = valorHoraInstrutor;
	}
	public String getPrograma() {
		return programa;
	}
	public void setPrograma(String programa) {
		this.programa = programa;
	}
	
}