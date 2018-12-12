package service;

import java.util.List;

import entidades.Instrutor;

public class InstrutorService extends Service<Instrutor, String>{

	public List<Instrutor> getInstrutores() {
		List <Instrutor> lista;
		lista = getAll(Instrutor.class);
		closeEntityManager();
		return lista;
	}

}
