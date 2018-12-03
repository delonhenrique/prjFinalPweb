package entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Avista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double valor;
	private int agencia;
	private int nCheque;
	private String preData;
	
	
	@ManyToOne
	@JoinColumn(name="id_matricula")
	private Matricula matricula;
	
	
	
    public Matricula getMatricula() {
		return matricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getnCheque() {
		return nCheque;
	}
	public void setnCheque(int nCheque) {
		this.nCheque = nCheque;
	}
	public String getPreData() {
		return preData;
	}
	public void setPreData(String preData) {
		this.preData = preData;
	}
	
}
