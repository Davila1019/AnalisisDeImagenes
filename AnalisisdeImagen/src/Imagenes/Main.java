/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//investigar e implementar un control de iluminacion y temperatura
package Imagenes;
import java.awt.Image;

/**
 *
 * @author Davila
 */
public class Main {
    
    public static void main(String[] args){
        Image imagen = AbrirImagen.openImage();
        JframeImagen frame1 = new JframeImagen(imagen);
        EscaneoRGB aux;   
        aux = new EscaneoRGB(imagen);
        aux.graficarHistograma();
        Image imagenExpansionLineal = FiltrosEspaciales.expansionLineal(aux, imagen);
        JframeImagen frame2 = new JframeImagen(imagenExpansionLineal);
        aux= new EscaneoRGB(imagenExpansionLineal);
        aux.graficarHistograma();
        Image imagenExpansionExpon = FiltrosEspaciales.expansionExponencial(imagen, .45);
        JframeImagen frame3 = new JframeImagen(imagenExpansionExpon);
        aux= new EscaneoRGB(imagenExpansionExpon);
        aux.graficarHistograma();
        Image imagenExpansionLog = FiltrosEspaciales.expansionLogartmica(imagen);
        JframeImagen frame4 = new JframeImagen(imagenExpansionLog);
        aux= new EscaneoRGB(imagenExpansionLog);
        aux.graficarHistograma();
        
        
//        JFrameSegmentacion seg = new JFrameSegmentacion("Imagen Segementada",imagen);
//        
//        aux.graficarHistograma();
        
        
        // OBTENER COLORES
//        int rgb = bi.getRGB(50, 50);

        
//        int i,j, m=130,n=89, r=40;
//        
//        for(j=0;j<281;j++){
//            for(i=0;i<179;i++){
//                
//                if((Math.pow((i-m), 2))+(Math.pow((j-n), 2)) <= Math.pow(r, 2) )
//                bi.setRGB(i,j,color.getRGB());
//            }
//        }
        
        //JframeImagen frame2 = new JframeImagen(AbrirImagen.toImage(bi));
//        EscaneoRGB m = new EscaneoRGB(imagen);
//        
//        m.graficarHistograma();
//        m.graficarHistogramaAzul();
//        m.graficarHistogramaRojo();
//        m.graficarHistogramaVerde();
//        m.graficarHistogramaGris();
       
        
        
        
//        //rojo    
//        int r = color.getRed();
//        //verde
//        int g = color.getGreen();
//        //azul
//        int b = color.getBlue();
        System.out.println();
        
    }
    
}
