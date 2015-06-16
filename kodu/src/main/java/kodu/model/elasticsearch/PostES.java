package kodu.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName="post")
public class PostES {
	@Id
	private String Id;
	private String description;	
	private String user;
	
	public PostES(String id, String description,String user) {
		this.Id = id;
		this.user=user;
		this.description = description;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setId(String id) {
		Id = id;
	}
	public PostES(){}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getId() {
		return Id;
	}



}
