package org.opendls.imaging;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.RenderingHints;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 *
 *
 * @author alexbcoles
 *
 */
public class GenerateThumbnail
{
 private String inputFilePath;
 private String outputFilePath;
 private int dpi;
 private int quality;
 private String comment;

 private float maxWidth;
 private float maxHeight;


 public void GenerateThumbnail() throws Exception
 {

   Image img = Toolkit.getDefaultToolkit().getImage(inputFilePath);

   //float thumbRatio = maxWidth / maxHeight;
   float imageWidth = (float)img.getWidth(null); //TODO: is there a paremeter
   float imageHeight = (float)img.getHeight(null);
   //float imageRatio = imageWidth / imageHeight;

   // scale by x factor first
   if (imageWidth > maxWidth)
   {
    float scaleFactor = maxWidth/imageWidth;

    // reduce x size and y size
    imageWidth = imageWidth * scaleFactor;
    imageHeight = imageHeight * scaleFactor;
   }

   // scale by y if needed
   if (imageHeight > maxHeight)
   {
    float scaleFactor = maxHeight/imageHeight;

    // reduce x size and y size
    imageWidth = imageWidth * scaleFactor;
    imageHeight = imageHeight * scaleFactor;
   }


   //int height = (int) new Float(maxWidth / imageRatio).intValue(); // TODO:clean this;

   java.awt.Frame frame = new java.awt.Frame();
   java.awt.Button button = new java.awt.Button();

   int width = (int)maxWidth;
   int height = (int)imageHeight;

   MediaTracker mediaTracker = new MediaTracker(frame);
   mediaTracker.addImage(img, 0);
   mediaTracker.waitForID(0);

   BufferedImage thumbImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
   Graphics2D graphics2D = thumbImage.createGraphics();
   graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
   graphics2D.drawImage(img, 0, 0, width, height, button);

   FileOutputStream fileOut = new FileOutputStream(outputFilePath);
   BufferedOutputStream bufOut = new BufferedOutputStream(fileOut);

   JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bufOut);
   JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(thumbImage);

   //int quality = max(0,min(attributes.quality,100));

   param.setQuality(quality/100,false);
   encoder.setJPEGEncodeParam(param);
   encoder.encode(thumbImage);



 }


}
