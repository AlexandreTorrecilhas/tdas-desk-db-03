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
    private int id_podcast;
    
    @ManyToOne
    @JoinColumn(name = "id_produtora")
    private ProdutoraEntidade nomeProdutora;
    
    @Column(name = "nome_episodio")
    private String nomeEpisodio;
    
    @Column(name = "qtd_episodio")
    private short qtdEpisodio;
    
    @Column(name = "duracao")
    private short duracao;

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

    public void setQtdEpisodio(short qtdEpisodio) {
        this.qtdEpisodio = qtdEpisodio;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(short producao) {
        this.duracao = producao;
    }
    
    
}
