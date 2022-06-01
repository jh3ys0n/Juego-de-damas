/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JuegoDeDamas;

import JuegoDeDamas.Juego.Tablero;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

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
       
        
        
       // tablero.setLista(matrix2);
        
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
       
        
       tablero.setLista(matrix);
       
       
        ArrayList<ArrayList<String>> matrix2=new ArrayList<ArrayList<String>>();
        matrix2.add(fila1);
        matrix2.add(fila2);
        matrix2.add(fila1);
        matrix2.add(fila2);
        matrix2.add(fila1);
        matrix2.add(fila2);
        matrix2.add(fila1);
        matrix2.add(fila2);
        
        tablero.setLista(matrix2);
       // tablero.setLista(matrix);
       //System.out.println(tablero.getMatrix().toString());
      



*/