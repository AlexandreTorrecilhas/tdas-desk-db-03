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
    
    public ControladorTelaListagem(){}
    
    public void inserirDezPrimeirosValores(DefaultTableModel modeloTabela){
        System.out.println("Entrei inserirDezPrimeirosValores");
        modeloTabela.addRow(this.podcastDao.pegarDezValoresIniciais().toArray());
    }
    
}
