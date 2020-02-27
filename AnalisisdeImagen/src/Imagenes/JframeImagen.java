/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Davila
 */
public class JframeImagen extends JFrame {
    
    private Image imagenoriginal;
    
    JframeImagen(Image aux){
        
        this.imagenoriginal=aux;
        JLabel etiqueta = new JLabel();
        etiqueta.setIcon(new ImageIcon(this.imagenoriginal));
        add(etiqueta);
        setSize(this.imagenoriginal.getWidth(null),this.imagenoriginal.getHeight(null));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public Image getImagenOriginal(){
        return this.imagenoriginal;
    
    }
    
    public void setImagenOriginal(Image aux){
        this.imagenoriginal=aux;
    
    }
}
