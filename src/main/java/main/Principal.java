/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import view.AdministracaoView;
import view.AtendimentoView;

/**
 *
 * @author Lucas
 */
public class Principal {
    
    public static void main(String[] args) {
        AdministracaoView administracaoView = new AdministracaoView();
        administracaoView.setVisible(true);
        
        AtendimentoView atendimentoView = new AtendimentoView();
        atendimentoView.setVisible(true);

    }
}
