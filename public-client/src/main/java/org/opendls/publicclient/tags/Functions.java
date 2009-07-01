package org.opendls.publicclient.tags;

public class Functions
{
     /**
      * Pass in a value in bytes, and this function converts it to a
      * human-readable format of bytes, KB, MB, or GB.
      * Updated from Nat Papovich's version.
      * Ported to Java from Coldfusion.
      *
      * @param size Size to convert.
      * @return Returns a string.
      * @author Paul Mone (paul@ninthlink.com).
      */
     public static String formatFileSize( int size )
     {
      int result = 0;
      String unit = "";
      //int closestInteger = 0;

      if (size >= 1024 && size < 1048576)
      {
       result = size / 1024;
       unit = " KB";
      }
      else if (size >= 1048576 && size < 1073741824)
      {
       result = size / (1048576);
       unit = " MB";
      }
      else if(size >= 0 && size < 1024)
      {
       result = size;
       unit = " bytes";
      }
      else if (size >= 1073741824)
      {
       result = size / (1073741824);
       unit = " GB";
      }
      else
       return "unknown";

      /*
      closestInteger = (int) (result);

      if(closestInteger > 10)
       result = numberformat(result,"0.00");
      else if (closestInteger >= 10 and closestInteger < 100)
       result = numberformat(result,"90.0");
      else
       result = closestInteger;
      */

      return result + unit;
     }
}
