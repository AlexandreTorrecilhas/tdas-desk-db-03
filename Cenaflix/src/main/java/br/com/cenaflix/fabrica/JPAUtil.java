package br.com.cenaflix.fabrica;

//Pacotes Jakartas
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPAUtil {
    
    private static final String PERSISTENCE_UNIT = "Cenaflix";
    private static EntityManagerFactory cenaflixFabrica;
    private static EntityManager em;
    
    public static EntityManager getEntityManager(){
        if(cenaflixFabrica == null || !cenaflixFabrica.isOpen()){
            cenaflixFabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        if(em == null || !em.isOpen()){
            em = cenaflixFabrica.createEntityManager();
        }
        
        return em;
    }
    
    public static void closeEntityManager(){
        if(em != null && em.isOpen()){
            em.close();
            cenaflixFabrica.close();
        }
    }
}
