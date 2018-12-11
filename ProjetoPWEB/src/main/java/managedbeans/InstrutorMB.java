package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Instrutor;
import service.InstrutorService;

@ManagedBean
@SessionScoped
public class InstrutorMB {
	private Instrutor instrutor = new Instrutor(null,null);
	private InstrutorService service = new InstrutorService();
	private boolean disbleQuery = false;
	private boolean disbleEdit = true;
	private Instrutor buscaInstrutor = new Instrutor(null,null);
	private String labelBtn = "Inserir";
	
	public void salvar() {
		service.save(instrutor);
		service.closeEntityManager();
		instrutor = new Instrutor(null,null);
		desabilitarEdicao();
	}
	
	public void consultar() {
		habilitarEdicao();
		buscaInstrutor = service.getById(Instrutor.class, instrutor.getCpf());
		if (buscaInstrutor != null) {
			instrutor = buscaInstrutor;
			labelBtn = "Alterar";
		} else {
			labelBtn = "Inserir";
		}
	}
	
	public void habilitarEdicao() {
		disbleQuery = true;
		disbleEdit = false;
	}

	public void desabilitarEdicao() {
		disbleQuery = false;
		disbleEdit = true;
		labelBtn = "Inserir";
	}
	
	public void apagar() {
		service.remove(instrutor);
		service.closeEntityManager();
		instrutor = new Instrutor(null, null);
		desabilitarEdicao();
	}
	
	public void limpar() {
		instrutor = new Instrutor(null, null);
		desabilitarEdicao();
	}
	
	public List<Instrutor> getInstrutores(){
		List <Instrutor> lista;
		lista = service.getAll(Instrutor.class);
		service.closeEntityManager();
		return lista;
	}

	public Instrutor getInstrutor() {
		return instrutor;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public boolean isDisbleQuery() {
		return disbleQuery;
	}

	public void setDisbleQuery(boolean disbleQuery) {
		this.disbleQuery = disbleQuery;
	}

	public boolean isDisbleEdit() {
		return disbleEdit;
	}

	public void setDisbleEdit(boolean disbleEdit) {
		this.disbleEdit = disbleEdit;
	}

	public Instrutor getBuscaInstrutor() {
		return buscaInstrutor;
	}

	public void setBuscaInstrutor(Instrutor buscaInstrutor) {
		this.buscaInstrutor = buscaInstrutor;
	}

	public String getLabelBtn() {
		return labelBtn;
	}

	public void setLabelBtn(String labelBtn) {
		this.labelBtn = labelBtn;
	}
	
	
}
