/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalistagempodcast;

//Pacotes swing
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
//Pacotes util
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author carlos.sa
 */
class ControladorTelaListagem {
    
    private PodcastDao podcastDao = new PodcastDao();
    private List<Object[]> resultado;
    private DefaultTableModel modeloTabela;
            
    public ControladorTelaListagem(DefaultTableModel modeloTabela){
        this.modeloTabela = modeloTabela;
    }
    
    public void inserirDezPrimeirosValores(){
        this.resultado = this.podcastDao.pegarDezValoresIniciais();
        this.inserirValoresNaTabela(this.resultado);
    }
    
    public void getFilmePeloNomeDaProdutora(JTextField txtNomeProdutora){
        this.resultado = this.podcastDao.getFilmePeloProdutor(txtNomeProdutora.getText());
        this.inserirValoresNaTabela(resultado);
    }
    
    private void inserirValoresNaTabela(List<Object[]> resultado){
        
        this.modeloTabela.setNumRows(0);
        
        JOptionPane.showMessageDialog(null, resultado.toArray().length);
        
        for(Object[] valor : resultado){
            System.out.println(valor);
            modeloTabela.addRow(valor);
        }
    }
    
}   
