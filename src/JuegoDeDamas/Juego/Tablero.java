/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoDeDamas.Juego;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Tablero{
    JFrame frame = new JFrame();
    ArrayList<ArrayList<String>> matrix=new ArrayList<ArrayList<String>>();
    public Tablero(){
        ArrayList<String>fila1=new ArrayList<String>();
        fila1.add("0");fila1.add("1");fila1.add("0");fila1.add("1");fila1.add("0");fila1.add("1");fila1.add("0");fila1.add("1");

        ArrayList<String>fila2=new ArrayList<String>();
        fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");

        ArrayList<String>filaCP=new ArrayList<String>();
        filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");

        ArrayList<String>filaCP2=new ArrayList<String>();
        filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");

        ArrayList<String>filaCPN=new ArrayList<String>();
        filaCPN.add("N");filaCPN.add("1");filaCPN.add("N");filaCPN.add("1");filaCPN.add("N");filaCPN.add("1");filaCPN.add("N");filaCPN.add("1");

        ArrayList<String>filaCPN2=new ArrayList<String>();
        filaCPN2.add("1");filaCPN2.add("N");filaCPN2.add("1");filaCPN2.add("N");filaCPN2.add("1");filaCPN2.add("N");filaCPN2.add("1");filaCPN2.add("N");

        matrix.add(filaCP);
        matrix.add(filaCP2);
        matrix.add(fila1);
        matrix.add(fila2);
        matrix.add(fila1);
        matrix.add(fila2);
        matrix.add(filaCPN);
        matrix.add(filaCPN2);

          
          frame.setBounds(10, 10, 512, 512);
          frame.setUndecorated(false);
          JPanel pn=new JPanel(){
              @Override
              public void paint(Graphics g) {
              boolean white=true;
                   for(int y= 0;y<8;y++){
                          for(int x= 0;x<8;x++){
                          if(matrix.get(y).get(x).compareTo("1")==0){
                              g.setColor(new Color(235,235, 208));
                          }else{
                              if(matrix.get(y).get(x).compareTo("0")==0){
                                   g.setColor(new Color(119, 148, 85));
                              }else{
                                  if(matrix.get(y).get(x).compareTo("B")==0){
                                      g.setColor(new Color(19, 18, 85));
                                      
                                  }
                                  else{
                                        if(matrix.get(y).get(x).compareTo("N")==0){
                                          g.setColor(new Color(255, 18, 85));
                                  }
                                  }
                              }
                          }
                          g.fillRect(x*64, y*64, 64, 64);
                           white=!white;
                      }
                      white=!white;
                  }

              }

          };
          frame.add(pn);
          frame.setDefaultCloseOperation(3);
          frame.setVisible(true);
        }
    
    public ArrayList<ArrayList<String>> getMatrix(){
        return matrix;
    }
    
    public void setTablero(ArrayList<ArrayList<String>> matrix){
        
        
         // JFrame frame = new JFrame();
          frame.setBounds(10, 10, 512, 512);
          frame.setUndecorated(false);
          JPanel pn=new JPanel(){
              @Override
              public void paint(Graphics g) {
              boolean white=true;
                   for(int y= 0;y<8;y++){
                          for(int x= 0;x<8;x++){
                          if(matrix.get(y).get(x).compareTo("1")==0){
                              g.setColor(new Color(235,235, 208));
                              g.fillOval(x, y, 30, 30);
                          }else{
                              if(matrix.get(y).get(x).compareTo("0")==0){
                                   g.setColor(new Color(119, 148, 85));
                              }else{
                                  if(matrix.get(y).get(x).compareTo("B")==0){
                                      g.setColor(new Color(19, 18, 85));
                                  }
                                  else{
                                        if(matrix.get(y).get(x).compareTo("N")==0){
                                          g.setColor(new Color(255, 18, 85));
                                          
                                         
                                  }
                                  }
                              }
                          }
                          g.fillRect(x*64, y*64, 64, 64);
                           white=!white;
                      }
                      white=!white;
                  }

              }
                
          };
          frame.add(pn);
          frame.setDefaultCloseOperation(3);
          frame.setVisible(true);
          
        }
}
