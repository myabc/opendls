package org.opendls.test;

import com.allaire.wddx.WddxSerializer;
import com.allaire.wddx.WddxDeserializer;
import com.allaire.util.RecordSet;
import org.xml.sax.InputSource;

import org.opendls.model.UserInterface;
import org.opendls.model.UIColors;
import org.opendls.model.UIFonts;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.OutputStream;
import java.util.Hashtable;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class TestWddxReader
{

    public static void main(String[] args) {
       Object out = null;

       System.out.print("Test Wddx Reader");

       try {
           WddxSerializer ser = new WddxSerializer();


       }
       catch (Exception ex)
       {
           System.out.println(ex.toString());
       }
    }

}
