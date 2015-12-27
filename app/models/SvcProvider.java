package models;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("SvcProviders")
public class SvcProvider {

	@Id
    private ObjectId id;
    private String name;
    
	public SvcProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SvcProvider(ObjectId id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + "]";
	}
}
