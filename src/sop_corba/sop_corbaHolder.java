package sop_corba;

/**
* sop_corba/sop_corbaHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from registro.idl
* martes 15 de mayo de 2018 07:33:08 AM COT
*/

public final class sop_corbaHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba value = null;

  public sop_corbaHolder ()
  {
  }

  public sop_corbaHolder (sop_corba initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corbaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corbaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corbaHelper.type ();
  }

}