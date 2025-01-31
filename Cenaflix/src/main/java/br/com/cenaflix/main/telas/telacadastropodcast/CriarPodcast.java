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

/**
 *
 * @author carlos.sa
 */
class CriarPodcast {
    
    private PodcastEntidade podcastEntidade = new PodcastEntidade();
    private ProdutoraEntidade produtoraEntidade = new ProdutoraEntidade();
    private EntityManager em = JPAUtil.getEntityManager();
    
    public CriarPodcast(String nomeEpisodio, String nomeProdutor, short quantidadeEpisodios, short duracao){
        this.findProdutora(nomeProdutor);
        
    }
    
    private void findProdutora(String nomeProdutora){
        
        try{
            TypedQuery<ProdutoraEntidade> queryProdutora = this.em.createQuery("SELECT pro FROM ProdutoraEntidade pro "
                + "WHERE pro.nomeProdutora LIKE :nomeProdutora", ProdutoraEntidade.class);
        
            queryProdutora.setParameter("nomeProdutora", nomeProdutora);
            this.produtoraEntidade = queryProdutora.getSingleResult();
        }catch(NoResultException e){
            System.out.println("Classe: CriarPodcast/Método: findProdutora()/Erro: " + e.getMessage());
        }
    }
    
    
    
}
