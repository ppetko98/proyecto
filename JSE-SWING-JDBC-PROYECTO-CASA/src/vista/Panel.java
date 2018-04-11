package vista;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Tamara
 */
public class Panel extends JPanel {

    public Image imagenFondo;
    public URL fondo;

    public Panel() {
        fondo = this.getClass().getResource("src/testImages/fondo swing.jpg");
        imagenFondo = new ImageIcon(fondo).getImage();
    }

}
