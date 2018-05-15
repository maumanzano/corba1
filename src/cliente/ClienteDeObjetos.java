package cliente;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

import sop_corba.*;

public class ClienteDeObjetos
{
  //*** Atributo estático ***
  static solucionOperations ref;
  static boolean flag=false;

  public static void main(String args[])
    {
      try{
        // crea e inicia el ORB
	    ORB orb = ORB.init(args, null);

        // obtiene la base del naming context
        org.omg.CORBA.Object objSolucion = 
	    orb.resolve_initial_references("NameService");     
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objSolucion);
 
        // *** Resuelve la referencia del objeto en el N_S ***
        String name = "objSolucion";
        ref = solucionHelper.narrow(ncRef.resolve_str(name));

        System.out.println("Obtenido el manejador sobre el servidor de objetos: " +ref);
        
        
        menuPrincipal();

	} catch (Exception e) {
          System.out.println("ERROR : " + e) ;
	  e.printStackTrace(System.out);
	  }
    }
    
    public static void menuPrincipal(){
    int opcion = 0;
        int jugada=0;
        do
        {
            //ref.();
            System.out.println("==Menu==");
            System.out.println("1. Comenzar Juego");			
            System.out.println("2. Adivinar letra");
            System.out.println("3. Adivinar palabra");
            System.out.println("4. Consultar longitud de palabra");
            System.out.println("5. Consultar numero de intentos ");
            System.out.println("6. Mostrar palabra");
            System.out.println("0. Para salir...");

            opcion = UtilidadesConsola.leerEntero();

            switch(opcion)
            {       case 0:
                        System.out.println("Saliendo del juego...");
                        System.exit(0);
                        break;
                        
                    case 1:
                        if(flag==false){
                            iniciarJuego();
                        }else{
                            System.out.println("EL juego ya esta iniciado desea comenzar uno nuevo?");
                            System.out.println("1. Para confirmar");
                            System.out.println("0. para cancelar");
                            opcion = UtilidadesConsola.leerEntero();

                            if(opcion==1) iniciarJuego();
                        }
                        break;
                    case 2:
                        adivinarLetra();
                        break;	
                    case 3:
                        adivinarPalabra();
                        break;	
                    
                    case 4:
                        longitudPalabra();
                        break;
                        
                    case 5:
                        numeroIntentos();
                        break;
                    case 6:
                        mostrarPalabra();
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        break;
            }

        }while(opcion != 3);
    }
    
    public static void iniciarJuego(){
        ref.comenzarJuego();
        flag=true;
        System.out.println("Juego iniciado");
    
    }
    
    public static void adivinarLetra(){
        String letra="";
        
        if(!flag){
            System.out.println("Error primero debes iniciar un juego");
        
        }else{
            System.out.println("Adivinar Letra");
        
            System.out.println("Digite una letra");

            letra=UtilidadesConsola.leerCadena();

            if(letra.length()>1){
                System.out.println("Error solo puede digitar una letra");
            }else{

                System.out.println("Palabra: " + ref.adivinarLetra(letra.charAt(0)));
            }
        }    
    }
    
    public static void adivinarPalabra(){
        String palabra="";
        boolean flag2=false;
        
        if(!flag){
            System.out.println("Error primero debes iniciar un juego");
        
        }else{
            System.out.println("Adivinar Palabra");
            System.out.println("Digite la palabra");

            palabra=UtilidadesConsola.leerCadena();

            if(palabra.length()==0){
                System.out.println("La palabra que envio es vacia");
            }else{    
                flag2=ref.adivinarPalabra(palabra);
            }

            if(flag2){
                System.out.println("Congrats adivino la palabra");
                System.out.println("Fin del juego");
                flag=false;
            }else{
                System.out.println("Error no adivino la palabra");
            
            }
        }
    }
    
    public static void longitudPalabra(){
        if(!flag){
            System.out.println("Error primero debes iniciar un juego");
        
        }else{
            System.out.println("La longitud de la palabra es:" + ref.longitudPalabra());
        }
    
    
    }
    
    public static void numeroIntentos(){
        if(!flag){
            System.out.println("Error primero debes iniciar un juego");
        
        }else{
            System.out.println("Numero de intentos: " + ref.numeroIntentos());
        }
    
    
    }
    
    public static void mostrarPalabra(){
        if(!flag){
            System.out.println("Error primero debes iniciar un juego");
        
        }else{
            System.out.println("La palabra era: " + ref.mostrarPalabras());
            System.out.println("Usted perdio Fin del juego");
            flag=false;
        }
    }
    

}

