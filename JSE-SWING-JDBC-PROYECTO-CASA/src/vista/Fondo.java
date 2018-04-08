/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Fondo extends JPanel{
    
    private Image background;

  

   

   
    
    public void paintComponent (Graphics g){
        
        int width = this.getSize().width;
        int height = this.getSize().height;
        
        if (this.background != null){
        g.drawImage(this.background, 0,0, width,height,null);
        }
        super.paintComponent(g);
    }
    
    public void setBackground(String pathImagen){
    this.setOpaque(false);
    this.background = new ImageIcon(pathImagen).getImage();
        
    repaint();
    }
    //"./src/testImages/Imagene1.jpg"
    
}
