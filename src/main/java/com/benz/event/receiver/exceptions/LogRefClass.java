package com.benz.event.receiver.exceptions;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Gets the custom code.
 *
 * @return the custom code
 */
@Getter

/**
 * Sets the custom code.
 *
 * @param customCode the new custom code
 */
@Setter

/**
 * Instantiates a new log ref class.
 *
 * @param logRef the log ref
 * @param status the status
 * @param message the message
 * @param customCode the custom code
 */
@AllArgsConstructor

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Data

/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Builder
public class LogRefClass {

    /** The log ref. */
    private String  logRef;
    
    /** The status. */
    private Integer status;
    
    /** The message. */
    private String  message;
    
    /** The custom code. */
    private String  customCode;

}