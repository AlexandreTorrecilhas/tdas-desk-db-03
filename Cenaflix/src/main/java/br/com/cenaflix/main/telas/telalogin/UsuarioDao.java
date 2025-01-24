
package br.com.cenaflix.main.telas.telalogin;

//Pacotes do Projeto
import br.com.cenaflix.fabrica.JPAUtil;
//Pacotes jakarta
import jakarta.persistence.EntityManager;


/**
 *
 * @author carlos.sa
 */
class UsuarioDao {
    
    /** 
     * O valor do EntityManager é inicializado
     */
    private EntityManager em = JPAUtil.getEntityManager();
    private UsuarioModelo login;
    
    public UsuarioDao(){
    
    }
    
    public boolean consultaLogin(UsuarioModelo login){
        
        return false;
    }
}
