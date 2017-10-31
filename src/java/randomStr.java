/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
import java.net.InetAddress;
import java.security.SecureRandom;  public class randomStr {
     public String getAphaNumKey(){
     StringBuilder sReturnBuffer = new StringBuilder();
     String strTemp = "";
     try{
        // Get IPAddress Segment
       InetAddress addr = InetAddress.getLocalHost();
       byte[] ipaddr = addr.getAddress();
       for (int i=0; i<ipaddr.length; i++){
         Byte b = new Byte(ipaddr[i]);
         strTemp = Integer.toHexString (b.intValue() & 0x000000ff);
         while (strTemp.length() < 2){
          strTemp = '0' + strTemp;
         }
         sReturnBuffer.append(strTemp);
        }
        sReturnBuffer.append("-");
       //Get CurrentTimeMillis() segment
       strTemp = Long.toHexString(System.currentTimeMillis());
       while (strTemp.length () < 12){
         strTemp = '0' + strTemp;
       }
       sReturnBuffer.append(strTemp);
       sReturnBuffer.append('-');
       //Get Random Segment
       SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
       strTemp = Integer.toHexString(prng.nextInt());
       while (strTemp.length () < 8){
        strTemp = '0' + strTemp;
       }
       sReturnBuffer.append(strTemp.substring(4));
       sReturnBuffer.append('-');
       //Get IdentityHash() segment
       strTemp = Long.toHexString(System.identityHashCode((Object) this));
       while (strTemp.length() < 8){
        strTemp = '0' + strTemp;
       }
       sReturnBuffer.append(strTemp);
    }catch(java.net.UnknownHostException ex){
     System.err.println("Unknown Host Exception Caught: " + ex.getMessage());
    }catch(java.security.NoSuchAlgorithmException ex) {
     System.err.println("No Such Algorithm Exception Caught: " + ex.getMessage());
    }
    return sReturnBuffer.toString().toUpperCase();
  }
}