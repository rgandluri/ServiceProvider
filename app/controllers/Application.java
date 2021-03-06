package controllers;

import java.util.List;

import models.Category;
import models.SvcProvider;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result getSvcProvider(String svcProviderId) {
    	SvcProvider svcprovider = SvcProviderController.getSvcProviderById(svcProviderId);
    	return ok(Json.toJson(svcprovider));
    }

    public static Result getSvcProviders() {
    	List<SvcProvider> list =  SvcProviderController.getAllSvcProviders();
    	System.out.println("test");
    	return ok(Json.toJson(list)) ;
    }

    public static Result getCategories() {
    	List<Category> list =  SvcProviderController.getCategories();
    	return ok(Json.toJson(list)) ;
    }
}
