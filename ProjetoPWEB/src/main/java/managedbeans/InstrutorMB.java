package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Instrutor;
import service.InstrutorService;

@ManagedBean
@SessionScoped
public class InstrutorMB {
	private Instrutor instrutor = new Instrutor();
	private InstrutorService service = new InstrutorService();
	
	public void salvar() {
		service.save(instrutor);
		service.closeEntityManager();
		instrutor = new Instrutor(null,null);
	}
	
	public List<Instrutor> getInstrutores(){
		List <Instrutor> lista;
		lista = service.getAll(Instrutor.class);
		return lista;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}
	
}
