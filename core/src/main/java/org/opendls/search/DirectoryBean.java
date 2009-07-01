package org.opendls.search;

import java.io.File;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author alexbcoles
 *
 */
public class DirectoryBean implements FactoryBean, InitializingBean
{
 private String path = null;
 private FSDirectory directory =  null;
 private boolean create = false;

 public boolean getCreate()
 {
  return create;
 }

 public void setCreate(boolean create)
 {
  this.create = create;
 }

 public String getPath()
 {
  return path;
 }

 public void setPath(String path)
 {
  this.path = path;
 }

 public Object getObject() throws Exception {
  return directory;
 }

 public Class getObjectType()
 {
  return FSDirectory.class;
 }

 public boolean isSingleton()
 {
  return true;
 }

 public void afterPropertiesSet() throws Exception
 {
  if (path==null)
   throw new BeanInitializationException("No path specified for Lucene Index directory");

  File f = new File(path);
  if(!f.isDirectory())
   throw new BeanInitializationException("Invalid path for Lucene Index directory");

  directory = FSDirectory.getDirectory(f, create);
  if(!IndexReader.indexExists(directory))
  {
   IndexWriter iw = new IndexWriter(directory, new StandardAnalyzer(), true);
   iw.close();
  }
 }

}
