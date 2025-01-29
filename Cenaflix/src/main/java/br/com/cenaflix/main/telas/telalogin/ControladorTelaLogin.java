/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalogin;

//Pacotes do projeto
import br.com.cenaflix.main.ControladorVisibilidade;
//Pacotes swing

//Pacotes util

/**
 *
 * @author carlos.sa
 */
class ControladorTelaLogin {
    
    public ControladorTelaLogin(){}
    
    public void consultarLogin(String usuario, char[] senha){
        UsuarioEntidade login = new UsuarioEntidade(usuario, senha.toString());
        boolean usuarioExiste = new UsuarioDao().consultaLogin(login);
        
        if(usuarioExiste){
            ControladorVisibilidade.fecharTelaLogin();
            ControladorVisibilidade.mostrarTelaListagemPodcast();
        }
    }
    
}
