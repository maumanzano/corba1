package sop_corba;


/**
* sop_corba/solucionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from registro.idl
* martes 15 de mayo de 2018 11:24:59 AM COT
*/

public interface solucionOperations 
{
  void comenzarJuego ();
  String adivinarLetra (char letra);
  boolean adivinarPalabra (String palabra);
  int longitudPalabra ();
  int numeroIntentos ();
  String mostrarPalabras ();
} // interface solucionOperations
