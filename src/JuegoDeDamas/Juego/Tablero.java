/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoDeDamas.Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Asus
 */
public class Tablero extends JPanel{
    
    ArrayList<ArrayList<String>> matrix=new ArrayList<ArrayList<String>>();
    
    private static final int DIM_WIDTH = 640;
    private static final int DIM_HEIGHT = 640;
    private static final int SQ_SIZE = 80;

    boolean black = true;

    public Tablero(){
           ArrayList<ArrayList<String>> matrix;
        matrix = new ArrayList<ArrayList<String>>();
        ArrayList<String>filaCP=new ArrayList<String>();
        filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");

        ArrayList<String>filaCP2=new ArrayList<String>();
        filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");

        ArrayList<String> fila1=new ArrayList<String>();
        fila1.add("0");fila1.add("1");fila1.add("0");fila1.add("1");fila1.add("0");fila1.add("1");fila1.add("N");fila1.add("1");

        ArrayList<String>fila2=new ArrayList<String>();
        fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");

        ArrayList<String> fila3=new ArrayList<String>();
        fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");

        ArrayList<String>fila4=new ArrayList<String>();
        fila4.add("1");fila4.add("B");fila4.add("1");fila4.add("0");fila4.add("1");fila4.add("0");fila4.add("1");fila4.add("0");

        ArrayList<String>filaCPN=new ArrayList<String>();
        filaCPN.add("0");filaCPN.add("1");filaCPN.add("N");filaCPN.add("1");filaCPN.add("N");filaCPN.add("1");filaCPN.add("N");filaCPN.add("1");

        ArrayList<String>filaCPN2=new ArrayList<String>();
        filaCPN2.add("1");filaCPN2.add("N");filaCPN2.add("1");filaCPN2.add("N");filaCPN2.add("1");filaCPN2.add("N");filaCPN2.add("1");filaCPN2.add("N");

        matrix.add(filaCP);
        matrix.add(filaCP2);
        matrix.add(fila1);
        matrix.add(fila2);
        matrix.add(fila3);
        matrix.add(fila4);
        matrix.add(filaCPN);
        matrix.add(filaCPN2);
    
    }
    
    @Override
    public void paint(Graphics g) {
        boolean white=true;
        for(int y= 0;y<matrix.size();y++){
            for(int x= 0;x<matrix.get(y).size();x++){
                if(matrix.get(y).get(x).compareTo("1")==0){
                    g.setColor(Color.decode("#7e6b56"));
                    g.fillRect(x*64, y*64, 64, 64);
                   
                }else{
                    if(matrix.get(y).get(x).compareTo("0")==0){
                        g.setColor(Color.decode("#fffff1"));
                        g.fillRect(x*64, y*64, 64, 64);
                        }else{
                        if(matrix.get(y).get(x).compareTo("B")==0){
                            g.setColor(Color.decode("#d7bb89"));
                            //g.fillRect(x*64, y*64, 64, 64);
                            g.fillOval(x*64, y*64, 60, 60);
                            }else{
                            if(matrix.get(y).get(x).compareTo("DB")==0){
                               g.setColor(Color.RED);
                                //g.fillRect(x*64, y*64, 64, 64);
                                g.fillOval(x*64, y*64, 60, 60);
                                }else{    
                                if(matrix.get(y).get(x).compareTo("N")==0){
                                    g.setColor(Color.decode("#463623"));
                                    //g.fillRect(x*64, y*64, 64, 64);
                                    g.fillOval(x*64, y*64, 60, 60);
                                    }
                                else{
                                    if(matrix.get(y).get(x).compareTo("DN")==0){
                                    g.setColor(Color.decode("#003077"));
                                    //g.fillRect(x*64, y*64, 64, 64);
                                    g.fillOval(x*64, y*64, 60, 60);
                                    }
                                }      
                
                            }
                         }
                     }
                }
                
                //
                white=!white;
                }
                white=!white;
                  }
    }
    
     public  void createAndShowGui() {
        JFrame frame = new JFrame();
        frame.add(new Tablero());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);

    }

    public Dimension getPreferredSize() {
        return new Dimension(DIM_WIDTH, DIM_HEIGHT);
    }
   /* 
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
    */
    
    public ArrayList<ArrayList<String>> getMatrix(){
        return matrix;    
    }
    
    public void upDateTable(ArrayList<ArrayList<String>> matrix) {	
        try {
            Thread.sleep(250);
            this.matrix = matrix;         
            repaint();
        } catch (InterruptedException e) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
