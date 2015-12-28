package controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import models.Category;
import models.SvcProvider;
import play.Logger;

public class SvcProviderController {

	
//	static {
//		SvcProvider svcProvider = new SvcProvider();
//    	final Morphia morphia = new Morphia();
//    	morphia.mapPackage("models");
//    	
//    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
//		datastore.ensureIndexes();
//		svcProvider.setName("Dr. John Williams");
//		datastore.save(svcProvider);
//	}
	
	public static SvcProvider getSvcProviderById(String svcProviderId) {

	    ObjectId oid = new ObjectId(svcProviderId);
    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		SvcProvider svcProvider = datastore.find( SvcProvider.class).field("id").equal(oid).get();

		return svcProvider;
	}
	
	public static void deletetSvcProviderByName(String svcProviderName) {

    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		Query<SvcProvider> query = datastore.createQuery(SvcProvider.class).filter("name", svcProviderName);
		datastore.delete(query);
	}

	public static List<SvcProvider> getAllSvcProviders() {
    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
//		SvcProvider svcProvider = new SvcProvider();
//		svcProvider.setName("amazon");
//		datastore.save(svcProvider);
		
		final Query<SvcProvider> query = datastore.createQuery(SvcProvider.class);
		final List<SvcProvider> svcProviders = query.asList();
		return svcProviders;
	}

	public static List<Category> getCategories() {
    	final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		final Query<Category> query = datastore.createQuery(Category.class);
		final List<Category> categories = query.asList();
		return categories;
	}

	public static void main(String[] args) {
    	createServiceProviders();
    	createCategories();
	}

	private static void createCategories() {
		final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		Query<Category> query = datastore.find( Category.class );
		WriteResult result = datastore.delete(query);

		Logger.info("Deleted all existing categories:"+result.getN());
		
		Category cat = new Category();
		cat.setName("Naturopathy");
		datastore.save(cat);
		
		cat = new Category();
		cat.setName("Ayurvedic");
		datastore.save(cat);
		
		cat = new Category();
		cat.setName("Homeopathy");
		datastore.save(cat);
		
		cat = new Category();
		cat.setName("Yoga");
		datastore.save(cat);
	}

	private static void createServiceProviders() {
		final Morphia morphia = new Morphia();
    	morphia.mapPackage("models");
    	
    	final Datastore datastore = morphia.createDatastore(new MongoClient(), "test");
		datastore.ensureIndexes();
		
		Query<SvcProvider> query = datastore.find( SvcProvider.class );
		WriteResult result = datastore.delete(query);
		Logger.info("Deleted all existing categories:"+result.getN());
		
		SvcProvider svcProvider = new SvcProvider();
		svcProvider.setName("Dr. John Williams1");
		svcProvider.setImagePath("Naturopathic-Doctor.png");
		svcProvider.setPromotionalRate("$300.00");
		svcProvider.setOriginalRate("$500.00");
		datastore.save(svcProvider);
		
		svcProvider = new SvcProvider();
		svcProvider.setName("Dr. John Williams2");
		svcProvider.setImagePath("Naturopathic-Doctor.png");
		svcProvider.setPromotionalRate("$300.00");
		svcProvider.setOriginalRate("$500.00");
		datastore.save(svcProvider);
		
		svcProvider = new SvcProvider();
		svcProvider.setName("Dr. John Williams3");
		svcProvider.setImagePath("Naturopathic-Doctor.png");
		svcProvider.setPromotionalRate("$300.00");
		svcProvider.setOriginalRate("$500.00");
		datastore.save(svcProvider);
		
		svcProvider = new SvcProvider();
		svcProvider.setName("Dr. John Williams4");
		svcProvider.setImagePath("Naturopathic-Doctor.png");
		svcProvider.setPromotionalRate("$300.00");
		svcProvider.setOriginalRate("$500.00");		
		datastore.save(svcProvider);
		
		svcProvider = new SvcProvider();
		svcProvider.setName("Dr. John Williams5");
		svcProvider.setImagePath("Naturopathic-Doctor.png");
		svcProvider.setPromotionalRate("$300.00");
		svcProvider.setOriginalRate("$500.00");
		datastore.save(svcProvider);
		
		svcProvider = new SvcProvider();
		svcProvider.setName("Dr. John Williams6");
		svcProvider.setImagePath("Naturopathic-Doctor.png");
		svcProvider.setPromotionalRate("$300.00");
		svcProvider.setOriginalRate("$500.00");
		datastore.save(svcProvider);
	}
}
