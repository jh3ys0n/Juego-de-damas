/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JuegoDeDamas;

import JuegoDeDamas.Agentes.JugadorBlanco;
import JuegoDeDamas.Agentes.JugadorNegro;
import JuegoDeDamas.Juego.Tablero;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
   public static void main(String[] args) throws IOException {
       
       Tablero tablero=new Tablero();
       
        JFrame frame = new JFrame();
        frame.add(tablero);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
       
        ArrayList<ArrayList<String>> matrix;
        matrix = new ArrayList<ArrayList<String>>();
        ArrayList<String>filaCP=new ArrayList<String>();
        filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");filaCP.add("B");filaCP.add("1");

        ArrayList<String>filaCP2=new ArrayList<String>();
        filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");filaCP2.add("1");filaCP2.add("B");

        ArrayList<String> fila1=new ArrayList<String>();
        fila1.add("B");fila1.add("1");fila1.add("B");fila1.add("1");fila1.add("B");fila1.add("1");fila1.add("B");fila1.add("1");

        ArrayList<String>fila2=new ArrayList<String>();
        fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");fila2.add("1");fila2.add("0");

        ArrayList<String> fila3=new ArrayList<String>();
        fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");fila3.add("0");fila3.add("1");

        ArrayList<String>fila4=new ArrayList<String>();
        fila4.add("1");fila4.add("N");fila4.add("1");fila4.add("N");fila4.add("1");fila4.add("N");fila4.add("1");fila4.add("N");

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
      
       tablero.upDateTable(matrix);
       
      JugadorBlanco blanco=new JugadorBlanco();
       JugadorNegro negro=new JugadorNegro();
       
      // System.out.println(blanco.fichasLibres(matrix).toString());
       //System.out.println(blanco.posicionesIr(matrix,1,5).toString());
      // tablero.
      /*for(int i=0;i<20;i++){
           tablero.upDateTable(blanco.minimax(tablero.getMatrix()));
       
            tablero.upDateTable(negro.minimax(tablero.getMatrix()));
        }*/
      boolean continuar=true;
      boolean turnoN=false;
      boolean turnoB=true;
      int i=0;
      while(continuar && i<=95){
          if(turnoB){
            tablero.upDateTable(blanco.minimax(tablero.getMatrix()));
            turnoB=false;
            turnoN=true;
            ArrayList<ArrayList<Integer>> cant=negro.fichasLibres(tablero.getMatrix());
            if(cant.size()==0){
                continuar=false;
                JOptionPane.showMessageDialog(null, "GANAN LAS NEGRAS");
            }
          }else if(turnoN){
            tablero.upDateTable(negro.minimax(tablero.getMatrix()));
            turnoB=true;
            turnoN=false;
            ArrayList<ArrayList<Integer>> cant=blanco.fichasLibres(tablero.getMatrix());
            if(cant.size()==0){
                continuar=false;
                JOptionPane.showMessageDialog(null, "GANAN LAS BLANCAS");
            }     
          }
          i++;
      }
     
     // blanco.comer(matrix, 0, 4, 2, 2);
     // tablero.upDateTable(matrix);
       
      //tablero.upDateTable(matrix);
      //negro.posPiezasAcomer(matrix, 3, 1);
      // negro.comer(matrix, 3, 1, 1, 3);
       
      // tablero.upDateTable(matrix);
       //negro.comer(matrix, 3, 5, 1, 3);
       
       // tablero.upDateTable(blanco.comer(matrix, 0, 2, 2, 0));
       //blanco.comerPieza(matrix, 0, 2);
       
        //************** METODO PARA ACTUALIZAR EL TABLERO ****************
        
                        //tablero.upDateTable(matrix2);
        
    }
    
}  


/*
    ArrayList<ArrayList<String>> matrix=new ArrayList<ArrayList<String>>();
    
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

        matrix.add(fila1);
        matrix.add(filaCP2);
        matrix.add(fila1);
        matrix.add(fila2);
        matrix.add(fila1);
        matrix.add(fila2);
        matrix.add(fila1);
        matrix.add(fila2);
       
        
       tablero.upDateTable(matrix);
       
       
        ArrayList<ArrayList<String>> matrix2=new ArrayList<ArrayList<String>>();
        matrix2.add(fila1);
        matrix2.add(fila2);
        matrix2.add(fila1);
        matrix2.add(fila2);
        matrix2.add(fila1);
        matrix2.add(fila2);
        matrix2.add(fila1);
        matrix2.add(fila2);
        
        tablero.upDateTable(matrix2);
       // tablero.upDateTable(matrix);
       //System.out.println(tablero.getMatrix().toString());
      



*/