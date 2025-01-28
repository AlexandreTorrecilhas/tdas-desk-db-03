/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalistagempodcast;

//Pacotes util
import java.util.List;
//Pacotes jakarta
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

/**
 *
 * @author carlos.sa
 */

@Entity
@Table (name = "produtora")
public class ProdutoraEntidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produtora;
    
    @Column(name = "nome_produtora")
    private String nomeProdutora;
    
    @OneToMany(mappedBy = "produtora")
    private List<PodcastEntidade> podcast; 
    
}
