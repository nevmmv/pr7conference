package com.google.devrel.training.conference.service;

import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.devrel.training.conference.domain.Conference;
import com.google.devrel.training.conference.domain.Profile;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * Custom Objectify Service that this application should use.
 */
public class OfyService {
	
	// Get the Memcache Service 
	private static final MemcacheService memcacheService;

	
    /**
     * This static block ensure the entity registration.
     */
    static {
    	memcacheService = MemcacheServiceFactory.getMemcacheService();
        factory().register(Profile.class);
        factory().register(Conference.class);
    }

    /**
     * Use this static method for getting the Objectify service object in order to make sure the
     * above static block is executed before using Objectify.
     * @return Objectify service object.
     */
    public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    /**
     * Use this static method for getting the Objectify service factory.
     * @return ObjectifyFactory.
     */
    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
    
    public static void putMemcache(final String key, final Object value) {
    	memcacheService.put(key, value);
    }
    
    public static Object getMemcache(final String key) {
    	return memcacheService.get(key);
    }
    
}
