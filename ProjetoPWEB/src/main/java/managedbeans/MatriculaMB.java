package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




@ManagedBean
@SessionScoped
public class MatriculaMB {
	
	private String pagamento;
	private boolean mostrar = true;
	private boolean mostrar2 = false;
	
	
	
	
	public String getPagamento() {
		return pagamento;
	}




	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}




	public boolean isMostrar() {
		return mostrar;
	}




	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}




	public boolean isMostrar2() {
		return mostrar2;
	}




	public void setMostrar2(boolean mostrar2) {
		this.mostrar2 = mostrar2;
	}




	public void show() {
		
		if (pagamento == "À vista") {
			mostrar = true;
			mostrar2 = false;
		} else {
			mostrar = false;
			mostrar2 = true;
		}
	}
}