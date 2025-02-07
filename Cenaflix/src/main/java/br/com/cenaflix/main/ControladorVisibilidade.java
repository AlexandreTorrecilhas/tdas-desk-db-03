/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main;

//Pacotes do Projeto
import br.com.cenaflix.main.telas.LimparFormulario;
import br.com.cenaflix.main.telas.telalogin.JFrameTelaLogin;
import br.com.cenaflix.main.telas.telalistagempodcast.JFrameListagemPodcast;
import br.com.cenaflix.main.telas.telacadastropodcast.JFrameCadastroPodcast;
/**
 *
 * @author carlos.sa
 */
public class ControladorVisibilidade {
    private static final JFrameTelaLogin jFrameTelaLogin = new JFrameTelaLogin();
    private static final JFrameListagemPodcast jFrameListagemPodcast = new JFrameListagemPodcast();
    private static final JFrameCadastroPodcast jFrameCadastroPodcast = new JFrameCadastroPodcast();
    
    public static void mostrarTelaLogin(){
        jFrameTelaLogin.setVisible(true);
    }
    
    public static void fecharTelaLogin(){
        jFrameTelaLogin.dispose();
    }
    
    public static void mostrarTelaListagemPodcast(){
        LimparFormulario.limparFormulario(jFrameListagemPodcast.getMapValoresFormulario());
        jFrameListagemPodcast.setVisible(true);
    }
    
    public static void fecharTelaListagemPodcast(){
        jFrameListagemPodcast.dispose();
    }
    
    public static void mostrarTelaCadastroPodcast(){
        LimparFormulario.limparFormulario(jFrameCadastroPodcast.getMapValoresFormulario());
        jFrameCadastroPodcast.setVisible(true);
    }
    
    public static void fecharTelaCadastroPodcast(){
        jFrameCadastroPodcast.dispose();
    }
}
