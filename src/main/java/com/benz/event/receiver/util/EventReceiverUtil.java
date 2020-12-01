package com.benz.event.receiver.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * The Class EventReceiverUtil.
 */
@Component
@EnableScheduling
public class EventReceiverUtil {
	public static final Map<String, Float> inMemoryCache = new HashMap<>();
	
	//Runs every 12 clock and update the inmemory cache
	@Scheduled(cron = "0 0 0 * * *")
	public void updateCache() {
		inMemoryCache.put("Bangalore", 82.75f);
		inMemoryCache.put("Hyderabad", 78.45f);
		inMemoryCache.put("Delhi", 85.25f);
		inMemoryCache.put("Mumbai", 81.65f);
		inMemoryCache.put("Punjab", 84.75f);

	}

	public float getPrice(String city) {
		return inMemoryCache.get(city);
	}


}
