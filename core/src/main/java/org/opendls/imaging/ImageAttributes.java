package org.opendls.imaging;

//import ImageInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 *
 * @author alexbcoles
 *
 */
class ImageAttributes
{
 private String inputFilePath;

 public ImageAttributes() throws FileNotFoundException
 {
  File file = new File(inputFilePath);
  FileInputStream imgFileStream = new FileInputStream(file);

  //ImageInfo ii = new ImageInfo();
  //ii.setInput(imgFileStream);

  //c = ii.check();

  //String formatName = ii.getFormatName();
  //int height = ii.getHeight();
  //int width = ii.getWidth();
  //int pixels = ii.getBitsPerPixel();
  //int physicalHeightDpi = ii.getPhysicalHeightDpi();
  //int physicalWidthDpi = ii.getPhysicalWidthDpi();

  //int resolution = -1;

  //if (physicalHeightDpi > physicalWidthDpi)
  //{
  //	resolution = physicalHeightDpi;
  //}
  //else
  //{
  //	resolution = physicalWidthDpi;
  //}

  Object graphStruct = new Object();

  //graphStruct.width = width;
  //graphStruct.height = height;
  //graphStruct.resolution= resolution;
  //graphStruct.depth = pixels;


  // Convert to WDDX

 }

}
