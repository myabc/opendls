package org.opendls.exceptions;

public class ItemNotFoundException extends Exception
{

    /**
  *
  */
 private static final long serialVersionUID = -7718662763493282989L;

 ItemNotFoundException() {

    }

    ItemNotFoundException(String msg) {
        super(msg);
    }
}
