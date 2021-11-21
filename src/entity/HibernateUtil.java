package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ezandro Bueno
 */
public class HibernateUtil {

    private static EntityManagerFactory instancia;
    private static EntityManager manager;
    private static final String NOME_BANCO_DADOS = "agenda" ;
    
    private HibernateUtil() {
    }
        
    private static EntityManagerFactory getFactory() {
        if (instancia == null) {
           instancia = Persistence.createEntityManagerFactory(NOME_BANCO_DADOS);
        }
        return instancia;
    }
    
    public static EntityManager getManager() {
        if (manager == null || !manager.isOpen()) {
           manager = getFactory().createEntityManager();
        }
        return manager;
    }
}
