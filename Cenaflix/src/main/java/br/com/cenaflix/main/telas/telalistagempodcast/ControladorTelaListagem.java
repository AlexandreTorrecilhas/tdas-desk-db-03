/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalistagempodcast;

//Pacotes swing
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carlos.sa
 */
class ControladorTelaListagem {
    
    private PodcastDao podcastDao = new PodcastDao();
    private PodcastEntidade podcastEntidade = new PodcastEntidade();
    private ProdutoraEntidade protudoraEntidade = new ProdutoraEntidade();
    
    public ControladorTelaListagem(){}
    
    public void inserirDezPrimeirosValores(DefaultTableModel modeloTabela){
        modeloTabela.addRow(this.podcastDao.pegarDezValoresIniciais(podcastEntidade, protudoraEntidade).toArray());
    }
    
}
