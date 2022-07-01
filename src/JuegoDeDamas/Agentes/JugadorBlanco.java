/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JuegoDeDamas.Agentes;


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
      
       public ArrayList<ArrayList<String>> comerDama(ArrayList<ArrayList<String>> matrix,int posPiesax,int posPiesay,int pcx,int pcy){
            ArrayList<String> lista1 = (ArrayList<String>) matrix.get(posPiesax).clone();
            lista1.set(posPiesay,"0");
            matrix.set(posPiesax,lista1);

           // matrix.get(posPiesax).set(posPiesay, "0");
              if(matrix.get(pcx+1).get(pcy-1).compareTo("N")==0){
                    matrix.get(pcx+1).set(pcy-1, "0");
              }else{
                   if(matrix.get(pcx-1).get(pcy-1).compareTo("N")==0){
                         matrix.get(pcx-1).set(pcy-1, "0");
                    }
              }
              System.out.println("-------> "+pcx+".......... "+pcy);

            ArrayList<String> lista2 = (ArrayList<String>) matrix.get(pcx).clone();
             lista2.set(pcy,"B");
            matrix.set(pcx,lista2);

            return matrix;
       }
       
       //-------------------------------------------------------------------------------
       
    
    public void imprimirMatrix(ArrayList<ArrayList<String>> matrix){
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public void imprimirMatrixInteger(ArrayList<ArrayList<Integer>> matrix){
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> minimax(ArrayList<ArrayList<String>> matrix){
        int bandera = -1000;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<Integer>> listaIni = fichasLibres(matrix);
        for(int i=0; i<listaIni.size();i++){
            ArrayList<Integer> posicion = listaIni.get(i);
            int x=posicion.get(0);int y=posicion.get(1);
            ArrayList<ArrayList<Integer>> listaPosFinal = posicionesIr(matrix,x,y);
            for(int j=0;j<listaPosFinal.size();j++){
                ArrayList<Integer> posicionDes = listaPosFinal.get(j);
                int a= posicionDes.get(0);int b=posicionDes.get(1);
                if(x-a==1 || a-x==1 ){
                    ArrayList<ArrayList<String>> aux= new ArrayList<ArrayList<String>>();
                    for(int k=0;k<matrix.size();k++){
                        ArrayList fila=(ArrayList<String>)matrix.get(k).clone();
                        aux.add(fila);
                    }
                    ArrayList<ArrayList<String>> matrixAux=moverPieza(aux,x,y,a,b);
                    ArrayList<ArrayList<String>> matrixMax=simularRespuesta(matrixAux);
                    int puntaje=obtenerPuntaje(matrixMax);
                    imprimirMatrix(matrixMax);
                    System.out.println("---> Puntaje Max: " + puntaje);
                    if(puntaje > bandera){
                        res=matrixAux;
                        bandera=puntaje;
                    }
                }else if(x-a==2 || a-x==2){
                    ArrayList<ArrayList<String>> aux= new ArrayList<ArrayList<String>>();
                    for(int m=0;m<matrix.size();m++){
                        ArrayList fila=(ArrayList<String>)matrix.get(m).clone();
                        aux.add(fila);
                    }       
                    ArrayList<ArrayList<String>> matrixAux=comerPieza(aux,x,y,a,b);
                    ArrayList<ArrayList<String>> matrixMax=simularRespuesta(matrixAux);
                    int puntaje=obtenerPuntaje(matrixMax);
                    imprimirMatrix(matrixMax);
                    System.out.println("---> Puntaje: Max " + puntaje);
                    if(puntaje > bandera){
                        res=matrixAux;
                        bandera=puntaje;
                    }
                }
            }
        }
        imprimirMatrix(res);
        System.out.println("---> Puntaje Final Max: " + bandera);
        return res;
    }

    public ArrayList<ArrayList<Integer>> fichasLibres(ArrayList<ArrayList<String>> matrix){
        ArrayList<ArrayList<Integer>> listaFinal = new ArrayList<ArrayList<Integer>> ();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                if(obtenerFicha(matrix,i,j).compareTo("B")==0 || obtenerFicha(matrix,i,j).compareTo("DB")==0){
                    ArrayList<ArrayList<Integer>> listaPos = posicionesIr(matrix,i,j);
                    if(listaPos.size()>0){                       
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i);listaAux.add(j);listaFinal.add(listaAux);
                    }
                }
            }
        }
        return listaFinal;
    }

    public ArrayList<ArrayList<Integer>> posicionesIr(ArrayList<ArrayList<String>> matrix,int i,int j){
        ArrayList<ArrayList<Integer>> listaFinal = new ArrayList<ArrayList<Integer>> ();
        if(obtenerFicha(matrix,i,j).compareTo("B")==0 || obtenerFicha(matrix,i,j).compareTo("DB")==0){
                        if(estaRango(i+1,j+1)){
                if(obtenerFicha(matrix,i+1,j+1).compareTo("N")==0 || obtenerFicha(matrix,i+1,j+1).compareTo("DN")==0){
                    if(estaRango(i+2,j+2) && librePos(matrix,i+2,j+2)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i+2);listaAux.add(j+2);listaFinal.add(listaAux);
                    }
                }else if(librePos(matrix,i+1,j+1)){
                    ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                    listaAux.add(i+1);listaAux.add(j+1);listaFinal.add(listaAux);
                }
            }
            if(estaRango(i+1,j-1)){
                if(obtenerFicha(matrix,i+1,j-1).compareTo("N")==0 || obtenerFicha(matrix,i+1,j-1).compareTo("DN")==0){
                    if(estaRango(i+2,j-2) && librePos(matrix,i+2,j-2)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i+2);listaAux.add(j-2);listaFinal.add(listaAux);
                    }
                }else if(librePos(matrix,i+1,j-1)){
                    ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                    listaAux.add(i+1);listaAux.add(j-1);listaFinal.add(listaAux);
                }
            }
            if(obtenerFicha(matrix,i,j).compareTo("DB")==0){
                if(estaRango(i-1,j+1)){
                    if(obtenerFicha(matrix,i-1,j+1).compareTo("N")==0 || obtenerFicha(matrix,i-1,j+1).compareTo("DN")==0){
                        if(estaRango(i-2,j+2) && librePos(matrix,i-2,j+2)){
                            ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                            listaAux.add(i-2);listaAux.add(j+2);listaFinal.add(listaAux);
                        }
                    }else if(librePos(matrix,i-1,j+1)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i-1);listaAux.add(j+1);listaFinal.add(listaAux);
                    }
                }
                if(estaRango(i-1,j-1)){
                    if(obtenerFicha(matrix,i-1,j-1).compareTo("N")==0 || obtenerFicha(matrix,i-1,j-1).compareTo("DN")==0){
                        if(estaRango(i-2,j-2) && librePos(matrix,i-2,j-2)){
                            ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                            listaAux.add(i-2);listaAux.add(j-2);listaFinal.add(listaAux);
                        }
                    }else if(librePos(matrix,i-1,j-1)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i-1);listaAux.add(j-1);listaFinal.add(listaAux);
                    }
                }
            }
        }
        return listaFinal;
    }

    public boolean librePos(ArrayList<ArrayList<String>> matrix,int i,int j){
        boolean esVerdad=false;
        if(matrix.get(i).get(j).compareTo("0")==0){
            esVerdad=true;
        }
        return esVerdad;
    }

    public boolean estaRango(int i,int j){
        boolean res=false;
        if(i>=0 && i<=7 && j>=0 && j<=7){
            res=true;
        }
        return res;
    }

    public ArrayList<ArrayList<String>> moverPieza(ArrayList<ArrayList<String>> matrixE, int x,int y, int a, int b){
        ArrayList<ArrayList<String>> matrix= matrixE;
        String ficha=obtenerFicha(matrix,x,y);
        if(a==7){
            ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
            matrix.set(x,lista1);
            ArrayList<String> lista2=matrix.get(a);lista2.set(b,"DB");
            matrix.set(a,lista2);
        }else{
            ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
            matrix.set(x,lista1);
            ArrayList<String> lista2=matrix.get(a);lista2.set(b,ficha);
            matrix.set(a,lista2);
        }
        return matrix;
    }

    public ArrayList<ArrayList<String>> comerPieza(ArrayList<ArrayList<String>> matrixE, int x,int y, int a, int b){
        ArrayList<ArrayList<String>> matrix= matrixE;
        String ficha=obtenerFicha(matrix,x,y);
        if(x-a==-2 && y-b== 2){
            ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
            matrix.set(x,lista1);
            ArrayList<String> lista2=matrix.get(x+1);lista2.set(y-1,"0");
            matrix.set(x+1,lista2);
            if(a==7){
                ArrayList<String> lista3=matrix.get(a);lista3.set(b,"DB");
                matrix.set(a,lista3);
            }else{
                ArrayList<String> lista3=matrix.get(a);lista3.set(b,"B");
                matrix.set(a,lista3);
            }
        }else{
            if(x-a==-2 && y-b==-2){
                ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
                matrix.set(x,lista1);
                ArrayList<String> lista2=matrix.get(x+1);lista2.set(y+1,"0");
                matrix.set(x+1,lista2);
                if(a==7){
                    ArrayList<String> lista3=matrix.get(a);lista3.set(b,"DB");
                    matrix.set(a,lista3);
                }else{
                    ArrayList<String> lista3=matrix.get(a);lista3.set(b,"B");
                    matrix.set(a,lista3);
                }
            }else{ 
                if(x-a== 2 && y-b== 2){
                    ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
                    matrix.set(x,lista1);
                    ArrayList<String> lista2=matrix.get(x-1);lista2.set(y-1,"0");
                    matrix.set(x-1,lista2);
                    ArrayList<String> lista3=matrix.get(a);lista3.set(b,"B");
                    matrix.set(a,lista3);
                }else{ 
                    if(x-a== 2 && y-b== -2){
                        ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
                        matrix.set(x,lista1);
                        ArrayList<String> lista2=matrix.get(x-1);lista2.set(y+1,"0");
                        matrix.set(x-1,lista2);
                        ArrayList<String> lista3=matrix.get(a);lista3.set(b,"B");
                        matrix.set(a,lista3);
                    }
                }
            }
        }
        return matrix;
    }

    public String obtenerFicha(ArrayList<ArrayList<String>> matrix, int i,int j){
        String ficha="";
        ficha=matrix.get(i).get(j);
        return ficha;
    }

    public int obtenerPuntaje(ArrayList<ArrayList<String>> matrix){
        int puntaje=0;
        for(int i=0; i< matrix.size();i++){
            ArrayList<String> lista=matrix.get(i);
            for(int j=0;j<lista.size();j++){
                if(lista.get(j)=="B" || lista.get(j)=="DB"){
                    puntaje=puntaje+1;
                }else{
                    if(lista.get(j)=="N" || lista.get(j)=="DN"){
                        puntaje=puntaje-1;
                    }
                }            
            }
        }
        return puntaje;
    }

    /*SIMULACION DE JUGADAS ENEMIGAS*/
    public ArrayList<ArrayList<String>> simularRespuesta(ArrayList<ArrayList<String>> matrix){
        int bandera = 1000;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<Integer>> listaIni = fichasLibresNegras(matrix);
        for(int i=0; i<listaIni.size();i++){
            ArrayList<Integer> posicion = listaIni.get(i);
            int x=posicion.get(0);int y=posicion.get(1);
            ArrayList<ArrayList<Integer>> listaPosFinal = posicionesIrNegras(matrix,x,y);
            for(int j=0;j<listaPosFinal.size();j++){
                ArrayList<Integer> posicionDes = listaPosFinal.get(j);
                int a= posicionDes.get(0);int b=posicionDes.get(1);
                if(x-a==1 || a-x==1 ){
                    ArrayList<ArrayList<String>> aux= new ArrayList<ArrayList<String>>();
                    for(int k=0;k<matrix.size();k++){
                        ArrayList fila=(ArrayList<String>)matrix.get(k).clone();
                        aux.add(fila);
                    }
                    ArrayList<ArrayList<String>> matrixMin=moverPiezaNegra(aux,x,y,a,b);
                    int puntaje=obtenerPuntaje(matrixMin);
                    if(puntaje < bandera){
                        res=matrixMin;
                        bandera=puntaje;
                    }
                }else if(x-a==2 || a-x==2){
                    ArrayList<ArrayList<String>> aux= new ArrayList<ArrayList<String>>();
                    for(int m=0;m<matrix.size();m++){
                        ArrayList fila=(ArrayList<String>)matrix.get(m).clone();
                        aux.add(fila);
                    }       
                    ArrayList<ArrayList<String>> matrixMin=comerPiezaNegra(aux,x,y,a,b);
                    int puntaje=obtenerPuntaje(matrixMin);
                    if(puntaje < bandera){
                        res=matrixMin;
                        bandera=puntaje;
                    }
                }
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> posicionesIrNegras(ArrayList<ArrayList<String>> matrix,int i,int j){
        ArrayList<ArrayList<Integer>> listaFinal = new ArrayList<ArrayList<Integer>> ();
        if(obtenerFicha(matrix,i,j).compareTo("N")==0 || obtenerFicha(matrix,i,j).compareTo("DN")==0){
                        if(estaRango(i-1,j+1)){
                if(obtenerFicha(matrix,i-1,j+1).compareTo("B")==0 || obtenerFicha(matrix,i-1,j+1).compareTo("DB")==0){
                    if(estaRango(i-2,j+2) && librePos(matrix,i-2,j+2)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i-2);listaAux.add(j+2);listaFinal.add(listaAux);
                    }
                }else if(librePos(matrix,i-1,j+1)){
                    ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                    listaAux.add(i-1);listaAux.add(j+1);listaFinal.add(listaAux);
                }
            }
            if(estaRango(i-1,j-1)){
                if(obtenerFicha(matrix,i-1,j-1).compareTo("B")==0 || obtenerFicha(matrix,i-1,j-1).compareTo("DB")==0){
                    if(estaRango(i-2,j-2) && librePos(matrix,i-2,j-2)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i-2);listaAux.add(j-2);listaFinal.add(listaAux);
                    }
                }else if(librePos(matrix,i-1,j-1)){
                    ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                    listaAux.add(i-1);listaAux.add(j-1);listaFinal.add(listaAux);
                }
            }
            if(obtenerFicha(matrix,i,j).compareTo("DN")==0){
                if(estaRango(i+1,j+1)){
                    if(obtenerFicha(matrix,i+1,j+1).compareTo("B")==0 || obtenerFicha(matrix,i+1,j+1).compareTo("DB")==0){
                        if(estaRango(i+2,j+2) && librePos(matrix,i+2,j+2)){
                            ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                            listaAux.add(i+2);listaAux.add(j+2);listaFinal.add(listaAux);
                        }
                    }else if(librePos(matrix,i+1,j+1)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i+1);listaAux.add(j+1);listaFinal.add(listaAux);
                    }
                }
                if(estaRango(i+1,j-1)){
                    if(obtenerFicha(matrix,i+1,j-1).compareTo("B")==0 || obtenerFicha(matrix,i+1,j-1).compareTo("DB")==0){
                        if(estaRango(i+2,j-2) && librePos(matrix,i+2,j-2)){
                            ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                            listaAux.add(i+2);listaAux.add(j-2);listaFinal.add(listaAux);
                        }
                    }else if(librePos(matrix,i+1,j-1)){
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i+1);listaAux.add(j-1);listaFinal.add(listaAux);
                    }
                }
            }
        }
        return listaFinal;
    }

    public ArrayList<ArrayList<Integer>> fichasLibresNegras(ArrayList<ArrayList<String>> matrix){
        ArrayList<ArrayList<Integer>> listaFinal = new ArrayList<ArrayList<Integer>> ();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.get(i).size();j++){
                if(obtenerFicha(matrix,i,j).compareTo("N")==0 || obtenerFicha(matrix,i,j).compareTo("NB")==0){
                    ArrayList<ArrayList<Integer>> listaPos = posicionesIrNegras(matrix,i,j);
                    if(listaPos.size()>0){                       
                        ArrayList<Integer> listaAux = new ArrayList<Integer> ();
                        listaAux.add(i);listaAux.add(j);listaFinal.add(listaAux);
                    }
                }
            }
        }
        return listaFinal;
    }

    public ArrayList<ArrayList<String>> moverPiezaNegra(ArrayList<ArrayList<String>> matrixE, int x,int y, int a, int b){
        ArrayList<ArrayList<String>> matrix= matrixE;
        String ficha=obtenerFicha(matrix,x,y);
        if(a==0){
            ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
            matrix.set(x,lista1);
            ArrayList<String> lista2=matrix.get(a);lista2.set(b,"DN");
            matrix.set(a,lista2);
        }else{
            ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
            matrix.set(x,lista1);
            ArrayList<String> lista2=matrix.get(a);lista2.set(b,ficha);
            matrix.set(a,lista2);
        }
        return matrix;
    }

    public ArrayList<ArrayList<String>> comerPiezaNegra(ArrayList<ArrayList<String>> matrixE, int x,int y, int a, int b){
        ArrayList<ArrayList<String>> matrix= matrixE;
        String ficha=obtenerFicha(matrix,x,y);
        if(x-a==2 && y-b== 2){
            ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
            matrix.set(x,lista1);
            ArrayList<String> lista2=matrix.get(x-1);lista2.set(y-1,"0");
            matrix.set(x-1,lista2);            
            ArrayList<String> lista3=matrix.get(a);lista3.set(b,ficha);
            matrix.set(a,lista3);
        }else{
            if(x-a==2 && y-b==-2){
                ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
                matrix.set(x,lista1);
                ArrayList<String> lista2=matrix.get(x-1);lista2.set(y+1,"0");
                matrix.set(x-1,lista2);
                ArrayList<String> lista3=matrix.get(a);lista3.set(b,ficha);
                matrix.set(a,lista3);
            }else{ 
                if(x-a== -2 && y-b== 2){
                    ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
                    matrix.set(x,lista1);
                    ArrayList<String> lista2=matrix.get(x+1);lista2.set(y-1,"0");
                    matrix.set(x+1,lista2);
                    if(a==0){
                        ArrayList<String> lista3=matrix.get(a);lista3.set(b,"DN");
                        matrix.set(a,lista3);
                    }else{
                        ArrayList<String> lista3=matrix.get(a);lista3.set(b,ficha);
                        matrix.set(a,lista3);
                    }
                }else{ 
                    if(x-a== -2 && y-b== -2){
                        ArrayList<String> lista1=matrix.get(x);lista1.set(y,"0");
                        matrix.set(x,lista1);
                        ArrayList<String> lista2=matrix.get(x+1);lista2.set(y+1,"0");
                        matrix.set(x+1,lista2);
                        if(a==0){
                            ArrayList<String> lista3=matrix.get(a);lista3.set(b,"DN");
                            matrix.set(a,lista3);
                        }else{
                            ArrayList<String> lista3=matrix.get(a);lista3.set(b,ficha);
                            matrix.set(a,lista3);
                        }
                    }
                }
            }
        }
        return matrix;
    }
}
