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
        
        ArrayList<String> fila3=new ArrayList<String>();
        fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");
        
        ArrayList<String>fila2=new ArrayList<String>();
        fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");
        
        ArrayList<String>fila4=new ArrayList<String>();
        fila4.add("1");fila4.add("0");fila4.add("1");fila4.add("0");fila4.add("1");fila4.add("0");fila4.add("1");fila4.add("0");
        
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
        matrix.add(fila3);
        matrix.add(fila4);
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
    
    
    public ArrayList<ArrayList<Integer>> posicionesIr(int i,int j){
        ArrayList<ArrayList<Integer>> listaFinal=new ArrayList<ArrayList<Integer>>();   
        if(estaRango(i,j)){
            if(estaRango(i-1,j-1)){
                if(librePos(matrix,i-1,j-1)){
                    ArrayList<Integer> listaAux = new ArrayList<Integer>();
                    listaAux.add(i-1);
                    listaAux.add(j-1);
                    listaFinal.add(listaAux);
                }
            }
            if(estaRango(i-1,j+1)){
                if(librePos(matrix,i-1,j+1)){
                    ArrayList<Integer> listaAux = new ArrayList<Integer>();
                    listaAux.add(i-1);
                    listaAux.add(j+1);
                    listaFinal.add(listaAux);
                }
            }
        }
        return listaFinal;
    }
    

    public boolean estaRango(int i, int j){
        boolean esVerdad=false;
        if(i>=0 && i<=7 && j>=0 && j<=7){
            esVerdad=true;
        }else{
            esVerdad=false;
        }
        return esVerdad;
    }

    public boolean librePos(ArrayList<ArrayList<String>> matrix,int i,int j ){
        boolean esVerdad=false;
        if(matrix.get(i).get(j).compareTo("0")==0){
            esVerdad=true;
        }else{
            esVerdad=false;
        }
        return esVerdad;
    }

    public void actualizarTablero(int a,int b, int i, int j){
        ArrayList<String> lista = matrix.get(a);
        lista.set(b,"N");
        matrix.set(a,lista);
        ArrayList<String> lista2 = matrix.get(i);
        lista2.set(j,"0");
        matrix.set(i,lista2);
    }
    
    /*-->POR EL MOMENTO LUEGO EL JUGADORNEGRO TENDRA ESTA FUNCION
    public ArrayList<Integer> escogerPosicion(ArrayList<ArrayList<Integer>> matrixLista){
        ArrayList<Integer> lista = matrixLista.get(0);
        return lista;
    }

    public void moverPieza(int i, int j){
        int a;int b;
        ArrayList<ArrayList<Integer>> mataux = posicionesIr(i, j);
        ArrayList<Integer> lista = escogerPosicion(mataux);
        a=lista.get(0);
        b=lista.get(1);
        actualizarTablero(a, b, i, j);
    }
    */
}
