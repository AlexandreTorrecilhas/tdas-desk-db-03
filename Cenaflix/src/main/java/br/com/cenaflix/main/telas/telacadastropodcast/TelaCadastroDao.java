/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telacadastropodcast;

//Pacotes do projeto
import br.com.cenaflix.fabrica.JPAUtil;
import br.com.cenaflix.main.telas.telalistagempodcast.PodcastEntidade;
import br.com.cenaflix.main.telas.telalistagempodcast.ProdutoraEntidade;
//Pacotes jakarta
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.NoResultException;
import javax.swing.JOptionPane;
//Pacotes swing
import javax.swing.JTextField;
//Pacotes util
import java.util.LinkedHashMap;

/**
 *
 * @author carlos.sa
 */
class TelaCadastroDao {
    
    private final EntityManager em = JPAUtil.getEntityManager();
    private PodcastEntidade podcastEntidade = new PodcastEntidade();
    private ProdutoraEntidade produtoraEntidade = new ProdutoraEntidade();
    private LinkedHashMap<String, JTextField> mapValoresFormulario = new LinkedHashMap();
    
    public TelaCadastroDao(LinkedHashMap<String, JTextField> mapValoresFormulario){
        this.mapValoresFormulario = mapValoresFormulario;
        
    }
    
    public void cadastrarProdutora(){
        
        try{
            TypedQuery<ProdutoraEntidade> queryProdutora = this.em.createQuery("SELECT pro FROM ProdutoraEntidade pro "
                + "WHERE pro.nomeProdutora LIKE :nomeProdutora", ProdutoraEntidade.class);
        
            queryProdutora.setParameter("nomeProdutora", "%" + this.mapValoresFormulario.get("nomeProdutora").getText() + "%");
            this.produtoraEntidade = queryProdutora.getSingleResult();
            this.inserirValorNoBanco();
        }catch(NoResultException e){
            JOptionPane.showMessageDialog(null, "O produtor informando não está cadastrado");
            System.out.println("Classe: CriarPodcast/Método: findProdutora()/Erro: " + e.getMessage());
        }
    }
    
    private void inserirValorNoBanco(){
        try{
            this.podcastEntidade.setNomeProdutora(this.produtoraEntidade);
            this.podcastEntidade.setNomeEpisodio(this.mapValoresFormulario.get("nomeEpisodio").getText());
            this.podcastEntidade.setQtdEpisodio(Short.parseShort(this.mapValoresFormulario.get("qtdEpisodio").getText()));
            this.podcastEntidade.setDuracao(Short.parseShort(this.mapValoresFormulario.get("duracao").getText()));
        
            this.em.getTransaction().begin();
            this.em.persist(this.podcastEntidade);
            this.em.getTransaction().commit();
        }catch(Exception e){
            this.em.getTransaction().rollback();
            System.out.println("Classe: CriarPodcast/Método: cadastrarProdutora/Erro: " + e.getMessage());
        }
    }
    
}
