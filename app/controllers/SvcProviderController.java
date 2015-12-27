package controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import models.SvcProvider;

public class SvcProviderController {

	
	static {
		SvcProvider svcProvider = new SvcProvider();
    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		svcProvider.setName("Dr. John Williams");
		datastore.save(svcProvider);
	}
	
	public static SvcProvider getSvcProviderById(String svcProviderId) {

	    ObjectId oid = new ObjectId(svcProviderId);
    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		SvcProvider svcProvider = datastore.find( SvcProvider.class).field("id").equal(oid).get();

		return svcProvider;
	}

	public static List<SvcProvider> getAllSvcProviders() {
    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		SvcProvider svcProvider = new SvcProvider();
		svcProvider.setName("amazon");
		datastore.save(svcProvider);
		
		final Query<SvcProvider> query = datastore.createQuery(SvcProvider.class);
		final List<SvcProvider> svcProviders = query.asList();
		return svcProviders;
	}

}
