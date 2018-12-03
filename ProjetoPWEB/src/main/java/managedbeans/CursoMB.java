package managedbeans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.Curso;
import service.CursoService;

@ManagedBean
@SessionScoped
public class CursoMB {

	private Curso curso = new Curso(null,null);
	private CursoService service = new CursoService();
	
	public void salvar() {
		service.save(curso);
		service.closeEntityManager();
		curso = new Curso(null,null);
	}
	
	public List<Curso> getCursos() {
		List <Curso> lista;
		lista = service.getAll(Curso.class);
		service.closeEntityManager();
		return lista;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
