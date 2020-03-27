/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com_grafico;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author cosma_000
 */
public class Grafico extends JComponent implements Serializable{
        
    private int nfiguras;
    private JLabel etis[];
    private int vals[]= {0,0,0};
    private static final Color color [] = {Color.BLUE, Color.GREEN, Color.CYAN,Color.YELLOW,
        Color.PINK,Color.WHITE,Color.RED, Color.ORANGE,Color.MAGENTA};
    private static JLabel leyendaBarra[] ;
    private static JLabel  colorB[];
    private JLabel titulo;
    private String tTitulo;
    private String  tLeyenda[];

    public Grafico() {
        this.titulo = new JLabel("");
        this.etis = new JLabel[0];
        leyendaBarra =  new JLabel[0];
        colorB = new JLabel[0];
        this.tLeyenda =  new String[0];        
    }

    public Grafico(String tTitulo, String[] tLeyenda) {
        this.nfiguras = tLeyenda.length;
        this.tTitulo = tTitulo;
        this.tLeyenda = tLeyenda;
        leyendaBarra =  new JLabel[tLeyenda.length];
        this.setLeyendas(tLeyenda);
        this.iniciarElementos();
    }
    
    public void iniciarElementos(){
        this.vals =  new int[this.nfiguras];
        for(int i = 0; i<this.nfiguras; i++){
            this.vals[i]=0;
        }
        this.titulo =  new JLabel(this.tTitulo);
        this.add(this.titulo);
        this.etis = new JLabel[this.nfiguras];
        colorB =  new JLabel[this.nfiguras];
        for(int i = 0; i<this.nfiguras; i++){
            this.etis[i]= new JLabel(""+i);
            this.add(this.etis[i]);
        }
    }

    public void settTitulo(String tTitulo) {
        this.tTitulo = tTitulo;
    }
    
    public void setLeyendas(String tLeyenda[]){
        this.nfiguras =  tLeyenda.length;
        this.tLeyenda = tLeyenda;
        leyendaBarra = new JLabel[tLeyenda.length];
        for(int i = 0; i<this.nfiguras; i++){
            leyendaBarra[i]= new JLabel(tLeyenda[i]);
            this.add(leyendaBarra[i]);
        }
        this.iniciarElementos();
    }

    public void setValores(int[] vals) {
        this.vals = vals;
    }
    
    public void paintComponent(Graphics f){

int i;
int j=1;
int ancho= this.getWidth();
int alto =  this.getHeight();
//this.titulo;
int separa = (int)(this.getWidth()/this.nfiguras + 0.10);
int anchoB = (int)(this.getWidth() / this.nfiguras - separa);

for(i = 0; i < this.nfiguras ; i++){
    f.setColor(color[i]);
    this.etis[i].setBounds(separa+i*(ancho+separa)+(ancho/2),(alto-20*this.colorB.length)-(this.vals[i]*5-this.etis[i].getWidth()-2),30, 20);
}

}
    
}
