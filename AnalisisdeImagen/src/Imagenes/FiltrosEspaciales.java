/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Alumno
 */
public class FiltrosEspaciales {
    public static Image generarImagenGrises(Image io){
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        int i,j;  
        Color color;
        for(j=0;j<bi.getHeight();j++){
            for(i=0;i<bi.getWidth();i++){
                color = new Color(bi.getRGB(i,j));
                int prom = (color.getRed()+color.getBlue()+color.getGreen())/3;
                color = new Color(prom,prom,prom);
                bi.setRGB(i,j,color.getRGB());
            }
        }
     return AbrirImagen.toImage(bi);
    }
    
    public static Image generarImagenNegativa(Image io){
        BufferedImage bi = AbrirImagen.toBufferedImage(io);
        int i,j;  
        Color color;
        for(j=0;j<bi.getHeight();j++){
            for(i=0;i<bi.getWidth();i++){
                color = new Color(bi.getRGB(i,j));
                color = new Color(255-color.getRed(),255-color.getBlue(),255-color.getGreen());
                bi.setRGB(i,j,color.getRGB());
            }
        }
     return AbrirImagen.toImage(bi);
    }
    
    public static Image iluminarImagen(Image imagen, int alpha){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen() + alpha;
            int b = color.getBlue() + alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image modificarTemperatura(Image imagen, int alpha){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = color.getRed() + alpha;
            int g = color.getGreen();
            int b = color.getBlue() - alpha;
            color = new Color(validarLimites(r),
            validarLimites(g),
            validarLimites(b));
            bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }

    public static Image segmentarImagen(Image imagen, int umbral){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color, colorFondo;
        colorFondo = new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if (prom>umbral){
                bi.setRGB(x,y,colorFondo.getRGB());
            }

        }
        return AbrirImagen.toImage(bi);
    }
    
    public static Image segmentarImagen(Image imagen, int u1, int u2){
        //TO-DO: garantizar que el u2 > u1
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color, colorFondo;
        colorFondo = new Color(255,255,255);
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int prom = (color.getRed()+ color.getGreen()+color.getBlue())/3;
            if ( !(prom >= u1 && prom <= u2)){
                bi.setRGB(x,y,colorFondo.getRGB());
            }

        }
        return AbrirImagen.toImage(bi);
    }
    
 public static Image expansionLineal(EscaneoRGB h, Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (color.getRed()-h.getMinR())*(255/h.getMaxR()-h.getMinR());
            int g = (color.getGreen()-h.getMinG())*(255/h.getMaxG()-h.getMinG());
            int b = (color.getBlue()-h.getMinB())*(255/h.getMaxB()-h.getMinB());
             color = new Color(validarLimites(r),
             validarLimites(g),
             validarLimites(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }
 
 public static Image expansionLogartmica( Image imagen){

        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((255*Math.log(1+color.getRed()))/Math.log(256));
            int g = (int)((255*Math.log(1+color.getGreen()))/Math.log(256));
            int b = (int)((255*Math.log(1+color.getBlue()))/Math.log(256));
             color = new Color(validarLimites(r),
             validarLimites(g),
             validarLimites(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
    }
 
  public static Image expansionExponencial(Image imagen, double z){
        
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color color;
        if(z>0){
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
            color = new Color(bi.getRGB(x, y));
            int r = (int)((Math.pow((1+z), color.getRed()))/z);
            int g = (int)((Math.pow((1+z), color.getGreen()))/z);
            int b = (int)((Math.pow((1+z), color.getBlue()))/z);
             color = new Color(validarLimites(r),
             validarLimites(g),
             validarLimites(b));
             bi.setRGB(x,y,color.getRGB());
        }
        return AbrirImagen.toImage(bi);
        }else
        {
        return    AbrirImagen.toImage(bi);
        }
    }
 
     public static int obtenerMin(double[] h){

        for(int x=0; x<h.length;x++){
            if(h[x]!=0) return x;
        }
     return -1;
    }

    public static int obtenerMax(double[] h){

        for(int x=h.length-1; x>=0;x--){
            if(h[x]!=0) return x;
        }
     return -1;
    }
    
    public static int validarLimites (int aux){

        if (aux<0)return 0;
        if (aux>255)return 255;
        return aux;

    }
   
 }
