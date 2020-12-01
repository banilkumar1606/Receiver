package com.benz.event.receiver.service;

import com.benz.event.receiver.model.Event;

/**
 * The Interface EventReceiverService.
 */
public interface EventReceiverService {
	
	/**
	 * Process event.
	 *
	 * @param event the event
	 */
	public void processEvent(Event event);
}
