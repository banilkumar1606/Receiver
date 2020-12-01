package com.benz.event.receiver.exceptions;

import lombok.Data;

/* (non-Javadoc)
 * @see java.lang.Throwable#toString()
 */
@Data
public class ReceiverServiceException extends RuntimeException {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    
    /**
     * Instantiates a new receiver service validation exception.
     *
     * @param message the message
     */
    public ReceiverServiceException(String message) {
        super(message);
    }
    
}
