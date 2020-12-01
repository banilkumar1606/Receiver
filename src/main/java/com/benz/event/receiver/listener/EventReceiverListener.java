package com.benz.event.receiver.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.benz.event.receiver.constants.EventReceiverConstants;
import com.benz.event.receiver.model.Event;
import com.benz.event.receiver.service.EventReceiverService;

import lombok.extern.slf4j.Slf4j;

/**
 * The listener interface for receiving eventReceiver events.
 * The class that is interested in processing a eventReceiver
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addEventReceiverListener<code> method. When
 * the eventReceiver event occurs, that object's appropriate
 * method is invoked.
 *
 * @see EventReceiverEvent
 */
@Component

/** The Constant log. */
@Slf4j
public class EventReceiverListener {
	
	/** The event receiver service. */
	@Autowired
	EventReceiverService eventReceiverService;

	/**
	 * Consume message from queue.
	 *
	 * @param event the event
	 */
	//TODO:we can use Executor framework for performance improvement
	
	@RabbitListener(queues = EventReceiverConstants.QUEUE)
	public void consumeMessageFromQueue(Event event) {
		log.info("Message recieved from queue : " + event);
		eventReceiverService.processEvent(event);
	}
}
