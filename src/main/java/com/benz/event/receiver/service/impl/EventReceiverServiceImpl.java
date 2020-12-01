package com.benz.event.receiver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.benz.event.receiver.exceptions.ReceiverServiceException;
import com.benz.event.receiver.model.Event;
import com.benz.event.receiver.service.EventReceiverService;
import com.benz.event.receiver.util.EventReceiverUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class EventReceiverServiceImpl.
 */
@Service

/** The Constant log. */
@Slf4j
public class EventReceiverServiceImpl implements EventReceiverService {
	
	@Autowired
	EventReceiverUtil eventReceiverUtil;
	/* (non-Javadoc)
	 * @see com.benz.event.receiver.service.EventReceiverService#processEvent(com.benz.event.receiver.model.Event)
	 */
	@Override
	public void processEvent(Event event) {
		long startTimeinSeconds = (System.currentTimeMillis())/1000;
		try {
			if(event.getFuellid()) {
				String city = event.getCity();
				log.info("City: "+city);
				float price = eventReceiverUtil.getPrice(city);
				//I took event trigger time is the input to calculate the fuel capacity and total cost
				float amountOfFuel = startTimeinSeconds%30;
				log.info("Total liters: "+amountOfFuel);
				float totalCost = price*amountOfFuel;
				log.info("Total Cost: "+totalCost);
				
			}
			else {
				log.info("Fuellid: "+event.getFuellid()+"Hence its closed");
			}
		} catch (ReceiverServiceException e) {
			StringBuilder builder = new StringBuilder();
			builder.append("Exception occured while processing event with traceID").append(event.getTraceID()).append(e.getMessage());
			throw new ReceiverServiceException(builder.toString());
		}

		
	}


}
