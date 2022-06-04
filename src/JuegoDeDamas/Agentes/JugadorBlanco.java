/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoDeDamas.Agentes;

import jade.core.Agent;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class JugadorBlanco{
   
     public static void main(String[] args) {
       
    }
    
    
      public ArrayList<ArrayList<Integer>> posPiezasAcomer(ArrayList<ArrayList<String>> tablero,int posx,int posy){
     
        ArrayList<ArrayList<Integer>> listaPos=new ArrayList<ArrayList<Integer>>();
          
        if(posy>=2 && posx<=5){
             if(tablero.get(posx+1).get(posy-1).compareTo("N")==0 && tablero.get(posx+2).get(posy-2).compareTo("0")==0){
                 ArrayList<Integer> lista=new ArrayList<Integer>();
                 lista.add(posx+2);
                 lista.add(posy-2);
                 System.out.print(lista.toString());
            }
        }
        
        if(posy<=5 && posx<=5){
             if(tablero.get(posx+1).get(posy+1).compareTo("N")==0 && tablero.get(posx+2).get(posy+2).compareTo("0")==0){
                ArrayList<Integer> lista=new ArrayList<Integer>();
                 lista.add(posx+2);
                 lista.add(posy+2);
                 System.out.print(lista.toString());
            }
        }
        
        return listaPos;
        
    }
    
      public ArrayList<ArrayList<String>> comer(ArrayList<ArrayList<String>> matrix,int posPiesax,int posPiesay,int pcx,int pcy){
           
        ArrayList<String> lista1 = (ArrayList<String>) matrix.get(posPiesax).clone();
        lista1.set(posPiesay,"0");
        matrix.set(posPiesax,lista1);
        
       // matrix.get(posPiesax).set(posPiesay, "0");
          if(pcx-2==posPiesax && pcy+2==posPiesay){
                matrix.get(pcx-1).set(pcy+1, "0");
          }else{
               if(pcx-2==posPiesax && pcy-2==posPiesay){
                     matrix.get(pcx-1).set(pcy-1, "0");
                }
          }
          System.out.println("-------> "+pcx+".......... "+pcy);
          
        ArrayList<String> lista2 = (ArrayList<String>) matrix.get(pcx).clone();
        lista2.set(pcy,"B");
        matrix.set(pcx,lista2);
       
        return matrix;
      }
}

