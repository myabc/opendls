package org.opendls.persistence.hibernate.id;

public class IncrementStringException extends Exception
{
    private static final long serialVersionUID = -5423144402428628239L;

    /**
     * Constructor for IncrementStringException.
     *
     * @param message
     *            Optional message.
     */
    public IncrementStringException(String message)
    {
        super(message);
    }

}
