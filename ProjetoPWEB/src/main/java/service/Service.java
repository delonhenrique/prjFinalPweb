package service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public abstract class Service <T, I extends Serializable> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public Service() {
		emf = Persistence.createEntityManagerFactory("ProjetoPWEB");
	}
	
	public T save(T entity) {
		T saved = null;
		
		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}
	public void remove(T entity) {
		getEntityManager().getTransaction().begin();
		getEntityManager().remove(entity);
		getEntityManager().getTransaction().commit();

	}


	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery("select o from " 
		+ classe.getSimpleName() + " o").getResultList();
	}
//ola mundo

	public EntityManager getEntityManager() {
	  
	 if(em == null)
	 	em = emf.createEntityManager();
	  
	 
	  return em;
	}
	

	public void closeEntityManager(){
		
		if(em != null)
			em.close();
		
		em = null;
	}
}
