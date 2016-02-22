package com.export.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

public class GUID {

	  private static SecureRandom seeder;
	  private static String sInetAddress;

	  private String sHashCode;

	  /* static constructor */
	  static{
	    InetAddress inetaddress;

	    //initialize the seeder
	    seeder = new SecureRandom();
	    int i = seeder.nextInt();

	    try{
	      inetaddress = InetAddress.getLocalHost();
	      byte addrbyte[] = inetaddress.getAddress();
	      sInetAddress = hexFormat(getInt(addrbyte), 8);
	    } catch (UnknownHostException ex){
	      sInetAddress = hexFormat(i, 8);
	    }
	  }

	  /**
	   * Return a global unique ID
	   @return java.lang.String GUID string returned.
	   @roseuid 3D6BFBA10081
	   */
	  public static String getGUID()
	  {
	    long l = System.currentTimeMillis();
	    int i = (int)l & -1;
	    int j = seeder.nextInt();

	    String sThreadHash = hexFormat(Thread.currentThread().getClass().hashCode(),8);

	    StringBuffer sb = new StringBuffer();
	    sb.append(hexFormat(i, 8));
	    sb.append(sInetAddress);
	    sb.append(sThreadHash);
	    sb.append(hexFormat(j, 8));

	    return sb.toString();
	  }

	  /* convert byte array to integer */
	  private static int getInt(byte bytearr[])
	  {
	    int i = 0;
	    int j = 24;
	    for(int k = 0; j >= 0; k++)
	    {
	      int l = bytearr[k] & 0xff;
	      i += l << j;
	      j -= 8;
	    }

	    return i;
	  }

	  /* convert i to a hex format with length of j */
	  private static String hexFormat(int i, int j)
	  {
	    String s = Integer.toHexString(i);
	    return padHex(s, j);
	  }

	  /* pad the string to the length of i */
	  private static String padHex(String s, int i)
	  {
	    StringBuffer stringbuffer = new StringBuffer();
	    if(s.length() < i)
	    {
	      for(int j = 0; j < i - s.length(); j++)
	        stringbuffer.append("0");
	    }
	    stringbuffer.append(s);
	    return stringbuffer.toString();
	  }

}
