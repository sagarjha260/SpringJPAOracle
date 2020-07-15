package SpringJPAORACLE.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TopicModels")
public class TopicModel implements Serializable {
 
	private static final long serialVersionUID = 1L;

	//@JsonProperty("ids") //This is to shorten name or to give proper name to fornt end.
	@Id
	@Column(name = "id",length = 20, nullable = false )
	private String id;
	
	@Column(name = "name", length = 20 )
	private String name;
	
	@Column(name = "description", length = 20)
	private String description;
	
	public TopicModel(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "TopicModel [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
