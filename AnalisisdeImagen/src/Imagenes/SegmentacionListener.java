package Imagenes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
/**
 *
 * @author Alumno
 */
public class SegmentacionListener implements ActionListener{
        
      private JFrameSegmentacion frame;
        public SegmentacionListener(JFrameSegmentacion frame){
            this.frame=frame;
        }
        
        public void actionPerformed(ActionEvent e){
            int u1 = this.frame.getJSliderU1().getValue();
            int u2 = this.frame.getJSliderU2().getValue();
            Image res = FiltrosEspaciales.
            segmentarImagen(this.frame.getImagenEscalada(), u1, u2);
            this.frame.getLableImagen().setIcon(new ImageIcon(res));
        }
}
