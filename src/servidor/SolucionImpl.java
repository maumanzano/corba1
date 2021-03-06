/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.util.ArrayList;
import java.util.Arrays;
import sop_corba.solucionPOA;

/**
 *
 * @author Mauricio
 */
public class SolucionImpl extends solucionPOA{
   
     String[] palabras={"usb","monitor","mouse","procesador","teclado","parlantes","cpu","escaner"};
     String actual;
     int a,flag,intentos=0;
     String ltrs;
     //char [] letras;

    
    @Override
    public void comenzarJuego() {
        System.out.println(" $ Jugador solicita: Comenzar Juego");
        ltrs="";
        flag=0;
        actual="";
        intentos=0;
        int n;
        n= (int) (Math.random() * palabras.length);
        actual=palabras[n];
        for (int i = 0; i < actual.length(); i++) {
            ltrs=ltrs+'_';
        }
        a=actual.length();
        
    }

    @Override
    public String adivinarLetra(char letra) {
        System.out.println(" $ Jugador solicita: Adivinar Letra");
        String cadena="";
        int n=0;
        if(flag==0){
            
            if(intentos<5){
                
                char[] letras = ltrs.toCharArray();
                for (int i = 0; i < actual.length(); i++) {
                    if(actual.charAt(i)==letra){
                        letras[i]=letra;
                        n++;
                        a--;
                    }
                    
                }
                
                ltrs="";
                
                for (int i = 0; i < letras.length; i++) {
                    ltrs=ltrs+letras[i];
                }
                
                
                if(n==0){
                        intentos++;
                }
                
                cadena=ltrs;
                
                if(a==0){
                    cadena=mostrarPalabras();
                    cadena=cadena+"\n"+"VICTORIA";
                }
        
            }else{
                cadena=mostrarPalabras();
                cadena=cadena+"\n"+"Fin del juego, supero los 5 intentos\n";
                
            }
        }else{
            cadena="Debe iniciar juego primero";
        }
        
        return cadena;
    }

    @Override
    public boolean adivinarPalabra(String palabra) {
        System.out.println(" $ Jugador solicita: Adivinar Palabra");
       boolean flag=false;
       if(palabra.equals(actual)){
           flag=true;
       }else{
           flag=false;
           intentos++;
       }
       return flag;
    }

    @Override
    public int longitudPalabra() {
        System.out.println(" $ Jugador solicita: Longitud de palabra");
        return actual.length();
    }

    @Override
    public int numeroIntentos() {
        System.out.println(" $ Jugador solicita: Numero de intentos");
        return intentos;
    }

    @Override
    public String mostrarPalabras() {
        System.out.println(" $ Jugador solicita: Mostrar palabra");
        flag=1;
        return actual;
    }
    
}
