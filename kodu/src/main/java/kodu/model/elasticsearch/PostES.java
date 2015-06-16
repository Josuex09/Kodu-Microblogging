package kodu.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


@Document(indexName="post")
public class PostES {
	@Id
	private String Id;
	private String description;	
	
	public PostES(String id, String description) {
		Id = id;
		this.description = description;
	}
	
	
	
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
