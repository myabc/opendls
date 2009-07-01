package org.opendls.exceptions;


/**
 *
 * @author  sjan evardsson
 * @version 1.0
 */
public class SearchException extends java.lang.Exception {

    /**
  *
  */
 private static final long serialVersionUID = 3192518885898573280L;


 /**
     * Creates new <code>DLSSearchException</code> without detail message.
     */
    public SearchException() {
    }


    /**
     * Constructs an <code>DLSSearchException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public SearchException(String msg) {
        super(msg);
    }
}
