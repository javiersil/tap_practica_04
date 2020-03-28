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
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author bere
 */
public class Grafico extends JComponent implements Serializable{
        
    private int nfiguras;
    private JLabel etis[];
    private int vals[]= {0,0,0};
    int[] num= {10,20,30};
    private static final Color color [] = {Color.BLUE, 
        Color.GREEN, Color.CYAN,Color.YELLOW,
        Color.PINK,Color.WHITE,Color.RED, 
        Color.ORANGE,Color.MAGENTA};
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
        nfiguras= vals.length;
        this.setVals(vals);
    }

    public Grafico(String tTitulo, String[] tLeyenda) {
        this.nfiguras = tLeyenda.length;
        this.tTitulo = tTitulo;
        this.tLeyenda = tLeyenda;
        leyendaBarra =  new JLabel[tLeyenda.length];
        
        this.iniciarElementos();
        this.setLeyendas(tLeyenda);
        this.setVals(vals);
    }
    
    public void iniciarElementos(){
        this.vals =  new int[this.nfiguras];
        for(int i = 0; i<this.nfiguras; i++){
            this.vals[i]=0;
        }
        
        leyendaBarra = new JLabel[nfiguras];
        
        for(int i = 0; i < nfiguras; i++){
            leyendaBarra[i] = new JLabel("");
            add(leyendaBarra[i]);
        }
        
        this.titulo =  new JLabel(this.tTitulo);
        this.add(this.titulo);
        
        
        this.etis = new JLabel[this.nfiguras];
        colorB =  new JLabel[this.nfiguras];
        for(int i = 0; i<this.nfiguras; i++){
            this.etis[i]= new JLabel("");
            //aquí iba una i
            this.add(this.etis[i]);
        }
        //aquí va el color de las etiquetas
        for(int i=0; i<nfiguras; i++){
            Color c = color[i];
            colorB[i] = new JLabel();
            colorB[i].setText(" ");
            colorB[i].setOpaque(true);
            colorB[i].setBackground(c);
            add(colorB[i]); 
        }
        
    }
    
    public void setVals(int[] vals) {
        this.vals = vals;  
        nfiguras= vals.length;
        for(int i = 0; i < vals.length; i++){
            etis[i].setText("" + vals[i]);
        }
    }
    

    public void setTitulo(String tTitulo) {
        this.tTitulo = tTitulo;
        titulo.setText(tTitulo);
    }
    
    public void setLeyendas(String tLeyenda[]){
        leyendaBarra = new JLabel[nfiguras];
        
        for(int i = 0; i < tLeyenda.length; i++){
            leyendaBarra[i] = new JLabel(tLeyenda[i]);
            add(leyendaBarra[i]);
        }
        
       
    }

   
 
    
    @Override
public void paintComponent(Graphics f){
       int i;
       int j=1;
       int ancho = getWidth()-150;
       int alto = getHeight()-150;
       titulo.setBounds((int)((getWidth()-f.getFontMetrics().stringWidth(titulo.getText()))/2),10,titulo.getText().length()*8,20);
       int separa = (int) ((ancho/nfiguras) * 0.10f);
       int anchoB = (int) (ancho/nfiguras) - separa;
       int x2=0;
       int y2=15;
       //Ubica cada elemento en su pos
       for(i=0; i<nfiguras; i++){
           f.setColor(color[i]); //Establece el color de cada barra
           
           int x = separa+i*(anchoB+separa)+(anchoB/2);
           int y=(alto-20-colorB.length)-vals[i]-5-etis[i].getHeight()-2;
           
           if(i==0){
               x2=x;
               y2+=y;
           }
          
            
            etis[i].setBounds(x,y+40,30,20);
            colorB[i].setBounds(x2,y2+((i+2)*25),40,20);
            leyendaBarra[i].setBounds(x2+40,y2+((i+2)*24),105,30);
            
          
           f.fill3DRect(separa+i*(anchoB+separa), (alto-(20*colorB.length))-vals[i]*5, anchoB, vals[i]*5, true);
          
             
       }
       


       
       
} 
    
    public static void main( String [] args){
        String[] elementosP= {"elemento1","elemento2","elemento3"};
        int[] num= {10,20,30};
        JFrame frame = new JFrame("Prueba");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Grafico p= new Grafico("elementos", elementosP);
        p.setVals(num);
        p.setSize(400, 300);
        p.setVisible(true);
        frame.add(p);      
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
