/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalistagempodcast;

//Pacotes projeto
import br.com.cenaflix.fabrica.JPAUtil;
//Pacotes util
import java.util.List;
//Pacotes jakarta
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
/**
 *
 * @author carlos.sa
 */
class PodcastDao {
    
    private final EntityManager em = JPAUtil.getEntityManager();
    
    public PodcastDao(){}
    
    public List<Object[]> pegarDezValoresIniciais(){
        Query getDezValoresIniciais = this.em.createQuery("SELECT pod.id_podcast, pro.nomeProdutora, pod.nomeEpisodio, pod.qtdEpisodio, "
                + "pod.duracao FROM PodcastEntidade pod "
                + "JOIN pod.nomeProdutora pro");
        
        List<Object[]> resultado = getDezValoresIniciais.getResultList();
        
        return resultado;
    }

    public List<Object[]> getFilmePeloProdutor(String nomeProdutora){
        Query getFilmeProdutor = this.em.createQuery("SELECT pod.id_podcast, pro.nomeProdutora, pod.nomeEpisodio, pod.qtdEpisodio "
                + "FROM PodcastEntidade pod "
                + "JOIN pod.nomeProdutora pro "
                + "WHERE (:nomeProdutora IS NULL OR pro.nomeProdutora LIKE :nomeProdutora)");
        
        if(nomeProdutora != null){
            getFilmeProdutor.setParameter("nomeProdutora", "%" + nomeProdutora + "%");
        }else{
            getFilmeProdutor.setParameter("nomeProdutora", null);
            getFilmeProdutor.setMaxResults(10);
        }
        
        List<Object[]> resultado = getFilmeProdutor.getResultList();
        
        return resultado;
    }
    
    
    
}
