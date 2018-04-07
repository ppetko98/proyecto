/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Tamara
 */
public class Panel extends JPanel{
    public Image imagenFondo;
    public URL fondo;

    public Panel() {
        fondo = this.getClass().getResource("src/testImages/fondo swing.jpg");
        imagenFondo = new ImageIcon(fondo).getImage();
    
   /* @Override
        public void paintComponent(Graphics g){
        g.drawImage(imagenFondo, 0 , 0,getWidth(),getHeight(), null);
        }*/
    }
    
    } 

