package managedbeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Turma;
import service.TurmaService;

@SessionScoped
@ManagedBean
public class TurmaMB {
	private Turma turma = new Turma(null,null);
	private TurmaService service = new TurmaService();
	
	public void salvar() {
		service.save(turma);
		service.closeEntityManager();
		turma = new Turma(null,null);
	}
	
	public List<Turma> getTurmas() {
		List <Turma> lista;
		lista = service.getAll(Turma.class);
		service.closeEntityManager();
		return lista;
	}
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}
