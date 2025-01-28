/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalistagempodcast;

//Pacotes jakarta
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/**
 *
 * @author carlos.sa
 */
@Entity
@Table(name = "podcast")
public class PodcastEntidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pocast;
    
    @ManyToOne
    @JoinColumn(name = "id_produtora")
    private ProdutoraEntidade nomeProdutora;
    
    @Column(name = "nome_episodio")
    private String nomeEpisodio;
    
    @Column(name = "qtd_episodio")
    private int qtdEpisodio;
    
    @Column(name = "duracao")
    private int producao;

    public ProdutoraEntidade getNomeProdutora() {
        return nomeProdutora;
    }

    public void setNomeProdutora(ProdutoraEntidade nomeProdutora) {
        this.nomeProdutora = nomeProdutora;
    }

    public String getNomeEpisodio() {
        return nomeEpisodio;
    }

    public void setNomeEpisodio(String nomeEpisodio) {
        this.nomeEpisodio = nomeEpisodio;
    }

    public int getQtdEpisodio() {
        return qtdEpisodio;
    }

    public void setQtdEpisodio(int qtdEpisodio) {
        this.qtdEpisodio = qtdEpisodio;
    }

    public int getProducao() {
        return producao;
    }

    public void setProducao(int producao) {
        this.producao = producao;
    }
    
    
}
