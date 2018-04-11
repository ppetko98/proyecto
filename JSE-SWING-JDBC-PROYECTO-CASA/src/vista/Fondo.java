package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondo extends JPanel {

    private Image background;

    @Override
    public void paintComponent(Graphics g) {

        int width = this.getSize().width;
        int height = this.getSize().height;

        if (this.background != null) {
            g.drawImage(this.background, 0, 0, width, height, null);
        }
        super.paintComponent(g);
    }

    public void setBackground(String pathImagen) {
        this.setOpaque(false);
        this.background = new ImageIcon(pathImagen).getImage();

        repaint();
    }
}
