
package br.com.cenaflix.main.telas.telalogin;

//Pacotes do Projeto
import br.com.cenaflix.fabrica.JPAUtil;
//Pacotes jakarta
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.NoResultException;
import javax.swing.JOptionPane;


/**
 *
 * @author carlos.sa
 */
class UsuarioDao {
    
    private final String consultaPeloLogin = "SELECT u.login FROM UsuarioEntidade AS u WHERE u.login = :login";
    
    /** 
     * O valor do EntityManager é inicializado
     */
    private EntityManager em = JPAUtil.getEntityManager();
    Object login;
    
    public UsuarioDao(){
    
    }
    
    public boolean consultaLogin(UsuarioEntidade login){
        try{
            this.login = em.createQuery(consultaPeloLogin)
                    .setParameter("login", login.getLogin())
                    .getSingleResult();
            
            if(this.login != null){
                JOptionPane.showMessageDialog(null, "Usuário localizado");
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Usuário informado não foi localizado");
                return false;
            }
            
        }catch(NoResultException nenhumResultado){
            JOptionPane.showMessageDialog(null, "Usuário informado não existe");
            System.out.println("Classe: UsuarioDao/Método: consultaLogin/Erro: " + nenhumResultado.getMessage());
            return false;
        }
    }
}
