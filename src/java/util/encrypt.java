/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

/**
 *
 * @author ayarochkin
 */
public class encrypt {
    
public encrypt()
    {

    }

  public static String xor_encrypt(String message, String key){
    try {
      if (message==null || key==null ) return null;

      char[] keys=key.toCharArray();
      char[] mesg=message.toCharArray();
      BASE64Encoder encoder = new BASE64Encoder();

      int ml=mesg.length;
      int kl=keys.length;
      char[] newmsg=new char[ml];

      for (int i=0; i<ml; i++){
        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
      }
      mesg=null; 
      keys=null;
      String temp = new String(newmsg);
      return new String(new BASE64Encoder().encodeBuffer(temp.getBytes()));
    }
    catch ( Exception e ) {
      return null;
    }  
  }


  public static String xor_decrypt(String message, String key){
    try {
      if (message==null || key==null ) return null;
      BASE64Decoder decoder = new BASE64Decoder();
      char[] keys=key.toCharArray();
      message = new String(decoder.decodeBuffer(message));
      char[] mesg=message.toCharArray();

      int ml=mesg.length;
      int kl=keys.length;
      char[] newmsg=new char[ml];

      for (int i=0; i<ml; i++){
        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
      }
      mesg=null; keys=null;
      return new String(newmsg);
    }
    catch ( Exception e ) {
      return null;
    }  
  }


}
