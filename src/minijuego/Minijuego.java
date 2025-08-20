/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minijuego;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Yair
 */
public class Minijuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame huellaGame=new JFrame("Juego");
        huellaGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dibujo d=new Dibujo();
        huellaGame.add(d);
        huellaGame.pack();
        huellaGame.setVisible(true);   
        huellaGame.setLocationRelativeTo(null);
        
        
        
        
    }
    
}
