package utilidades;

import javax.swing.*;

public interface BaseSwing {
    static JFrame crear(String titulo, int anchura, int altura, boolean resizable, boolean centerOnScreen) {
        JFrame app = new JFrame(titulo);
        app.setSize(anchura, altura);
        app.setDefaultCloseOperation(3);
        if (centerOnScreen) {
            app.setLocationRelativeTo(null);
        } else {
            app.setLocationByPlatform(true);
        }

        app.setResizable(resizable);
        //app.setLocationByPlatform(true);
        return app;
    }
}
