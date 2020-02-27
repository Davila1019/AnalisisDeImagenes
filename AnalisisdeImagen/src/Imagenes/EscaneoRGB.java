/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Color;
import org.jfree.chart.plot.XYPlot;

/**
 *
 * @author Davila
 */
public class EscaneoRGB {
    private static Color ROJO = Color.RED;
    private static Color AZUL = Color.BLUE;
    private static Color VERDE = Color.GREEN;
    private static Color GRIS = Color.GRAY;
    private double[] RED;
    private double[] GREEN; 
    private double[] BLUE;
    private double[] HGRIS;
    private Integer minR,maxR;
    private Integer minG,maxG;
    private Integer minB,maxB;
  
        EscaneoRGB(){
            this.RED= new double[256];
            this.GREEN=new double[256];
            this.BLUE=new double[256];
            this.HGRIS=new double[256];
            
        }
        public EscaneoRGB(Image imagen){
        this.RED = new double[256];
        this.GREEN = new double[256];
        this.BLUE = new double[256];
        this.HGRIS = new double[256];
        Escaneo(imagen);
        }
        
   private void Escaneo(Image imagen)
    {
        
        BufferedImage bi = AbrirImagen.toBufferedImage(imagen);
        Color aux = null;
        for(int x=0; x<bi.getWidth();x++)
            for(int y=0; y<bi.getHeight();y++){
                aux = new Color(bi.getRGB(x, y));
                this.RED[aux.getRed()]++;
                this.GREEN[aux.getGreen()]++;
                this.BLUE[aux.getBlue()]++;
                int prom = (aux.getRed()+aux.getGreen()+aux.getBlue())/3;
                this.HGRIS[prom]++;
            }
             calcularMinimosYMaximos(); 
        }
        
       
        
    public void graficarHistograma(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.RED, "Rojo");
        G.agregarSerie(this.BLUE, "Azul");
        G.agregarSerie(this.GREEN, "Verde");
        G.crearGrafica();

        XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
        plot.getRenderer().setSeriesPaint(1, new Color(Color.BLUE.getRGB()));
        plot.getRenderer().setSeriesPaint(2, new Color(Color.GREEN.getRGB()));
        G.muestraGrafica();
    }
    public void graficarHistogramaRojo(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.RED, "Rojo");
        G.crearGrafica();
        XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.RED.getRGB()));
        G.muestraGrafica();
       
    }
    public void graficarHistogramaAzul(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.BLUE, "Azul");
        G.crearGrafica();
         XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.BLUE.getRGB()));
        G.muestraGrafica();
    }
    public void graficarHistogramaVerde(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.GREEN, "Verde");
         G.crearGrafica();
         XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.GREEN.getRGB()));
        G.muestraGrafica();
    }
    public void graficarHistogramaGris(){
        Grafica  G=new Grafica("Tono", "Intencidad","Frecuencia");
        G.agregarSerie(this.HGRIS, "Gris");
        G.crearGrafica();
        XYPlot plot = G.getGrafica().getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(Color.GRAY.getRGB()));
        G.muestraGrafica();
    }
    


    public double[] getRED() {
        return RED;
    }

    public double[] getGREEN() {
        return GREEN;
    }

    public double[] getBLUE() {
        return BLUE;
    }
    private void calcularMinimosYMaximos(){
    this.minR = -1;
    this.minG = -1;
    this.minB = -1;
    this.maxR = 256;
    this.maxG = 256;
    this.maxB = 256;

    for(int t1 = 0, t2= RED.length-1; minR==-1 || maxR==256 ;t1++,t2--){
        if(RED[t1]!=0 && minR ==-1){
            minR = t1;
        }
        if(RED[t2]!=0 && maxR==256){
            maxR = t2;
        }
       
    }

    for(int t1 = 0, t2= GREEN.length-1; minG==-1 || maxG==256 ;t1++,t2--){
        if(GREEN[t1]!=0 && minG ==-1){
            minG = t1;
        }
        if(GREEN[t2]!=0 && maxG==256){
            maxG = t2;
        }
       
    }

    for(int t1 = 0, t2= BLUE.length-1; minB==-1 || maxB==256 ;t1++,t2--){
        if(BLUE[t1]!=0 && minB ==-1){
            minB = t1;
        }
        if(BLUE[t2]!=0 && maxB==256){
            maxB = t2;
        }
       
    }
    
   System.out.println();

 }
    public int getMinR(){
        return this.minR;
    }
    public int getMaxR(){
        return this.maxR;
    }

    public int getMinG(){
        return this.minG;
    }
    public int getMaxG(){
        return this.maxG;
    }

    public int getMinB(){
        return this.minB;
    }
    public int getMaxB(){
        return this.maxB;
    }

    
}
