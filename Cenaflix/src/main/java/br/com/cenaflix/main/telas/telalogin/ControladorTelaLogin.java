/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalogin;

//Pacotes swing

//Pacotes util

/**
 *
 * @author carlos.sa
 */
class ControladorTelaLogin {
    
    public ControladorTelaLogin(){}
    
    public void consultarLogin(String usuario, char[] senha){
        UsuarioModelo login = new UsuarioModelo(usuario, senha.toString());
        boolean usuarioExiste = new UsuarioDao().consultaLogin(login);
        
        if(usuarioExiste){
            System.out.println("Funcionou======");
        }
    }
    
}
