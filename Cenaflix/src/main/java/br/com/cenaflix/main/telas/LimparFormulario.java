/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas;

//Pacotes Swing
import javax.swing.JTextField;
//Pacotes util
import java.util.Map;
import java.util.LinkedHashMap;

/**
 *
 * @author carlo
 */
public class LimparFormulario {
        
    public LimparFormulario(){}
    
    public static void limparFormulario(LinkedHashMap<String, JTextField> camposParaLimpar){
        for(Map.Entry<String, JTextField> entry: camposParaLimpar.entrySet()){
            camposParaLimpar.get(entry.getKey()).setText("");
        }
    }
}
