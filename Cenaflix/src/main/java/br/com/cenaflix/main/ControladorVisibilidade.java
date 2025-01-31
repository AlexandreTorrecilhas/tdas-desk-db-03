/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main;

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
        jFrameListagemPodcast.setVisible(true);
    }
    
    public static void fecharTelaListagemPodcast(){
        jFrameListagemPodcast.setVisible(false);
    }
    
    public static void mostrarTelaCadastroPodcast(){
        jFrameCadastroPodcast.setVisible(true);
    }
    
    public static void fecharTelaCadastroPodcast(){
        jFrameCadastroPodcast.setVisible(false);
    }
}
