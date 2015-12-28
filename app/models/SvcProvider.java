package models;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("SvcProviders")
public class SvcProvider {

	@Id
    private ObjectId id;
    private String name;
    private String imagePath;
    private String promotionalRate;
    private String originalRate;
    
	public SvcProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "SvcProvider [id=" + id + ", name=" + name + ", imagePath=" + imagePath + ", promotionalRate="
				+ promotionalRate + ", originalRate=" + originalRate + "]";
	}


	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public String getPromotionalRate() {
		return promotionalRate;
	}


	public void setPromotionalRate(String promotionalRate) {
		this.promotionalRate = promotionalRate;
	}


	public String getOriginalRate() {
		return originalRate;
	}


	public void setOriginalRate(String originalRate) {
		this.originalRate = originalRate;
	}
	

}
