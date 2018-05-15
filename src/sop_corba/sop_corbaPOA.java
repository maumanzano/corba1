package sop_corba;


/**
* sop_corba/sop_corbaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from registro.idl
* martes 15 de mayo de 2018 07:33:08 AM COT
*/

public abstract class sop_corbaPOA extends org.omg.PortableServer.Servant
 implements sop_corbaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("comenzarJuego", new java.lang.Integer (0));
    _methods.put ("adivinarLetra", new java.lang.Integer (1));
    _methods.put ("adivinarPalabra", new java.lang.Integer (2));
    _methods.put ("longitudPalabra", new java.lang.Integer (3));
    _methods.put ("numeroIntentos", new java.lang.Integer (4));
    _methods.put ("mostrarPalabras", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba/sop_corba/comenzarJuego
       {
         this.comenzarJuego ();
         out = $rh.createReply();
         break;
       }

       case 1:  // sop_corba/sop_corba/adivinarLetra
       {
         char letra = in.read_char ();
         String $result = null;
         $result = this.adivinarLetra (letra);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // sop_corba/sop_corba/adivinarPalabra
       {
         String palabra = in.read_string ();
         boolean $result = false;
         $result = this.adivinarPalabra (palabra);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 3:  // sop_corba/sop_corba/longitudPalabra
       {
         int $result = (int)0;
         $result = this.longitudPalabra ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 4:  // sop_corba/sop_corba/numeroIntentos
       {
         int $result = (int)0;
         $result = this.numeroIntentos ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 5:  // sop_corba/sop_corba/mostrarPalabras
       {
         String $result = null;
         $result = this.mostrarPalabras ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/sop_corba:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public sop_corba _this() 
  {
    return sop_corbaHelper.narrow(
    super._this_object());
  }

  public sop_corba _this(org.omg.CORBA.ORB orb) 
  {
    return sop_corbaHelper.narrow(
    super._this_object(orb));
  }


} // class sop_corbaPOA
