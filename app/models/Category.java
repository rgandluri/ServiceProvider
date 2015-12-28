package models;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("Categories")
public class Category {

	@Id
    private ObjectId id;
    private String name;
    
    
	public Category() {
		super();
		// TODO Auto-generated constructor stub
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
    
    
}
