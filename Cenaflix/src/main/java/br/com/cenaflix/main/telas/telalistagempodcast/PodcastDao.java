/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cenaflix.main.telas.telalistagempodcast;

//Pacotes projeto
import br.com.cenaflix.fabrica.JPAUtil;
//Pacotes jakarta
import jakarta.persistence.EntityManager;
/**
 *
 * @author carlos.sa
 */
public class PodcastDao {
    EntityManager em = JPAUtil.getEntityManager();
}
