/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telacadastropodcast;

//Pacotes swing
import javax.swing.JTextField;
//Pacotes util
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
class ValidacaoCadastroPodcast {
    
    private final String[] mensagemValidacao = {"Por favor, informe um nome para produtora", 
    "Por favor, informe o nome do podcast", 
    "Por favor, informe o número do episódio",
    "Por favor, informe a quantidade de minutos do episódio (Somente número)"};
    
    private final LinkedHashMap<String, String> validacaoCadastroPoscast = new LinkedHashMap();
    
    public ValidacaoCadastroPodcast(){
        this.setValidacaoCadastroPodcast();
    }
    
    private void setValidacaoCadastroPodcast(){
        this.validacaoCadastroPoscast.put("nomeProdutoraPodcast", "^(\\D|\\D\\s\\D)+$");
        this.validacaoCadastroPoscast.put("nomePodcast", "^(\\D|\\D\\s\\D)+$");
        this.validacaoCadastroPoscast.put("numeroEpisodio", "^(\\d)+$");
        this.validacaoCadastroPoscast.put("duracaoEpisodio", "^(\\d)+$");
    }
    
    public boolean validacaoCadstroPodcast(LinkedHashMap<String, JTextField> valoresParaValidar){
        
        int contador = 0;
        
        for(Map.Entry<String, JTextField> entry: valoresParaValidar.entrySet()){
            String chave = entry.getKey();
            String valorParaValidar = entry.getValue().getText().trim();
            
            if(!Pattern.matches(this.validacaoCadastroPoscast.get(chave), valorParaValidar)){
                JOptionPane.showMessageDialog(null, this.mensagemValidacao[contador]);
                return false;
            }
            contador++;
        }
        return true;
    }
}
