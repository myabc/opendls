package org.opendls.dao;

import org.springframework.dao.DataAccessException;

import org.opendls.dao.GenericDao;
import org.opendls.model.Item;

/**
 * @author alexbcoles
 *
 */
public interface ItemDao extends GenericDao<Item, String>
{
    // standard CRUD is inherited from GenericDao

 /**
  * Publishes an item so that it is publicly viewable.
  * @param id
  */
 public void publishItem(String id) throws DataAccessException;
 //public void publishItem(Item item);
 /**
  * Moves an item back to the staging area.
  * @param id
  */
 public void restageItem(String id) throws DataAccessException;
 //public void restageItem(Item item);
 /**
  * Moves an item to the Recycle Bin
  * @param id
  */
 public void deleteItem(String id) throws DataAccessException;
 //public void deleteItem(Item item);

    //public List<String> getTitles();
    //public List<String> getTitleAlternatives();
    //public List<String> getCreators();
    //public List<String> getPublishers();

  //  public List findItemsByLibrary(String libraryId);
  //  public List findItemsByUser(String email);

  //  public Integer getItemCount(int status);
    // public Integer getItemCount(int status, String libraryId);

}
